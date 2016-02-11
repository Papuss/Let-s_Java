package toXML;

public class Book extends Product {

    Person author;

    public Book(String title, Person person,Person author) {
        super(title,person);
        this.author = author;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public long getInvestment(){
        return author.salary;

    }

}
