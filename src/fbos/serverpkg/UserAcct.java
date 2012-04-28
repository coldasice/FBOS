/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.serverpkg;

import fbos.UserAcctInterface;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class UserAcct extends java.rmi.server.UnicastRemoteObject implements UserAcctInterface
{
    int      thisRMIPort;
    String   thisRMIAddress;
    Registry registry;    // rmi registry for lookup the remote objects.
    String userName = "";
    String password = "";
    String profession = "";
    String livingCity = "";
    String company = "";
    String college = "";
    ArrayList<String> myUpdates = new ArrayList<String>();
    ArrayList<UserAcctInterface> myFriends = new ArrayList<UserAcctInterface>();
    ArrayList<UserAcctInterface> myRequests = new ArrayList<UserAcctInterface>();
    int gradYear = -1;
    
    public UserAcct(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException
    {
        this.userName = userName;
        this.password = password;
        this.profession = profession;
        this.livingCity = livingCity;
        this.company = company;
        this.college = college;
        this.gradYear = gradYear;
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
            registry = LocateRegistry.getRegistry( thisRMIPort );
            registry.rebind(userName, this);
        }
        catch(RemoteException e){
            throw e;
        }
    }
    
    @Override
    public synchronized int viewProfile() throws RemoteException
    {
        System.out.println("STUFFFF");
        return -1;
    } 
    
    @Override
    public synchronized int updateProfile(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException
    {
        this.userName = userName;
        this.password = password;
        this.profession = profession;
        this.livingCity = livingCity;
        this.company = company;
        this.college = college;
        this.gradYear = gradYear;
        return 1;
    }
    
    @Override
    public synchronized int postUpdate(String content) throws RemoteException
    {
        myUpdates.add(content);
        return 1;
    }
    
    @Override
    public synchronized int getUpdates() throws RemoteException
    {
        return -1;
    }

    @Override
    public String getUserName() throws RemoteException {
        return userName;
    }

    @Override
    public String getPassword() throws RemoteException {
        return password;
    }

    @Override
    public String getProfession() throws RemoteException {
        return profession;
    }

    @Override
    public String getLivingCity() throws RemoteException {
        return livingCity;
    }

    @Override
    public String getCompany() throws RemoteException {
        return company;
    }

    @Override
    public String getCollege() throws RemoteException {
        return college;
    }

    @Override
    public int getGradYear() throws RemoteException {
        return gradYear;
    }

    @Override
    public String setUserName(String value) throws RemoteException {
        userName = value;
        return userName;
    }

    @Override
    public String setPassword(String value) throws RemoteException {
        password = value;
        return password;
    }

    @Override
    public String setProfession(String value) throws RemoteException {
        profession = value;
        return profession;
    }

    @Override
    public String setLivingCity(String value) throws RemoteException {
        livingCity = value;
        return livingCity;
    }

    @Override
    public String setCompany(String value) throws RemoteException {
        company = value;
        return company;
    }

    @Override
    public String setCollege(String value) throws RemoteException {
        college = value;
        return college;
    }

    @Override
    public int setGradYear(int value) throws RemoteException {
        gradYear = value;
        return gradYear;
    }
    
}
