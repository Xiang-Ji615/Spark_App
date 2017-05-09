package main.java.spark.common.util;

import java.text.ParseException;
import java.util.Date;

public interface IDateHelper {

	String convertDate(Date date, String format);
	
	Date getDateyyyyMMdd(String date) throws ParseException ;
}
