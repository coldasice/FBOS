/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.clientpkg;
import fbos.FBOSServantInterface;
import fbos.UserAcctInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author User
 */
public class FBOSClient 
{
    static Registry registry;
    static FBOSServantInterface FBOSServer;
    public static JFrame uiLog, uiNewAccount, uiSearch, uiUserEdit, uiWall;
    
    public static void main(String args[]) 
    {

        uiLog = new uiLog ();
//        uiLog.setDisposed(false);
        uiLog.setVisible(true);
    }    
}
