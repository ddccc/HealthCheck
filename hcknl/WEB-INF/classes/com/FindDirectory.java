package com;

public class FindDirectory {

    final static String directory = getDirectoryJRun();


public static void main (String [] arguments) {

    String value = directory;

    System.out.println("value= " + value);

} // end of main

    private static String getDirectoryJRun() {
	String value = System.getProperty("user.dir");
	System.out.println("value1= " + value);
	String separator = System.getProperty("file.separator");
	System.out.println("separator= " + separator);
	int i = value.lastIndexOf(separator);
	value = value.substring(0, i);
	i = value.lastIndexOf(separator);
	value = value.substring(0, i);
	i = value.lastIndexOf(separator);
	value = value.substring(0, i);
	System.out.println("value2= " + value);
	if ( separator.equals("\\") ) 
	    value = value.replace('\\', '/');
	System.out.println("value3= " + value);
	return value;
    }


} 
