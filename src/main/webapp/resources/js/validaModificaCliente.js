$(() => {
    window.ctrl = new modifClienteCtrl(); //Register global var
    ctrl.init(); //Attach view event Handlers
});

class modifClienteCtrl {
    constructor() {
        this.config = {
            formulario: "#fModifClienteMC",
            nombre: "#fModifCliente\\:nombreMC",
            apellidos: "#fModifCliente\\:apellidosMC",
            fecha: "#fModifCliente\\:fnacMC",
            direccion: "#fModifCliente\\:direccionMC",
            email: "#fModifCliente\\:emailMC",
            foto: "#fModifCliente\\:fotoMC",
            contrasena: "#fModifCliente\\:passMC"
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
        console.log("Validación modificación cliente con JS");
        let el = selector => document.querySelector(selector);
        let nombre = $(this.config.nombre).val();
        let apellidos = $(this.config.apellidos).val();
        let fnac = $(this.config.fecha).val();
        let dir = $(this.config.direccion).val();
        let email = $(this.config.email).val();
        let foto = $(this.config.foto).val();
        let contrasena = $(this.config.contrasena).val();

        let valido = true;
        //Validación
        if (nombre.length < 3 || nombre.length > 12) {
            el('#errNombreMC').innerHTML = `<p class= "alert alert-danger"> La longitud del nombre debe estar entre 3 y 12 caracteres. </p>`;
            valido = false;
        } else {
            el('#errNombreMC').innerHTML = "";
        }
        if (apellidos.length < 6 || apellidos.length > 20) {
            el('#errApellMC').innerHTML = `<p class="alert alert-danger"> La longitud de los apellidos debe estar entre 6 y 20 caracteres. </p>`;
            valido = false;
        } else {
            el('#errApellMC').innerHTML = "";
        }
        if (fnac.length === 0) {
            el('#errFechaMC').innerHTML = `<p class="alert alert-danger"> Debe introducir una fecha. </p>`;
            valido = false;
        } else {
            el('#errFechaMC').innerHTML = "";
        }
        if (dir.length < 6 || dir.length > 30) {
            el('#errDirMC').innerHTML = `<p class="alert alert-danger"> La longitud de la dirección debe estar entre 6 y 30 caracteres. </p>`;
            valido = false;
        } else {
            el('#errDirMC').innerHTML = "";
        }

        if (email.search(/[a-zA-Z0-9._+-]+@[a-zA-Z]+\.[a-zA-Z.]{2,}/) === -1) {
            el('#errEmailMC').innerHTML = `<p class="alert alert-danger"> El correo debe tener el formato email@email.com </p>`;
            valido = false;
        } else {
            el('#errEmailMC').innerHTML = "";
        }
        if (foto.length === 0) {
            el('#errFotoMC').innerHTML = `<p class="alert alert-danger"> Debe introducir una foto. </p>`;
            valido = false;
        } else {
            el('#errFotoMC').innerHTML = "";
        }
        if (contrasena.length < 6 || contrasena.length > 10) {
            el('#errContrasenaMC').innerHTML = `<p class="alert alert-danger"> La longitud de la contraseña debe estar entre 6 y 10 caracteres. </p>`;
            valido = false;
        } else {
            el('#errContrasenaMC').innerHTML = "";
        }
        return valido;
    }
}

//Ventana emergente
function borrar(event) {
    console.log("Confirma borrado");
    let opcion = confirm("¿Estás seguro de borrar el cliente?");
    console.log(opcion);
    if (opcion === false) {
        console.log("Cancelado");
        event.preventDefault();
    }
}