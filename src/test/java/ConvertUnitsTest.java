package test.java;


import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import main.java.ConvertUnits;


/**
 * Test class for ConvertUnits.java
 */
@RunWith(JUnitPlatform.class)
public class ConvertUnitsTest {

	public ConvertUnitsTest() {}
	
	@Test
	public void testConvertTemperature() throws FileNotFoundException, IOException {
		
		InputStream inputStream = getClass().getClassLoader().
				getResourceAsStream("test/data/convertTempTruth.csv");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String line = bufferedReader.readLine();  // throw away headings
		
		int row = 1;
		while ((line = bufferedReader.readLine()) != null) {
			
			double inputVal = Double.parseDouble(line.split(",")[0]);
			String unitsFrom = line.split(",")[1];
			String unitsTo = line.split(",")[2];
			double truthAns = Double.parseDouble(line.split(",")[3]);
			
			double convertedTemp = ConvertUnits.convertTemperature(
					inputVal, unitsFrom, unitsTo).doubleValue();
			
			assertEquals(convertedTemp, truthAns, 0.01, 
					"Values should be the same - issue in row " + row);
			
			row++;
		}
		
		bufferedReader.close();
	}

	
	@Test
	public void testConvertVolume() throws FileNotFoundException, IOException {
		
		InputStream inputStream = getClass().getClassLoader().
				getResourceAsStream("test/data/convertVolTruth.csv");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String line = bufferedReader.readLine();  // throw away headings
		
		int row = 1;
		while ((line = bufferedReader.readLine()) != null) {
			
			double inputVal = Double.parseDouble(line.split(",")[0]);
			String unitsFrom = line.split(",")[1];
			String unitsTo = line.split(",")[2];
			double truthAns = Double.parseDouble(line.split(",")[3]);
			
			double convertedVol = ConvertUnits.convertVolume(
					inputVal, unitsFrom, unitsTo).doubleValue();
			
			assertEquals(convertedVol, truthAns, 0.01, 
					"Values should be the same - issue in row " + row);
			
			row++;
		}
		
		bufferedReader.close();
	}

	
	@Test
	public void testRoundToTenths() {
		
		Double testInput = 55.543;
		double truthAns = 55.5;
		
		double testAns = ConvertUnits.roundToTenths(testInput);
		
		assertEquals(testAns, truthAns, 0.1, "Values should be the same");
	}
	
	
	@Test
	public void testCompareAnswer() {
		
		String testResultRight = ConvertUnits.compareAnswer(55.5, 55.5);
		assertEquals(testResultRight, "correct", "Bad comparison. Student answer correct.");
		
		String testResultWrong = ConvertUnits.compareAnswer(55.6, 55.5);
		assertEquals(testResultWrong, "incorrect", "Bad comparison. Student answer incorrect.");
		
	}

}
