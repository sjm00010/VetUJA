let el = selector => document.querySelector(selector);
class DuenioCtrl {
    constructor() {
        this.srvUrl = "api/duenio"; //REST service url
        //view-model
    }
    
    init() { }
    
    detalleDuenio(id) {
        let panel = el('#form\\:paneldetalle');
        let enviado = false;
        return fetch(this.srvUrl + "/" + id)
                .then(response => {
                    if (response.ok) {
                        enviado = true; //dueño accepted in server
                    } //else bean-validation errors!
                    return response.json();
                }).then(response => {
            let error = [];
            if (enviado === true) {
                console.log(`Confirmado detalle de dueño: ${response.DNI}`);
                el('#fotoDuenio').innerHTML = `<img src = "${response.foto}" alt="foto cliente" class="card-img" height="100%"/>`;
                el('#detalleNom').innerHTML = `${response.nombre} ${response.apellidos}`;
                el('#detalleDir').innerHTML = `${response.direccion}`;
                panel.style.display = "block";
            } else { //show bean-validation errors
                console.warn(response);
            }
            return enviado;
        }).catch(ex => { //Network error
            panel.style.display = "none";
            console.error("Error en conexión");
            return enviado;
        });
    }
}

window.addEventListener('load', () => {
//Create and initialize controller
    window.ctrl = new DuenioCtrl();
    console.log('Inicializando controlador dueño');
    ctrl.init();
});