package com.example.crud.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.ColorUIResource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.example.crud.dto.Docente;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("index")
public class GenerarPDF extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
            
            document.setPageSize(PageSize.LETTER.rotate());
            document.setMargins(-20, -20, 40, 20);
            document.open();

            List<Docente> docentesPDF = (List<Docente>) model.get("docentes");
            PdfPTable tb_title = new PdfPTable(1);
            //PdfPTable formato y mapeo de datos de los docentes
            PdfPTable tb_docentes = new PdfPTable(5);
            PdfPCell celda = null;

            Font fontFamily_Tittle = FontFactory.getFont("Helvetica", 16,Color.WHITE);
            Font fontColumn = FontFactory.getFont("Helvetica",10,Color.BLACK);

            String Mayuscula = "Listado de docentes.";
            celda = new PdfPCell(new Phrase(Mayuscula.toUpperCase(), fontFamily_Tittle));
            celda.setBorder(0);
            celda.setBackgroundColor(new Color(40,90,138));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_CENTER);
            celda.setPadding(20);
            tb_title.addCell(celda);
            tb_title.setSpacingAfter(20);


            celda= new PdfPCell(new Phrase("NOMBRES", fontColumn));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_CENTER);
            celda.setPadding(20);
            tb_docentes.addCell(celda);
            
            celda= new PdfPCell(new Phrase("EMAIL", fontColumn));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_CENTER);
            celda.setPadding(20);
            tb_docentes.addCell(celda);

            celda= new PdfPCell(new Phrase("EDAD", fontColumn));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_CENTER);
            celda.setPadding(20);
            tb_docentes.addCell(celda);

            celda= new PdfPCell(new Phrase("FECHA DE NACIMIENTO", fontColumn));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_CENTER);
            celda.setPadding(20);
            tb_docentes.addCell(celda);

            celda= new PdfPCell(new Phrase("GÉNERO", fontColumn));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_CENTER);
            celda.setPadding(20);
            tb_docentes.addCell(celda);
            
            for(Docente docente : docentesPDF) {
                    celda= new PdfPCell(new Phrase(docente.getNombre(), fontColumn));
                    celda.setPadding(2);
                    tb_docentes.addCell(celda);

                    celda= new PdfPCell(new Phrase(docente.getEmail(), fontColumn));
                    celda.setPadding(2);
                    tb_docentes.addCell(celda);

                    celda= new PdfPCell(new Phrase(docente.getEdad().toString(), fontColumn));
                    celda.setPadding(2);
                    tb_docentes.addCell(celda);

                    celda= new PdfPCell(new Phrase(docente.getFecha_nacimiento(), fontColumn));
                    celda.setPadding(2);
                    tb_docentes.addCell(celda);

                    celda= new PdfPCell(new Phrase(docente.getGenero(), fontColumn));
                    celda.setPadding(2);
                    tb_docentes.addCell(celda);
            }

            // docentesPDF.forEach(docente -> {
            //        tb_docentes.addCell(docente.getNombre());
            //        tb_docentes.addCell(docente.getEmail());
            //        tb_docentes.addCell(docente.getEdad().toString());
            //        tb_docentes.addCell(docente.getFecha_nacimiento());
            //        tb_docentes.addCell(docente.getGenero());
            // });

            document.add(tb_title);
            document.add(tb_docentes);
    }

}
