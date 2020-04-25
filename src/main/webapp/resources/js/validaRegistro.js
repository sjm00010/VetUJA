$(() => {
    window.ctrl = new registroCtrl(); //Register global var
    ctrl.init(); //Attach view event Handlers
});


class registroCtrl {
    constructor() {
        this.config = {
            formulario: "#fRegistro",
            nombre: "#fRegistro\\:nombre"
           
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
        console.log("Iniciandoo controlador");

    }

    validarFormulario() {
        console.log("Validaciónn registro cliente con JS");
        let el = selector => document.querySelector(selector);
        let nombre = $(this.config.nombre).val();

        let valido = true;
          if (nombre.length < 3 || nombre.length > 12) {
            el('#errNombre').textContent = "La longitud del nombre debe estar entre 3 y 12 caracteress";
            valido = false;
        } else {
            el('#errNombre').textContent = "";
        }

        return valido;
    }
}