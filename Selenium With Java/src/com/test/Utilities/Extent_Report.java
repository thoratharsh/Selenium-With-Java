package com.test.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_Report {
	public static ExtentReports report = null;

	public static ExtentReports create_Report() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MMM_yyyy-HH_MM");
		String report_file_name = "Extent_Report_" + formatter.format(date);
		report = new ExtentReports(Config.REPORT_PATH + "//" + report_file_name + ".html", true);

		return report;
	}

	public static void close_Report() {
		report.flush();
		report.close();
	}

	public static ExtentTest start_test(String test_name) {
		ExtentTest test = report.startTest(test_name);
		return test;
	}

	public static void end_test(ExtentTest test) {
		report.endTest(test);
	}
	
	public static void pass_test(ExtentTest test,String step_name) {
		test.log(LogStatus.PASS, step_name);
	}
	
	public static void fail_test(ExtentTest test,String step_name) {
		test.log(LogStatus.FAIL, step_name);
	}
}
