package com.toniclecb.velocity;

import java.util.Scanner;

import com.toniclecb.velocity.generator.MainGen;

/**
 * 
 * @author toniclecb@gmail.com
 *
 */
public class App {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" -=- Follow the instructions -=- \n");
		System.out.println("1: Create a Main Class;");
		System.out.println("2: Create a Bean Class;");
		System.out.println("\n0: Exit;");
		System.out.println("Choose one:\n");
		
		String choose = "0";
		if (sc.hasNext()){
			choose = sc.next();			
	    }
		
		if (choose.equals("1")) {
			App.executeMain();
		} else if (choose.equals("2")) {
			AppBean.execute();
		}
		sc.close();
	}
	
	private static void executeMain() {
		Scanner sc = new Scanner(System.in);

		String className = "ClassName";
		String message = "Message";
		
		System.out.println(" -=- Follow the instructions -=- ");
		System.out.println("Class Name:");
		if (sc.hasNext()){
			className = sc.next();			
	    }
		System.out.println("Message to print:");
		sc.nextLine(); // to get the first ENTER
		message = sc.nextLine();
		
		sc.close();
		
		MainGen.generateMain(className, message);
	}
}
