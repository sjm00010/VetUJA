/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class modifMascotaCtrl {
constructor() {
this.config = {
formulario: "#fModifMascotaMM",
        nombre: "#fModifMascotaMM\\:nombreMM",
        raza: "#fModifMascotaMM\\:razaMM",
        especie: "#fModifMascotaMM\\:especieMM",
        sexo: "#fModifMascotaMM\\:sexoMM",
        fecha: "#fModifMascotaMM\\:fechanacMM",
        altura: "#fModifMascotaMM\\:alturaMM",
        peso: "#fModifMascotaMM\\:pesoMM",
        foto: "#fModifMascotaMM\\:fotoMM",
        cliDNI: "#fModifMascotaMM\\:cliDNIMM",
        vetCC: "#fModifMascotaMM\\:vetCCMM"

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
        let raza = $(this.config.raza).val();
        let especie = $(this.config.especie).val();
        let sexo = $(this.config.sexo).val();
        let fechanac = $(this.config.fecha).val();
        let foto = $(this.config.foto).val();
        let altura = $(this.config.altura).val();
        let peso = $(this.config.peso).val();
        let cliDNI = $(this.config.cliDNI).val();
        let vetCC = $(this.config.vetCC).val();
        let valido = true;
        //Validación mascotas



if (nombre.length < 3 || nombre.length > 12) {
el('#errNombreMM').innerHTML = `<p class= "alert alert-danger"> La longitud del nombre debe estar entre 3 y 12 caracteres. </p>`;
        valido = false;
} else {
el('#errNombreMM').innerHTML = "";
}


if (raza.length < 2 || raza.length > 12) {
el('#errRazaMM').innerHTML = `<p class="alert alert-danger"> La raza debe tener una longitud entre 2 y 12 caracteres. </p>`;
        valido = false;
} else {
el('#errRazaMM').innerHTML = "";
}

if (especie.length < 2 || especie.length > 12) {
el('#errEspecieMM').innerHTML = `<p class="alert alert-danger"> La especie debe tener una longitud entre 2 y 12 caracteres. </p>`;
        valido = false;
} else {
el('#errEspecieMM').innerHTML = "";
}

if (sexo !== "Macho" || sexo !== "Hembra") {
el('#errSexoMM').innerHTML = `<p class="alert alert-danger"> El sexo debe ser Macho o Hembra </p>`;
        valido = false;
} else {
el('#errSexoMM').innerHTML = "";
}

if (altura.length <= 0) {
el('#errAlturaMM').innerHTML = `<p class="alert alert-danger"> La altura debe ser mayor que 0. </p>`;
        valido = false;
} else {
el('#errAlturaMM').innerHTML = "";
}

if (peso.length <= 0) {
el('#errPesoMM').innerHTML = `<p class="alert alert-danger"> El peso tiene que ser mayor a 0 g </p>`;
        valido = false;
} else {
el('#errPesoMM').innerHTML = "";
}

if (fechanac.length === 0) {
el('#errFechaMM').innerHTML = `<p class="alert alert-danger"> Debe introducir una fecha. </p>`;
        valido = false;
} else {
el('#errFechaMM').innerHTML = "";
}


if (foto.length === 0) {
el('#errFotoMM').innerHTML = `<p class="alert alert-danger"> Debe introducir una foto. </p>`;
        valido = false;
} else {
el('#errFotoMM').innerHTML = "";
}

if (cliDNI.search(/^\d{8}([A-Z])$/) === - 1) {
el('#errCliDNIMM').innerHTML = `<p class="alert alert-danger"> El DNI debe tener 8 números y la letra debe estar en mayúscula. </p>`;
        valido = false;
} else {
el('#errCliDNIMM').innerHTML = "";
}

if (vetCC.search(/[A - Z]{2}[0 - 9]{4}) $/)) {
el('#errVetCCMM').innerHTML = `<p class="alert alert-danger"> El código de colegiado debe tener 2 letras y 4 números </p>`;
        valido = false;
} else {
el('#errvetCCMM').innerHTML = "";
}





return valido;
}

}

//Ventana emergente borrado cliente
function borrar(event) {
console.log("Confirma borrado");
        let opcion = confirm("¿Estás seguro de borrar la mascota?");
        console.log(opcion);
        if (opcion === false) {
console.log("Cancelado");
        event.preventDefault();
}
}
//Ventana emergente modificado cliente
function modifica(event) {
console.log("Confirma modificar mascota");
        let opcion = confirm("¿Estás seguro de modificar la mascota?");
        console.log(opcion);
        if (opcion === false) {
console.log("Cancelado");
        event.preventDefault();
}
}
