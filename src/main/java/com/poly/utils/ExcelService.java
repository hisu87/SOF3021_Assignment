package com.poly.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poly.entity.Report;

public class ExcelService {
	
	public static void exportReportExcel(String sheetName, List<Report> reports, boolean isDrink) {
		try {
			String columnName = isDrink ? "Drink Name" : "Create Date";
			
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet(sheetName);
			
			
			Row row = sheet.createRow(0);
			row.createCell(0).setCellValue("#");
			row.createCell(1).setCellValue(columnName);
			row.createCell(2).setCellValue("Quantity");
			row.createCell(3).setCellValue("Total Price");
			
			for (int i = 0; i < reports.size(); i++) {
				Report r = reports.get(i);
				row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(r.getId() + 1);
				if (!isDrink)
					row.createCell(1).setCellValue(r.getCreateDate().toString());
				else
					row.createCell(1).setCellValue(r.getDrinkName().toString());
				row.createCell(2).setCellValue(r.getQuantity());
				row.createCell(3).setCellValue(r.getTotalPrice());
			}
			
			String path = System.getProperty("user.dir") + "/src/main/webapp/report/report.xlsx";
			File file = new File(path);
			if (!file.getParentFile().exists())
				file.getParentFile().mkdir();
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);;

			fos.close();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static CellStyle getRowStyle(XSSFWorkbook workbook) {
		CellStyle rowStyle = workbook.createCellStyle();
		rowStyle.setAlignment(HorizontalAlignment.CENTER);
		rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		rowStyle.setWrapText(true);

		return rowStyle;
	}

}