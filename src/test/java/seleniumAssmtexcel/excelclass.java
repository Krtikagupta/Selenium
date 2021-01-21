package seleniumAssmtexcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelclass {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static String celldata;



	public excelclass(String excelPath, String sheetName) {

		try {
			wb = new XSSFWorkbook(excelPath);
			sheet = wb.getSheet(sheetName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void main(String []args) {
		/*rowcount();
		coldataStr(0, 0);
		 */coldatanum(1, 0);

	}

	public static int rowcount() {
		int rowcount=0;
		try {

			rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of rows= "+rowcount);

		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowcount;
	}

	public static int colcount() {
		int colcount=0;
		try {

			colcount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No. of columns= "+colcount);

		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colcount;
	}

	public static String coldataStr(int rowNum, int colNum) {
		celldata= null;
		try {
			celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(celldata);

		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;
	}

	public static String coldatanum(int rowNum, int colNum) {
		celldata=null;
		try {

			Double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata);

		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;

	}


}
