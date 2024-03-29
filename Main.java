import Model.Clients.*;
import Model.Records.Records;
import Model.Records.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Client[] clientArr = new Client[3];
        int ch;
        List<Records> recordsList = new ArrayList<>();


        do {
            System.out.println("1 - Add client");
            System.out.println("2 - Edit client");
            System.out.println("3 - Delete client");
            System.out.println("4 - Display clients");
            System.out.println("5 - Enter record");
            System.out.println("6 - Display records");
            System.out.println(" - Exit");
            System.out.print("Enter Choice of Operation: ");

            ch = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (ch) {
                case 1:
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
                        System.out.println("Please write a valid integer input");
                     }
                        break;

                case 2:
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
                    System.out.println();
                }

                case 3:
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
                    try{

                        System.out.println("existing clients are ");
                        System.out.println();
                         for (int i = 0; i < clientArr.length; i++) {
                        clientArr[i].display();}
                        System.out.println();

                }
                    catch (NullPointerException e) {
                        
                    }

                    break;

                case 5:

                try{

                    System.out.println("existing clients are ");
                    System.out.println();
                     for (int i = 0; i < clientArr.length; i++) {
                    clientArr[i].display();}
                    System.out.println();

            }
                catch (NullPointerException e) {
                    
                }
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
                sc.nextLine();

                recordsList.add(new Records(steps, sleephrs, hydration, meditation));
                
                break;

                case 6:
                Model.Records.display_records();                                           
                break;
                case 7:
                    return;
                default:
                System.out.println("Invalid input.");
            }
        }
        
    while (true);
    }
}
