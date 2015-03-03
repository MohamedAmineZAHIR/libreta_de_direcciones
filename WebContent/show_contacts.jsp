<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.lang.String"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>

	<%
		//out.println(request.getAttribute("jeton"));
		ResultSet r = (ResultSet)request.getAttribute("contacts");
		out.println("<table border='1'><tr><td>FIRST NAME</td><td>FAMILY NAME</td><td>ADRESS</td><td>PHONE NUMBER</td></tr>");
		if(r != null){
			try{
				while(r.next()){
					out.println("<tr><td>"+r.getString("first_name")+"</td><td>"+r.getString("family_name")+"</td><td>"+r.getString("adress")+"</td><td>"+r.getString("phone")+"</td></tr>");
				}
			}catch(SQLException e){e.printStackTrace();}
		}
		out.println("</table>");
	%>
</body>
</html>