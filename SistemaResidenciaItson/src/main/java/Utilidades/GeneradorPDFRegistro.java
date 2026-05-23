package Utilidades;

import Negocio.DTOs.ResidenteDTO;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.net.URL;

/**
 * * @author Tesis
 */
public class GeneradorPDFRegistro {

    public static void generarRegistroResidente(String rutaArchivo, ResidenteDTO residente) {

        try {
            // Inicializar PDF
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document documento = new Document(pdfDoc, PageSize.LETTER);
            documento.setMargins(20, 20, 20, 20);

            // Encabezado de 3 columnas: logo - titulos - logo
            try {
                URL urlIzq = GeneradorPDFRegistro.class.getResource("/Imagenes/LogoLetrasChico.png");
                URL urlDer = GeneradorPDFRegistro.class.getResource("/Imagenes/LogoItsonCam.png");

                Table tabCabecera = new Table(UnitValue.createPercentArray(new float[]{2, 6, 2})).useAllAvailableWidth();
                tabCabecera.setBorder(Border.NO_BORDER);

                // Logo izquierdo
                Cell celdaIzq = new Cell().setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                if (urlIzq != null) {
                    Image imgIzquierda = new Image(ImageDataFactory.create(urlIzq));
                    imgIzquierda.scaleToFit(110f, 60f);
                    imgIzquierda.setHorizontalAlignment(HorizontalAlignment.LEFT);
                    celdaIzq.add(imgIzquierda);
                }
                tabCabecera.addCell(celdaIzq);

                // Titulos en el centro
                Cell celdaCentro = new Cell().setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                celdaCentro.setTextAlignment(TextAlignment.CENTER);

                celdaCentro.add(new Paragraph("RESIDENCIAS ESTUDIANTILES ITSON")
                        .setFontSize(14).setBold().setMarginBottom(0));
                celdaCentro.add(new Paragraph("Registro de Datos Personales (RDP)")
                        .setFontSize(12).setBold().setMarginTop(0).setMarginBottom(0));
                celdaCentro.add(new Paragraph("RESI-POP-FO-05-06")
                        .setFontSize(8).setItalic().setMarginTop(0));

                tabCabecera.addCell(celdaCentro);

                // logo derecho
                Cell celdaDer = new Cell().setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                celdaDer.setTextAlignment(TextAlignment.RIGHT);
                if (urlDer != null) {
                    Image imgDerecha = new Image(ImageDataFactory.create(urlDer));
                    imgDerecha.scaleToFit(90f, 60f);
                    imgDerecha.setHorizontalAlignment(HorizontalAlignment.RIGHT);
                    celdaDer.add(imgDerecha);
                }
                tabCabecera.addCell(celdaDer);

                documento.add(tabCabecera);

            } catch (Exception e) {
                System.err.println("Error cargando logos: " + e.getMessage());
            }

            // Texto de confidencialidad
            documento.add(new Paragraph("La información proporcionada es confidencial y para uso interno de Residencias Estudiantiles ITSON.")
                    .setFontSize(9).setItalic().setTextAlignment(TextAlignment.CENTER).setMarginTop(5f));

            documento.add(new Paragraph("\n"));

            // === DATOS DEL SOLICITANTE ===
            documento.add(new Paragraph("Datos del Solicitante").setBold().setFontSize(10));
            Table tabSolicitante = new Table(UnitValue.createPercentArray(new float[]{2, 3, 2, 3})).useAllAvailableWidth();

            agregarCelda(tabSolicitante, "Nombre completo:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getNombreCompleto()), false, 3);

            agregarCelda(tabSolicitante, "Carrera:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getCarrera()), false);

            agregarCelda(tabSolicitante, "Semestre:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getSemestre()), false);

            agregarCelda(tabSolicitante, "Periodo de residencia:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getPeriodoResidencia()), false, 3);

            agregarCelda(tabSolicitante, "ID (ITSON):", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getIdAcademico()), false, 3);

            agregarCelda(tabSolicitante, "Fecha de nacimiento:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.fecha(residente.getFechaNacimiento()), false);

            agregarCelda(tabSolicitante, "Sexo:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getSexo()), false);

            agregarCelda(tabSolicitante, "CURP:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getCurp()), false);

            agregarCelda(tabSolicitante, "Número afiliación IMSS:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getNss()), false);

            agregarCelda(tabSolicitante, "Domicilio:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getDomicilio()), false, 3);

            agregarCelda(tabSolicitante, "Ciudad:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getLugarResidencia()), false);

            agregarCelda(tabSolicitante, "Teléfono:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getTelefono()), false);

            agregarCelda(tabSolicitante, "Celular:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getCelular()), false);

            agregarCelda(tabSolicitante, "Email:", true);
            agregarCelda(tabSolicitante, UtilidadPDF.texto(residente.getCorreo()), false, 3);

            documento.add(tabSolicitante);
            documento.add(new Paragraph("\n"));

            // === DATOS DEL TUTOR ===
            documento.add(new Paragraph("Datos del Tutor").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabTutor = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4})).useAllAvailableWidth();

            agregarCelda(tabTutor, "Nombre:", true);
            agregarCelda(tabTutor, UtilidadPDF.texto(residente.getNombreTutor()), false, 3);

            agregarCelda(tabTutor, "Domicilio:", true);
            agregarCelda(tabTutor, UtilidadPDF.texto(residente.getDomicilioTutor()), false, 3);

            agregarCelda(tabTutor, "Ciudad:", true);
            agregarCelda(tabTutor, UtilidadPDF.texto(residente.getLugarTutor()), false);

            agregarCelda(tabTutor, "Teléfono:", true);
            agregarCelda(tabTutor, UtilidadPDF.texto(residente.getTelefonoTutor()), false);

            agregarCelda(tabTutor, "Celular:", true);
            agregarCelda(tabTutor, UtilidadPDF.texto(residente.getCelularTutor()), false);

            agregarCelda(tabTutor, "Email:", true);
            agregarCelda(tabTutor, UtilidadPDF.texto(residente.getCorreoTutor()), false);

            documento.add(tabTutor);
            documento.add(new Paragraph("\n"));

            // === CONTACTO DE EMERGENCIA ===
            documento.add(new Paragraph("En caso de emergencia llamar a:").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabEmergencia = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4})).useAllAvailableWidth();

            agregarCelda(tabEmergencia, "Nombre:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getNombreEmergencia()), false, 3);

            agregarCelda(tabEmergencia, "Parentesco:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getParentescoEmergencia()), false);

            agregarCelda(tabEmergencia, "Domicilio:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getDomicilioEmergencia()), false, 3);

            agregarCelda(tabEmergencia, "Ciudad:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getLugarEmergencia()), false);

            agregarCelda(tabEmergencia, "Email:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getCorreoEmergencia()), false);

            agregarCelda(tabEmergencia, "Teléfono:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getTelefonoEmergencia()), false);

            agregarCelda(tabEmergencia, "Celular:", true);
            agregarCelda(tabEmergencia, UtilidadPDF.texto(residente.getCelularEmergencia()), false);

            documento.add(tabEmergencia);
            documento.add(new Paragraph("\n"));

            // === ASPECTOS PERSONALES Y CONVIVENCIA ===
            documento.add(new Paragraph("Aspectos Personales y de Convivencia").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabPersonal = new Table(UnitValue.createPercentArray(new float[]{6, 4})).useAllAvailableWidth();

            agregarPregunta(tabPersonal, "¿Ha vivido fuera anteriormente?", UtilidadPDF.siNo(residente.isHaVividoFuera()));
            agregarPregunta(tabPersonal, "¿Por cuánto tiempo?", UtilidadPDF.texto(residente.getTiempoVividoFuera()));
            agregarPregunta(tabPersonal, "Decisión de vivir en residencias:", UtilidadPDF.texto(residente.getDecisionResidencia()));
            agregarPregunta(tabPersonal, "Razones principales:", UtilidadPDF.texto(residente.getRazonesVivirResidencia()));
            agregarPregunta(tabPersonal, "¿Se adapta a situaciones nuevas?", UtilidadPDF.texto(residente.getAdaptacion()));
            agregarPregunta(tabPersonal, "Preferencia en convivencia:", UtilidadPDF.texto(residente.getEstiloConvivencia()));
            agregarPregunta(tabPersonal, "¿Qué NO le gustaría vivir?", UtilidadPDF.texto(residente.getSituacionesNoDeseadas()));
            agregarPregunta(tabPersonal, "Características de compañero ideal:", preferenciasCompanero(residente));
            agregarPregunta(tabPersonal, "Hora de dormir:", UtilidadPDF.texto(residente.getHoraDormir()));
            agregarPregunta(tabPersonal, "¿Tolera ruido al estudiar?", UtilidadPDF.siNo(residente.isToleraRuido()));
            agregarPregunta(tabPersonal, "Importancia del orden:", UtilidadPDF.texto(residente.getImportanciaOrden()));
            agregarPregunta(tabPersonal, "Hábitos de higiene:", UtilidadPDF.texto(residente.getHabitosHigiene()));
            agregarPregunta(tabPersonal, "Objetos que traerá:", objetosTraera(residente));
            agregarPregunta(tabPersonal, "Iniciativa en actividades:", UtilidadPDF.texto(residente.getIniciativaActividades()));
            agregarPregunta(tabPersonal, "Participación en grupos/clubes:", UtilidadPDF.siNo(residente.isParticipacionGrupo()));
            agregarPregunta(tabPersonal, "Tipo de grupo:", UtilidadPDF.texto(residente.getTipoGrupo()));
            agregarPregunta(tabPersonal, "Descripción actividades:", UtilidadPDF.texto(residente.getActividadesRealizadasGrupo()));
            agregarPregunta(tabPersonal, "Actividades de interés:", actividadesDeseadas(residente));
            agregarPregunta(tabPersonal, "Áreas de desarrollo:", UtilidadPDF.texto(residente.getAspectosMejoraPersona()));
            agregarPregunta(tabPersonal, "Información adicional:", UtilidadPDF.texto(residente.getOtraInformacion()));

            documento.add(tabPersonal);
            documento.add(new Paragraph("\n"));

            // === ASPECTOS ACADÉMICOS ===
            documento.add(new Paragraph("Aspectos Académicos").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabAcademico = new Table(UnitValue.createPercentArray(new float[]{6, 4})).useAllAvailableWidth();

            agregarPregunta(tabAcademico, "Búsqueda de ayuda:", UtilidadPDF.texto(residente.getBuscaAyudaAcademica()));
            agregarPregunta(tabAcademico, "Efectividad de estudio:", UtilidadPDF.texto(residente.getEfectividadEstudio()));
            agregarPregunta(tabAcademico, "Admin. del tiempo:", UtilidadPDF.texto(residente.getEfectividadTiempo()));
            agregarPregunta(tabAcademico, "Áreas a reforzar:", UtilidadPDF.texto(residente.getAspectosMejoraAcademica()));

            documento.add(tabAcademico);
            documento.add(new Paragraph("\n"));

            // === DATOS MÉDICOS ===
            documento.add(new Paragraph("Datos Médicos y Salud").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabMedico = new Table(UnitValue.createPercentArray(new float[]{6, 4})).useAllAvailableWidth();

            agregarPregunta(tabMedico, "Estado de salud:", UtilidadPDF.texto(residente.getEstadoSalud()));
            agregarPregunta(tabMedico, "Deficiencia visual:", UtilidadPDF.detalleSiNo(residente.isTieneDeficienciaVista(), residente.getEspecificarVista()));
            agregarPregunta(tabMedico, "Deficiencia auditiva:", UtilidadPDF.detalleSiNo(residente.isTieneDeficienciaAuditiva(), residente.getEspecificarAuditiva()));
            agregarPregunta(tabMedico, "Discapacidad física:", UtilidadPDF.detalleSiNo(residente.isTieneDiscapacidadFisica(), residente.getEspecificarFisica()));
            agregarPregunta(tabMedico, "Lesiones graves:", UtilidadPDF.detalleSiNo(residente.isTieneLesionesGraves(), residente.getEspecificarLesiones()));
            agregarPregunta(tabMedico, "Padecimientos:", UtilidadPDF.detalleSiNo(residente.isTienePadecimientos(), residente.getEspecificarPadecimientos()));
            agregarPregunta(tabMedico, "Tratamiento médico/psic.:", UtilidadPDF.detalleSiNo(residente.isTieneTratamientosPsicologicos(), residente.getMotivoTratamientosPsicologicos()));
            agregarPregunta(tabMedico, "Medicamento controlado:", UtilidadPDF.detalleSiNo(residente.isTieneMedicamentosControlados(), residente.getEspecificarMedicamentos()));
            agregarPregunta(tabMedico, "Alergias:", UtilidadPDF.detalleSiNo(residente.isTieneAlergias(), residente.getEspecificarAlergias()));
            agregarPregunta(tabMedico, "Tratamientos externos:", UtilidadPDF.detalleSiNo(residente.isTieneTratamientosExternos(), residente.getMotivoTratamientosExternos()));
            agregarPregunta(tabMedico, "Tipo de sangre:", UtilidadPDF.texto(residente.getTipoSangre()));
            agregarPregunta(tabMedico, "Áreas salud a reforzar:", UtilidadPDF.texto(residente.getAspectosSaludMejora()));
            agregarPregunta(tabMedico, "Información adicional de salud:", UtilidadPDF.texto(residente.getOtraInformacionSalud()));

            documento.add(tabMedico);

            // Contenedor de firmas y pie de pagina
            Div contenedorFirmas = new Div();
            contenedorFirmas.setKeepTogether(true);
            contenedorFirmas.setMarginTop(15f);

            Table tabFirmas = new Table(UnitValue.createPercentArray(new float[]{1, 0.2f, 1})).useAllAvailableWidth();
            tabFirmas.setBorder(Border.NO_BORDER);

            Cell lineaFirma = new Cell().setHeight(25f).setBorder(Border.NO_BORDER);
            lineaFirma.setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));

            tabFirmas.addCell(lineaFirma);
            tabFirmas.addCell(new Cell().setBorder(Border.NO_BORDER));
            tabFirmas.addCell(lineaFirma.clone(true));

            tabFirmas.addCell(new Cell().add(new Paragraph("Firma del Alumno").setTextAlignment(TextAlignment.CENTER).setFontSize(9)).setBorder(Border.NO_BORDER));
            tabFirmas.addCell(new Cell().setBorder(Border.NO_BORDER));
            tabFirmas.addCell(new Cell().add(new Paragraph("Firma del Tutor/Padre").setTextAlignment(TextAlignment.CENTER).setFontSize(9)).setBorder(Border.NO_BORDER));

            contenedorFirmas.add(tabFirmas);

            contenedorFirmas.add(new Paragraph("Favor de imprimir, firmar para subir a sistema.")
                    .setTextAlignment(TextAlignment.CENTER).setFontSize(8).setItalic().setMarginTop(5f));

            documento.add(contenedorFirmas);
            documento.close();
            System.out.println("¡PDF Generado con éxito en: " + rutaArchivo);

        } catch (Exception e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void agregarCelda(Table tabla, String texto, boolean esNegrita) {
        agregarCelda(tabla, texto, esNegrita, 1);
    }

    private static void agregarCelda(Table tabla, String texto, boolean esNegrita, int colspan) {
        Paragraph p = new Paragraph(texto != null ? texto : " ");
        if (esNegrita) {
            p.setBold().setFontSize(9);
        } else {
            p.setFontSize(9);
        }
        Cell celda = new Cell(1, colspan).add(p).setPadding(3);
        tabla.addCell(celda);
    }

    private static void agregarPregunta(Table tabla, String pregunta, String respuesta) {
        tabla.addCell(new Cell().add(new Paragraph(pregunta).setBold().setFontSize(9)).setPadding(2));
        tabla.addCell(new Cell().add(new Paragraph(respuesta != null ? respuesta : " ").setFontSize(9)).setPadding(2));
    }

    private static String preferenciasCompanero(Negocio.DTOs.ResidenteDTO dto) {
        java.util.List<String> lista = new java.util.ArrayList<>();
        if (dto.isBuscaCompaneroExtranjero()) {
            lista.add("Extranjero");
        }
        if (dto.isBuscaCompaneroMexicano()) {
            lista.add("Mexicano");
        }
        if (dto.isBuscaCompaneroReingreso()) {
            lista.add("Reingreso");
        }
        return lista.isEmpty() ? "No especificado" : String.join(", ", lista);
    }

    private static String objetosTraera(Negocio.DTOs.ResidenteDTO dto) {
        java.util.List<String> lista = new java.util.ArrayList<>();
        if (dto.isTraeAuto()) {
            lista.add("Auto");
        }
        if (dto.isTraeComputadora()) {
            lista.add("Computadora");
        }
        if (dto.isTraeTv()) {
            lista.add("TV");
        }
        if (dto.isTraeFrigobar()) {
            lista.add("Frigobar");
        }
        return lista.isEmpty() ? "Ninguno" : String.join(", ", lista);
    }

    private static String actividadesDeseadas(Negocio.DTOs.ResidenteDTO dto) {
        java.util.List<String> lista = new java.util.ArrayList<>();
        if (dto.isDeseaActDeportivas()) {
            lista.add("Deportivas");
        }
        if (dto.isDeseaActCulturales()) {
            lista.add("Culturales");
        }
        if (dto.isDeseaActArtisticas()) {
            lista.add("Artísticas");
        }
        return lista.isEmpty() ? "No especificado" : String.join(", ", lista);
    }
}
