package cn.itcast.test;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.junit.Before;
import org.junit.Test;

public class TestPOIExcel {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWrite03() throws Exception {
//		1、创建工作簿
		HSSFWorkbook workbook=new HSSFWorkbook();
//		2、创建工作表及表名
		HSSFSheet sheet=workbook.createSheet("hello world");
//		3、创建第三行
		HSSFRow row=sheet.createRow(3);
//		4、创建第三行第三列
		HSSFCell cell=row.createCell(3);		
		cell.setCellValue("Hello");
		
		//输出硬盘
		FileOutputStream out=new FileOutputStream("E:/itcast/poi/test.xls");		
		//将excel输出到具体地址 
		workbook.write(out);
		workbook.close();
		out.close();	
	}
	@Test
	public void testRead03() throws Exception {
		FileInputStream input=new FileInputStream("E:/itcast/poi/test.xls");	
//		1、读取工作簿
		HSSFWorkbook workbook=new HSSFWorkbook(input);
//		2、读取工作表及表名
		HSSFSheet sheet=workbook.getSheet("hello world");
//		3、读取第三行
		HSSFRow row=sheet.getRow(3);
//		4、读取第三行第三列
		HSSFCell cell=row.getCell(3);		
		System.out.println("第四行第四列单元格内容为："+cell.getStringCellValue());

		workbook.close();
		input.close();	
	}
	@Test//XMLEventFactory.newFactory()这个API是在JDK 1.6.0.18加入的，你得确保你使用的JDK高于这个版本
	public void testWrite07() throws Exception {
//		1、创建工作簿
		XSSFWorkbook workbook=new XSSFWorkbook();
//		2、创建工作表及表名
		XSSFSheet sheet=workbook.createSheet("hello world");
//		3、创建第三行
		XSSFRow row=sheet.createRow(3);
//		4、创建第三行第三列
		XSSFCell cell=row.createCell(3);		
		cell.setCellValue("Hello");
		
		//输出硬盘
		FileOutputStream out=new FileOutputStream("E:/itcast/poi/test07.xlsx");		
		//将excel输出到具体地址 
		workbook.write(out);
		workbook.close();
		out.close();	
	}
	@Test
	public void testRead07() throws Exception {
		FileInputStream input=new FileInputStream("E:/itcast/poi/test07.xlsx");	
//		1、读取工作簿
		XSSFWorkbook workbook=new XSSFWorkbook(input);
//		2、读取工作表及表名
		XSSFSheet sheet=workbook.getSheet("hello world");
//		3、读取第三行
		XSSFRow row=sheet.getRow(3);
//		4、读取第三行第三列
		XSSFCell cell=row.getCell(3);		
		System.out.println("第四行第四列单元格内容为："+cell.getStringCellValue());
		
		workbook.close();
		input.close();	
	}
	
	@Test
	public void testRead03And07Excel() throws Exception {
		String fileName = "E:/itcast/poi/test07.xlsx";
		if(fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){//判断是否excel文档
			
			boolean is03Excel = fileName.matches("^.+\\.(?i)(xls)$");		
			FileInputStream inputStream = new FileInputStream(fileName);
			
			//1、读取工作簿
			Workbook workbook = is03Excel ?new HSSFWorkbook(inputStream):new XSSFWorkbook(inputStream);
			//2、读取第一个工作表
			Sheet sheet = workbook.getSheetAt(0);
			//3、读取行；读取第3行
			Row row = sheet.getRow(3);
			//4、读取单元格；读取第3行第3列
			Cell cell = row.getCell(3);
			System.out.println("第4行第4列单元格的内容为：" + cell.getStringCellValue());
			
			workbook.close();
			inputStream.close();
		}
	}
	
	@Test
	public void testExcelStyle() throws Exception {
		//1、创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//1.1、创建合并单元格对象;合并第3行的第3列到第5列
		CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 2, 2, 4);//起始行号，结束行号，起始列号，结束列号
		//1.2、创建单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		//1.3、创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗字体
		font.setFontHeightInPoints((short) 16);//设置字体大小
		//加载字体
		style.setFont(font);
	
		//单元格背景
		//设置背景填充模式
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置填充背景色
		style.setFillBackgroundColor(HSSFColor.YELLOW.index);
		//设置填充前景色
		style.setFillForegroundColor(HSSFColor.RED.index);
		
		//2、创建工作表
		HSSFSheet sheet = workbook.createSheet("Hello World");//指定工作表名
		//2.1、加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		
		//3、创建行；创建第3行
		HSSFRow row = sheet.createRow(2);
		//4、创建单元格；创建第3行第3列
		HSSFCell cell = row.createCell(2);
		//加载样式
		cell.setCellStyle(style);
		cell.setCellValue("Hello World!");
	
		//输出到硬盘
		FileOutputStream outputStream = new FileOutputStream("E:/itcast/poi/test03style.xls");
		//把excel输出到具体的地址
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
