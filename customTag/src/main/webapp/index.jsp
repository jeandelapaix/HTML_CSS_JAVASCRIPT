<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='mytag' uri='/WEB-INF/tlds/TldDemo'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JSTL and Custom Tags</title>
    </head>
    <body>
        <div>
            <mytag:Head thecolor='red' words='Hello John You Good'/>
        </div>

    </body>
</html>
