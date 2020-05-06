//Ventana emergente
function borrar(event) {
    console.log("Confirma borrado");
    let opcion = confirm("¿Estás seguro de borrar la cita?");
    console.log(opcion);
    if (opcion  === false) {
        console.log("Cancelado");
        event.preventDefault();
    }
}