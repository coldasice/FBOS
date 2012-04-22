/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.serverpkg;

import fbos.FBOSI;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author User
 */
public class FBOSServer extends java.rmi.server.UnicastRemoteObject implements FBOSI
{
    Connection con;
    java.util.Date utilDate = new java.util.Date();
    int      thisRMIPort;
    String   thisRMIAddress;
    Registry registry;    // rmi registry for lookup the remote objects.
    
    
    public FBOSServer() throws RemoteException
    {
        try{
            // get the address of this host.
            thisRMIAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }
        
        thisRMIPort=3232;  // this port(registry�fs port)
        System.out.println("this address="+thisRMIAddress+",port="+thisRMIPort);
        try{
            // create the registry and bind the name and object.
            registry = LocateRegistry.createRegistry( thisRMIPort );
            registry.rebind("FBOSServer", this);
        }
        catch(RemoteException e){
            throw e;
        }
        
        
        /*
        //OPEN CONNECTION TO DB
        //Initialize all the names and such
        String serverName = "127.0.0.1";
        String dbms = "mysql";
        String dbName = "";
        String portNumber = "";
        String userName = "";
        String password = "";
        //Open up my connection
        String dbUrl = "jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + dbName;
        String dbClass = "com.mysql.jdbc.Driver";
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password); 
        
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection (dbUrl, connectionProps);
        }
        catch (SQLException ex) {
            Logger.getLogger(FBOSServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(FBOSServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        
    }
    
    
    
    //-2 Means user existed already
    //-1 Other error
    @Override
    public int addUser(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear)  throws RemoteException
    {
        
        java.sql.Timestamp createTime = new java.sql.Timestamp(utilDate.getTime());
        System.out.println(createTime);
        
        /*
        String query = "SELECT userId FROM users WHERE UserName='"+userName+"'";
        String update = "INSERT INTO users VALUES(0, '"+userName+"', '"+password+"', '"+profession+"', '"
                                                    +livingCity+"', '"+company+"', '"+college+"', '"
                                                    +gradYear+"', '"+createTime+"')";

        try {
             
            Statement stmt = con.createStatement();
            
            //Look up with given info to see if it's already been made
            int userId = -1;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(userName + " existed");
                return -2;
            } //end while
            
            int success = stmt.executeUpdate(update);
            if(success != 0) {
                System.out.println("successfully created user at time: " + createTime);
            } else {
                System.err.println("Failure to create user");
            }
            
            //Find the object we just made and return the RoR val
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userId = rs.getInt("userId");
                System.out.println("User: "+userId+" created");
            } //end while
            con.close();
            return userId;
            
        } //end try
        catch(Exception e) {
            e.printStackTrace();
        }
        */
        return -1;
        
    }
    
    public void closeCon() {
        //close up the connection when we're done
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FBOSServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
