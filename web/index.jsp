<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="JavaSource.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <title>Webáruház</title>
        <link href="tablastilus.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <%@include file="menu.jsp" %>
    
        
        <table>
            <tr>
            <th>
                Kép
            </th>
            <th>
                 Elnevezés
            </th>
            <th>
                Ár
            </th>
            <th>
                Település
            </th>
        </tr>
            
        <% for (Termek t : Main.modell.getTermekek()) {%>
        <tr>
            <td>
                <img src="/<%=  t.getKep().substring(1) %>" alt="<%= t.getNev() %>"  width="100" height="100" >
            </td>
            <td>
                 <%= t.getNev() %> 
            </td>
            <td>
                 <%= t.getAr() %>Ft
            </td>
            <td>
                 <%= t.getTelepules()%> 
            </td>
        </tr>

        <%}%>
        
        </table>

    </body>
</html>
