package test.java;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class ConvertUnitsTestRunner {

	public static void main(String[] args) {
		
		Result testResult = JUnitCore.runClasses(ConvertUnitsTest.class);
		
		for (Failure failure : testResult.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println("Tests were successful: " + testResult.wasSuccessful());
	}
}
