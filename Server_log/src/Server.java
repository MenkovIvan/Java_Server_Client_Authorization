
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket listener = new ServerSocket(8000);
        listener.setSoTimeout(8000);
        Socket client = listener.accept();

        ObjectInputStream deserializer = new ObjectInputStream(client.getInputStream());  //получение объекта
        //ObjectOutputStream serializer = new ObjectOutputStream(client.getOutputStream()); //отправка объекта


        ReadFile rf = new ReadFile();
        ArrayList array = new ArrayList();
        try {
            rf.read(array);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Player input = (Player) deserializer.readObject();

        //DataInputStream inStream = new DataInputStream(client.getInputStream());     //получение boolean
        DataOutputStream outStream = new DataOutputStream(client.getOutputStream()); //отправка boolean

        if (check(array,input)){
            outStream.writeBoolean(true);
        }
        else{
            outStream.writeBoolean(false);
        }

        outStream.flush();
    }

    private static boolean check(ArrayList a, Player input){
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(input))
                return true;
        }
        return false;
    }
}