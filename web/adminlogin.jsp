<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.Connection" %>

<%@page import="java.sql.PreparedStatement" %>

<%@page import="java.sql.ResultSet" %>

<%
        String a=request.getParameter("username");
 
     
   String b=request.getParameter("pass");
         
   Class.forName("com.mysql.jdbc.Driver");
  
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
     
           PreparedStatement  st=con.prepareStatement("select * from admin where loginid,password=(?,?)");
       
         st.setString(1,a);
              
  st.setString(2,b);
          
 ResultSet rs=st.executeQuery();
           if (rs.next())
		   {     response.sendRedirect("adminpage.html");
			}
			else 
				System.out.println("No such username found!!");
				 response.sendRedirect("adminpage.html");

%>