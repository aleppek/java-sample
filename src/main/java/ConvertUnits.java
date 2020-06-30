package main.java;


import java.util.ArrayList;
import java.util.Arrays;


/**
 * Class to calculate unit conversions and compare them to student answers, 
 * returning a result of correct or incorrect. Various invalid arugment cases are 
 * also handled. Temperature and volume units are allowed to be converted.
 * 
 * @author Adam Leppek
 * @since June 2020
 */
public class ConvertUnits {

	// Temperature Constants
	private static final Double CELSIUS_KELVIN_OFFSET = 273.15;
	private static final Double FAHRENHEIT_RANKINE_OFFSET = 459.67; 
	private static final Double KELVIN_TO_RANKINE = (double)9/5;
		
	// Volume Constants
	private static final Double LITERS_TO_TBSP = 67.6280455;
	private static final Double LITERS_TO_CU_IN = 61.0237441;
	private static final Double LITERS_TO_CUPS = 4.22675284;
	private static final Double LITERS_TO_CU_FT = 0.03531467;
	private static final Double LITERS_TO_GAL = 0.26417205;
	
	public static void main(String[] args) {

		// Define the units supported by the program
		ArrayList<String> temperatureUnits = new ArrayList<String>(Arrays.
				asList("Kelvin", "Celsius", "Fahrenheit", "Rankine"));
		
		ArrayList<String> volumeUnits = new ArrayList<String>(Arrays.
				asList("liters", "tablespoons", "cubic-inches", "cups", "cubic-feet", "gallons"));
		
		
		// Get inputs and do error checking
		Double inputNum = null;
		String inputUnits = null;
		String targetUnits = null;
		Double studentAns = null;
		
		if (args.length != 4) {
			throw new IllegalArgumentException("Use the correct arguments:\n" + 
					"Usage: java -jar ConvertUnits.jar <input number (dec.)> <input units (str.)> "
					+ "<output units (str.)> <student answer (dec.)>");
		}
		
		try {
			inputNum = Double.parseDouble(args[0]);
		} catch (NumberFormatException e) {
			System.err.println(e + " Invalid argument: Input number must be a decimal number.");
		}
		
		if (temperatureUnits.contains(args[1]) || volumeUnits.contains(args[1])) {
			inputUnits = args[1];
		} else {
			throw new IllegalArgumentException("Invalid argument: "
					+ "Input units must be in a supported format. See README.");
		}
		
		if (temperatureUnits.contains(args[2]) || volumeUnits.contains(args[2])) {
			targetUnits = args[2];
		} else {
			throw new IllegalArgumentException("Invalid argument: "
					+ "Target units must be in a supported format. See README.");
		}
		
		boolean oneListContainsBoth = (temperatureUnits.contains(inputUnits) && 
				temperatureUnits.contains(targetUnits)) || 
				(volumeUnits.contains(inputUnits) && volumeUnits.contains(targetUnits));
		if (!oneListContainsBoth) {
			throw new IllegalArgumentException("Invalid arguments: "
					+ "Input and target units must be compatible (both temperature or volume).");
		}
		
		try {
			studentAns = Double.parseDouble(args[3]);
		} catch (NumberFormatException e) {
			System.err.println(e + " Invalid student answer: Must be a decimal number.");
		}
		
		
		// Perform the conversion to get the right answer, depending on inputs
		Double rightAns = null;
		
		if (temperatureUnits.contains(inputUnits)) {
			rightAns = convertTemperature(inputNum, inputUnits, targetUnits);
		} else if (volumeUnits.contains(inputUnits)) {
			rightAns = convertVolume(inputNum, inputUnits, targetUnits);
		}
		
		// Compare the right answer to the student's answer
		String result = compareAnswer(studentAns, rightAns);
		
		System.out.println("Result: " + result);
	}
	
	
	/**
	 * Method to convert temperature values given an input and the units to convert to/from.
	 * 
	 * @param inputTemp {@code <Double>} Input temp value
	 * @param inputUnits {@code <String>} Units to convert <em>from</em>
	 * @param targetUnits {@code <String>} Units to convert <em>to</em>
	 * @return {@code <Double>} Converted temperature
	 */
	public static Double convertTemperature(Double inputTemp, String inputUnits, String targetUnits) {
	
		// First convert to Kelvin, a standard base unit
		Double inputTempK = null;
		
		if (inputUnits.equals("Celsius")) {
			inputTempK = inputTemp + CELSIUS_KELVIN_OFFSET;
		} else if (inputUnits.equals("Fahrenheit")) {
			inputTempK = (inputTemp + FAHRENHEIT_RANKINE_OFFSET)/KELVIN_TO_RANKINE;
		} else if (inputUnits.equals("Rankine")) {
			inputTempK = inputTemp/KELVIN_TO_RANKINE;
		} else if (inputUnits.equals("Kelvin")){
			inputTempK = inputTemp; 
		}
		
		// Then convert Kelvin to target units
		Double outputTemp = null;
		
		if (targetUnits.equals("Celsius")) {
			outputTemp = inputTempK - CELSIUS_KELVIN_OFFSET;
		} else if (targetUnits.equals("Fahrenheit")) {
			outputTemp = inputTempK*KELVIN_TO_RANKINE - FAHRENHEIT_RANKINE_OFFSET;
		} else if (targetUnits.equals("Rankine")) {
			outputTemp = inputTempK*KELVIN_TO_RANKINE;
		} else if (targetUnits.equals("Kelvin")) {
			outputTemp = inputTempK;
		}
		
		return outputTemp;
	}
	
	
	/**
	 * Method to convert volume values given an input and the units to convert to/from.
	 * 
	 * @param inputVol {@code <Double>} Input volume value
	 * @param inputUnits {@code <String>} Units to convert <em>from</em>
	 * @param targetUnits {@code <String>} Units to convert <em>to</em>
	 * @return {@code <Double>} Converted volume
	 */
	public static Double convertVolume(Double inputVol, String inputUnits, String targetUnits) {
		
		// First convert to liters, a standard base unit
		Double inputVolL = null;
		
		if (inputUnits.equals("tablespoons")) {
			inputVolL = inputVol/LITERS_TO_TBSP;
		} else if (inputUnits.equals("cubic-inches")) {
			inputVolL = inputVol/LITERS_TO_CU_IN;
		} else if (inputUnits.equals("cups")) {
			inputVolL = inputVol/LITERS_TO_CUPS;
		} else if (inputUnits.equals("cubic-feet")) {
			inputVolL = inputVol/LITERS_TO_CU_FT;
		} else if (inputUnits.equals("gallons")) {
			inputVolL = inputVol/LITERS_TO_GAL;
		} else if (inputUnits.equals("liters")) {
			inputVolL = inputVol;
		}
		
		// Then convert liters to target units
		Double outputVol = null;
		
		if (targetUnits.equals("tablespoons")) {
			outputVol = inputVolL*LITERS_TO_TBSP;
		} else if (targetUnits.equals("cubic-inches")) {
			outputVol = inputVolL*LITERS_TO_CU_IN;
		} else if (targetUnits.equals("cups")) {
			outputVol = inputVolL*LITERS_TO_CUPS;
		} else if (targetUnits.equals("cubic-feet")) {
			outputVol = inputVolL*LITERS_TO_CU_FT;
		} else if (targetUnits.equals("gallons")) {
			outputVol = inputVolL*LITERS_TO_GAL;
		} else if (targetUnits.equals("liters")) {
			outputVol = inputVolL;
		}
		
		return outputVol;
	}
	
	
	/**
	 * Method to convert a student's answer to the correct answer.
	 * 
	 * @param studentAnswer {@code <Double>} Student's answer
	 * @param rightAnswer {@code <Double>} Correct answer
	 * @return {@code <String>} Evaluation of the student's answer
	 */
	public static String compareAnswer(Double studentAnswer, Double rightAnswer) {
		
		String result = null;
		
		if (roundToTenths(studentAnswer).equals(roundToTenths(rightAnswer))) {
			result = "correct";
		} else {
			result = "incorrect";
		}
		
		return result;
	}
	
	
	/**
	 * Method to round a double number to the tenths place.
	 * 
	 * @param ans {@code <Double>} Number to be rounded
	 * @return {@code <Double>} Rounded number
	 */
	public static Double roundToTenths(Double ans) {
		
		// a. Multiply ans by 10 to get the tenths place in the ones place
		// b. Round this to a long (no decimal)
		// c. Convert it back to a double and divide by 10, putting the new (rounded)
		//    ones place back into the old tenths place
		Double ansTenths = Long.valueOf(Math.round(ans*10)).doubleValue()/10;
		
		return ansTenths;
	}
}
