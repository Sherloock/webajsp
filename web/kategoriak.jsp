<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="JavaSource.*"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kategóriák</title>
        <link href="tablastilus.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        
         <table>
            <tr>
                <th>
                    Kategória
                </th>
                <th>
                    Leírás
                </th>
            </tr>   
        <% for (Kategoria k : Main.modell.getKategoriak()) {%>
        
        <tr>
            <td>
                <%= k.getNev() %>
            </td>
            <td>
                <%= k.getLeiras() %> 
            </td>
        </tr>

         

        <%}%>
         
         </table>
        
    </body>
</html>
