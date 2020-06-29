# flexion-project
Project for Flexion code exercise


How to install & run: 
1. Ensure that Java is installed on your machine and your Path environment 
variable contains a path to your Java installation directory's bin folder.
2. Access the bin folder of this repository (flexion-project), or download the 
.jar file located there to a location of your choosing.
3. Using the command line, navigate to the directory where the jar file is
saved.
4. Run the application using the following syntax:
   java -jar <jar-filename> <inputNum> <inputUnits> <outputUnits> <studentAns>
   a. <jar-filename> is the full filename (including .jar) of the jar you 
      downloaded from the repository.
   b. inputNum is the value to be converted from.
   c. inputUnits is the unit to be converted from.
      i. Available temperature units for conversion: 
         Kelvin, Celsius, Fahrenheit, Rankine
      ii. Available volume units for conversion:
          liters, tablespoons, cubic-inches, cups, cubic-feet, gallons
   d. outputUnits is the unit to be converted to.
   e. studentAns is the answer provided by the student.
   Example: java -jar ConvertUnits.jar 61.8 Fahrenheit Rankine 200.8
5. Upon running, the command line will show whether the student's answer was
   correct or incorrect.
   
   
Future updates: 
1. Add junit test exercising the major use cases (all the unit conversion
   permutations, error cases, exceptions thrown, etc.)
2. Refactor this in a simple web application: 
   a. The GUI will contain a text box for input number and dropdowns for the 
      input and output units. A "Calculate" button will do the calculation, and
      the answer will be displayed to the user.
   b. COTS solution AWS will simplify the design and usage (tools include AWS
      Amplify and AWS Lambda).
3. Set up a simple pipeline to automatically build, deploy, and test the app. 
   a. AWS solution above supports running a pipeline and carrying out any tests.
4. Update the application to allow for bulk input: 
   a. Instead of forcing the user to type in conversion one-by-one, allow them
      to upload a CSV file containing columns for each of the arguments.
   b. The script or web app can then produce a table showing the result of each
      calculation. 
5. Inrease the available range of unit types to convert between. To accomodate 
   a larger number of units and conversion parameters, a properties file may
   come in handy. 
6. Potentially beef up the app by calling existing unit conversion APIs instead
   of redoing them all.
   a. For example, it should be possible to call Google or Bing's conversion
      features. 
   b. This would also make it easier to provide a wider range of unit 
      conversions. 
    





