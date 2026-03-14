const rolSeleccionado = document.getElementById("selectRol");
const formularioOdonto = document.getElementById("formularioOdonto");
const formularioSecre = document.getElementById("formularioSecre");
const opcionRolCrear = document.getElementById("crearRol");
rolSeleccionado.addEventListener("change",(event)=>{

    let rol = event.target.value;
        console.log("cambio en select", rol);
        console.log(formularioOdonto);
    if ("Odontologo"===rol ) {
        formularioOdonto.hidden = false;
        formularioSecre.hidden = true;
        opcionRolCrear.value="crearOdontologo";
    }
    
    if ("Secretario"===rol){
        formularioSecre.hidden = false;
        formularioOdonto.hidden = true;
        opcionRolCrear.value="crearSecretario";
    }
});
