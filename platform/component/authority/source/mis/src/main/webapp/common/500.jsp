<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.io.ByteArrayOutputStream"%>
<%@ page import="java.io.PrintStream"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%=exception.getClass()%>:<%=exception.getMessage()%>  
                </br> <%  
                    Enumeration<String> e = request.getHeaderNames();  
                    String key;  
                    while(e.hasMoreElements()){  
                        key = e.nextElement();  
                    }  
                    e = request.getAttributeNames();  
                    while(e.hasMoreElements()){  
                          key = e.nextElement();  
                    }  
                    e = request.getParameterNames();  
                    while(e.hasMoreElements()){  
                        key = e.nextElement();  
                    }  
            %> <%=request.getAttribute("javax.servlet.forward.request_uri") %><br>  
                    <%=request.getAttribute("javax.servlet.forward.servlet_path") %>  
            <p>With the following stack trace:</p>  
        <pre>  
        <%  
  exception.printStackTrace();  
  ByteArrayOutputStream ostr = new ByteArrayOutputStream();  
  exception.printStackTrace(new PrintStream(ostr));  
  out.print(ostr);  
%>  

</body>
</html>