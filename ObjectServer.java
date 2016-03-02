package toXML_Movies2dot0;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjectServer {



    static final String FILEPATH = "data.ser";


    public static void main(String[] args) throws Exception {


        Servermode servermode;

        ServerSocket ss = new ServerSocket(666);
        Socket s = ss.accept();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        Object inputObj;
        ObjectServer objectServer = new ObjectServer();

            while (true){
                inputObj = ois.readObject();
                if (inputObj.equals(Command.GET)) {
                    servermode = Servermode.LOAD;
                    System.out.println("Server mode: LOAD");
                    oos.writeObject(objectServer.load());
                    }

                else if ((inputObj.equals(Command.PUT))) {
                    servermode = Servermode.SAVE;
                    System.out.println("Server mode: SAVE");
                    File f = new File(FILEPATH);
                    try {

                        if (!f.exists()) {
                            ObjectOutputStream filewriter = new ObjectOutputStream(new FileOutputStream(f));
                            filewriter.close();
                        }
                        while (ois.read() == 0) {
                            save(ois.readObject());
                        }
                    } catch (Exception e) {
                        System.out.println("Problem Occured, lets start searching :D");
                    }
                }
                else if (inputObj.equals(Command.EXIT)) {
                        System.out.println("Exit");
                        break;
                    }
            }
        ois.close();
        oos.close();
        System.out.println("Disconnected");

        }

    public void test() throws Exception{

      ServerSocket ss = new ServerSocket(666);
        Socket s = ss.accept();
        FileOutputStream fileOut = new FileOutputStream("test.txt");
        ObjectOutputStream ois = new ObjectOutputStream(fileOut);




        String test = "Ez egy teszt szoveg";
        ois.writeObject(test);

    }

    public static void save(Object obj) throws IOException {
        FileOutputStream fos ;
        ObjectOutputStream oos;
        try
        {
            File file = new File(FILEPATH);
            fos = new FileOutputStream(FILEPATH,true);
            if(!new File(FILEPATH).exists())
            {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.close();
            }
            oos = new AppendingObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            System.out.println("Object successfully saved!");
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }


    public Object load(){
        FileInputStream fis;
        ObjectInputStream ois;
        Object obj;
        List<Object> receivedObjects = new ArrayList<>();
        try
        {
            fis = new FileInputStream(FILEPATH);
            ois = new ObjectInputStream(fis);
            while (true){
                try{
                    obj = ois.readObject();
                    receivedObjects.add(obj);
                } catch (EOFException e){
                    break;
                }

            }
            System.out.println("Objects loaded!");
            ois.close();
            System.out.println(receivedObjects);
            return receivedObjects;
        }
        catch(ClassNotFoundException | IOException e)
        {
            System.err.println(e.getMessage());
        }
        return null;

    }
}
