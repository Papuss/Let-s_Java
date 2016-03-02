package toXML_Movies2dot0;

import java.util.List;

public class Game extends Product implements Buyable {

    boolean preOrdered;
    List<Person> staff;
    int price;

    public Game(String title , Person person,boolean preOrdered, List<Person> staff, int price) {
        super(title,person);
        this.preOrdered = preOrdered;
        this.staff = staff;
        this.price = price;
    }

    public boolean isPreOrdered() {
        return preOrdered;
    }

    public void setPreOrdered(boolean preOrdered) {
        this.preOrdered = preOrdered;
    }

    public List<Person> getStaff() {
        return staff;
    }

    public void setStaff(List<Person> staff) {
        this.staff = staff;
    }


    public int getPrice() {
        if(preOrdered){
            return (int) (price*0.8);
        }
        else{
            return price;
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public long getInvestment(){
        int investment  = 0;
        for (Person person : staff){
            investment += person.getSalary();
        }
        return investment;
    }

}
