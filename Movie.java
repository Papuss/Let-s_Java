package toXML_Movies2dot0;

import java.io.Serializable;
import java.util.List;

public class Movie extends Product implements Buyable,Serializable{

    Genre genre;
    long duration;
    double rate;
    List<Person> cast;
    int price;




    public Movie(String title,Person person,Genre genre,long duration,double rate,List<Person> cast,int price){
        super(title,person);
        this.genre = genre;
        this.duration = duration;
        this.rate = rate;
        this.cast = cast;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }

    @Override
    public long getInvestment(){
        int investment = 0;

        for (Person person : cast){
            investment += person.getSalary();
        }
        return investment;
    }


    @Override
    public String toString()
    {
        return title;
    }






}
