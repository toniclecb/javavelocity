package com.toniclecb.velocity.generator;

import org.apache.velocity.VelocityContext;

/**
 * Generator for Main classes
 * @author toniclecb@gmail.com
 *
 */
public class MainGen {
	static String inputTemplate = "java_main.vm";
	
	public static void generateMain(String className, String message) {
		VelocityContext context = VelocityUtil.initVelocity();
		
    	// set 'variables'
        context.put("className", className);
        context.put("message", message);

        VelocityUtil.writeTemplate(context, className, inputTemplate);
	}
}
