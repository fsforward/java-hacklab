import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    // Variables
    // Some are just initialized with no/default values to prevent random memory values
    final Scanner scanner = new Scanner(System.in);
    final int METERS_PER_SEC = 343;

    // Variables to store input values and calculated distances and speed
    int secondsBetween1 = 0, secondsBetween2 = 0;
    int distance1 = 0, distance2 = 0;
    double speed = 0;
    String measurement = "";
    boolean shouldLoop = true;

    // Ask user to measure in Kilometers or Feet
    while (true) {
      System.out.print("Show the distance in KM or FT: ");
      measurement = scanner.nextLine().toUpperCase();

      if (measurement.equals("FT") || measurement.equals("KM")) break;
      else System.out.println("Not a valid measurement, please try again...");
    }

    // Main program
    while (shouldLoop) {
      try {
        // Get input for seconds between lightning and thunder
        System.out.print("\nEnter seconds between lightning and thunder: ");
        secondsBetween1 = scanner.nextInt();

        // Calculate distance to lightning
        distance1 = secondsBetween1 * METERS_PER_SEC;
        System.out.println("Distance to lightning: " + distance1 + measurement);

        // Calculate speed and time till lightning reaches
        if (secondsBetween2 != 0) {
          speed = (double) (distance1 - distance2) / (secondsBetween1 - secondsBetween2);
          System.out.println("Speed of lightning: " + speed + " M/s");
          double timeTillLightning = (double) distance1 / speed;
          System.out.println("Time till lightning reaches us: " + timeTillLightning + " seconds");
        } else {
          System.out.println("Please measure a second time to calculate the time...");
        }

        // Update variables for next iteration
        secondsBetween2 = secondsBetween1;
        distance2 = distance1;

        // Ask user if they want to measure again
        System.out.print("\nMeasure again? (y/any other character for no): ");
        scanner.nextLine();
        String userInput = scanner.nextLine();

        shouldLoop = userInput.equalsIgnoreCase("y");
      } catch (InputMismatchException e) {
        // Handle invalid input for seconds
        System.out.println("Invalid input. Please enter a valid numeric value for seconds.");
        scanner.nextLine();
      }
    }

    // Close the scanner to prevent memory leak
    scanner.close();
  }
}
