import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        Socket toServer = new Socket("localhost", 8000);
        //ObjectInputStream deserializer = new ObjectInputStream(toServer.getInputStream());  //получение объекта
        ObjectOutputStream serializer = new ObjectOutputStream(toServer.getOutputStream()); //отправка объекта

        Scanner scn = new Scanner(System.in);
        String login;
        String password;

        System.out.println("Hello guest!\nWrite\n login: ");
        login = scn.nextLine();
        System.out.println(" password: ");
        password = scn.nextLine();

        Player player = new Player(login,password);
        boolean autification;

        serializer.writeObject(player);
        serializer.flush();

        DataInputStream inStream = new DataInputStream(toServer.getInputStream());     //получение boolean
        //DataOutputStream outStream = new DataOutputStream(toServer.getOutputStream()); //отправка boolean

        autification = inStream.readBoolean();

        if (autification)
            System.out.println("Login and Password true. Welcome");
        else{
            System.out.println("Login and Password false. Try again");
        }
    }
}

