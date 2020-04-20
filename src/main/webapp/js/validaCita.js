$(() => {
    window.ctrl = new citasCtrl(); //Register global var
    ctrl.init(); //Attach view event Handlers
});


class citasCtrl {
    constructor() {
        this.config = {
            formulario: "#fAltaCita",
            fecha: "#fAltaCita\\:dia",
            veterinario: "#fAltaCita\\:vet",
            mascota: "#fAltaCita\\:mas"
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
    }

    validarFormulario() {
        console.log("Validación registro cita con JS");
        let el = selector => document.querySelector(selector);
        let fecha = $(this.config.fecha).val();
        let veterinario = $(this.config.veterinario).val();
        let mascota = $(this.config.mascota).val();

        let valido = true;
        if (fecha === null) {
            el('#errFecha').textContent = "La fecha no puede estar vacíaa.";
            valido = false;
        } else {
            el('#errFecha').textContent = "";
        }

        if (fecha < hoyFecha()) {
            el('#errFecha').textContent = "La fecha debe ser posterior a hoyy.";
            valido = false;
        } else {
            el('#errFecha').textContent = "";
        }

        if (veterinario === null) {
            el('#errVet').textContent = "Se debe seleccionar un veterinarioo";
            valido = false;
        } else {
            el('#errVet').textContent = "";
        }

        if (mascota === null) {
            el('#errMas').textContent = "Se debe seleccionar una mascotaa";
            valido = false;
        } else {
            el('#errMas').textContent = "";
        }


        return valido;
    }
}

function fechaActual() {
    var hoy = new Date();
    var dd = hoy.getDate();
    var mm = hoy.getMonth() + 1; //Empiezan en 0
    var yyyy = hoy.getFullYear();

// Si queremos que los días y meses tengan dos dígitos hacemos lo siguiente
    if (dd < 10) {
        dd = '0' + dd;
    }

    if (mm < 10) {
        mm = '0' + mm;
    }

    hoy = dd + '-' + mm + '-' + yyyy;

    return hoy;
}