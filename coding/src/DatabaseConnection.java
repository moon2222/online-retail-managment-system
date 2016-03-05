
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection{

    public Statement stmt;
    public ResultSet res;
    public Connection conn;
    public PreparedStatement insert;


    public DatabaseConnection(){

    }

    @SuppressWarnings("CallToThreadDumpStack")
    public Connection setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/retail_management?user=root&password=shashank@96M");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public ResultSet getResult(String query, Connection conn)
    {
        this.conn = conn;
        try{
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
        }
        catch(Exception e)
        {
        }
        return res;
    }
    public void setvalue(int retailer_id,String user_name,String password,String Fname,String Lname,String address,String city,String state,int pincode,String shopName,int contact_no,Connection conn,String query)
    {
        this.conn = conn;
        try{
            insert=conn.prepareStatement(query);
            insert.setInt(1, retailer_id);
            insert.setString(2, user_name);
            insert.setString(3,password);
            insert.setString(4,Fname);
            insert.setString(5,Lname);
            insert.setString(6,address);
            insert.setString(7,city);
            insert.setString(8,state);
            insert.setInt(3, pincode);
            insert.setString(3,shopName);
            insert.setInt(3, contact_no);


            insert.executeUpdate();
        }
        catch(Exception e)
        {
        }

    }
    public void setvalue2(int ID1,int ID2,int ID3,String date,Connection conn,String query)
    {
        this.conn = conn;
        try{
            insert=conn.prepareStatement(query);
            insert.setInt(1,ID1);
            insert.setInt(2,ID2);
            insert.setInt(3,ID3);
            insert.setString(4,date);
            insert.executeUpdate();
        }
        catch(Exception e)
        {
        }

    }
    public void setvalue3(String item_id,String item_name,int price,int quantity,Connection conn,String query) {
        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setString(1, item_id);
            insert.setString(2, item_name);
            insert.setInt(3, price);
            insert.setInt(4, quantity);

            insert.executeUpdate();
        } catch (Exception e) {
        }

    }
}