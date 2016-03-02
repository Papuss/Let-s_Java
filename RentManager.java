package toXML_Movies2dot0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RentManager {


    public static void main(String[] args) throws IOException {

        Person papus = new Person("Gazdik","Zsolt",Gender.MALE,500000);
        Person lacos = new Person("Eperjesi","Laszlo",Gender.MALE,350000);
        Person joska = new Person("Moravszki","Jozsef",Gender.MALE,150000);
        Person niki = new Person("Bakondi","Niki",Gender.FEMALE,120000);
        Person mentors = new Person("Mentor", "Jézus", Gender.MALE, 1 );
        Person kukac = new Person("Kara", "Lábé", Gender.FEMALE,99999 );
        Person allTimeAuthor = new Person("I Wrtie","Books",Gender.FEMALE,555);

        List<Person> azOtKerekCast = new ArrayList<>();
        azOtKerekCast.add(papus);
        azOtKerekCast.add(niki);

        List<Person> kolisEletCast = new ArrayList<>();
        kolisEletCast.add(papus);
        kolisEletCast.add(lacos);
        kolisEletCast.add(joska);
        kolisEletCast.add(niki);

        List<Person> privateMovieCast = new ArrayList<>();
        privateMovieCast.add(niki);
        privateMovieCast.add(papus);

        List<Person> gamers = new ArrayList<>();
        gamers.add(papus);
        gamers.add(lacos);
        gamers.add(joska);
        gamers.add(mentors);
        gamers.add(kukac);

        List<Person> bookworms = new ArrayList<>();


        Movie azOtKerek = new Movie("Az öt kerék",papus,Genre.DRAMA,120,8.7,azOtKerekCast,13000);
        Movie kolisElet = new Movie("Kolis élet",lacos,Genre.SCI_FI,135,5.4,kolisEletCast,2500);
        Movie privateMovie = new Movie("Private Movie",niki,Genre.ACTION,90,9.8,privateMovieCast,3500);

        Game wow = new Game("World of Warcraft",papus,true,gamers,12000);
        Game lol = new Game("League of Legends",lacos,false,gamers,0);

        Book demonata = new Book("Darren Shan Demonata Saga",papus,allTimeAuthor);
        Book bodylanguage = new Book("Allan Pease: Testbeszéd",papus,allTimeAuthor);
        Book asSzetHullottBirodalom = new Book("Mark L Lawrence: Tövisek Hercege,Tövisek Királya," +
                "Töviesk Császára",papus,allTimeAuthor);
        Book aTerseg = new Book("James S.A. Corey: Leviatán ébredése, Kalibán Háborúja, " +
                "Abaddon Kapuja, Cibola Meghódítása",papus,allTimeAuthor);
        Book luciferHatas = new Book("Philip Zimbardo: A Lucifer Hatás",papus,allTimeAuthor);

        List<Product> products = new ArrayList<>();
        products.add(azOtKerek);
        products.add(kolisElet);
        products.add(privateMovie);
        products.add(wow);
        products.add(lol);
        products.add(demonata);
        products.add(bodylanguage);
        products.add(asSzetHullottBirodalom);
        products.add(aTerseg);
        products.add(luciferHatas);









        Socket clientSocket = new Socket("localhost",666);
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());


        Scanner sc = new Scanner(System.in);
        String input;


        label:
        while (true) {
            System.out.println("Client started, enter Commands(PUT,GET,EXIT): ");
            try {
                input = sc.nextLine();
                switch (input) {
                    case "PUT":
                        oos.writeObject(Command.PUT);
                        oos.write(0);
                        oos.writeObject(papus);
                        oos.write(0);
                        oos.writeObject(azOtKerek);
                        oos.flush();
                        break;
                    case "GET":
                        oos.writeObject(Command.GET);
                        List<Object> res = new ArrayList<>();
                        try{
                            res.add(ois.readObject());
                            if (!res.isEmpty()){
                                for (Object o : res){
                                    System.out.println(o);
                                }
                            } else{
                                System.out.println("Server sent empty list");
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case "EXIT":
                        oos.writeObject(Command.EXIT);
                        break label;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        for (int i = 0;i < products.size();i++){
//            System.out.println(products.get(i).getTitle());
//            System.out.println(products.get(i).getId());
//            System.out.println("*********************************************************");
//        }

        List<Buyable> buyableStuff = new ArrayList<Buyable>();
        for (Product product : products){
            if (product instanceof Game){
                buyableStuff.add((Game) product);
            }
            if (product instanceof Movie){
                buyableStuff.add((Movie) product);
            }
        }

//        for (int i = 0;i < buyableStuff.size();i++){
//            System.out.println(buyableStuff.get(i).getTitle());
//            System.out.println(buyableStuff.get(i).getId());
//            System.out.println("*********************************************************");
//        }
    }


    public static int incomeFromBuyableProducts(List<Buyable> buyableStuff){
        int result=0;
        for (Buyable buyable : buyableStuff){
            result += buyable.getPrice();
        }
        return result;

    }


}
