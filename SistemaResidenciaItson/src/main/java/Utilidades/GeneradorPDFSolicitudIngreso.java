/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.net.URL;

/**
 *
 * @author Tesis
 */
public class GeneradorPDFSolicitudIngreso {

    public static void generarSolicitudIngreso(
            String rutaArchivo,
            ResidenteDTO residente,
            SolicitudIngresoDTO solicitud
    ) {
        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document documento = new Document(pdfDoc, PageSize.LETTER);
            documento.setMargins(25, 25, 25, 25);

            try {
                URL urlLogo = GeneradorPDFSolicitudIngreso.class.getResource("/Imagenes/LogoResidencia.jpg");
                if (urlLogo != null) {
                    ImageData data = ImageDataFactory.create(urlLogo);
                    Image img = new Image(data);
                    img.scaleToFit(80, 80);
                    img.setHorizontalAlignment(HorizontalAlignment.RIGHT);
                    documento.add(img);
                }
            } catch (Exception e) {
                System.out.println("No se pudo cargar el logo.");
            }

            documento.add(new Paragraph("Residencias ITSON – Panel de Gestión de residentes")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(14)
                    .setBold());

            documento.add(new Paragraph("Solicitud de Ingreso a Residencias")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(13)
                    .setBold());

            documento.add(new Paragraph("Documento para imprimir, firmar y subir al sistema como SIR Firmada.")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(9)
                    .setItalic());

            documento.add(new Paragraph("\n"));

            documento.add(new Paragraph("Datos del Solicitante")
                    .setBold()
                    .setFontSize(11)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            Table tablaSolicitante = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4}))
                    .useAllAvailableWidth();

            agregarCelda(tablaSolicitante, "Nombre completo:", true);
            agregarCelda(tablaSolicitante, texto(residente.getNombreCompleto()), false, 3);

            agregarCelda(tablaSolicitante, "ID académico:", true);
            agregarCelda(tablaSolicitante, texto(residente.getIdAcademico()), false);

            agregarCelda(tablaSolicitante, "CURP:", true);
            agregarCelda(tablaSolicitante, texto(residente.getCurp()), false);

            agregarCelda(tablaSolicitante, "Carrera:", true);
            agregarCelda(tablaSolicitante, texto(residente.getCarrera()), false);

            agregarCelda(tablaSolicitante, "Semestre:", true);
            agregarCelda(tablaSolicitante, texto(residente.getSemestre()), false);

            agregarCelda(tablaSolicitante, "Periodo de residencia:", true);
            agregarCelda(tablaSolicitante, texto(residente.getPeriodoResidencia()), false);

            agregarCelda(tablaSolicitante, "Correo:", true);
            agregarCelda(tablaSolicitante, texto(residente.getCorreo()), false);

            agregarCelda(tablaSolicitante, "Celular:", true);
            agregarCelda(tablaSolicitante, texto(residente.getCelular()), false);

            agregarCelda(tablaSolicitante, "Domicilio:", true);
            agregarCelda(tablaSolicitante, texto(residente.getDomicilio()), false, 3);

            agregarCelda(tablaSolicitante, "Lugar de residencia:", true);
            agregarCelda(tablaSolicitante, texto(residente.getLugarResidencia()), false, 3);

            documento.add(tablaSolicitante);
            documento.add(new Paragraph("\n"));

            documento.add(new Paragraph("Datos del Tutor")
                    .setBold()
                    .setFontSize(11)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            Table tablaTutor = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4}))
                    .useAllAvailableWidth();

            agregarCelda(tablaTutor, "Nombre:", true);
            agregarCelda(tablaTutor, texto(residente.getNombreTutor()), false, 3);

            agregarCelda(tablaTutor, "Parentesco:", true);
            agregarCelda(tablaTutor, texto(residente.getParentescoTutor()), false);

            agregarCelda(tablaTutor, "Celular:", true);
            agregarCelda(tablaTutor, texto(residente.getCelularTutor()), false);

            agregarCelda(tablaTutor, "Teléfono:", true);
            agregarCelda(tablaTutor, texto(residente.getTelefonoTutor()), false);

            agregarCelda(tablaTutor, "Correo:", true);
            agregarCelda(tablaTutor, texto(residente.getCorreoTutor()), false);

            agregarCelda(tablaTutor, "Domicilio:", true);
            agregarCelda(tablaTutor, texto(residente.getDomicilioTutor()), false, 3);

            documento.add(tablaTutor);
            documento.add(new Paragraph("\n"));

            documento.add(new Paragraph("Contacto de Emergencia")
                    .setBold()
                    .setFontSize(11)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            Table tablaEmergencia = new Table(UnitValue.createPercentArray(new float[]{2, 4, 2, 4}))
                    .useAllAvailableWidth();

            agregarCelda(tablaEmergencia, "Nombre:", true);
            agregarCelda(tablaEmergencia, texto(residente.getNombreEmergencia()), false, 3);

            agregarCelda(tablaEmergencia, "Parentesco:", true);
            agregarCelda(tablaEmergencia, texto(residente.getParentescoEmergencia()), false);

            agregarCelda(tablaEmergencia, "Celular:", true);
            agregarCelda(tablaEmergencia, texto(residente.getCelularEmergencia()), false);

            agregarCelda(tablaEmergencia, "Teléfono:", true);
            agregarCelda(tablaEmergencia, texto(residente.getTelefonoEmergencia()), false);

            agregarCelda(tablaEmergencia, "Correo:", true);
            agregarCelda(tablaEmergencia, texto(residente.getCorreoEmergencia()), false);

            agregarCelda(tablaEmergencia, "Domicilio:", true);
            agregarCelda(tablaEmergencia, texto(residente.getDomicilioEmergencia()), false, 3);

            documento.add(tablaEmergencia);
            documento.add(new Paragraph("\n"));

            documento.add(new Paragraph("Datos de la Solicitud")
                    .setBold()
                    .setFontSize(11)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            Table tablaSolicitud = new Table(UnitValue.createPercentArray(new float[]{3, 5}))
                    .useAllAvailableWidth();

            agregarPregunta(tablaSolicitud, "Tipo de pago:", texto(solicitud.getTipoPago()));
            agregarPregunta(tablaSolicitud, "Monto de pago:", texto(solicitud.getMontoPago()));
            agregarPregunta(tablaSolicitud, "ID del compañero:", texto(solicitud.getIdCompanero()));
            agregarPregunta(tablaSolicitud, "Nombre del compañero:", texto(solicitud.getNombreCompanero()));

            documento.add(tablaSolicitud);

            documento.add(new Paragraph("\n\n\n"));

            Table tabFirmas = new Table(UnitValue.createPercentArray(new float[]{1, 0.2f, 1}))
                    .useAllAvailableWidth();

            tabFirmas.setBorder(Border.NO_BORDER);

            Cell lineaFirma1 = new Cell().add(new Paragraph("\n"))
                    .setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));

            Cell lineaFirma2 = new Cell().add(new Paragraph("\n"))
                    .setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));

            tabFirmas.addCell(lineaFirma1);
            tabFirmas.addCell(new Cell().setBorder(Border.NO_BORDER));
            tabFirmas.addCell(lineaFirma2);

            tabFirmas.addCell(new Cell().add(new Paragraph("Firma del Residente")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(9)).setBorder(Border.NO_BORDER));

            tabFirmas.addCell(new Cell().setBorder(Border.NO_BORDER));

            tabFirmas.addCell(new Cell().add(new Paragraph("Firma del Tutor/Padre")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(9)).setBorder(Border.NO_BORDER));

            documento.add(tabFirmas);

            documento.add(new Paragraph("\nFavor de imprimir, firmar y subir al sistema como SIR Firmada.")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8)
                    .setItalic());

            documento.close();

        } catch (Exception e) {
            System.err.println("Error al generar Solicitud de Ingreso PDF: " + e.getMessage());
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
        tabla.addCell(new Cell().add(new Paragraph(pregunta).setBold().setFontSize(9)).setPadding(3));
        tabla.addCell(new Cell().add(new Paragraph(respuesta != null ? respuesta : " ").setFontSize(9)).setPadding(3));
    }

    private static String texto(String valor) {
        return valor != null ? valor : "";
    }

}
