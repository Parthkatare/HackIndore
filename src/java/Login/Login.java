package Login;
import java.io.IOException;  
    import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
      
    import javax.servlet.RequestDispatcher;  
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
public class Login extends HttpServlet {  
    static boolean status;
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.print("<button>Submit</button>");      
        String n=request.getParameter("username");  
        String p=request.getParameter("password");
                try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mess","root","");  
      
        PreparedStatement ps=con.prepareStatement( "select * from login where username=? and password=?");  
    ps.setString(1,n);  
    ps.setString(2,p);  
      
                    ResultSet rs=ps.executeQuery();  
        status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
        if(status){  
            RequestDispatcher rd=request.getRequestDispatcher("Home_Admin.html");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request,response);  
        }  
         out.close();  
        }  
}  
