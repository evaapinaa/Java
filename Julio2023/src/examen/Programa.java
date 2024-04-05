package examen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        // Crear el calendario "personal"
        Calendario personalCalendario = new Calendario("personal");

        // Añadir eventos al calendario "personal"
        personalCalendario.añadirEvento("dentista", LocalDateTime.of(2023, 9, 14, 17, 30), 60);
        personalCalendario.añadirEvento("cita médico", LocalDateTime.of(2023, 9, 13, 9, 30), 15);

        // Crear el calendario automático "celebraciones" con recordatorios de 60 minutos
        CalendarioAutomatico celebracionesCalendario = new CalendarioAutomatico("celebraciones",60);

        // Registrar serie de eventos "Cumple María" en el calendario automático "celebraciones"
        LocalDate fechaCumpleMaría = LocalDate.of(2023, 7, 16);
        celebracionesCalendario.registrarSerieEventos("Cumple María", fechaCumpleMaría, 10);

        // Agregar los calendarios a una lista
        List<Calendario> listaCalendarios = new ArrayList<>();
        listaCalendarios.add(personalCalendario);
        listaCalendarios.add(celebracionesCalendario);

        // Recorrer la lista de calendarios y mostrar información
        for (Calendario calendario : listaCalendarios) {
            System.out.println("Nombre del calendario: " + calendario.getNombre());

            if (calendario instanceof CalendarioAutomatico) {
                // Si es un calendario automático, registrar una serie de eventos "¡Acabo el grado!" para mañana con 50 repeticiones
                LocalDate fechaMañana = LocalDate.now().plusDays(1);
                ((CalendarioAutomatico) calendario).registrarSerieEventos("¡Acabo el grado!", fechaMañana, 50);
            }

            System.out.println("Eventos futuros:");
            List<Evento> eventosFuturos = calendario.getEventosFuturos();
            for (Evento evento : eventosFuturos) {
                System.out.println("Evento: " + evento.getNombre() + " - Inicio: " + evento.getInicio());
                System.out.println("Recordatorios:");
                List<Recordatorio> recordatorios = calendario.obtenerTodosRecordatorios(evento);
                for (Recordatorio recordatorio : recordatorios) {
                    System.out.println("- Recordatorio: " + recordatorio.getFechaHora());
                }
            }
        }
     // Suponiendo que listaCalendarios es una lista que contiene tus calendarios creados previamente

     // Itera sobre cada calendario en la lista
     for (Calendario calendario : listaCalendarios) {
         if (!(calendario instanceof CalendarioAutomatico) && 
                 calendario.getEventos().stream()
                         .anyMatch(evento -> evento.getInicio().getYear() == 2023 && evento.getInicio().getMonthValue() == 9)) {
             System.out.println("El calendario normal tiene eventos en septiembre de 2023.");
         }
     }

    }
}
