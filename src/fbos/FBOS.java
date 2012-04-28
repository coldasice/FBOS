/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos;

/**
 *
 * @author User
 */
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
public class FBOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
