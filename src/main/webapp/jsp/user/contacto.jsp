<%-- 
    Document   : contacto
    Created on : 16-feb-2020, 14:20:20
    Author     : sjm00010
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>VetUJA</title>
        <link rel="icon" type="image/vnd.microsoft.icon" href="../../img/icono.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="../../css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>

    <%@include file="../../WEB-INF/jspf/cabecera_user.jspf" %>

    <body>
        <div class="card bg-dark" style="max-width: 100%">
            <img src="../../img/contacto.png" class="card-img" alt="mapa">
            <div class="card-img-overlay">
                <div class="card border-secondary mb-3" style="max-width: 20rem;">
                    <div class="card-header text-dark"><strong>VetUJA</strong></div>
                    <div class="card-body text-dark">
                        <h5 class="card-title">Visitanos</h5>
                        <p class="card-text">Campus Las Lagunillas</p>
                        <p class="card-text">Jaén (Jaén) 23009</p>
                        <p class="card-text">Email: vetuja@ujaen.es</p>
                        <p class="card-text">Tlf: 953 111 111</p>
                    </div>
                </div>
            </div>
        </div>
    </body>    

    <%@include file="../../WEB-INF/jspf/footer.jspf" %>
</html>
