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
import java.util.ArrayList;
import java.util.Map;
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
    int      acctRMIPort;
    String   acctRMIAddress;
    Registry registry;    // rmi registry for lookup the remote objects.
    Registry acctRegistry;
    
    public FBOSServant() throws RemoteException
    {
        try{
            // get the address of this host.
            thisRMIAddress= (InetAddress.getLocalHost()).toString();
            acctRMIAddress = thisRMIAddress;
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }
        
        thisRMIPort=3232;  // this port(registry port)
        acctRMIPort=4242;
        System.out.println("this address="+thisRMIAddress+",port="+thisRMIPort);
        try{
            // create the registry and bind the name and object.
            registry = LocateRegistry.createRegistry( thisRMIPort );
            acctRegistry = LocateRegistry.createRegistry( acctRMIPort );
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
        try {
            UserAcctInterface myAcct = (UserAcctInterface)(acctRegistry.lookup(userName+"-NOPASS"));
            System.out.println("Name exists");
            return null;
        } catch (NotBoundException ex) {
            UserAcct newUser = new UserAcct(userName, password, profession, livingCity, company, college, gradYear, null);
            UserAcct newUser2 = new UserAcct(userName, "NOPASS", profession, livingCity, company, college, gradYear, newUser);
            newUser.mySisterAcct = newUser2;
            return newUser;
        } catch (AccessException ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public synchronized UserAcctInterface loginAccount(String userName, String password) throws RemoteException
    {
        try {
            UserAcctInterface myAcct = (UserAcctInterface)(acctRegistry.lookup(userName+"-"+password));
            return myAcct;
        } catch (NotBoundException ex) {
            System.out.println("Unable to access account: " + userName);
        } catch (AccessException ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public synchronized ArrayList<UserAcctInterface> searchForFriends(String college, String company) throws RemoteException
    {
        String[] objList = acctRegistry.list();
        ArrayList<String> userList = new ArrayList<String>();
        for(int i = 0; i < objList.length; i++) {
            if(objList[i].contains("-NOPASS")) {
                userList.add(objList[i]);
            }
        }
        ArrayList<UserAcctInterface> userObjList = new ArrayList<UserAcctInterface>();
        for(int i = 0; i < userList.size(); i++) {
            try {
                UserAcctInterface currAcct = (UserAcctInterface)(acctRegistry.lookup(userList.get(i)));
                Map currProfileInfo = currAcct.viewProfile();
                String currCompany = (String) currProfileInfo.get("company");
                String currCollege = (String) currProfileInfo.get("college");
                if (company != null && currCompany.equals(company)) {
                    userObjList.add(currAcct);
                }
                else if (college != null && currCollege.equals(college)) {
                    userObjList.add(currAcct);
                }
                else if(college == null && company == null) {
                    userObjList.add(currAcct);
                }
            } catch (Exception ex) {
                Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
                userList.remove(i);
            }
        }        
        return userObjList;
    }
    
    @Override
    public synchronized int inviteFriend(UserAcctInterface requesterAcct, UserAcctInterface friendAcct) throws RemoteException
    {
        Map requesterProfile = requesterAcct.viewProfile();
        if (requesterProfile.get("password").equals("NOPASS")) {
            System.out.println("Must be logged in to invite friend");
            return 0;
        }
        String userName = (String) requesterProfile.get("userName");
        try {
            UserAcctInterface safeAcct = (UserAcctInterface)(acctRegistry.lookup(userName+"-NOPASS"));
            friendAcct.addReq(safeAcct, true);
            requesterAcct.sentReq(friendAcct, true);
        } 
        catch (Exception ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        return 1;
    }
    
    @Override
    public int verifyName(String userName) throws RemoteException
    {
        try {
            UserAcctInterface myAcct = (UserAcctInterface)(acctRegistry.lookup(userName+"-NOPASS"));
            return 0;
        } catch (NotBoundException ex) {
            return 1;
        } catch (AccessException ex) {
            Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
