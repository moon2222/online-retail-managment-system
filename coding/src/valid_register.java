
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class valid_register extends HttpServlet {

    Connection conn;
    ResultSet res;

    String username, password1,FirstName,LastName,Address,mobile,Shop,City,State,Pincode, query,query1;
    DatabaseConnection dbconn;
    int store,temp1=0,temp2=0;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            temp1=0;
            temp2=0;


            username = request.getParameter("user_name");
            password1 = request.getParameter("password");
            FirstName = request.getParameter("Fname");
            LastName = request.getParameter("Lname");
            Address = request.getParameter("address");
            City = request.getParameter("city");
            State = request.getParameter("state");
            Pincode = request.getParameter("pincode");
            mobile = request.getParameter("contact_no");
            Shop = request.getParameter("shop_name");
            temp1 = Integer.parseInt(Pincode);
            temp2 = Integer.parseInt(mobile);
            query = "select * from retailer where username = '" + username + "' and password = '" + password1 + "'";
            dbconn = new DatabaseConnection();
            conn = dbconn.setConnection();
            res = dbconn.getResult(query, conn);

            if (res.next()) {
                out.write("You Are Already Registered");
            } else {
                query1 = "select max(ID) from retailer";
                res = dbconn.getResult(query1, conn);
                if (res.next()) {
                    store = res.getInt("max(ID)");
                    store = store + 1;
                }
                query = "insert into retailer values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                dbconn.setvalue(store,username, password1,FirstName,LastName,Address,City,State,temp1,Shop,temp2, conn, query);
                out.write("You Are Successfully Registered\n");
                out.write("You Can proceed to LogIn page");
            }


        }
        catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
        finally{
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
