//package toXML_Movies2dot0;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.HashMap;
//
//
//public class Tools {
//
//    public static HashMap<Person,Integer> countMoviesPerPerson(List<Movie> movies){
//        HashMap<Person,Integer> moviePerPerson = new HashMap<>();
//        for (Movie movie : movies){
//            for (Person person : movie.getCast()){
//                if(moviePerPerson.containsKey(person)){
//                    moviePerPerson.put(person,moviePerPerson.get(person)+1);
//                }
//                else if (moviePerPerson.containsKey(person)){
//                    moviePerPerson.put(person,1);
//                }
//            }
//        }
//        return moviePerPerson;
//    }
//
//    public static String[] getMovieTitles(ArrayList<Movie> movies){
//        int movieNum = movies.size();
//        String[] result = new String[movieNum];
//        for (int i=0;i<movieNum;i++){
//            result[i] = movies.get(i).getTitle();
//        }
//        return result;
//
//    }
//
//
//    public static String toXMLTag(String tagName, String value)
//    {
//        return "<" + tagName + ">" + value + "</" + tagName + ">";
//    }
//
//
//
//}
