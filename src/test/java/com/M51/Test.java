package com.M51;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

	public static void main(String[] args) {
		LocalDate startDate = LocalDate.of(java.time.LocalDateTime.now().getYear(), java.time.LocalDateTime.now().getMonthValue(), java.time.LocalDateTime.now().getDayOfMonth()); //start date
	    long start = startDate.toEpochDay();

	    LocalDate endDate = LocalDate.of(java.time.LocalDateTime.now().getYear(),java.time.LocalDateTime.now().getMonthValue()+8,java.time.LocalDateTime.now().getDayOfMonth()); //end date
	    long end = endDate.toEpochDay();

	    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
	    System.out.println(LocalDate.ofEpochDay(randomEpochDay).getMonth().name());
	    System.out.println("SEPTEMBER 2018".contains("September")); 
	    String StartDate="01";
	    System.out.println(StartDate.substring(0,1));
	    System.out.println(StartDate.substring(0,1).equals("0")?StartDate.substring(1):StartDate);

	}

}
