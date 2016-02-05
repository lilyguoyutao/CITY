package com.jcg.examples.viewcontent;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.jcg.examples.viewcontent.AbstractExcelView;

import com.jcg.examples.viewBean.Student;

public class ViewExcel extends AbstractExcelView{
	
	@Override
     protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) 
                     throws Exception{
		response.setHeader("Content-Dispositon", "inline;filename="+new String("listwe".getBytes(),"iso8859-1"));
    	 List<Student> list=(List<Student>)model.get("liststudent");
    	 Sheet sheet=workbook.createSheet("userlistsheet");
 		Row fist=sheet.createRow(0);
 		fist.createCell(0).setCellValue("username");
 		fist.createCell(1).setCellValue("password");
 		fist.createCell(2).setCellValue("firstname");
 		fist.createCell(3).setCellValue("lastname");
 		fist.createCell(4).setCellValue("school");
 		fist.createCell(5).setCellValue("email");
 		
 		for (int i = 0; i < list.size(); i++) {
 			 
 			             Student student=list.get(i);
 			             Row row = sheet.createRow(i + 1);
 			 
 			             Cell cell = row.createCell(0);
 			             cell.setCellValue(student.getUsername());
 			             
 			            
 			 
 			            cell = row.createCell(1);
 			            cell.setCellValue(student.getPassword());
 			            row.createCell(2).setCellValue(student.getFirstname());
 			            row.createCell(3).setCellValue(student.getSecondname());
 			            row.createCell(4).setCellValue(student.getSchool());
 			            row.createCell(5).setCellValue(student.getEmail());
 			            
 			        }
     }


}


