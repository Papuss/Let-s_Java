package toXML_Movies2dot0;

import java.io.Serializable;

public abstract class Product implements Serializable {

    String id;
    String title;
    Person person;

    public Product(String title, Person person) {
        this.id = IdGenerator.generateId(this);
        this.title = title;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    abstract long getInvestment();




}
