
package Utilidades;

import Negocio.DTOs.ActaDTO;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

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
            documento.setMargins(60, 60, 60, 60);

            documento.add(new Paragraph("Cd. Obregón, Sonora. A " + UtilidadPDF.fecha(acta.getFecha()) + ".")
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(11));

            documento.add(new Paragraph("\nResidencias Estudiantiles ITSON:\n")
                    .setBold()
                    .setFontSize(12));

            documento.add(new Paragraph(
                    "Por medio del presente hago constar que yo, "
                    + nombreResidente
                    + ", como residente, incumplí los Lineamientos de Vida Comunitaria establecidos en Residencias Estudiantiles ITSON, "
                    + "los cuales hacen referencia a lo siguiente:"
            ).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(11));

            documento.add(new Paragraph("\n(" + acta.getLineamiento() + ")\n")
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12));

            documento.add(new Paragraph("ACONTECIMIENTO:")
                    .setBold()
                    .setFontSize(11)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            documento.add(new Paragraph(acta.getDescripcion())
                    .setTextAlignment(TextAlignment.JUSTIFIED)
                    .setFontSize(11));

            documento.add(new Paragraph(
                    "\nPor lo anterior, acepto recibir las consecuencias/acciones correspondientes aplicables a mi persona "
                    + "que la Administración de Residencias Estudiantiles ITSON considere, estando consciente de que pudiera tener afectación "
                    + "en mi historial académico ITSON, así como en la continuidad de mi estancia actual o futura."
            ).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(11));

            documento.add(new Paragraph(
                    "\nSin más que agregar, se expide la presente en Cd. Obregón, Sonora, a los "
                    + UtilidadPDF.fecha(acta.getFecha()) + "."
            ).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(11));

            documento.add(new Paragraph("\n\n\nAtentamente:\n\n___________________________\n" + nombreResidente)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(11));

            documento.add(new Paragraph("\nResidente Semestre: " + UtilidadPDF.texto(acta.getSemestre()))
                    .setFontSize(11));

            documento.add(new Paragraph("Estudiante de la carrera: " + UtilidadPDF.texto(carrera))
                    .setFontSize(11));

            documento.add(new Paragraph("ID: " + UtilidadPDF.texto(acta.getIdAcademico()))
                    .setFontSize(11));

            documento.close();

        } catch (Exception e) {
            throw new RuntimeException("Error al generar acta administrativa: " + e.getMessage(), e);
        }
    }
}
