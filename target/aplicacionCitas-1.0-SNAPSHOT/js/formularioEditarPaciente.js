const selectorFecha = document.getElementById("fechaNacPaciente");
const formularioResponsable = document.getElementById("formularioResponsable");

document.addEventListener("DOMContentLoaded",()=>{
    console.log("Se activo el evento de carga pagina");
    
   
    
    const fechaActual = new Date();
    const [año, mes, dia] = selectorFecha.value.split("-");
    const fechaNacimientoPaciente = new Date(año,mes-1,dia);
    let edad = fechaActual.getFullYear()-fechaNacimientoPaciente.getFullYear();
    
    const mesActual = fechaActual.getMonth();
    const diaActual = fechaActual.getDate();
    
    const mesNacimiento = fechaNacimientoPaciente.getMonth();
    const diaNacimiento = fechaNacimientoPaciente.getDate();
    
    if (mesActual<mesNacimiento ||
       ( mesActual === mesNacimiento && diaActual<diaNacimiento)){
       edad--;
    }
    
    if (edad<18){
        formularioResponsable.hidden = false;
    }else{
        formularioResponsable.hidden = true;
    }


});
