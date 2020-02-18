<%-- 
    Document   : citas
    Created on : 16-feb-2020, 13:01:52
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
    <%@include file="../../WEB-INF/jspf/cabecera_admin.jspf" %>

    <body>
        <div class="container espaciado">
            <div class="user">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Fecha, mascota, ..." aria-label="Search">
                    <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Buscar</button>
                </form>
            </div>
            <table class="table table-striped espMen">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Veterinario</th>
                        <th scope="col">Cliente</th>
                        <th scope="col"></th>
                
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>08/02/2020</td>
                        <td>16:30</td>
                        <td>José Ramón</td>
                        <td>Angel Luis</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>06/05/2020</td>
                        <td>10:30</td>
                        <td>Flo</td>
                        <td>Angel Luis</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>15/07/2020</td>
                        <td>9:00</td>
                        <td>José Rámon</td>
                        <td>Angel Luis</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td>15/07/2020</td>
                        <td>17:10</td>
                        <td>José Rámon</td>
                        <td>Angel Luis</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">5</th>
                        <td>01/09/2020</td>
                        <td>12:15</td>
                        <td>Flo</td>
                        <td>Angel Luis</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">6</th>
                        <td>15/07/2020</td>
                        <td>11:00</td>
                        <td>José Rámon</td>
                        <td>Paco</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">7</th>
                        <td>15/07/2020</td>
                        <td>17:10</td>
                        <td>Flo</td>
                        <td>Juan</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                    <tr>
                        <th scope="row">8</th>
                        <td>05/09/2020</td>
                        <td>12:00</td>
                        <td>Flo</td>
                        <td>Sergio</td>
                        <td><img src="../../img/borrar.png" alt="Borrar"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>

    <!--Footer-->
    <%@include file="../../WEB-INF/jspf/footer.jspf" %>
</html>
