package constant;

public class Constant {

//     --------------------------------FILEPATH--------------------------------------
	
		public static final String TESTDATAFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
		public static final String CATEGORYFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\Strawberry.jpg";
		public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
		
//	     -------------------------------ALERT MESSAGES--------------------------------
		
		public static final String VALIDCREDSMSG = "HomePage is not loading with proper credentials entered";
		public static final String INVALIDCREDSMSG = "HomePage is loading with invalid credentials entered";
		public static final String LOGOUTMSG = "WebPage is not getting redirected to LoginPage after LogOut";
		public static final String MANAGENEWSMSG ="Failed to add News";
		public static final String ADMINUSERSMSG ="Failed to add new Users with correct set of Data";
		public static final String MANAGECATEGORYMSG ="Failed to add a new category with proper Data";
		public static final String MANAGECONTACTMSG ="Failed to add new Contact details";
		public static final String MANAGEFOOTERMSG ="Failed to add new Footer";
		
}
