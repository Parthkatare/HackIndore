/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import static Login.Login.status;
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
      
    public class servlet2 extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String s=request.getParameter("sabzi");
        String d=request.getParameter("desserts");
        String r=request.getParameter("roti");
        String a2[]=s.split(",");
        String a3[]=d.split(",");
        String a4[]=r.split(",");
        
        //String r[4][3]=[{a2[0],a2[1],a2[3]},{},{}];
        //String a5[]=ts.split(",");
        try{int i;
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mess","root","");  
        PreparedStatement ps;
        for(i=0;i<4;i++){
        ps=con.prepareStatement( "insert data into Menu('Breakfast', 'Lunch', 'Dinner')"
                + " values('?','?','?')");  
        ps.setString(1,a2[i]);
        ps.setString(2, a3[i]);
        ps.setString(3,a4[i]);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
    //ps.setString(2,p);  
        }
            
          
          
}catch(Exception e){System.out.println(e);}  
        if(status){  
            out.print("Data Inserted"); 
            //RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
            //rd.forward(request,response);  
        }  
        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request,response);  
        }  
         out.close();  
        }  
              
        }  
      
