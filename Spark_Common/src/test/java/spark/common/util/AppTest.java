package test.java.spark.common.util;

import java.text.ParseException;

import main.java.spark.common.util.DateHelperImp;
import main.java.spark.common.util.IDateHelper;

public class AppTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		IDateHelper dateHelper = new DateHelperImp();
		System.out.println(dateHelper.convertDate(dateHelper.getDateyyyyMMdd("20170509"), "yyyy/MM/dd"));
	}

}
