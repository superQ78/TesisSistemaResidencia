///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Utilidades;
//
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.property.HorizontalAlignment;
//import com.itextpdf.layout.property.TextAlignment;
//import com.itextpdf.layout.property.VerticalAlignment;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.layout.properties.TextAlignment;
//import java.io.File;
//
//public class GeneradorPDFRegistro {
//
//    public static void generarRegistroResidente(
//            String rutaArchivo,
//            String nombreCompleto,
//            String idItson,
//            String carrera,
//            String semestre,
//            String email,
//            String fechaNacimiento,
//            String sexo,
//            String curp,
//            String numeroIMSS,
//            String domicilio,
//            String ciudadProcedencia,
//            String telefono,
//            String celular,
//            String nombreTutor,
//            String domicilioTutor,
//            String ciudadTutor,
//            String telefonoTutor,
//            String celularTutor,
//            String emailTutor,
//            String nombreEmergencia,
//            String edadEmergencia,
//            String parentescoEmergencia,
//            String domicilioEmergencia,
//            String ciudadEmergencia,
//            String telefonoEmergencia,
//            String celularEmergencia,
//            String emailEmergencia,
//            // Aspectos personales
//            String vivedoFuera,
//            String tiempoVivido,
//            String decisionVivienda,
//            String razonesResidencia,
//            String adaptacion,
//            String convivenciaPreferencia,
//            String noLeGustaria,
//            String caracteristicasCompanero,
//            String horaDomir,
//            String toleraRuido,
//            String importanciaOrden,
//            String habitosHigiene,
//            String traera,
//            String participaActividades,
//            String grupoClubEquipo,
//            String tipoGrupo,
//            String descripcionActividades,
//            String actividadesDeseaRealizar,
//            String prepararseMejor,
//            String informacionAdicional,
//            // Aspectos académicos
//            String ayudaAcademica,
//            String metodoEstudio,
//            String administracionTiempo,
//            String preparacionAcademica,
//            // Datos médicos
//            String estadoSalud,
//            String deficienciaVista,
//            String deficienciaAuditiva,
//            String discapacidadFisica,
//            String lesionesGraves,
//            String padecimiento,
//            String tratamientoMedico,
//            String medicamentoControlado,
//            String alergias,
//            String tratamientosExternos,
//            String tipoSangre,
//            String preparacionSalud,
//            String informacionSalud) {
//
//        try {
//            // Crear documento PDF
//            PdfWriter writer = new PdfWriter(rutaArchivo);
//            PdfDocument pdfDoc = new PdfDocument(writer);
//            Document documento = new Document(pdfDoc, PageSize.LETTER);
//            
//            // Fuentes
//            PdfFont fontTitulo = PdfFontFactory.createFont();
//            PdfFont fontNormal = PdfFontFactory.createFont();
//            
//            // === ENCABEZADO ===
//            documento.add(new Paragraph("Residencias ITSON – Panel de Gestión de residentes")
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setFontSize(12)
//                    .setBold());
//            
//            documento.add(new Paragraph("Registro de Datos Personales (RDP)")
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setFontSize(11)
//                    .setBold());
//            
//            documento.add(new Paragraph("RESI-POP-FO-05-06")
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setFontSize(9)
//                    .setItalic());
//            
//            documento.add(new Paragraph(" "));
//            
//            documento.add(new Paragraph("La información proporcionada es confidencial y para uso interno de Residencias Estudiantiles ITSON.")
//                    .setFontSize(9)
//                    .setItalic());
//            
//            documento.add(new Paragraph(" "));
//            
//            // === DATOS DEL SOLICITANTE ===
//            documento.add(new Paragraph("Datos del Solicitante")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabSolicitante = new Table(4).setWidth(500);
//            tabSolicitante.addCell(new Cell().setText("Nombre completo:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(nombreCompleto));
//            
//            tabSolicitante.addCell(new Cell().setText("Carrera:").setBold());
//            tabSolicitante.addCell(new Cell().setText(carrera));
//            tabSolicitante.addCell(new Cell().setText("Semestre:").setBold());
//            tabSolicitante.addCell(new Cell().setText(semestre));
//            
//            tabSolicitante.addCell(new Cell().setText("ID (ITSON):").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(idItson));
//            
//            tabSolicitante.addCell(new Cell().setText("E-mail:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(email));
//            
//            tabSolicitante.addCell(new Cell().setText("Fecha de nacimiento:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(fechaNacimiento));
//            
//            tabSolicitante.addCell(new Cell().setText("Sexo:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(sexo));
//            
//            tabSolicitante.addCell(new Cell().setText("CURP:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(curp));
//            
//            tabSolicitante.addCell(new Cell().setText("Número afiliación IMSS:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(numeroIMSS));
//            
//            tabSolicitante.addCell(new Cell().setText("Domicilio:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(domicilio));
//            
//            tabSolicitante.addCell(new Cell().setText("Ciudad y país:").setBold());
//            tabSolicitante.addCell(new Cell(1, 3).setText(ciudadProcedencia));
//            
//            tabSolicitante.addCell(new Cell().setText("Teléfono:").setBold());
//            tabSolicitante.addCell(new Cell().setText(telefono));
//            tabSolicitante.addCell(new Cell().setText("Celular:").setBold());
//            tabSolicitante.addCell(new Cell().setText(celular));
//            
//            documento.add(tabSolicitante);
//            documento.add(new Paragraph(" "));
//            
//            // === DATOS DEL TUTOR ===
//            documento.add(new Paragraph("Datos del Tutor")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabTutor = new Table(4).setWidth(500);
//            tabTutor.addCell(new Cell().setText("Nombre completo:").setBold());
//            tabTutor.addCell(new Cell(1, 3).setText(nombreTutor));
//            
//            tabTutor.addCell(new Cell().setText("Domicilio:").setBold());
//            tabTutor.addCell(new Cell(1, 3).setText(domicilioTutor));
//            
//            tabTutor.addCell(new Cell().setText("Ciudad y país:").setBold());
//            tabTutor.addCell(new Cell(1, 3).setText(ciudadTutor));
//            
//            tabTutor.addCell(new Cell().setText("Teléfono:").setBold());
//            tabTutor.addCell(new Cell().setText(telefonoTutor));
//            tabTutor.addCell(new Cell().setText("Celular:").setBold());
//            tabTutor.addCell(new Cell().setText(celularTutor));
//            
//            tabTutor.addCell(new Cell().setText("E-mail:").setBold());
//            tabTutor.addCell(new Cell(1, 3).setText(emailTutor));
//            
//            documento.add(tabTutor);
//            documento.add(new Paragraph(" "));
//            
//            // === CONTACTO DE EMERGENCIA ===
//            documento.add(new Paragraph("A quién llamar en casos de emergencia")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabEmergencia = new Table(4).setWidth(500);
//            tabEmergencia.addCell(new Cell().setText("Nombre completo:").setBold());
//            tabEmergencia.addCell(new Cell(1, 3).setText(nombreEmergencia));
//            
//            tabEmergencia.addCell(new Cell().setText("Edad:").setBold());
//            tabEmergencia.addCell(new Cell().setText(edadEmergencia));
//            tabEmergencia.addCell(new Cell().setText("Parentesco:").setBold());
//            tabEmergencia.addCell(new Cell().setText(parentescoEmergencia));
//            
//            tabEmergencia.addCell(new Cell().setText("Domicilio:").setBold());
//            tabEmergencia.addCell(new Cell(1, 3).setText(domicilioEmergencia));
//            
//            tabEmergencia.addCell(new Cell().setText("Ciudad:").setBold());
//            tabEmergencia.addCell(new Cell(1, 3).setText(ciudadEmergencia));
//            
//            tabEmergencia.addCell(new Cell().setText("Teléfono:").setBold());
//            tabEmergencia.addCell(new Cell().setText(telefonoEmergencia));
//            tabEmergencia.addCell(new Cell().setText("Celular:").setBold());
//            tabEmergencia.addCell(new Cell().setText(celularEmergencia));
//            
//            tabEmergencia.addCell(new Cell().setText("E-mail:").setBold());
//            tabEmergencia.addCell(new Cell(1, 3).setText(emailEmergencia));
//            
//            documento.add(tabEmergencia);
//            documento.add(new Paragraph(" "));
//            
//            // === ASPECTOS PERSONALES Y CONVIVENCIA ===
//            documento.add(new Paragraph("Aspectos Personales y de Convivencia")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabPersonal = new Table(2).setWidth(500);
//            tabPersonal.addCell(new Cell().setText("¿Has vivido fuera de casa anteriormente?").setBold());
//            tabPersonal.addCell(new Cell().setText(vivedoFuera));
//            
//            tabPersonal.addCell(new Cell().setText("Si tu respuesta es sí, ¿por cuánto tiempo?").setBold());
//            tabPersonal.addCell(new Cell().setText(tiempoVivido));
//            
//            tabPersonal.addCell(new Cell().setText("La decisión de vivir en Residencias es principalmente:").setBold());
//            tabPersonal.addCell(new Cell().setText(decisionVivienda));
//            
//            tabPersonal.addCell(new Cell().setText("Razones principales para solicitar la residencia:").setBold());
//            tabPersonal.addCell(new Cell().setText(razonesResidencia));
//            
//            tabPersonal.addCell(new Cell().setText("¿Te adaptas a situaciones nuevas de convivencia?").setBold());
//            tabPersonal.addCell(new Cell().setText(adaptacion));
//            
//            tabPersonal.addCell(new Cell().setText("En la convivencia generalmente prefieres:").setBold());
//            tabPersonal.addCell(new Cell().setText(convivenciaPreferencia));
//            
//            tabPersonal.addCell(new Cell().setText("¿Qué no te gustaría vivir en la convivencia?").setBold());
//            tabPersonal.addCell(new Cell().setText(noLeGustaria));
//            
//            tabPersonal.addCell(new Cell().setText("Características deseadas en compañero/a de habitación:").setBold());
//            tabPersonal.addCell(new Cell().setText(caracteristicasCompanero));
//            
//            tabPersonal.addCell(new Cell().setText("¿A qué hora acostumbras dormirte?").setBold());
//            tabPersonal.addCell(new Cell().setText(horaDomir));
//            
//            tabPersonal.addCell(new Cell().setText("¿Toleras cierto ruido al estudiar?").setBold());
//            tabPersonal.addCell(new Cell().setText(toleraRuido));
//            
//            tabPersonal.addCell(new Cell().setText("¿Qué tan importante para ti es el orden?").setBold());
//            tabPersonal.addCell(new Cell().setText(importanciaOrden));
//            
//            tabPersonal.addCell(new Cell().setText("¿Cuáles son tus hábitos de higiene?").setBold());
//            tabPersonal.addCell(new Cell().setText(habitosHigiene));
//            
//            tabPersonal.addCell(new Cell().setText("¿Qué traerás a la residencia?").setBold());
//            tabPersonal.addCell(new Cell().setText(traera));
//            
//            tabPersonal.addCell(new Cell().setText("¿Participas en actividades por iniciativa propia?").setBold());
//            tabPersonal.addCell(new Cell().setText(participaActividades));
//            
//            tabPersonal.addCell(new Cell().setText("¿Has participado en grupo, club o equipo?").setBold());
//            tabPersonal.addCell(new Cell().setText(grupoClubEquipo));
//            
//            tabPersonal.addCell(new Cell().setText("Si es sí, ¿de qué tipo?").setBold());
//            tabPersonal.addCell(new Cell().setText(tipoGrupo));
//            
//            tabPersonal.addCell(new Cell().setText("Describe la(s) actividad(es):").setBold());
//            tabPersonal.addCell(new Cell().setText(descripcionActividades));
//            
//            tabPersonal.addCell(new Cell().setText("Actividades que te gustaría realizar en Residencias:").setBold());
//            tabPersonal.addCell(new Cell().setText(actividadesDeseaRealizar));
//            
//            tabPersonal.addCell(new Cell().setText("Aspectos en los que deseas prepararte mejor:").setBold());
//            tabPersonal.addCell(new Cell().setText(prepararseMejor));
//            
//            tabPersonal.addCell(new Cell().setText("Información adicional importante:").setBold());
//            tabPersonal.addCell(new Cell().setText(informacionAdicional));
//            
//            documento.add(tabPersonal);
//            documento.add(new Paragraph(" "));
//            
//            // === ASPECTOS ACADÉMICOS ===
//            documento.add(new Paragraph("Aspectos Académicos")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabAcademico = new Table(2).setWidth(500);
//            tabAcademico.addCell(new Cell().setText("¿Sueles buscar ayuda académica cuando la necesitas?").setBold());
//            tabAcademico.addCell(new Cell().setText(ayudaAcademica));
//            
//            tabAcademico.addCell(new Cell().setText("¿Qué tan efectivo consideras tu método de estudio?").setBold());
//            tabAcademico.addCell(new Cell().setText(metodoEstudio));
//            
//            tabAcademico.addCell(new Cell().setText("¿Qué tan efectiva es tu administración del tiempo?").setBold());
//            tabAcademico.addCell(new Cell().setText(administracionTiempo));
//            
//            tabAcademico.addCell(new Cell().setText("Aspectos académicos en los que te gustaría prepararte:").setBold());
//            tabAcademico.addCell(new Cell().setText(preparacionAcademica));
//            
//            documento.add(tabAcademico);
//            documento.add(new Paragraph(" "));
//            
//            // === DATOS MÉDICOS ===
//            documento.add(new Paragraph("Datos Médicos")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabMedico = new Table(2).setWidth(500);
//            tabMedico.addCell(new Cell().setText("Estado de salud general:").setBold());
//            tabMedico.addCell(new Cell().setText(estadoSalud));
//            
//            tabMedico.addCell(new Cell().setText("Deficiencia en la vista:").setBold());
//            tabMedico.addCell(new Cell().setText(deficienciaVista));
//            
//            tabMedico.addCell(new Cell().setText("Deficiencia auditiva:").setBold());
//            tabMedico.addCell(new Cell().setText(deficienciaAuditiva));
//            
//            tabMedico.addCell(new Cell().setText("Discapacidad física:").setBold());
//            tabMedico.addCell(new Cell().setText(discapacidadFisica));
//            
//            tabMedico.addCell(new Cell().setText("Lesiones graves:").setBold());
//            tabMedico.addCell(new Cell().setText(lesionesGraves));
//            
//            tabMedico.addCell(new Cell().setText("¿Algún padecimiento que tengas o hayas tenido?").setBold());
//            tabMedico.addCell(new Cell().setText(padecimiento));
//            
//            tabMedico.addCell(new Cell().setText("¿Tratamiento médico, psiquiátrico o psicológico?").setBold());
//            tabMedico.addCell(new Cell().setText(tratamientoMedico));
//            
//            tabMedico.addCell(new Cell().setText("¿Necesitas medicamento controlado?").setBold());
//            tabMedico.addCell(new Cell().setText(medicamentoControlado));
//            
//            tabMedico.addCell(new Cell().setText("¿Padeces alergias?").setBold());
//            tabMedico.addCell(new Cell().setText(alergias));
//            
//            tabMedico.addCell(new Cell().setText("Tratamientos externos:").setBold());
//            tabMedico.addCell(new Cell().setText(tratamientosExternos));
//            
//            tabMedico.addCell(new Cell().setText("Tipo de sangre:").setBold());
//            tabMedico.addCell(new Cell().setText(tipoSangre));
//            
//            tabMedico.addCell(new Cell().setText("Aspectos de salud para prepararte mejor:").setBold());
//            tabMedico.addCell(new Cell().setText(preparacionSalud));
//            
//            tabMedico.addCell(new Cell().setText("Información adicional sobre tu salud:").setBold());
//            tabMedico.addCell(new Cell().setText(informacionSalud));
//            
//            documento.add(tabMedico);
//            documento.add(new Paragraph(" "));
//            documento.add(new Paragraph(" "));
//            
//            // === FIRMAS ===
//            documento.add(new Paragraph("Firmas y Autorizaciones")
//                    .setBold()
//                    .setFontSize(10));
//            
//            Table tabFirmas = new Table(2).setWidth(500);
//            
//            // Fila 1: Firma del alumno
//            Cell celFirmaAlumno1 = new Cell().setText(" ").setHeight(60)
//                    .setBorder(null).setBorderBottom(com.itextpdf.kernel.pdf.canvas.draw.SolidLine.getInstance());
//            Cell celNombreAlumno = new Cell().setText("Firma del alumno").setFontSize(9)
//                    .setTextAlignment(TextAlignment.CENTER).setBorder(null);
//            
//            tabFirmas.addCell(celFirmaAlumno1);
//            tabFirmas.addCell(new Cell().setText(" ").setHeight(60)
//                    .setBorder(null));
//            
//            tabFirmas.addCell(celNombreAlumno);
//            tabFirmas.addCell(new Cell().setText(" ").setBorder(null));
//            
//            // Fila 2: Firma del tutor
//            Cell celFirmaTutor1 = new Cell().setText(" ").setHeight(60)
//                    .setBorder(null).setBorderBottom(com.itextpdf.kernel.pdf.canvas.draw.SolidLine.getInstance());
//            Cell celNombreTutor = new Cell().setText("Firma del tutor/padre").setFontSize(9)
//                    .setTextAlignment(TextAlignment.CENTER).setBorder(null);
//            
//            tabFirmas.addCell(celFirmaTutor1);
//            tabFirmas.addCell(new Cell().setText(" ").setHeight(60)
//                    .setBorder(null));
//            
//            tabFirmas.addCell(celNombreTutor);
//            tabFirmas.addCell(new Cell().setText(" ").setBorder(null));
//            
//            // Fila 3: Fecha
//            Cell celFecha = new Cell().setText(" ").setHeight(30)
//                    .setBorder(null).setBorderBottom(com.itextpdf.kernel.pdf.canvas.draw.SolidLine.getInstance());
//            Cell celFechaLabel = new Cell().setText("FECHA (dd/mm/aa)").setFontSize(9)
//                    .setTextAlignment(TextAlignment.CENTER).setBorder(null);
//            
//            tabFirmas.addCell(celFecha);
//            tabFirmas.addCell(new Cell().setText(" ").setHeight(30)
//                    .setBorder(null));
//            
//            tabFirmas.addCell(celFechaLabel);
//            tabFirmas.addCell(new Cell().setText(" ").setBorder(null));
//            
//            documento.add(tabFirmas);
//            documento.add(new Paragraph(" "));
//            documento.add(new Paragraph("Favor de imprimir, firmar, escanear y enviar por correo electrónico a: recepcionresidencias@itson.edu.mx")
//                    .setFontSize(9)
//                    .setItalic()
//                    .setTextAlignment(TextAlignment.CENTER));
//            
//            // Cerrar documento
//            documento.close();
//            
//            System.out.println("PDF generado correctamente en: " + rutaArchivo);
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error al generar PDF: " + e.getMessage());
//        }
//    }
//}
