package toXML;


public class Person {
    String firstName;
    String lastName;
    Gender gender;
    boolean hasOscar;
    boolean hasGoldenGlobe;
    String kutya;

    public Person(String firstName, String lastName, Gender gender, boolean hasOscar, boolean hasGoldenGlobe){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hasOscar = hasOscar;
        this.hasGoldenGlobe = hasGoldenGlobe;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getHasOscar() {
        return hasOscar;
    }

    public void setHasOscar(Boolean hasOscar) {
        this.hasOscar = hasOscar;
    }

    public Boolean getHasGoldenGlobe() {
        return hasGoldenGlobe;
    }

    public void setHasGoldenGlobe(Boolean hasGoldenGlobe) {
        this.hasGoldenGlobe = hasGoldenGlobe;
    }

    public String toXMLString(){
        String returnFirstName = Tools.toXMLTag("firstname", firstName);
        String returnLastName = Tools.toXMLTag("lastname", lastName);
        String returnGender = Tools.toXMLTag("gender", gender.toString());
        String returnHasOscar = Tools.toXMLTag("hasoscar", String.valueOf(hasOscar));
        String returnHasGoldenGlobe = Tools.toXMLTag("hasgoldenglobe", String.valueOf(hasGoldenGlobe));
        String returnAll = returnFirstName + returnLastName + returnGender + returnHasOscar + returnHasGoldenGlobe;
        return ("person") + returnAll;

    }

}
