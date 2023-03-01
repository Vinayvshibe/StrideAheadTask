package com.strideAhead; 
import java.io.File; 
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Scanner;

public class Task {
	public static void dateTask() {
		System.out.println("Select Start date in the form yyyy-mm-dd");
		Scanner sc =new Scanner(System.in);
		String strstartDate = sc.next();
		try {
		LocalDate startdate=LocalDate.parse(strstartDate);
		System.out.println("Select end date in the form yyyy-mm-dd");
		String strendDate = sc.next();
		LocalDate enddate=LocalDate.parse(strendDate);
		for(LocalDate i=startdate;i.isBefore(enddate);i=i.plusDays(1)) {
			if((i.getDayOfWeek().toString()=="MONDAY")
					|| (i.getDayOfWeek().toString()=="THURSDAY") 
					||  (i.getDayOfWeek().toString()=="FRIDAY")) {
				System.out.println(i+ " " +i.getDayOfWeek());
				
			}
		}
		}
		catch(Exception e) {
			System.out.println("please enter date in valid form given date not exists!");
			Task.dateTask();
		}
		
		
	}
	
	public static void interestTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter principal amount to calculate interest");
		float p = sc.nextFloat();
		float r = (float) (4.5 / 4.0);
		float si = (float) ((p * r) / 100.0);
		System.out.println("Quarterly interest generated on " + p + " is " + si + " for 4.5% interest per annum");

	}
	
	
	public static void electricBill() {
		System.out.println("Select date in the form yyyy-mm-dd to pay bill");
		Scanner sc =new Scanner(System.in);
		String strDate = sc.next();
		try {
			LocalDate date=LocalDate.parse(strDate);
			if(date.getDayOfMonth()<=10) {
				System.out.println("Electric amount of the month is 1000");
			}
			else {
				int extraDays =(date.getDayOfMonth()-10);
				float penaltyCharge=(float) ((1000*extraDays)/100.0);
				float payableAmount=1000+penaltyCharge;
				System.out.println("Electric amount of the month is "+payableAmount);
			}
		}
		catch(Exception e) {
			System.out.println("please enter date in valid form given date not exists!");
			Task.electricBill();
		}
		
	}
	public static void fileTask() {
		File file =new File("data.txt");
		String content="abc";
		byte[] bytes =content.getBytes();
		//System.out.println(file.getAbsolutePath());
		try {
			
			Files.write(file.toPath(), bytes);
			System.out.println("String content added into the file successfully");
		}
		catch(IOException e) {
		e.printStackTrace();
		Task.fileTask();
		}
	}

	public static void main(String[] args) {
		
				Task.dateTask();
			
				Task.interestTask();
				
				Task.electricBill();
				
				Task.fileTask();
				
			}
			
				
		
		
		
		
		
	

}

