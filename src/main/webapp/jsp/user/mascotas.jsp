<%-- 
    Document   : mascotas
    Created on : 16-feb-2020, 21:13:10
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

    <!--Cabecera-->
    <%@include file="../../WEB-INF/jspf/cabecera_user.jspf" %>

    <body>
        <div class="container espaciado">
            <div class="card mb-3" style="max-width: 100%;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="../../img/remy.png" class="card-img" alt="foto mascota">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h3 class="card-title">Remy</h3>
                            <p class="card-text h4"><strong>Código de identificación :</strong> 938000000455987</p>
                            <p class="card-text h4"><strong>Edad :</strong> 5 años</p>
                            <p class="card-text h4"><strong>Raza :</strong> Rata</p>
                            <a href="#" class="espaciado btn btn-info btn-lg btn-block">+ Información</a>
                            
                        </div>
                    </div>
                </div>
            </div>
            <div class="card mb-3" style="max-width: 100%;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="../../img/gato.jpg" class="card-img" alt="foto mascota">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h3 class="card-title">Misifu</h3>
                            <p class="card-text h4"><strong>Código de identificación :</strong> 938000159457532</p>
                            <p class="card-text h4"><strong>Edad :</strong> 10 años</p>
                            <p class="card-text h4"><strong>Raza :</strong> Gato siames</p>
                            <a href="#" class="espaciado btn btn-info btn-lg btn-block">+ Información</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <!--Footer-->
    <%@include file="../../WEB-INF/jspf/footer.jspf" %>
</html>
