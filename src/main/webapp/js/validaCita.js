/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
    var el = selector => document.querySelector(selector);
    var fecha = el('#fAltaCita\\:dia').value;
    var valido = true;
    console.log("Validación con JS");
    if (fecha === null) {
        el('#errFecha')
                .textContent = "La fecha no puede estar vacía";
        valido = false;
    }

    if (fecha < hoyFecha()) {
        el('#errFecha')
                .textContent = "La fecha debe ser posterior a hoy";
        valido = false;
    }

    if (!valido)
        event.preventDefault(); //stop form submit
}
