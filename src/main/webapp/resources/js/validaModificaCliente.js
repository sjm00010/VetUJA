$(() => {
    window.ctrl = new modifClienteCtrl(); //Register global var
    ctrl.init(); //Attach view event Handlers
});

class modifClienteCtrl {
    constructor() {
        this.config = {
            formulario: "#fModifCliente",
            nombre: "#fModifCliente\\:nombre",
            apellidos: "#fModifCliente\\:apellidos",
            dni: "#fModifCliente\\:dni",
            fecha: "#fModifCliente\\:fnac",
            direccion: "#fModifCliente\\:direccion",
            email: "#fModifCliente\\:email",
            foto: "#fModifCliente\\:foto",
            contrasena: "#fModifCliente\\:pass",
            contrasena2: "#fModifCliente\\:pass2"
        };
    }
    
    init() {
        $(this.config.formulario)
                .on('submit', event => { //ev. handler
                    if (this.validarFormulario() === false) {
                        //Stop submission
                        event.preventDefault();
                    };
                });
        console.log("Iniciando controlador JS");

    }
    
    validarFormulario() {
        console.log("Validación modificación cliente con JS");
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
            el('#errNombre').textContent = "La longitud del nombre debe estar entre 3 y 12 caracteres.";
            valido = false;
        } else {
            el('#errNombre').textContent = "";
        }
        if (apellidos.length < 6 || apellidos.length > 20) {
            el('#errApell').textContent = "La longitud de los apellidos debe estar entre 6 y 20 caracteres.";
            valido = false;
        } else {
            el('#errApell').textContent = "";
        }

        if (dni.search(/^\d{8}([A-Z])$/) === -1) {
            el('#errDni').textContent = "El DNI debe tener 8 números y la letra debe estar en mayúscula.";
            valido = false;
        } else {
            el('#errDni').textContent = "";
        }
        if (fnac.length === 0) {
            el('#errFecha').textContent = "Debe introducir una fecha";
            valido = false;
        } else {
            el('#errFecha').textContent = "";
        }
        if (dir.length < 6 || dir.length > 30) {
            el('#errDir').textContent = "La longitud de la dirección debe estar entre 6 y 30 caracteres.";
            valido = false;
        } else {
            el('#errDir').textContent = "";
        }

        if (email.search(/[a-zA-Z0-9._+-]+@[a-zA-Z]+\.[a-zA-Z.]{2,}/) === -1) {
            el('#errEmail').textContent = "El correo debe tener el formato email@email.com";
            valido = false;
        } else {
            el('#errEmail').textContent = "";
        }
        if (foto.length === 0) {
            el('#errFoto').textContent = "Debe introducir una foto";
            valido = false;
        } else {
            el('#errFoto').textContent = "";
        }
        if (contrasena1.length < 6 || contrasena1.length > 10) {
            el('#errContrasena1').textContent = "La longitud de la contraseña debe estar entre 6 y 10 caracteres.";
            valido = false;
        } else {
            el('#errContrasena1').textContent = "";
        }
        if (contrasena2.length < 6 || contrasena2.length > 10) {
            el('#errContrasena2').textContent = "La longitud de la contraseña debe estar entre 6 y 10 caracteres.";
            valido = false;
        } else {
            el('#errContrasena2').textContent = "";
        }
        if (contrasena1 !== contrasena2) {
            el('#errContrasena1').textContent = "Las contraseñas deben ser iguales";
            valido = false;
        } else {
            el('#errContrasena1').textContent = "";
        }
        
        return valido;
    }
}