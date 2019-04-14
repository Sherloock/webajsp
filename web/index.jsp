<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="JavaSource.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

        <title>Webáruház</title>
    </head>

    <body>
        <%@include file="menu.jsp" %>
    
        <% for (Termek t : Main.modell.getTermekek()) {%>
            <div> <%= t.getNev() %> </div>
        <% }%>
        

    </body>
</html>
