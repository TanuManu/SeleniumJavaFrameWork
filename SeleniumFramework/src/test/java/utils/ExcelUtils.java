package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String ProjectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		//getRowCount();

		//getCelldatastring(0,0);
		//getCelldatanumber(1,1);
	}
	public static int getRowCount () {

		int rowCount= 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of Rows :"+ rowCount);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return rowCount;

	}

	public static int getColCount () {
		int colCount=0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No. of Columns :"+ colCount);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return colCount;

	}

	public static String getCelldatastring (int rownum, int colnum) {

		String celldata = null;
		try {

			celldata = sheet.getRow(rownum).getCell(colnum).getStringCellValue();

			//System.out.println(celldata);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		
		return celldata;


	}

	public static double getCelldatanumber (int rownum, int colnum) {
		
		double celldata =0.0;

		try {

			celldata= sheet.getRow(rownum).getCell(colnum).getNumericCellValue();

		 //System.out.println(celldata);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
return celldata;

	}
}
