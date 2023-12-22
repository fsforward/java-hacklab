import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int METERS_PER_SEC = 343;

    int secondsBetween = 0;
    int distance = 0;
    String measurement = "";
    boolean shouldLoop = true;

    while (true) {
      System.out.print("Show the distance in KM or FT: ");
      measurement = scanner.nextLine().toUpperCase();

      if (measurement.equals("KM") || measurement.equals("FT")) break;
      else System.out.println("Not a valid measurement, please try again...");
    }


    while (shouldLoop) {
      System.out.print("\nWhat is the seconds between the lightning and the thunder: ");
      secondsBetween = scanner.nextInt();

      distance = secondsBetween * METERS_PER_SEC;
      System.out.println("The distance of the thunder is: " + distance + measurement);
      System.out.println("Speed of thunder: " + METERS_PER_SEC + "M");
      System.out.println("Time till thunder reaches us: " + distance / METERS_PER_SEC);

      System.out.print("\nMeasure again? y/n: ");
      scanner.nextLine();
      String userInput = scanner.nextLine();

      shouldLoop = userInput.equalsIgnoreCase("y");
    }
  }
}