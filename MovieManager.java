//package toXML;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MovieManager {
//
//    public static final String FILE_PATH = "C:\\CodeCool\\Let's_JAVA\\Week9_Java\\src\\toXML\\result.xml";
//
//    public static void main(String[] args) {
//        Person Papus = new Person("Gazdik", "Zsolt", Gender.MALE, true, false);
//        Person Mentors = new Person("Mentor", "Jézus", Gender.MALE, true, true);
//        Person Kukac = new Person("Kara", "Lábé", Gender.FEMALE, false, false);
//
//        List<Person> persons = new ArrayList<Person>();
//
//        persons.add(Papus);
//        persons.add(Mentors);
//        persons.add(Kukac);
//
//        Movie film1 = new Movie("Mr.Old", Genre.DRAMA, 120L, 8.7, persons);
//        List<Movie> movies = new ArrayList<Movie>();
//        movies.add(film1);
//
//
//        try {
//            BufferedWriter writeToXML = new BufferedWriter(new FileWriter(new File(FILE_PATH)));
//            StringBuilder temp_text = new StringBuilder();
//            temp_text.append("<movies>");
//            temp_text.append(film1.toXMLString());
//            temp_text.append(Papus.toXMLString());
//            temp_text.append("</movies>");
//            writeToXML.write(temp_text.toString());
//            writeToXML.flush();
//            writeToXML.close();
//            System.out.println("Success!");
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }
//
//    }
//    }


