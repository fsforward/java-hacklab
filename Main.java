import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int METERS_PER_SEC = 343;

    int secondsBetween1 = 0, secondsBetween2 = 0;
    int distance1 = 0, distance2 = 0;
    double speed = 0;
    String measurement = "";
    boolean shouldLoop = true;

    while (true) {
      System.out.print("Show the distance in KM or FT: ");
      measurement = scanner.nextLine().toUpperCase();

      if (measurement.equals("FT") || measurement.equals("KM")) break;
      else System.out.println("Not a valid measurement, please try again...");
    }

    while (shouldLoop) {
      try {
        System.out.print("\nEnter seconds between lightning and thunder: ");
        secondsBetween1 = scanner.nextInt();

        distance1 = secondsBetween1 * METERS_PER_SEC;
        System.out.println("Distance to lightning: " + distance1 + measurement);

        if (secondsBetween2 != 0) {
          speed = (double) (distance1 - distance2) / (secondsBetween1 - secondsBetween2);
          System.out.println("Speed of lightning: " + speed + " M/s");
          double timeTillLightning = (double) distance1 / speed;
          System.out.println("Time till lightning reaches us: " + timeTillLightning + " seconds");
        } else {
          System.out.println("Please measure a second time to calculate the time...");
        }

        secondsBetween2 = secondsBetween1;
        distance2 = distance1;

        System.out.print("\nMeasure again? (y/any other character for no): ");
        scanner.nextLine();
        String userInput = scanner.nextLine();

        shouldLoop = userInput.equalsIgnoreCase("y");
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid numeric value for seconds.");
        scanner.nextLine();
      }
    }

    scanner.close();
  }
}
