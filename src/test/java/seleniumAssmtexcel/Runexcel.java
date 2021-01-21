package seleniumAssmtexcel;

public class Runexcel {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		excelclass excelnew= new excelclass(path+"/excelfile/MyData.xlsx", "Sheet1");
		excelnew.rowcount();
		excelnew.coldataStr(0, 0);
		excelnew.coldatanum(1, 0);

	}

}
