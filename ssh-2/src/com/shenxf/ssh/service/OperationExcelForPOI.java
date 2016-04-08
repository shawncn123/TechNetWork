package com.shenxf.ssh.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OperationExcelForPOI {

	/*
	 * 实现excel 文件的导入导出
	 */

	public void impExcel(String execelFile) {
		try {
			// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)
			Workbook book = null;
			try {
				// Excel 2007获取方法
				book = new XSSFWorkbook(new FileInputStream(execelFile));
			} catch (Exception ex) {
				// Excel 2003获取方法
				book = new HSSFWorkbook(new FileInputStream(execelFile));
			}

			// 读取表格的第一个sheet页
			Sheet sheet = book.getSheetAt(0);
			// 定义 row、cell
			Row row;
			Cell cell;
			//CellValue cellValue;
			String cellValue;
			String cell_str;
			// 总共有多少行,从0开始
			int totalRows = sheet.getLastRowNum();
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			for (int i = 1; i <= totalRows; i++) {
				row = sheet.getRow(i);
				// 处理空行
				if (row == null) {
					continue;
				}
				// 总共有多少列,从0开始
				int totalCells = row.getLastCellNum();
				for (int j = row.getFirstCellNum(); j < totalCells; j++) {
					// 处理空列
					if (row.getCell(j) == null) {
						continue;
					}
					// 通过 row.getCell(j).toString() 获取单元格内容
//					cell = row.getCell(j).toString();
					cell = row.getCell(j);
					
					switch(cell.getCellType()){
			        case  HSSFCell.CELL_TYPE_NUMERIC:
			         if (HSSFDateUtil.isCellDateFormatted(cell)) {  
			                double d = cell.getNumericCellValue();  
			                Date date = HSSFDateUtil.getJavaDate(d); 
			                SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
			                cellValue = dformat.format(date);
			          // System.out.println("=========date="+ dformat.format(date));     
			             }else{
			           NumberFormat nf = NumberFormat.getInstance();
			           nf.setGroupingUsed(false);//true时的格式：1,234,567,890
			           cellValue= nf.format(cell.getNumericCellValue());//数值类型的数据为double，所以需要转换一下
			           //System.out.println("===CELL_TYPE_NUMERIC"+cellValue);
			             }
			        break;
			        case HSSFCell.CELL_TYPE_STRING:
			        // System.out.println("===CELL_TYPE_STRING"+cell.getStringCellValue());
			           cellValue=cell.getStringCellValue();
			        break;
			        case HSSFCell.CELL_TYPE_BOOLEAN:
			        // System.out.println("====CELL_TYPE_BOOLEAN"+cell.getBooleanCellValue());
			         cellValue=String.valueOf(cell.getBooleanCellValue());
			        break;
			        case HSSFCell.CELL_TYPE_FORMULA:
			         //System.out.println("====CELL_TYPE_FORMULA"+cell.getCellFormula());
			         cellValue=String.valueOf(cell.getCellFormula());
			        break;
			        
			        default:
			         cellValue="";
			       // System.out.println("unsuported cell type");
			        break;
			       }
					
					
//					String cell1 = new String(cell.getBytes(""), "UTF-8");
					System.out.print(cellValue + "\t");
				}
				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
