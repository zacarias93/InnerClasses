/**
 * Created by zaclee on 9/27/16.
 */
public class App {

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager(3);
        System.out.println(connectionManager.maxConnections);
    }
}
