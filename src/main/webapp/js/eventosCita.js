document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'es',
        headerToolbar: {
            start: 'dayGridMonth,timeGridWeek,timeGridDay',
            center: 'title',
            end: 'prevYear,prev,next,nextYear'
        },
        buttonText: {
            month: 'Mes',
            week: 'Semana',
            day: 'Día'
        },
        initialView: 'dayGridMonth',
        aspectRatio: window.innerWidth < 768 ? 1 : 2.5,
        contentHeight: 'auto',
        events: [
            {// this object will be "parsed" into an Event Object
                id: 'evento1',
                title: 'Felipe Torres', // a property!
                start: '2026-03-18T08:00:00',
                end: '2026-03-18T08:30:00',// a property!
                editable: true,// a property! ** see important note below about 'end' **
                extendedProps:{
                    nombre: 'Felipe'
                }
            },
                        {// this object will be "parsed" into an Event Object
                id: 'evento2',
                title: 'Felipe Torres', // a property!
                start: '2026-03-18T08:30:00',
                end: '2026-03-18T09:00:00',// a property!
                editable: true,// a property! ** see important note below about 'end' **
                extendedProps:{
                    nombre: 'Felipe'
                }
            }
        ],
        eventClick: function (info) {
            console.log("Se presionó el evento del calendario");
            console.log("ID:", info.event.id);
            console.log("nombre: ", info.event.extendedProps.nombre);
            window.location.replace("http://www.w3schools.com");
        }

    });
    calendar.render();


});






