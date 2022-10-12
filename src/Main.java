import java.util.Scanner;

public class Main {

    public static void listAvailableCommands() {
        System.out.println("Invalid Input: Please enter a valid input (x+, x-, y+, y-, thrusters, self destruct, nothing)");
    }
    public static void selfDestructSequence() {
        String command = "";
        while (!command.equalsIgnoreCase("BOOM")) {
            System.out.println("Self destruct initializer activated, please enter cancellation code to deactivate");
            command = getCommand();
        }
    }
    public static String getCommand() {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Enter your command. (x+, x-, y+, y-, thrusters, self destruct, nothing)");
        String command = newScanner.nextLine();
        return command;
    }
    public static int randomNumberGeneration() {
        int randomNumber = (int) (Math.random() * -20) + 10;
        return randomNumber;
    }
    public static boolean commandIsValid(String command) {
        return command.equalsIgnoreCase("x+") ||
                command.equalsIgnoreCase("x-") ||
                command.equalsIgnoreCase("y+") ||
                command.equalsIgnoreCase("y-") ||
                command.equalsIgnoreCase("thrusters") ||
                command.equalsIgnoreCase("self destruct") ||
                command.equalsIgnoreCase("nothing");
    }

    public static void main(String[] args) {

        String playAgain = "Y";
        while (playAgain.equalsIgnoreCase("y")) {


            int surfaceDistance = 10;
            int xTilt = randomNumberGeneration();
            int yTilt = randomNumberGeneration();

            while (surfaceDistance != 0) {
                System.out.println("Your starting distance is " +surfaceDistance+ "km. from the surface.\n" +
                        "Your current coordinates are:\nx-axis: " +xTilt+ " degrees.\ny-axis: " +yTilt+ " degrees.");

                String command = getCommand();
                if (commandIsValid(command)) {
                    surfaceDistance--;
                    if (command.equalsIgnoreCase("x+")) {
                        xTilt++;
                    } else if (command.equalsIgnoreCase("x-")) {
                        xTilt--;
                    } else if (command.equalsIgnoreCase("y+")) {
                        yTilt++;
                    } else if (command.equalsIgnoreCase("y-")) {
                        yTilt--;
                    } else if (command.equalsIgnoreCase("thrusters")) {
                        surfaceDistance += 2;
                    } else if (command.equalsIgnoreCase("self destruct")) {
                        selfDestructSequence();
                    }
                } else {
                    listAvailableCommands();
                }
            }
            if (xTilt != 0 || yTilt != 0) {
                System.out.println("You crashed the lander... NASA is NOT happy!! $$$");
            } else {
                System.out.println("The eagle has landed! Great work:)");
            }

            System.out.println("Would you like to play again? (y/n)");
            Scanner keyboard = new Scanner(System.in);
            playAgain = keyboard.nextLine();
        }

    }

}