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
            email: "#fRegistro\\:email"
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
        console.log("Validación registro cliente con JS");
        let el = selector => document.querySelector(selector);
        let nombre = $(this.config.nombre).val();
        let apellidos = $(this.config.apellidos).val();
        let dni = $(this.config.dni).val();
        let fnac = $(this.config.fecha).val();
        let dir = $(this.config.direccion).val();
        let email = $(this.config.email).val();



        let valido = true;
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

        return valido;
    }
}
