<%@page import="java.sql.DriverManager" %>

<%@page import="java.sql.Connection" %>

<%@page import="java.sql.PreparedStatement" %>

<%@page import="java.sql.ResultSet" %>

<%
        String a=request.getParameter("name");
 
       Integer b=Integer.(parseInt(request.getParameter("phonenoneno"));
     
   String c=request.getParameter("username");
      
  String d=request.getParameter("password");
        
         
   Class.forName("com.mysql.jdbc.Driver");
  
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
     
           PreparedStatement  st=con.prepareStatement("insert into customers values(?,?,?,?)");
       
         st.setString(1,a);
              
  st.setString(2,b);
          
      st.setString(3,c);
        
        st.setString(4,d);
        
        st.executeUpdate();
           
     response.sendRedirect("sign_up_page.html");

%>