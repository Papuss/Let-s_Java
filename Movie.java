package toXML;

import java.util.List;

public class Movie {
    String title;
    Genre genre;
    long duration;
    double rate;
    List<Person> cast;

    public Movie(String title,Genre genre,long duration,double rate,List<Person> cast){
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rate = rate;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public String toXMLString(){
        String returnTitle = Tools.toXMLTag("title",title);
        String returnGenre = Tools.toXMLTag("genre", genre.toString());
        String returnDuration = Tools.toXMLTag("duration", String.valueOf(duration));
        String returnRate = "rate" + rate;
//        StringBuilder castbuilder = new StringBuilder();
//        for (Person person : cast){
//
//        }
        String returnAlll = returnTitle + returnGenre + returnDuration + returnRate;
        return ("movie") + returnAlll;

    }


}
