package org.pluralsight;


import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    // simple search engine with user input
    static void main() {
        Scanner userInput = new Scanner(System.in);


        System.out.println();
        System.out.println("WELCOME TO MY VERY LEGIT AND REAL SEARCH ENGINE");
        System.out.println("----------------------------------------------------------");

        // assigns searchTerm as empty to have loop below work
        String searchTerm = "";

        while (!searchTerm.equals("X")){
            System.out.print("Please enter a search term (or X to exit): ");
            // do not declare searchTerm again
            searchTerm = userInput.nextLine();
            System.out.println();

            // if/else loop to help the user close the app
            if (searchTerm.equals("X")) {
                System.out.println();
                System.out.println("Closing the program, see you never!");
            }

            else
            {
                System.out.println("Searching for: " + searchTerm);
                System.out.println();
                System.out.println(searchTerm + " not found! Maybe try Google instead? " +
                        "I'm sure they don't keep track of what you search AT ALL");
                System.out.println();
            }




            // put logging function AFTER user's input
            logAction("SHOW USER SEARCH", searchTerm);
            // NOTE: add a boolean flag to avoid empty SHOW USER SEARCH lines in the log

        }
    }

    // logAction function
    private static void logAction(String action, String message) {

        FileOutputStream fileOutputStream = null;
        PrintWriter printWriter = null;

        try
        {
            // setting up variables to track what user searches/creates the .txt file
            fileOutputStream = new FileOutputStream("log.txt", true);
            printWriter = new PrintWriter(fileOutputStream);

            // gets the specific time for the logs
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timeStamp = now.format(formatter);

            // logs into the text file
            printWriter.println(timeStamp + " " + action + " " + message);
        }

        // catches any errors
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        finally
            {
                if(printWriter != null)
                {
                    // PrintWriter doesn't throw an exception if it fails to close, so we don't need to catch it
                    printWriter.close();
                }
            }

    }
}
