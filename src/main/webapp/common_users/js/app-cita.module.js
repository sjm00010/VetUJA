
class ControladorCitas {
    constructor($http) {
        console.log("Controlador cargado");
        this.$http = $http;
        this.serviceUrl = 'api/cita';

        //init view-model
        this.cc=""
        this.selec=false;
        this.veterinarios = [];
        this.horas = [];
        this.cargaVeterinarios();
    }
    
    cargaVeterinarios() {
        this.$http({
            method: 'GET',
            url: this.serviceUrl
        }).then(response => {
            console.log("Veterinarios cargados");
            this.veterinarios = response.data;
        });
    }
    
    muestraHorario(cc){
        this.cc=cc;
        this.$http.get(this.serviceUrl + '/' + cc)
                .then(response => {
                    this.horas = response.data;
                    this.errorMsgs = [];
                }).then(() => this.visualiza()
        ).catch(response => { //bean validation errors
            this.errorMsgs = response.data;
        });
    }
    
    visualiza(){
        this.selec = true;
    }
}

ControladorCitas.$inject = ['$http'];

const appCitasComponent = {
    templateUrl: "./js/app-citas.template.html",
    controller: ControladorCitas
};

export const AppLibrosModule = angular
        .module("citas.app", [])
        .component("appCitas", appCitasComponent)
        .name;
