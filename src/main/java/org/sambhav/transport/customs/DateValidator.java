package org.sambhav.transport.customs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateValidator {

	public boolean validateDate(String date)
	{
		LocalDateTime now = LocalDateTime.now();
		if(date.length()>5 || date.length()<5)
		{
			return false;
		}
		String substring = date.substring(0,2);
		for(int i=0;i<substring.length();i++)
		{
			if(!Character.isDigit(substring.charAt(i)))
			{
				return false;
			}
		}
		int value = Integer.parseInt(substring);
		if(value>23 || value<now.getHour())
		{
			return false;
		}
		
		if(date.charAt(2)!=':')
		{
			return false;
		}
		substring = date.substring(3);
		for(int i=0;i<substring.length();i++)
		{
			if(!Character.isDigit(substring.charAt(i)))
			{
				return false;
			}
		}	
		value = Integer.parseInt(substring);
		if(value>59)
		{
			return false;
		}
		if(Integer.parseInt(date.substring(0,2)) == now.getHour())
		{
			if(Integer.parseInt(date.substring(3))<now.getMinute())
			{
				return false;
			}
		}
		return true;
	}
	
	public Date calculateStartTime(String start)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		
		start = day+"/"+month+"/"+year+" "+start;
		if(day<10)
		{
			start = "0"+start;
		}
		if(month<10)
		{
			start = start.substring(0,3)+"0"+start.substring(3);
		}
		try {

			date = format.parse(start);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public Date calculateEndTime(Date starting,double getHrs)
	{
		String startTime = String.format("%tc",starting);
		String dateSplit[] = startTime.split(" ");
		String date = dateSplit[3];
		String dateSplit1[] = date.split(":");
		int hrs = Integer.parseInt(dateSplit1[0]);
		int minutes = Integer.parseInt(dateSplit1[1]);
		int number = (int)getHrs;
		double get = getHrs - number;
//		System.out.println(split2.length);
		hrs = hrs + number;
		double min = minutes + (get*60.0);
		if(min >=60)
		{
			hrs = hrs+1;
			min = min-60;
		}
		if(hrs>23)
		{
			hrs = hrs-24;
		}
		String start = hrs+":"+min;
		Date end = calculateStartTime(start);
		return end;
	}
}
