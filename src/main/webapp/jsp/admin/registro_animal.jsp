<%-- 
    Document   : registro_animal
    Created on : 16-feb-2020, 2:46:40
    Author     : PC
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
    <div class="container espaciado">
        <form>
            <h1 class="text-center"><u>Registro animal</u></h1>
            <h2><small class="text-muted">Datos de la mascota</small></h2>
            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="ci">Código de identificacion</label>
                        <input type="text" class="form-control" id="ci" placeholder="13 dígitos">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" placeholder="Ej. Pipo">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="raza">Raza</label>
                        <input type="text" class="form-control" id="raza" placeholder="Ej. Gran danés">
                    </div>
                </div>
                <div class="col-6">
                    <label for="sexo">Sexo</label>
                    <select class="form-control" id="sexo">
                        <option>Macho</option>
                        <option>Hembra</option>
                    </select>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="fechanac">Fecha de nacimiento</label>
                        <input class="form-control" type="date" value="2000-01-01" id="fechanac">
                    </div>
                </div>
                <div class="col-6">
                    <label for="foto">Foto de la mascota</label>
                    <input type="file" class="form-control-file" id="foto">
                </div>
            </div>
            <h2><small class="text-muted">Datos del dueño</small></h2>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="dni">DNI</label>
                        <input type="text" class="form-control" id="dni" placeholder="1111111A">
                    </div>
                </div>
            </div>
            <div class="espMen">
                <!--para el formulario hace falta boton type="submit"-->
                <a class="eBoton btn btn-secondary btn-lg btn-block" href="mascotas.jsp">Registrar animal</a>
            </div>
        </form>

        <%@include file="../../WEB-INF/jspf/footer.jspf" %>
</html>
