<%@page import="java.sql.DriverManager" %>

<%@page import="java.sql.Connection" %>

<%@page import="java.sql.PreparedStatement" %>

<%@page import="java.sql.ResultSet" %>

<%
   
   String c=request.getParameter("username");
      
  String d=request.getParameter("password");
        
         
   Class.forName("com.mysql.jdbc.Driver");
  
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
     
           PreparedStatement  st=con.prepareStatement("select * from customers where loginid,password=(?,?)");
       
         st.setString(1,c);
              
  st.setString(2,d);
          
 ResultSet rs=st.executeQuery();
           if (rs.next())
		   {     response.sendRedirect("menuafterlogin.html");
			}
			else 
				System.out.println("No such username found!!");
				 response.sendRedirect("adminpage.html");

%>