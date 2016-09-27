import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConnectionManager {

    int connections = 0;
    int maxConnections = 0;
    List<Connection> listOfConnections;

    // HTTP / SSH / HTTPS

    ConnectionManager(int maxConnections) {
        this.maxConnections = maxConnections;
        listOfConnections = new ArrayList<Connection>();
    }

    public ManagedConnection getConnection (String IP, String protocol, int port) {
        if (connections >= maxConnections) {return null;}
        connections++;
        ManagedConnection connection = new ManagedConnection(IP, protocol, port);
        return connection;
    }


    public ManagedConnection getConnection (String IP, int port) {
        if (connections >= maxConnections) { return null;}
        connections++;
        return new ManagedConnection(IP, port);
    }
// good one
    public ManagedConnection getConnection(String IP, String protocol) {
        if (connections >= maxConnections) {return null;}
        connections++;
        return new ManagedConnection(IP, protocol);
    }

     class ManagedConnection implements Connection {

        private String IP;
        private String protocol = "HTTP";
        private int port;
        private boolean closed = false;
        Random rand = new Random();

        ManagedConnection(String IP, String protocol, int port) {
            this.IP = IP;
            this.protocol = protocol;
            this.port = port;
            listOfConnections.add(this);
            System.out.println(connect());
        }

        ManagedConnection(String IP, String protocol) {
            this.IP = IP;
            this.protocol = protocol;
            this.port = rand.nextInt(1023+1);
            listOfConnections.add(this);
            System.out.println(connect());

        }

        ManagedConnection(String IP, int port) {
            this.IP = IP;
            this.port = port;
            protocol = "HTTP";
            listOfConnections.add(this);
            System.out.println(connect());

        }

        public String getIP(){
            return IP;
        }

        public void setIP(String IP) {
            this.IP = IP;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public void setClosed() {
            this.closed = true;
            this.port = -1;
            this.IP = "error";
            this.protocol = "error";
        }

        public String connect() {
            return "Connection succeeded. Your IP is: " + IP + ", your port is " + port + ", your protocol is " + protocol;
        }

        public String close() {
            this.setClosed();
            connections--;
            return "This connection is closed...forever.";
        }




    }
}
