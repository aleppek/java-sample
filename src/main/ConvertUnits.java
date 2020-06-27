package main;

public class ConvertUnits {

	public static void main(String[] args) {
		// Get input: arg1 = input num; arg2 = input unit; arg3 = target unit; arg4 = student ans num
		// Response is correct, incorrect, or invalid
		// Correct means right answer and student answer match after rounded to tenths place
		// Judge on input unit what to convert, temp or volume
			// if unit is Kelvin, Celsius, Fahrenheit, Rankine, it's temp
			// if unit is liters, tablespoons, cubic-inches, cups, cubic-feet, gallons, it's vol
		// Do error check if the input unit isn't exactly one of these
		// Do error check on whether the inputs are what's expected (strings or numbers)
		// convertTemp() and convertVol() methods (these are truth): 
			// Take input num, input unit, and target unit
			// First convert to a standard reference unit, say Kelvin
				// Temp: 12 possible conversions, shortened to 6 possible conversions (go both ways)
				// Vol: 30 possible, shortened to 10 (go both ways)
		// compare truth to student answer
			// Get them both to tenths
			// Provide the answer correct or incorrect

	}

}
