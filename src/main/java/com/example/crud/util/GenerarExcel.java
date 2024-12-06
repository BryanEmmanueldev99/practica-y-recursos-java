package com.example.crud.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.example.crud.dto.Docente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("index.xlsx")
public class GenerarExcel extends AbstractXlsxView {
    
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        
             response.setHeader("Content-Disposition", "attachment; filename=\"reporte-docentes.xlsx\"");
             Sheet hoja = workbook.createSheet("Reporte_Docentes");

             Row filaTitulo = hoja.createRow(0);
             Cell celda = filaTitulo.createCell(0);
             celda.setCellValue("Reporte de docentes.");

             Row filaData = hoja.createRow(2);
             //creo un array de tipo String
             String[] arrayColumn = {"NOMBRES","EMAIL","EDAD","FECHA DE NACIMIENTO","EDAD"};
             //Recupero y me traigo todos los datos de la tabla docentes en una lista List<>
             List<Docente> docentesExcel = (List<Docente>) model.get("docentes");
             int numFila = 3;

            for(int i = 0; i < arrayColumn.length; i++) {
                    celda = filaData.createCell(i);
                    celda.setCellValue(arrayColumn[i]);
            }

             for(Docente docenteExcel : docentesExcel) {
                    filaData = hoja.createRow(numFila);
                    filaData.createCell(0).setCellValue(docenteExcel.getNombre());
                    filaData.createCell(1).setCellValue(docenteExcel.getEmail());
                    filaData.createCell(2).setCellValue(docenteExcel.getEdad());
                    filaData.createCell(3).setCellValue(docenteExcel.getFecha_nacimiento());
                    filaData.createCell(4).setCellValue(docenteExcel.getGenero());

                    numFila++;
             }
    }

}
