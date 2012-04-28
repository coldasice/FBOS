/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.serverpkg;

import fbos.FBOSServantInterface;
import fbos.UserAcctInterface;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
/**
 *
 * @author User
 */
public class FBOSServant extends java.rmi.server.UnicastRemoteObject implements FBOSServantInterface
{
    Connection con;
    java.util.Date utilDate = new java.util.Date();
    int      thisRMIPort;
    String   thisRMIAddress;
    Registry registry;    // rmi registry for lookup the remote objects.
    
    
    public FBOSServant() throws RemoteException
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
    }
    
    
    
    //-2 Means user existed already
    //-1 Other error
    @Override
    public synchronized UserAcctInterface createAccount(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear)  throws RemoteException
    {
        UserAcct newUser = new UserAcct(userName, password, profession, livingCity, company, college, gradYear);
        return newUser;        
    }
    
    @Override
    public synchronized UserAcctInterface loginAccount(String userName, String password) throws RemoteException
    {
        try {
            UserAcctInterface myAcct = (UserAcctInterface)(registry.lookup(userName));
            if(myAcct.getPassword().equals(password)){
                System.out.println("Access Granted");
                return myAcct;
            }
            else {
                System.out.println("Access Denied");
                return null;
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public synchronized int searchForFriends() throws RemoteException
    {
        return -1;
    }
    
    @Override
    public synchronized int inviteFriend(String userName) throws RemoteException
    {
        return -1;
    }
    
    public void closeCon() {
        //close up the connection when we're done
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
