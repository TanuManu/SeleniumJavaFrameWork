package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {

		String ProjectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(ProjectPath + "/excel/data.xlsx", "1st Page");

		excel.getRowCount();
		excel.getCelldatanumber(1, 1);
		excel.getCelldatastring(0, 0);
		excel.getColCount();
	}
}
