package toXML;

import java.util.Random;
import java.util.StringJoiner;

public class IdGenerator {

    public static String generateId(Product product){
        String id = "";
        Random rNumGenerate = new Random();
        double randNum = 0;
        for (int i = 0; i < 500; i++)
        {
            randNum += rNumGenerate.nextInt(150);
        }



        if (product instanceof Movie){
            id = "MOV";
        }
        if (product instanceof Game){
            id = "GAM";
        }
        if (product instanceof Book){
            id = "BOO";
        }

        return id + randNum;
    }

}
