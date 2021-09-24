package com.qa.testscripts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.qa.pages.AmazonAddCartPage;
import com.qa.pages.AmazonFilterPages;
import com.qa.pages.AmazonLoginPage;
import com.qa.pages.AmazonOrderDetailsPage;
import com.qa.pages.AmazonOrderPage;
import com.qa.pages.CancelOrderPage;
import com.qa.pages.GiftCardPage;
import com.qa.pages.MobileRechargePage;
import com.qa.pages.TodaysDeals;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver Driver;
	public static JavascriptExecutor js;
	public static Actions act;
	public static AmazonAddCartPage amazoneOBJ;
	public static AmazonLoginPage signUp_OR;
	public static GiftCardPage gftb;
	public static CancelOrderPage cop;
	public static AmazonFilterPages filter;
	public static MobileRechargePage aftb;
	public static AmazonOrderPage ao;
	public static TodaysDeals Amazon;
	public static AmazonOrderDetailsPage mcp;
	public static Properties property;
	public static FileReader reader;
	public static String path;
	public static JFrame jframe;
	public static String mailConfirm;
	public static List<String> logs = new ArrayList<String>();
	public static List<String> paths = new ArrayList<String>();

	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setUp(String browser, String url) throws InterruptedException, IOException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			Driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
		}
		signUp_OR = new AmazonLoginPage(Driver);
		amazoneOBJ = new AmazonAddCartPage(Driver);
		gftb = new GiftCardPage(Driver);
		cop = new CancelOrderPage(Driver);
		filter = new AmazonFilterPages(Driver);
		aftb = new MobileRechargePage(Driver);
		ao = new AmazonOrderPage(Driver);
		Amazon = new TodaysDeals(Driver);
		mcp = new AmazonOrderDetailsPage(Driver);
		js = (JavascriptExecutor) Driver;
		act = new Actions(Driver);
		reader = new FileReader(".\\src\\test\\java\\com\\qa\\testdata\\input.properties");
		property = new Properties();
		property.load(reader);
		path = ".\\src\\test\\java\\com\\qa\\testdata\\AmazonInputData.xlsx";
		jframe = new JFrame();
		Driver.manage().window().maximize();
		Driver.get(url);
		Driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws IOException, InterruptedException {
		
		Driver.quit();
		mailConfirm = JOptionPane.showInputDialog(jframe,"If you want to send Email to ExtentHtmlReport\n Enter Yes / No");
		Thread.sleep(100);
	}

	public static void captureScreenshot(String methodName, String status) {
		try {
			TakesScreenshot ts = (TakesScreenshot) Driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(".//Screenshots//" + methodName + ".png");
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot captured for " + status);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean getMailConfirm() {
		boolean status = false;
		if (mailConfirm.equalsIgnoreCase("yes")) {
			status = true;
		} else if (mailConfirm.equalsIgnoreCase("no") || mailConfirm == null) {
			status = false;
		}
		return status;
	}

	public static void setDetailMsg(String msg) {
		logs.add(msg);
	}

	public static List<String> getDetailMsg() {
		return logs;
	}

	public static void clearLogs() {
		logs.clear();
	}

	public static void setOpenFilePath(String openFilePath) {
		paths.add(openFilePath);
	}

	public static List<String> getFilesPath() {
		return paths;
	}

	public static void clearPaths() {
		paths.clear();
	}

}
