package com.toniclecb.velocity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.toniclecb.velocity.bean.Field;
import com.toniclecb.velocity.generator.BeanGen;

/**
 * 
 * @author toniclecb@gmail.com
 *
 */
public class AppBean {
    
	/**
	 * Process inputs to generate a Bean
	 */
	public static void execute() {
//		To generate a Bean with default variables
//		BeanGen.generateBean();
		
		// Dinamic
		Scanner sc = new Scanner(System.in);
		
		String pClassName = "ClassName";
		String pPackageName = "package_name";
		long pSerialVersionUID = 1L;
		List<String> imports = new ArrayList<String>();
		List<Field> fields = new ArrayList<Field>();
		
		System.out.println(" -=- Follow the instructions, type what is requested! -=- ");
		System.out.println("Class Name:");
		if (sc.hasNext()){
			pClassName = sc.next();			
	    }
		System.out.println("Package:");
		if (sc.hasNext()){
			pPackageName = sc.next();			
	    }
		System.out.println("SerialVersionUID (need to be a valid long):");
		if (sc.hasNext()){
			try {
				pSerialVersionUID = sc.nextLong();
			} catch (Exception e) {
				System.out.println("Error to enter *SerialVersionUID*: " + e.getMessage());
				System.exit(0);
			}
	    }
		
		System.out.println("Import [type -1 to stop entering imports]:");
		while (sc.hasNext()){
			String importString = sc.next();
			if (importString.equalsIgnoreCase("-1"))
				break;
			else
				imports.add(importString);
			System.out.println("Import [type -1 to stop entering imports]:");
	    }
		
		System.out.println("Fields names and fields types (separated by a comma (name,type example: size,float) [type -1 to stop entering fields]:");
		while (sc.hasNext()){
			String field = sc.next();
			if (field.equalsIgnoreCase("-1"))
				break;
			else {
				String[] splited = field.split(",");
				String fieldName = splited[0];
				String fieldType = splited[1];
				fields.add(new Field(fieldName, fieldType));
			}
			System.out.println("Fields names and fields types (separated by a comma (name,type example: size,float) [type -1 to stop entering fields]:");
	    }
		
		System.out.println("Default constructor (zero-argument constructor)? [Y or N]:");
		boolean constructorEmpty = false;
		if (sc.hasNext()){
			String c = sc.next();
			if (c.equalsIgnoreCase("Y"))
				constructorEmpty = true;
	    }
		System.out.println("Constructor with all fields? [Y or N]:");
		boolean constructorFull = false;
		if (sc.hasNext()){
			String c = sc.next();
			if (c.equalsIgnoreCase("Y"))
				constructorFull = true;
	    }
				
	    sc.close();
	    
	    BeanGen.generateBean(pClassName, pPackageName, pSerialVersionUID, imports, fields, constructorEmpty, constructorFull);
	}
}
/* Example of input:
Person
com.toniclecb.velocity.bean
123456
java.util.Date
-1
id,int
firstName,String
lastName,String
birthday,Date
-1
Y
Y
*/

