<%-- 
    Document   : modifCliente
    Created on : 18-feb-2020, 11:15:59
    Author     : PORTATIL
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
    
    <%@include file="../../WEB-INF/jspf/cabecera_admin.jspf" %>
    
    
     <div class="container espaciado">
        <form>
            <h1 class="text-center"><u>Modificación de datos de usuario</u></h1>
            <h2><small class="text-muted">Datos personales</small></h2>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="FormControlInput">Nombre completo</label>
                        <div class="row">
                            <div class="col">
                                <input type="text" class="form-control" id="nombre" placeholder="Nombre" value="Ángel Luis">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" value="García Fernández">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">DNI</label>
                        <input type="text" class="form-control" id="dni" placeholder="Ej. 12345678A" value="54215624R">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">Fecha de nacimiento</label>
                        <input class="form-control" type="date" value="1976-11-06" id="example-date-input">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">Dirección</label>
                        <input type="text" class="form-control" id="direccion" placeholder="Ej. Avenida de Madrid, 5" value="Campus Las Lagnillas">
                    </div>
                </div>
                <div class="col-6">
                    <label for="foto">Foto</label>
                    <input type="file" class="form-control-file" id="foto">
                </div>
            </div>
            <h2><small class="text-muted">Datos de usuario</small></h2>
            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">Usuario</label>
                        <input type="text" class="form-control" id="usuario" placeholder="Usuario" value="algarcia">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="email">Correo electrónico</label>
                        <input type="text" class="form-control" id="email" placeholder="nombre@ejemplo.es" value="algarcia@ujaen.es">
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <label for="pass">Contraseña</label>
                        <div class="row">
                            <div class="col">
                                <input type="text" class="form-control" id="pass" placeholder="Contraseña" value="contrasenaDificil2">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" id="pass2" placeholder="Repite la contraseña" value="contrasenaDificil2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="espMen">
                <!--para el formulario hace falta boton type="submit"-->
                <a class="eBoton btn btn-success btn-lg btn-block" href="../../index.jsp">Guardar</a>
            </div>
        </form>
    
    <%@include file="../../WEB-INF/jspf/footer.jspf" %>
</html>
