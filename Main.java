import Model.Clients.*;
import Model.Records.Records;
import Model.Records.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Identification comments:
 *   Name: 
 *   Group:10
 *   Experiment No: 
 *   Experiment Title: Health Monitoring System
 *   Experiment Date:
 *   @version 1.0
 *
 * Beginning comments:
 * Filename: Main.java
 * @author:  soham patil
 * Overview: This is the main class used for managing clients and records. In this file, we have achieved the following:
 * - Menu-driven program to perform operations on clients and records
 * - Exception handling for input validation
 */

// Main class of the program
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Client[] clientArr = new Client[3];// Array to store client objects
        int ch;// User choice variable
        List<Records> recordsList = new ArrayList<>();

        // Starting a do-while loop to repeatedly display menu and perform operations
        do {
            // Displaying menu options
            System.out.println("1 - Add client");
            System.out.println("2 - Edit client");
            System.out.println("3 - Delete client");
            System.out.println("4 - Display clients");
            System.out.println("5 - Enter record");
            System.out.println("6 - Display records");
            System.out.println(" - Exit");
            System.out.print("Enter Choice of Operation: ");

            // Reading user choice
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline character

            // Handling user choices
            switch (ch) {
                case 1:
                        // Adding a new client
                        try {
                         for (int i = 0; i < clientArr.length; i++) {
                            System.out.println("Enter no. of clients to be entered:");
                            int n = sc.nextInt();
                            sc.nextLine(); // Consume newline character
                            for (int j = 1; j <= n; j++) {
                                System.out.println("Enter Client Name: ");
                                String name = sc.nextLine();
                                System.out.println("Enter Client Age: ");
                                int age = sc.nextInt();
                                sc.nextLine(); // Consume newline character
                                System.out.println("Enter Client Email: ");
                                String email = sc.nextLine();
                                System.out.println("Enter Client Gender: ");
                                String gender = sc.nextLine();
                                clientArr[i] = new Client(email, name, age, gender);
                                
                            }
                            break;
                        }
                     }   catch (InputMismatchException e) {
                        // Exception handling for invalid input
                        System.out.println("Please write a valid integer input");
                     }
                        break;

                case 2:
                    // Editing an existing client
                    try {
                    System.out.println("Existing Clients:");
                    for (int i = 0; i < clientArr.length; i++) {
                        System.out.println((i + 1) + ". " + clientArr[i].getf_name());
                    }

                    System.out.println("Enter the client number you want to edit:");
                    int userChoice = sc.nextInt();
                    sc.nextLine(); // Consume newline character

                    if (userChoice > 0 && userChoice <= clientArr.length) {
                        int index = userChoice - 1;
                        Client selectedClient = clientArr[index];

                        // Updating client information
                        System.out.println("Selected Client Information:");
                        selectedClient.display();

                        System.out.println("Enter new information for the selected client:");
                        System.out.print("Enter Client Name: ");
                        String name = sc.nextLine();
                        selectedClient.setf_name(name);

                        System.out.print("Enter Client Age: ");
                        int age = sc.nextInt();
                        selectedClient.setf_age(age);
                        sc.nextLine(); // Consume newline character

                        System.out.print("Enter Client Email: ");
                        String email = sc.nextLine();
                        selectedClient.setClient_email(email);

                        System.out.print("Enter Client Gender: ");
                        String gender = sc.nextLine();
                        selectedClient.setf_gender(gender);

                        System.out.println("Updated Client Information:");
                        selectedClient.display();
                    } else {
                        System.out.println("Invalid client number.");
                    }
                    break;
                } catch (Exception e) {
                    // Handle any exception that might occur during client editing
                    System.out.println("An error occurred while editing the client. Please try again.");
                }
                break;

                case 3:
                    // Deleting a  existing client
                    for (int i = 0; i < clientArr.length; i++) {
                        System.out.print("Enter Index of client to delete : ");
                        int user = sc.nextInt();
                        sc.nextLine(); // Consume newline character
                        clientArr[user].setf_name(null);
                        clientArr[user].setf_age(0);
                        clientArr[user].setClient_email(null);
                        clientArr[user].setf_gender(null);
                    }
                    break;

                case 4:
                    // Displaying all existing clients
                    try{

                        // Attempting to display existing clients
                        System.out.println("existing clients are ");
                        System.out.println();
                         for (int i = 0; i < clientArr.length; i++) {
                        clientArr[i].display();}
                        System.out.println();

                }
                    catch (NullPointerException e) {
                        // Handling NullPointerException if any client is null
                        // This can occur if a client object has not been initialized
                        // or if it has been explicitly set to null
                        System.out.println("Error: NullPointerException occurred while displaying clients.");
                        
                    }

                    break;

                case 5:
                // Entering record for a client
                try{
                    // Displaying existing clients
                    System.out.println("existing clients are ");
                    System.out.println();
                     for (int i = 0; i < clientArr.length; i++) {
                    clientArr[i].display();}
                    System.out.println();

            }
                catch (NullPointerException e) {
                    // Handle null pointer exception if client array is not initialized or contains null elements
                    System.out.println("Error: No clients available. Please add clients first.");
                    break;                   
                }

                // Asking for client ID and record details
                System.out.println("Enter Client Id: ");
                int client_id = sc.nextInt();
                // To avoid unnecessary skip of input
                sc.nextLine();
                System.out.println("Enter number of steps: ");
                int steps = sc.nextInt();
                System.out.println("Enter sleep hours: ");
                int sleephrs = sc.nextInt();

                System.out.println("Enter litres of water consumed: ");
                int hydration = sc.nextInt();

                System.out.println("Meditation (true/false): ");
                boolean meditation = sc.nextBoolean();
                sc.nextLine(); // Consume newline character

               // Adding record to the records list
                recordsList.add(new Records(steps, sleephrs, hydration, meditation));
                
                break;

                case 6:
                // Displaying all records
                // Call the display_records method from Records class
                Model.Records.display_records();                                           
                break;
                case 7:
                    // Exiting the program
                    return;
                default:
                System.out.println("Invalid input.");
            }
        }
        
    while (true);
    /**
 * Infinite Loop:
 * The loop condition "true" ensures that the loop will run indefinitely 
 * unless there's an explicit exit condition within the loop body or the program is terminated externally.
 * The loop is used to maintain the program's interactive nature
 * Allowing the user to perform multiple operations without exiting the program after each operation.
 * To exit the program, the user can choose the appropriate option from the menu, triggering a return statement or breaking out of the loop.
 */
    }
}
