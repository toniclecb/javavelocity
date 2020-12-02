package com.toniclecb.velocity.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityUtil {
	// path to velocity templates files
	static String inputPath = "src/main/java/resources/";
	/**
	 * Initialize the Velocity engine
	 * @return Velocity Context
	 */
	protected static VelocityContext initVelocity() {
    	System.out.println("Init Velocity!");

		VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
     
        VelocityContext context = new VelocityContext();
        return context;
    }
	
    /**
     * Generate the code and write the file.
     * @param context
     * @param pClassName Class name, and of course the file name.
     * @param inputTemplate The template file
     */
	protected static void writeTemplate(VelocityContext context, String pClassName, String inputTemplate) {
		Writer writer = null;
		String outputFile = pClassName + ".java";
		try {
			// config output file
			writer = new FileWriter(new File(outputFile));
			
			Velocity.mergeTemplate(inputPath + inputTemplate, "UTF-8", context, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
       
        System.out.println("Generated java file! ["+outputFile+"]");
	}
}
