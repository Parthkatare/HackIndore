package Login;

import com.mysql.jdbc.ResultSetMetaData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Count extends HttpServlet{
  
    static boolean status;
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        PrintWriter pw=response.getWriter();
                try{           
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mess","root","");    
      
                    Statement ps=con.createStatement(); 
      
                    ResultSet rs=ps.executeQuery("select username, count from customers");    
                    ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();
while (rs.next()) {
    for (int i = 1; i <= columnsNumber; i++) {
        if (i > 1) pw.print(",  ");
        String columnValue = rs.getString(i);
        pw.print(rsmd.getColumnName(i)+":"+columnValue);
        if(i==2){
        pw.print("      Rs. "+Integer.parseInt(columnValue)*100);
    };
    }
    pw.println();
}
                    
}catch(Exception e){System.out.println(e);}  
        /*if(status){  
            RequestDispatcher rd=request.getRequestDispatcher("Home_Admin.html");  
            rd.forward(request,response);  
        }  
        else{  
            pw.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request,response);  
        }  */
         pw.close();  
        }  
}  

