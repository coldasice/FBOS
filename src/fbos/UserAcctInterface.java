/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public interface UserAcctInterface extends Remote
{
    public abstract int viewProfile() throws RemoteException;
    public abstract int updateProfile(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException;
    public abstract int postUpdate(String content) throws RemoteException;
    public abstract int getUpdates() throws RemoteException;
    
    public abstract String getUserName() throws RemoteException;
    public abstract String getPassword() throws RemoteException;
    public abstract String getProfession() throws RemoteException;
    public abstract String getLivingCity() throws RemoteException;
    public abstract String getCompany() throws RemoteException;
    public abstract String getCollege() throws RemoteException;
    public abstract int getGradYear() throws RemoteException;
    
    public abstract String setUserName(String value) throws RemoteException;
    public abstract String setPassword(String value) throws RemoteException;
    public abstract String setProfession(String value) throws RemoteException;
    public abstract String setLivingCity(String value) throws RemoteException;
    public abstract String setCompany(String value) throws RemoteException;
    public abstract String setCollege(String value) throws RemoteException;
    public abstract int setGradYear(int value) throws RemoteException;
}
