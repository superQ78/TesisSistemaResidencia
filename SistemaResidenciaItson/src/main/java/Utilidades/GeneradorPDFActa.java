package Utilidades;

import Negocio.DTOs.ActaDTO;
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
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.net.URL;

/**
 *
 * @author Tesis
 */
public class GeneradorPDFActa {

    public static void generarActaAdministrativa(
            String rutaArchivo,
            ActaDTO acta,
            String nombreResidente,
            String carrera
    ) {
        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document documento = new Document(pdfDoc, PageSize.LETTER);
            documento.setMargins(35, 50, 40, 50);

            // Encabezado de 3 columnas: logo - titulos - logo
            try {
                URL urlIzq = GeneradorPDFActa.class.getResource("/Imagenes/LogoLetrasChico.png");
                URL urlDer = GeneradorPDFActa.class.getResource("/Imagenes/LogoItsonCam.png");
                
                Table tabCabecera = new Table(UnitValue.createPercentArray(new float[]{2.5f, 5f, 2.5f})).useAllAvailableWidth();
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
                        .setFontSize(13).setBold().setMarginBottom(0));
                celdaCentro.add(new Paragraph("Acta Administrativa")
                        .setFontSize(12).setBold().setMarginTop(0).setMarginBottom(0));
                
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
                System.err.println("Error cargando logos en acta: " + e.getMessage());
            }

            // Cuerpo del acta
            
            // Fecha alineada a la derecha
            documento.add(new Paragraph("\nCd. Obregon, Sonora. A " + UtilidadPDF.fecha(acta.getFecha()) + ".")
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(11));

            documento.add(new Paragraph("\nResidencias Estudiantiles ITSON:\n")
                    .setBold()
                    .setFontSize(12));

            documento.add(new Paragraph(
                    "Por medio del presente hago constar que yo, "
                    + nombreResidente
                    + ", como residente, incumpli los Lineamientos de Vida Comunitaria establecidos en Residencias Estudiantiles ITSON, "
                    + "los cuales hacen referencia a lo siguiente:"
            ).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(11));

            // Lineamiento roto
            documento.add(new Paragraph("\n(" + acta.getLineamiento() + ")\n")
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12));

            // Titulo de acontecimiento
            documento.add(new Paragraph("ACONTECIMIENTO:")
                    .setBold()
                    .setFontSize(11)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                    .setPadding(3f));

            // Descripcion de lo que paso
            documento.add(new Paragraph(acta.getDescripcion())
                    .setTextAlignment(TextAlignment.JUSTIFIED)
                    .setFontSize(11)
                    .setMarginTop(5f));

            // Texto de aceptacion
            documento.add(new Paragraph(
                    "\nPor lo anterior, acepto recibir las consecuencias/acciones correspondientes aplicables a mi persona "
                    + "que la Administracion de Residencias Estudiantiles ITSON considere, estando consciente de que pudiera tener afectacion "
                    + "en mi historial academico ITSON, asi como en la continuidad de mi estancia actual o futura."
            ).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(11));

            // Cierre del texto
            documento.add(new Paragraph(
                    "\nSin mas que agregar, se expide la presente en Cd. Obregon, Sonora, a los "
                    + UtilidadPDF.fecha(acta.getFecha()) + "."
            ).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(11));

            
            // Firmas y datos
            Div contenedorFirmas = new Div();
            contenedorFirmas.setKeepTogether(true);
            contenedorFirmas.setMarginTop(40f);

            contenedorFirmas.add(new Paragraph("Atentamente,")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(11));

            // columnas para la linea de firma
            Table tabFirma = new Table(UnitValue.createPercentArray(new float[]{1, 2, 1})).useAllAvailableWidth();
            tabFirma.setBorder(Border.NO_BORDER);
            tabFirma.setMarginTop(40f);

            Cell lineaFirma = new Cell().setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));
            
            tabFirma.addCell(new Cell().setBorder(Border.NO_BORDER));
            tabFirma.addCell(lineaFirma);
            tabFirma.addCell(new Cell().setBorder(Border.NO_BORDER));
            
            contenedorFirmas.add(tabFirma);

            // Nombre del residente
            contenedorFirmas.add(new Paragraph(nombreResidente)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(11)
                    .setMarginTop(2f));

            // datos adicionales
            Div infoExtra = new Div().setMarginTop(25f);
            infoExtra.add(new Paragraph("Residente Semestre: " + UtilidadPDF.texto(acta.getSemestre()))
                    .setFontSize(11).setMarginBottom(0));
            infoExtra.add(new Paragraph("Estudiante de la carrera: " + UtilidadPDF.texto(carrera))
                    .setFontSize(11).setMarginTop(0).setMarginBottom(0));
            infoExtra.add(new Paragraph("ID: " + UtilidadPDF.texto(acta.getIdAcademico()))
                    .setFontSize(11).setMarginTop(0));

            contenedorFirmas.add(infoExtra);

            documento.add(contenedorFirmas);
            documento.close();

        } catch (Exception e) {
            throw new RuntimeException("Error al generar acta administrativa: " + e.getMessage(), e);
        }
    }
}