/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author cesar
 */
public class LineamientosResidencias {

    public static String obtenerTextoLineamiento(String lineamientoSeleccionado) {
        int numero = extraerNumero(lineamientoSeleccionado);

        switch (numero) {
            case 1:
                return "1. Es obligación de todos los Residentes cumplir y hacer cumplir los Lineamientos de Vida Comunitaria de Residencias Estudiantiles ITSON. El desconocimiento de dichos lineamientos no exime de la obligatoriedad de ser cumplidos.";
            case 2:
                return "2. El Residente tiene el derecho a disfrutar de todos los servicios y programas ofrecidos por Residencias, habiendo hecho los pagos correspondientes. Estos servicios pueden ser suspendidos por periodos de tiempo en caso de indisciplina, sanciones o adeudos.";
            case 3:
                return "3. El Residente tiene la obligación de respetar los derechos de los demás Residentes y del personal relacionado a Residencias, así como no poner en riesgo la integridad física, emocional o social de las personas.";
            case 4:
                return "4. Es responsabilidad de todo Residente portar todo el tiempo su identificación con fotografía y presentarla al personal de Residencias, administrativo y de seguridad, cuando se le requiera. Las credenciales son únicas e intransferibles; en caso de préstamo y uso indebido, el residente será amonestado.";
            case 5:
                return "5. Residencias no es responsable por extravíos, robos, pérdidas y/o daños por incendios, inundaciones u otras causas de fuerza mayor, en los bienes y propiedades de los Residentes.";
            case 6:
                return "6. El Residente debe contar con un seguro de gastos médicos mayores o IMSS, ya que los gastos generados por enfermedad y/o accidentes serán cubiertos por el Residente.";
            case 7:
                return "7. El Residente deberá notificar a la administración de Residencias si padece alguna lesión grave, tratamiento médico, psicológico o psiquiátrico, o si requiere medicamento o sustancia controlada para su salud, presentando receta o documento médico correspondiente.";
            case 8:
                return "8. Todas las personas que ingresen a las instalaciones de Residencias Estudiantiles ITSON deberán cumplir con el filtro sanitario correspondiente ante cualquier contingencia sanitaria.";
            case 9:
                return "9. Las autoridades de Residencias Estudiantiles ITSON están conformadas por Administrador de Recintos, Asistente de Procesos y Proyectos, Auxiliar Administrativo y/o de Servicios, Técnico de Mantenimiento, Asistentes de Residencias, personal de seguridad y vigilancia.";
            case 10:
                return "10. Deberá haber mutuo respeto y amabilidad entre el personal de Residencias y los Residentes, evitando excesos de confianza que puedan ocasionar malentendidos o conflictos.";
            case 11:
                return "11. Queda prohibido que los empleados reciban directamente de los Residentes algún presente monetario. Toda donación deberá canalizarse por medio de la oficina de Residencias mediante el formato correspondiente.";
            case 12:
                return "12. Los Asistentes de Residencias o personal administrativo pueden realizar juntas o publicaciones para comunicar eventos importantes. El residente es responsable del cumplimiento de toda información publicada o vista en reunión, asista o no.";
            case 13:
                return "13. El derecho de admisión se reserva en el área de Administración de Residencias. Esta área informará al solicitante la disponibilidad de espacios y el procedimiento de ingreso.";
            case 14:
                return "14. Los Residentes aceptados deberán realizar el pago del depósito-garantía o firma de pagaré, según corresponda, para reservar su lugar dentro de las fechas límite indicadas.";
            case 15:
                return "15. Check-in a Residencias: debe realizarse al inicio de cada periodo o cambio de habitación, siguiendo los requisitos, horarios, revisión de habitación, firma de reporte de condiciones, recepción de llaves y resguardos correspondientes.";
            case 16:
                return "16. Check-out de Residencias: debe realizarse al final de cada periodo, baja o cambio de habitación. El residente debe acordar fecha y hora, limpiar habitación y baño, devolver muebles, retirar pertenencias, firmar reporte y regresar llaves.";
            case 17:
                return "17. Áreas comunes: el residente debe hacer buen uso de patios, escaleras, pasillos, balcones, gimnasio, lavandería, salas, cocinas y áreas de estudio. Debe recoger basura y dejar mobiliario en su lugar. Dormir en áreas comunes está prohibido.";
            case 18:
                return "18. Daños: el residente será responsable financieramente por cualquier daño o pérdida de propiedad derivado de su comportamiento personal o participación en actividades grupales.";
            case 19:
                return "19. Limpieza: es obligación del Residente mantener en óptimas condiciones de higiene su persona, ropa, objetos personales, baño, habitación, cocinas y áreas comunes después de usarlas.";
            case 20:
                return "20. Mobiliarios y propiedad del edificio: el mobiliario de áreas comunes no puede ser introducido a habitaciones ni viceversa. Debe usarse solamente en sus áreas correspondientes.";
            case 21:
                return "21. Recursos y consumibles: los Residentes deben preservar los recursos de las instalaciones, apagar luces, cuidar el aire acondicionado y reportar fugas de agua, gas u otros recursos.";
            case 22:
                return "22. Periódicos murales y publicaciones: queda prohibido maltratar periódicos murales, clavar, pegar, rayar o golpear puertas, muebles y paredes de Residencias.";
            case 23:
                return "23. Conexiones eléctricas y aparatos: no se deben mover o alterar conexiones o aparatos eléctricos. El mal uso, daño o pérdida puede generar multa, pago de reparación o pérdida del derecho de alojamiento.";
            case 24:
                return "24. Lavandería: no se permite alterar equipos, sentarse sobre máquinas, golpearlas, sobrecargarlas, introducir calzado u objetos no permitidos. Las prendas olvidadas podrán considerarse para desecho y las faltas pueden generar sanciones.";
            case 25:
                return "25. Cocina comunitaria: el residente debe hacer buen uso del área, mantenerla limpia, traer sus utensilios e ingredientes, apagar estufa, cerrar llaves de agua, cuidar refrigeradores y respetar pertenencias de otros residentes.";
            case 26:
                return "26. Áreas de socialización: los residentes deben mantener el volumen de reproductores de sonido en nivel moderado. Está prohibida la exhibición de contenido pornográfico o contrario a los valores institucionales.";
            case 27:
                return "27. Apuestas y juegos de azar: las apuestas y juegos de azar no están permitidos dentro de Residencias.";
            case 28:
                return "28. Accesos no autorizados: las áreas restringidas incluyen techos, cuartos de limpieza, eléctricos, voz y datos, mantenimiento y bodegas, además de las que determine la administración.";
            case 29:
                return "29. Llaves de acceso: las llaves son responsabilidad del Residente, no pueden darse a otros, copiarse, cambiar chapas o colocar candados sin autorización escrita de la Administración.";
            case 30:
                return "30. Olvido o extravío de llaves: se permite abrir la habitación una sola vez durante la estancia sin sanción; en más ocasiones se cobrará un cargo de $100.00 MXN por cada olvido.";
            case 31:
                return "31. Aparatos eléctricos y utensilios en habitaciones: se permiten ciertos aparatos siempre que no ocasionen problemas. No se permite usar microondas, ollas, tostadores, parrillas, licuadoras ni electrodomésticos similares dentro de las habitaciones.";
            case 32:
                return "32. Muebles de habitaciones y ropa de cama: las habitaciones cuentan con mobiliario básico. No están permitidas camas de agua, camas extras, lámparas de halógeno, literas ni construcciones o repisas no autorizadas.";
            case 33:
                return "33. Decoración en cuartos: están prohibidos clavos, chinchetas, pines, papel crepe, acetatos y adhesivos. Las decoraciones no deben extenderse al pasillo ni ser ofensivas, explícitas o denigrantes.";
            case 34:
                return "34. Ventanas y balcones: está prohibido dañar ventanas, colocar letreros al exterior, dejar caer, suspender, tirar o disparar objetos, así como colgar letreros, banderas, ropa o calzado en balcones.";
            case 35:
                return "35. Pintura: no se permite pintar paredes, puertas de habitación ni áreas de Residencias, a menos que sea indicado como parte de una sanción por daño a la pintura.";
            case 36:
                return "36. Inspección de habitación: pueden realizarse inspecciones por salud, seguridad, sospecha de incumplimiento, preparación de cierre de periodo o mantenimiento. El residente debe permitir el acceso al personal autorizado.";
            case 37:
                return "37. Preparación para compañero: si el residente no tiene compañero asignado, debe mantener el lado del compañero limpio y listo para ser ocupado en cualquier momento.";
            case 38:
                return "38. Acuerdo de compañeros de habitación: el residente deberá estar disponible para llenar y firmar acuerdos de convivencia, comunicación, aseo y compañerismo. Violar estos acuerdos puede generar pérdida del derecho de alojamiento.";
            case 39:
                return "39. Bicicletas, motocicletas, patines y patinetas: no se permite usar o guardar motocicletas en cuartos o edificios. Bicicletas y motocicletas deben estacionarse afuera, y el uso de patines o patineta está prohibido dentro del edificio.";
            case 40:
                return "40. Visitas: los visitantes deben registrarse, entregar identificación, portar gafete, estar acompañados por el residente, permanecer en áreas permitidas y cumplir horarios. El residente es responsable de su comportamiento.";
            case 41:
                return "41. Mascotas: no se permiten mascotas de ninguna especie ni propiciar el acercamiento de animales a las instalaciones. El incumplimiento será sancionado según determine la Administración.";
            case 42:
                return "42. Seguridad: promover la seguridad es responsabilidad de todos. No se deben dejar puertas abiertas, trabadas o manipuladas, y se deben resguardar objetos de valor.";
            case 43:
                return "43. Seguridad contra incendios: se deben seguir procedimientos de evacuación y lineamientos. Quedan prohibidos incienso, velas, cerillos, líquidos inflamables, falsas alarmas o interferir con equipos de seguridad.";
            case 44:
                return "44. Conducta perjudicial y negativa: cualquier actividad que impacte negativamente el uso razonable de Residencias o afecte objetivos académicos, privacidad, salud, seguridad o derechos de otros no está permitida.";
            case 45:
                return "45. Respeto y equidad: el lenguaje verbal y corporal debe ser congruente con los valores institucionales. No se permite abuso físico, verbal, mental, psicológico o sexual, ni intolerancia, acoso, intimidación o amenaza.";
            case 46:
                return "46. Agresión: se define como causar daño físico, poner a otra persona en peligro, tocar con intención de lastimar, insultar o provocar. La agresión puede generar expulsión de Residencias.";
            case 47:
                return "47. Acoso: el acoso sexual o de cualquier índole está prohibido. Incluye violencia física, amenazas, lenguaje ofensivo, acercamientos sexuales no bienvenidos y conductas físicas o verbales de naturaleza sexual.";
            case 48:
                return "48. Conducta sexual impropia: cualquier toque, caricia, exhibición o manipulación de genitales o intimidad de cualquier parte del cuerpo, directa o indirectamente expuesta, es considerada conducta sexual impropia.";
            case 49:
                return "49. Vestimenta: los residentes no pueden salir de sus habitaciones sin vestimenta, en ropa interior, en toalla o ropa de cama que deje el cuerpo descubierto.";
            case 50:
                return "50. Ruido: el ruido molesto para otros Residentes está prohibido. Debe mantenerse silencio razonable en áreas comunitarias y responder positivamente a solicitudes para reducir ruido.";
            case 51:
                return "51. Robo: el robo de pertenencias personales o universitarias puede llevar a proceso judicial. Incluye préstamos no autorizados, posesión de propiedad confiscada o robada.";
            case 52:
                return "52. Armas: Residencias es una instalación sin armas. Están prohibidas armas de fuego, simuladas, químicos peligrosos, explosivos, navajas u objetos que puedan intimidar, amenazar o poner en peligro.";
            case 53:
                return "53. Bebidas alcohólicas: no se permite elaborar, poseer, transportar, comercializar, distribuir o consumir alcohol en habitaciones ni áreas de Residencias, ni poseer contenedores de alcohol como decoración.";
            case 54:
                return "54. Drogas: no se permite cultivar, poseer, elaborar, transportar, comercializar, distribuir o consumir narcóticos o drogas ilegales en Residencias ni alrededor de esta. La falta puede generar expulsión y consignación.";
            case 55:
                return "55. Fumar: fumar no está permitido dentro de Residencias. El incumplimiento genera una sanción que puede ser el desarrollo de servicio comunitario a beneficio de Residencias o la expulsión si la falta es recurrente.";
            case 56:
                return "56. Trámites de alta para servicios médicos: es responsabilidad del Residente tramitar servicios médicos como Seguro de Accidentes Personales y Escolares, IMSS o seguros adicionales. Los gastos de emergencia corren a cargo del Residente.";
            case 57:
                return "57. Sospecha o amenaza de suicidio: en caso de amenaza o sospecha, se informará a padres o tutor y se canalizará al departamento de consejería o a un hospital para su atención y evaluación.";
            case 58:
                return "58. Presencia durante una violación de lineamientos: estar presente en un área o evento donde ocurra una falta se considera violación. El residente debe abandonar el área y reportar la situación inmediatamente.";
            case 59:
                return "59. Lineamientos de Casa: estos lineamientos están sujetos a cambio para beneficio de la comunidad. Los lineamientos exclusivos de edificio, sección, piso o área común serán publicados y comunicados. Cualquier incidente no previsto será tratado por las autoridades.";
            default:
                return "Lineamiento no especificado.";
        }
    }

    public static int extraerNumero(String lineamientoSeleccionado) {
        if (lineamientoSeleccionado == null) {
            return 0;
        }

        String soloNumeros = lineamientoSeleccionado.replaceAll("[^0-9]", "");

        if (soloNumeros.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(soloNumeros);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
