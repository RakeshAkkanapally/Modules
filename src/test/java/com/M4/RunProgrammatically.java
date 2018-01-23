package com.M4;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class RunProgrammatically {
	
	public static void main(String args[]) {
		List<String> suitesList = new ArrayList<String>();
		TestListenerAdapter listener = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setOutputDirectory("Output-M4");
		suitesList.add("./src/test/resources/testng_m4.xml");
		testng.setTestSuites(suitesList);
		testng.addListener(listener);
		testng.run(); 
		
	}
	
	
}
