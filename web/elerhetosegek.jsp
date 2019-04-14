<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="JavaSource.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elérhetőségek</title>
        <style>
            .center {
                margin: auto;


                padding: 10px;
                display: grid;
                grid-template-areas:
                    'm m m m m t';

                grid-gap: 10px;
                background-color: #007ACC;
                padding: 10px;
            }

            .mapouter { grid-area: m; }
            .tobbi { grid-area: t; }

            .center > div {            
               
                font-size: 20px;
            }

        </style>
    </head>
    <body>
        <%@include file="menu.jsp" %>

        <div class="center">

            <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=parlament&t=&z=15&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>Werbung: <a href="https://www.pureblack.de">pureblack.de</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style></div>

            <div class="tobbi">
                <address>Cím:
                    Országház<br>
                    Budapest, Kossuth Lajos tér 1-3, 1055<br>
                </address><br>
                <table>
                    <thead>Nyitvatartás</thead>
                    <tr>
                        <td>hétfő</td>
                        <td>6:00–18:00</td>
                    </tr>
                    <tr>
                        <td>kedd</td>
                        <td>6:00–18:00</td>
                    </tr> 
                    <tr>
                        <td>szerda</td>
                        <td>6:00–18:00</td>
                    </tr> 
                    <tr>
                        <td>csütörtök</td>
                        <td>6:00–18:00</td>
                    </tr> 
                    <tr>
                        <td>péntek</td>
                        <td>6:00–18:00</td>
                    </tr> 
                    <tr>
                        <td>szombat</td>
                        <td>6:00–13:00</td>
                    </tr> 
                    <tr>
                        <td>vasárnap</td>
                        <td>Zárva</td>
                    </tr> 
                </table>     
            </div>

        </div>


    </body>
</html>
