package com.helpezee.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {

		// Get the current date only
		LocalDate date = LocalDate.now();
		System.out.println("Current Date: " + date);

		// Get the current time only
		LocalTime time = LocalTime.now();
		System.out.println("Current Time: " + time);

		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		Month month = currentTime.getMonth();
		int monthInInteger = month.getValue();
		int day = currentTime.getDayOfMonth();
		int year = currentTime.getYear();
		int hrs = currentTime.getHour();
		int minutes = currentTime.getMinute();
		int seconds = currentTime.getSecond();

		System.out.println("Month: " + month + " day: " + day + " Year: " + year + " monthInInteger: " + monthInInteger);
		System.out.println("Hours:  " + hrs + " Minutes:  " + minutes + " Seconds:  " + seconds);

		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);
		
	      //12 december 2014
	      LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
	      System.out.println("date3: " + date3);
	      
	      //22 hour 15 minutes
	      LocalTime date4 = LocalTime.of(22, 15);
	      System.out.println("date4: " + date4);
	      
	      //parse a string
	      LocalTime date5 = LocalTime.parse("20:15:30");
	      System.out.println("date5: " + date5);
	      
	      LocalDate date6 = LocalDate.parse("2014-12-12");
	      System.out.println("date6: " + date6);
	      
	      //Zoned Date-Time API
	      
	      // Get the current date and time
	      ZonedDateTime date7 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
	      System.out.println("date7: " + date7);
	      
	      ZoneId id = ZoneId.of("Europe/Paris");
	      System.out.println("ZoneId: " + id);
			
	      ZoneId currentZone = ZoneId.systemDefault();
	      System.out.println("CurrentZone: " + currentZone);
	      
	      // Chrono Units Enum
	      
	    //Get the current date
	      LocalDate today = LocalDate.now();
	      System.out.println("Current date: " + today);
			
	      //add 1 week to the current date
	      LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
	      System.out.println("Next week: " + nextWeek);
			
	      //add 1 month to the current date
	      LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
	      System.out.println("Next month: " + nextMonth);
			
	      //add 1 year to the current date
	      LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
	      System.out.println("Next year: " + nextYear);
			
	      //add 10 years to the current date
	      LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
	      System.out.println("Date after ten year: " + nextDecade);
	      
	      //Period 
	      
	      //Get the current date
	      LocalDate date8 = LocalDate.now();
	      System.out.println("Current date: " + date8);
			
	      //add 1 month to the current date
	      LocalDate date9 = date1.plus(1, ChronoUnit.MONTHS);
	      System.out.println("Next month: " + date9);
	      
	      Period period = Period.between(date9, date8);
	      System.out.println("Period: " + period);
	      
	      
	      // Duration
	      
	      LocalTime time1 = LocalTime.now();
	      
	      Duration twoHours = Duration.ofHours(2);
	      LocalTime time2 = time1.plus(twoHours);
	      
	      Duration duration = Duration.between(time1, time2);
			
	      System.out.println("Duration: " + duration);
	      
	      
	      //Temporal Adjusters
	      
	    //Get the current date
	      LocalDate date10 = LocalDate.now();
	      System.out.println("Current date: " + date10);
			
	      //get the next tuesday
	      LocalDate nextTuesday = date10.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
	      System.out.println("Next Tuesday on : " + nextTuesday);
			
	      //get the second saturday of next month
	      LocalDate firstInYear = LocalDate.of(date10.getYear(),date10.getMonth(), 1);
	      System.out.println("First in Year :    "+firstInYear);
	      
	      LocalDate firstSaturday = firstInYear.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
	      System.out.println("first Saturday on : " + firstSaturday);
	  
	      LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
	      System.out.println("Second Saturday on : " + secondSaturday);
	      
	      LocalDate thirdSaturday = secondSaturday.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
	      System.out.println("Third Saturday on : " + thirdSaturday);
	      
	      
	      
	      //Backward Compatibility
	      
	      
	     //Get the current date
	      Date currentDate = new Date();
	      System.out.println("Current date: " + currentDate);
			
	      //Get the instant of current date in terms of milliseconds
	      Instant now = currentDate.toInstant();
	      ZoneId currentZone1 = ZoneId.systemDefault();
			
	      LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone1);
	      System.out.println("Local date: " + localDateTime);
			
	      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone1);
	      System.out.println("Zoned date: " + zonedDateTime);

	}

}
