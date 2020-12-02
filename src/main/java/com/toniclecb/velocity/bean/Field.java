package com.toniclecb.velocity.bean;

import org.apache.commons.lang.WordUtils;

/**
 * This Class is used to provide the field of a class like an object to velocity engine.
 * 
 * @author toniclecb@gmail.com
 */
public class Field {
	private String fieldName;
	private String fieldType;

	public Field(String fieldName, String fieldType) {
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Capitalize the first char of the field name.
	 * @return
	 */
	public String getFieldNameCapitalize() {
		return WordUtils.capitalize(fieldName.substring(0, 1)) + fieldName.substring(1);
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
}
