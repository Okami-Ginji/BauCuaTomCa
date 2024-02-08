package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Roll;

public class DBContext implements DatabaseInfo {

    public static Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver" + e);
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    /*public static Connection getConnect(){
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
                    DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
                    return ds.getConnection();
        } catch (SQLException | NamingException ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }*/

    public static void insert(Roll s) {
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("insert into Roll (Roll1,Roll2,Roll3) values (?,?,?)");          
            stmt.setString(1, s.getRoll1());
            stmt.setString(2, s.getRoll2());
            stmt.setString(3, s.getRoll3());
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
//--------------------------------------------------------------------------------------------

    public static Roll listAll() {
        //Connection con = getConnect();
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select Top 1 *from Roll order by ID DESC");
            ResultSet rs = stmt.executeQuery();  
            while(rs.next()){
            Roll roll = new Roll(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4)); 
//            con.prepareStatement("DELETE FROM Roll\n" +
//"WHERE ID NOT IN (\n" +
//"    SELECT TOP (SELECT COUNT(*)-1 FROM Roll) id\n" +
//"    FROM Roll\n" +
//");").executeQuery();
            return roll;
            }
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//--------------------------------------------------------------------------------------------

    public static void main(String[] a) {
        Roll list = DBContext.listAll();
        System.out.println(list.getRoll1());
        System.out.println(list.getRoll2());
        System.out.println(list.getRoll3());
    }
//---------------------------------------------------------------------------
}
