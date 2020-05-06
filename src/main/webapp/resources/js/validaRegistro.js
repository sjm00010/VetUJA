$(() => {
    window.ctrl = new registroCtrl(); //Register global var
    ctrl.init(); //Attach view event Handlers
});


class registroCtrl {
    constructor() {
        this.config = {
            formulario: "#fRegistro",
            nombre: "#fRegistro\\:nombre",
            apellidos: "#fRegistro\\:apellidos",
            dni: "#fRegistro\\:dni",
            fecha: "#fRegistro\\:fnac",
            direccion: "#fRegistro\\:direccion",
            email: "#fRegistro\\:email",
            foto: "#fRegistro\\:foto",
            contrasena: "#fRegistro\\:pass",
            contrasena2: "#fRegistro\\:pass2"
        };
    }
    init() {
        $(this.config.formulario)
                .on('submit', event => { //ev. handler
                    if (this.validarFormulario() === false) {
                        //Stop submission
                        event.preventDefault();
                    }
                    ;
                });
        console.log("Iniciando controlador JS");

    }

    validarFormulario() {
        console.log("Validación registro cliente con JS");
        let el = selector => document.querySelector(selector);
        let nombre = $(this.config.nombre).val();
        let apellidos = $(this.config.apellidos).val();
        let dni = $(this.config.dni).val();
        let fnac = $(this.config.fecha).val();
        let dir = $(this.config.direccion).val();
        let email = $(this.config.email).val();
        let foto = $(this.config.foto).val();
        let contrasena1 = $(this.config.contrasena).val();
        let contrasena2 = $(this.config.contrasena2).val();

        let valido = true;
        //Validación
        if (nombre.length < 3 || nombre.length > 12) {
            el('#errNombre').innerHTML = `<p class= "alert alert-danger"> La longitud del nombre debe estar entre 3 y 12 caracteres. </p>`;
            valido = false;
        } else {
            el('#errNombre').innerHTML = "";
        }
        if (apellidos.length < 6 || apellidos.length > 20) {
            el('#errApell').innerHTML = `<p class="alert alert-danger"> La longitud de los apellidos debe estar entre 6 y 20 caracteres. </p>`;
            valido = false;
        } else {
            el('#errApell').innerHTML = "";
        }

        if (dni.search(/^\d{8}([A-Z])$/) === -1) {
            el('#errDni').innerHTML = `<p class="alert alert-danger"> El DNI debe tener 8 números y la letra debe estar en mayúscula. </p>`;
            valido = false;
        } else {
            el('#errDni').innerHTML = "";
        }
        if (fnac.length === 0) {
            el('#errFecha').innerHTML = `<p class="alert alert-danger"> Debe introducir una fecha. </p>`;
            valido = false;
        } else {
            el('#errFecha').innerHTML = "";
        }
        if (dir.length < 6 || dir.length > 30) {
            el('#errDir').innerHTML = `<p class="alert alert-danger"> La longitud de la dirección debe estar entre 6 y 30 caracteres. </p>`;
            valido = false;
        } else {
            el('#errDir').innerHTML = "";
        }

        if (email.search(/[a-zA-Z0-9._+-]+@[a-zA-Z]+\.[a-zA-Z.]{2,}/) === -1) {
            el('#errEmail').innerHTML = `<p class="alert alert-danger"> El correo debe tener el formato email@email.com </p>`;
            valido = false;
        } else {
            el('#errEmail').innerHTML = "";
        }
        if (foto.length === 0) {
            el('#errFoto').innerHTML = `<p class="alert alert-danger"> Debe introducir una foto. </p>`;
            valido = false;
        } else {
            el('#errFoto').innerHTML = "";
        }
        if (contrasena1.length < 6 || contrasena1.length > 10) {
            el('#errContrasena1').innerHTML = `<p class="alert alert-danger"> La longitud de la contraseña debe estar entre 6 y 10 caracteres. </p>`;
            valido = false;
        } else {
            el('#errContrasena1').innerHTML = "";
        }
        if (contrasena2.length < 6 || contrasena2.length > 10) {
            el('#errContrasena2').innerHTML = `<p class="alert alert-danger"> La longitud de la contraseña debe estar entre 6 y 10 caracteres.</p>`;
            valido = false;
        } else {
            el('#errContrasena2').innerHTML = "";
        }
        if (contrasena1 !== contrasena2) {
            el('#errContrasena1').innerHTML = `<p class="alert alert-danger"> Las contraseñas deben ser iguales </p>`;
            valido = false;
        } else {
            el('#errContrasena1').innerHTML = "";
        }

        return valido;
    }
}

//Ventana emergente
function bienvenida(event) {
    console.log("Mensaje registro bienvenida");
    let opcion = alert("Registro realizado correctamente");
    console.log(opcion);
    if (opcion === false) {
        console.log("Cancelado");
        event.preventDefault();
    }
}
