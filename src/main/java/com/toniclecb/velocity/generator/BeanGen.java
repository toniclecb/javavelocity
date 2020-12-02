package com.toniclecb.velocity.generator;

import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.VelocityContext;

import com.toniclecb.velocity.bean.Field;

/**
 * Will generate a bean class.
 * @author toniclecb@gmail.com
 *
 */
public class BeanGen {
	static String inputTemplate = "java_bean.vm";
    
	public static void generateBean() {
		VelocityContext context = VelocityUtil.initVelocity();
		
    	String className = setDefault(context);

    	VelocityUtil.writeTemplate(context, className, inputTemplate);
	}

    /**
     * Generate a .java file.
     * In computing based on the Java Platform, JavaBeans are classes that encapsulate many objects into a single object (the bean). They are serializable, have a zero-argument constructor, and allow access to properties using getter and setter methods.
     * 
     * @param pClassName Class name, and of course the file name.
     * @param pPackageName Package where the class will be.
     * @param pSerialVersionUID Class serial.
     * @param imports If class has some imports like Date = "java.util.Date".
     * @param fields Every field in class need to be here.
     * @param constructorEmpty Will write or not the default constructor.
     * @param constructorFull Will write or not the constructor with all fields.
     */
    public static void generateBean(String pClassName, String pPackageName, long pSerialVersionUID, List<String> imports, List<Field> fields,
    		boolean constructorEmpty, boolean constructorFull) {
    	VelocityContext context = VelocityUtil.initVelocity();
		
    	// set 'variables'
        context.put("className", pClassName);
        context.put("packagename", pPackageName);

        context.put("imports", imports);
        context.put("fields", fields);
        
        context.put("serialVersionUID", pSerialVersionUID);
        
        context.put("constructorEmpty", constructorEmpty);
        context.put("constructorFull", constructorFull);
        if (constructorFull) {
        	StringBuffer listFields = new StringBuffer();
        	// Create a string like: "Long id, String name, String lastName" (used in constructor)
        	for (int i = 0; i < fields.size(); i++) {
        		Field f = fields.get(i);
				listFields.append(f.getFieldType()).append(" ").append(f.getFieldName());
				if (i+1 < fields.size())
					listFields.append(", ");
			}
        	
        	context.put("listFields", listFields);
        }

        VelocityUtil.writeTemplate(context, pClassName, inputTemplate);
    }
    

	/**
	 * This method is an example.
	 * @param context
	 * @return
	 */
	private static String setDefault(VelocityContext context) {
	    String className = "NameClass";
	    String packageName = "com.toniclecb.velocity.bean";
	    
		// set 'variables'
        context.put("className", className);
        context.put("packagename", packageName);
        List<Field> fields = new ArrayList<Field>(4);
        fields.add(new Field("id", "int"));
        fields.add(new Field("firstName", "String"));
        fields.add(new Field("lastName", "String"));
        fields.add(new Field("birthday", "Date"));
        context.put("fields", fields);
        List<String> imports = new ArrayList<String>(1);
        imports.add("java.util.Date");
        context.put("imports", imports);
        context.put("serialVersionUID", 12341234L);
        
        return className;
	}
}
