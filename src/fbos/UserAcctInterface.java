/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author User
 */
public interface UserAcctInterface extends Remote
{
    public abstract Map viewProfile() throws RemoteException;
    public abstract int updateProfile(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException;
    public abstract int postUpdate(String content) throws RemoteException;
    public abstract ArrayList<String> getUpdates() throws RemoteException;
    
}
