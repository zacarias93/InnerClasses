import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ConnectionManagerTest {

    ConnectionManager connectionManager;

    @Before
    public void setUpTest() {
        connectionManager = new ConnectionManager(3);

    }

    @Test
    public void getConnectionTest() {
        connectionManager.getConnection("1", "HTTP");
        Assert.assertEquals("size should be 1", 1,connectionManager.listOfConnections.size() );
    }

    @Test
    public void getConnectionTest2() {
        connectionManager.getConnection("999", "HTTPS");
        connectionManager.getConnection("234", 20);
        ConnectionManager.ManagedConnection temp = connectionManager.getConnection("233","SSH",20);
        System.out.println(temp.close());
        System.out.println(connectionManager.connections);
        System.out.println(temp.getIP());


        Assert.assertEquals("protocol should be HTTPS", 3,connectionManager.listOfConnections.size() );
    }

}
