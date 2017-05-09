package main.java.spark.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DateHelperImp implements IDateHelper{

	@Override
	public String convertDate(Date date, String format) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String ret = formatter.format(date);
		return ret;
	}

	@Override
	public Date getDateyyyyMMdd(String date) throws ParseException {
		// TODO Auto-generated method stub
		DateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
		return format.parse(date);
	}

}
