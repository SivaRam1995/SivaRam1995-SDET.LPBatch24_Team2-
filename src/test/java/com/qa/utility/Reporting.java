package com.qa.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.katasiva.javaemail.JavaEmail;
import com.katasiva.zipfolder.ZipFolder;
import com.qa.testscripts.TestBase;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports exReports;
	public ExtentTest xTest;
	public String repName;;
	public String DateStamp;
	public String repFolder;
	public String repPath;

	public void onStart(ITestContext testContext) {
		DateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + DateStamp + ".html";
		repFolder = ".//Reports//Test-Report-" + DateStamp;
		File f = new File(repFolder);
		f.mkdir();
		repPath = ".//Reports//Test-Report-" + DateStamp + "//" + repName;
		htmlReporter = new ExtentHtmlReporter(repPath);
		exReports = new ExtentReports();
		exReports.attachReporter(htmlReporter);
		exReports.setSystemInfo("HostName", "localhost");
		exReports.setSystemInfo("AQ", "Team2");
		exReports.setSystemInfo("OS", "Windows10");
		htmlReporter.config().setDocumentTitle("Test Automation");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

	}

	public void onFinish(ITestContext testContext) {
		exReports.flush();
		File htmlFile = new File(repPath);
		try {
			Thread.sleep(3000);
			boolean confirm = TestBase.getMailConfirm();
			if (confirm) {
				try {
					Thread.sleep(5000);
					ZipFolder.setZipped(repFolder);
					System.out.println("ZipFolder Created");
					Thread.sleep(5000);
					String[] attachments = { repFolder + ".zip" };
					JavaEmail.sendEmail(attachments);
					System.out.println(" Thank you for your response (YES) Mail Sended...! ");
					Thread.sleep(2000);
					boolean d = ZipFolder.getDeleted(repFolder + ".zip");
					if (d == true) {
						System.out.println("Zip file Deleted");
					} else {
						System.out.println("zip file not deleted");
					}
				} catch (Exception e) {
					System.out.println("mail issue");
					e.printStackTrace();
				}
			} else {
				System.out.println(" Thank you for your response (NO) Mail Not Sended...! ");
			}
			Thread.sleep(4000);
			if (htmlFile.exists()) {
				Desktop.getDesktop().open(htmlFile);
				List<String> filesPath = TestBase.getFilesPath();
				for (String path : filesPath) {
					Thread.sleep(2000);
					File file = new File(path);
					if (file.exists()) {
						Desktop.getDesktop().open(file);
					}
				}
				TestBase.clearPaths();
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void onTestSuccess(ITestResult tr) {
		xTest = exReports.createTest(tr.getName());// create an entry in the extent report
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		xTest.log(Status.PASS, "Test is Passed");
		List<String> detail = TestBase.getDetailMsg();
		for (String logs : detail) {
			xTest.log(Status.INFO, logs);
		}
		TestBase.clearLogs();
	}

	public void onTestFailure(ITestResult tr) {
		xTest = exReports.createTest(tr.getName());// create an entry in the extent report
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		xTest.log(Status.FAIL, "Test is Failed");
		xTest.log(Status.FAIL, tr.getThrowable());
		List<String> detail = TestBase.getDetailMsg();
		for (String logs : detail) {
			xTest.log(Status.INFO, logs);
		}
		TestBase.clearLogs();
		TestBase.captureScreenshot(tr.getMethod().getMethodName(), "Failed Test");
		String SSName = ".//Screenshots//" + tr.getName() + ".png";
		File file = new File(SSName);
		if (file.exists()) {
			try {
				xTest.fail("Screenshot for the test failed is:" + xTest.addScreenCaptureFromPath(SSName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult tr) {
		xTest = exReports.createTest(tr.getName());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		xTest.log(Status.SKIP, "Test is Skipped");
	}

}
