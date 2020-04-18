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

function validarFormulario(event) {
    console.log("Validación con JS");
    var el = selector => document.querySelector(selector);
    var fecha = el('#fAltaCita\\:dia').value;
    var veterinario = el('#fAltaCita\\:vet').value;
    var mascota = el('#fAltaCita\\:mas').value;

    var valido = true;
    if (fecha === null) {
        el('#errFecha').textContent = "La fecha no puede estar vacía.";
        valido = false;
    }

    if (fecha < hoyFecha()) {
        el('#errFecha').textContent = "La fecha debe ser posterior a hoy.";
        valido = false;
    }

    if (veterinario === null) {
        el('#errVet').textContent = "Se debe seleccionar un veterinario";
        valido = false;
    }

    if (mascota === null) {
        el('#errMas').textContent = "Se debe seleccionar una mascota";
        valido = false;
    }


    if (!valido)
        event.preventDefault(); //stop form submit
}
