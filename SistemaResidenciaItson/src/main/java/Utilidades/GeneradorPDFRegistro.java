/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.net.URL;

public class GeneradorPDFRegistro {

    public static void generarRegistroResidente(
            String rutaArchivo,
            String nombreCompleto,
            String idItson,
            String carrera,
            String semestre,
            String email,
            String fechaNacimiento,
            String sexo,
            String curp,
            String numeroIMSS,
            String domicilio,
            String ciudadProcedencia,
            String telefono,
            String celular,
            String nombreTutor,
            String domicilioTutor,
            String ciudadTutor,
            String telefonoTutor,
            String celularTutor,
            String emailTutor,
            String nombreEmergencia,
            String edadEmergencia,
            String parentescoEmergencia,
            String domicilioEmergencia,
            String ciudadEmergencia,
            String telefonoEmergencia,
            String celularEmergencia,
            String emailEmergencia,
            // Aspectos personales
            String vividoFuera,
            String tiempoVivido,
            String decisionVivienda,
            String razonesResidencia,
            String adaptacion,
            String convivenciaPreferencia,
            String noLeGustaria,
            String caracteristicasCompanero,
            String horaDomir,
            String toleraRuido,
            String importanciaOrden,
            String habitosHigiene,
            String traera,
            String participaActividades,
            String grupoClubEquipo,
            String tipoGrupo,
            String descripcionActividades,
            String actividadesDeseaRealizar,
            String prepararseMejor,
            String informacionAdicional,
            // Aspectos académicos
            String ayudaAcademica,
            String metodoEstudio,
            String administracionTiempo,
            String preparacionAcademica,
            // Datos médicos
            String estadoSalud,
            String deficienciaVista,
            String deficienciaAuditiva,
            String discapacidadFisica,
            String lesionesGraves,
            String padecimiento,
            String tratamientoMedico,
            String medicamentoControlado,
            String alergias,
            String tratamientosExternos,
            String tipoSangre,
            String preparacionSalud,
            String informacionSalud) {

        try {
            // Inicializar PDF
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document documento = new Document(pdfDoc, PageSize.LETTER);
            documento.setMargins(20, 20, 20, 20);

            // --- INTENTO DE CARGAR LOGO (Opcional) ---
            try {
                URL urlLogo = GeneradorPDFRegistro.class.getResource("/Imagenes/LogoResidencia.jpg");
                if (urlLogo != null) {
                    ImageData data = ImageDataFactory.create(urlLogo);
                    Image img = new Image(data);
                    img.scaleToFit(80, 80);
                    img.setHorizontalAlignment(HorizontalAlignment.RIGHT);
                    documento.add(img);
                }
            } catch (Exception e) {
                System.out.println("No se pudo cargar el logo (continuando sin él).");
            }

            // --- ENCABEZADO ---
            documento.add(new Paragraph("Residencias ITSON – Panel de Gestión de residentes")
                    .setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
            documento.add(new Paragraph("Registro de Datos Personales (RDP)")
                    .setTextAlignment(TextAlignment.CENTER).setFontSize(12).setBold());
            documento.add(new Paragraph("RESI-POP-FO-05-06")
                    .setTextAlignment(TextAlignment.CENTER).setFontSize(8).setItalic());
            documento.add(new Paragraph("\n")); // Espacio

            documento.add(new Paragraph("La información proporcionada es confidencial y para uso interno de Residencias Estudiantiles ITSON.")
                    .setFontSize(9).setItalic().setTextAlignment(TextAlignment.JUSTIFIED));
            documento.add(new Paragraph("\n"));

            // === DATOS DEL SOLICITANTE ===
            documento.add(new Paragraph("Datos del Solicitante").setBold().setFontSize(10));

            // Tabla de 4 columnas que ocupa el 100% del ancho disponible
            Table tabSolicitante = new Table(UnitValue.createPercentArray(new float[]{2, 3, 2, 3})).useAllAvailableWidth();

            // Método auxiliar para agregar celdas rápido (ver abajo)
            agregarCelda(tabSolicitante, "Nombre completo:", true);
            agregarCelda(tabSolicitante, nombreCompleto, false, 3); // Colspan 3

            agregarCelda(tabSolicitante, "Carrera:", true);
            agregarCelda(tabSolicitante, carrera, false);

            agregarCelda(tabSolicitante, "Semestre:", true);
            agregarCelda(tabSolicitante, semestre, false);

            agregarCelda(tabSolicitante, "ID (ITSON):", true);
            agregarCelda(tabSolicitante, idItson, false, 3);

            agregarCelda(tabSolicitante, "Fecha de nacimiento:", true);
            agregarCelda(tabSolicitante, fechaNacimiento, false);

            agregarCelda(tabSolicitante, "Sexo:", true);
            agregarCelda(tabSolicitante, sexo, false);

            agregarCelda(tabSolicitante, "CURP:", true);
            agregarCelda(tabSolicitante, curp, false);

            agregarCelda(tabSolicitante, "Número afiliación IMSS:", true);
            agregarCelda(tabSolicitante, numeroIMSS, false);

            agregarCelda(tabSolicitante, "Domicilio:", true);
            agregarCelda(tabSolicitante, domicilio, false, 3);

            agregarCelda(tabSolicitante, "Ciudad:", true);
            agregarCelda(tabSolicitante, ciudadProcedencia, false);

            agregarCelda(tabSolicitante, "Teléfono:", true);
            agregarCelda(tabSolicitante, telefono, false);

            agregarCelda(tabSolicitante, "Celular:", true);
            agregarCelda(tabSolicitante, celular, false);

            agregarCelda(tabSolicitante, "Email:", true);
            agregarCelda(tabSolicitante, email, false, 3);

            documento.add(tabSolicitante);
            documento.add(new Paragraph("\n"));

            // === DATOS DEL TUTOR ===
            documento.add(new Paragraph("Datos del Tutor").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabTutor = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4})).useAllAvailableWidth();

            agregarCelda(tabTutor, "Nombre:", true);
            agregarCelda(tabTutor, nombreTutor, false, 3);

            agregarCelda(tabTutor, "Domicilio:", true);
            agregarCelda(tabTutor, domicilioTutor, false, 3);

            agregarCelda(tabTutor, "Ciudad:", true);
            agregarCelda(tabTutor, ciudadTutor, false);

            agregarCelda(tabTutor, "Teléfono:", true);
            agregarCelda(tabTutor, telefonoTutor, false);

            agregarCelda(tabTutor, "Celular:", true);
            agregarCelda(tabTutor, celularTutor, false);

            agregarCelda(tabTutor, "Email:", true);
            agregarCelda(tabTutor, emailTutor, false);

            documento.add(tabTutor);
            documento.add(new Paragraph("\n"));

            // === CONTACTO DE EMERGENCIA ===
            documento.add(new Paragraph("En caso de emergencia llamar a:").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabEmergencia = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4})).useAllAvailableWidth();

            agregarCelda(tabEmergencia, "Nombre:", true);
            agregarCelda(tabEmergencia, nombreEmergencia, false, 3);

            agregarCelda(tabEmergencia, "Parentesco:", true);
            agregarCelda(tabEmergencia, parentescoEmergencia, false);
            agregarCelda(tabEmergencia, "Edad:", true);
            agregarCelda(tabEmergencia, edadEmergencia, false);

            agregarCelda(tabEmergencia, "Domicilio:", true);
            agregarCelda(tabEmergencia, domicilioEmergencia, false, 3);

            agregarCelda(tabEmergencia, "Ciudad:", true);
            agregarCelda(tabEmergencia, ciudadEmergencia, false);
            agregarCelda(tabEmergencia, "Email:", true);
            agregarCelda(tabEmergencia, emailEmergencia, false);

            agregarCelda(tabEmergencia, "Teléfono:", true);
            agregarCelda(tabEmergencia, telefonoEmergencia, false);
            agregarCelda(tabEmergencia, "Celular:", true);
            agregarCelda(tabEmergencia, celularEmergencia, false);

            documento.add(tabEmergencia);
            documento.add(new Paragraph("\n"));

            // === ASPECTOS PERSONALES Y CONVIVENCIA ===
            documento.add(new Paragraph("Aspectos Personales y de Convivencia").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            // estructura de columnas, 60% pregunta, 40% respuesta
            Table tabPersonal = new Table(UnitValue.createPercentArray(new float[]{6, 4})).useAllAvailableWidth();

            agregarPregunta(tabPersonal, "¿Ha vivido fuera anteriormente?", vividoFuera);
            agregarPregunta(tabPersonal, "¿Por cuánto tiempo?", tiempoVivido);
            agregarPregunta(tabPersonal, "Decisión de vivir en residencias:", decisionVivienda);
            agregarPregunta(tabPersonal, "Razones principales:", razonesResidencia);
            agregarPregunta(tabPersonal, "¿Se adapta a situaciones nuevas?", adaptacion);
            agregarPregunta(tabPersonal, "Preferencia en convivencia:", convivenciaPreferencia);
            agregarPregunta(tabPersonal, "¿Qué NO le gustaría vivir?", noLeGustaria);
            agregarPregunta(tabPersonal, "Características de compañero ideal:", caracteristicasCompanero);
            agregarPregunta(tabPersonal, "Hora de dormir:", horaDomir);
            agregarPregunta(tabPersonal, "¿Tolera ruido al estudiar?", toleraRuido);
            agregarPregunta(tabPersonal, "Importancia del orden:", importanciaOrden);
            agregarPregunta(tabPersonal, "Hábitos de higiene:", habitosHigiene);
            agregarPregunta(tabPersonal, "Objetos que traerá:", traera);
            agregarPregunta(tabPersonal, "Iniciativa en actividades:", participaActividades);
            agregarPregunta(tabPersonal, "Participación en grupos/clubes:", grupoClubEquipo);
            agregarPregunta(tabPersonal, "Tipo de grupo:", tipoGrupo);
            agregarPregunta(tabPersonal, "Descripción actividades:", descripcionActividades);
            agregarPregunta(tabPersonal, "Actividades de interés:", actividadesDeseaRealizar);
            agregarPregunta(tabPersonal, "Áreas de desarrollo:", prepararseMejor);
            agregarPregunta(tabPersonal, "Información adicional:", informacionAdicional);

            documento.add(tabPersonal);
            documento.add(new Paragraph("\n"));

            // === ASPECTOS ACADÉMICOS ===
            documento.add(new Paragraph("Aspectos Académicos").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));

            // estructura de columnas, 60% pregunta, 40% respuesta
            Table tabAcademico = new Table(UnitValue.createPercentArray(new float[]{6, 4})).useAllAvailableWidth();
            agregarPregunta(tabAcademico, "Búsqueda de ayuda:", ayudaAcademica);
            agregarPregunta(tabAcademico, "Efectividad de estudio:", metodoEstudio);
            agregarPregunta(tabAcademico, "Admin. del tiempo:", administracionTiempo);
            agregarPregunta(tabAcademico, "Áreas a reforzar:", preparacionAcademica);

            documento.add(tabAcademico);
            documento.add(new Paragraph("\n"));

            // === DATOS MÉDICOS ===
            documento.add(new Paragraph("Datos Médicos y Salud").setBold().setFontSize(11).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            Table tabMedico = new Table(UnitValue.createPercentArray(new float[]{6, 4})).useAllAvailableWidth();

            agregarPregunta(tabMedico, "Estado de salud:", estadoSalud);
            agregarPregunta(tabMedico, "Deficiencia visual:", deficienciaVista);
            agregarPregunta(tabMedico, "Deficiencia auditiva:", deficienciaAuditiva);
            agregarPregunta(tabMedico, "Discapacidad física:", discapacidadFisica);
            agregarPregunta(tabMedico, "Lesiones graves:", lesionesGraves);
            agregarPregunta(tabMedico, "Padecimientos:", padecimiento);
            agregarPregunta(tabMedico, "Tratamiento médico/psic.:", tratamientoMedico);
            agregarPregunta(tabMedico, "Medicamento controlado:", medicamentoControlado);
            agregarPregunta(tabMedico, "Alergias:", alergias);
            agregarPregunta(tabMedico, "Tratamientos externos:", tratamientosExternos);
            agregarPregunta(tabMedico, "Tipo de sangre:", tipoSangre);
            agregarPregunta(tabMedico, "Áreas salud a reforzar:", preparacionSalud);
            agregarPregunta(tabMedico, "Información adicional de salud:", informacionSalud);

            documento.add(tabMedico);
            documento.add(new Paragraph("\n\n")); // Espacio para firmas

        // === FIRMAS ===
            Table tabFirmas = new Table(UnitValue.createPercentArray(new float[]{1, 0.2f, 1})).useAllAvailableWidth();
            tabFirmas.setBorder(Border.NO_BORDER);

            // Crear línea sólida para la firma
            Cell lineaFirma = new Cell().add(new Paragraph("\n")).setBorder(Border.NO_BORDER);
            lineaFirma.setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));

            // Firma Alumno
            tabFirmas.addCell(lineaFirma);
            tabFirmas.addCell(new Cell().setBorder(Border.NO_BORDER)); // Espacio vacío

            // Firma Tutor
            tabFirmas.addCell(lineaFirma.clone(true));

            // Nombres debajo de la línea
            tabFirmas.addCell(new Cell().add(new Paragraph("Firma del Alumno").setTextAlignment(TextAlignment.CENTER).setFontSize(9)).setBorder(Border.NO_BORDER));
            tabFirmas.addCell(new Cell().setBorder(Border.NO_BORDER));
            tabFirmas.addCell(new Cell().add(new Paragraph("Firma del Tutor/Padre").setTextAlignment(TextAlignment.CENTER).setFontSize(9)).setBorder(Border.NO_BORDER));

            documento.add(tabFirmas);

            // Pie de página
            documento.add(new Paragraph("\nFavor de imprimir, firmar y entregar en recepción.")
                    .setTextAlignment(TextAlignment.CENTER).setFontSize(8).setItalic());

            documento.close();
            System.out.println("¡PDF Generado con éxito en: " + rutaArchivo);

        } catch (Exception e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // --- MÉTODOS AUXILIARES ---
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

    // Método especial para Pregunta - Respuesta 
    private static void agregarPregunta(Table tabla, String pregunta, String respuesta) {
        // Celda Pregunta
        tabla.addCell(new Cell().add(new Paragraph(pregunta).setBold().setFontSize(9)).setPadding(2));
        // Celda Respuesta
        tabla.addCell(new Cell().add(new Paragraph(respuesta != null ? respuesta : " ").setFontSize(9)).setPadding(2));
    }
}
