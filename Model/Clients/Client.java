package Model.Clients;

/**
 * Identification comments:
 *   Name: Soham patil
 *   Experiment No: 02
 *   Experiment Title: Client Class
 *   Experiment Date:08-02-2024
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Client.java
 * @author:  Soham patil
 * Overview: This is the Client class.In this file we have achieved the following
 * - Created Attributes
 * --- int client_id
 * --- String client_name
 * --- String client_email
 * --- int client_age
 * --- String client_gender; 
 *
 * - Created Setters and Getters
 * - Created a Display Function to call the getters and display Instance data
 * - This class extends the Human class 
 * - to inherit common attributes and behaviors of a human
 * - Created static variable to keep track of total no of client objects  
 *
 */
public class Client extends Human {

    private static int client_count = 0;
    int client_id;
    String client_email;

    public static int getClient_count() {
        return client_count;
    }

    public Client() {
        super();
        client_count++;
        this.setClient_email("default@example.com"); // Assuming default email
    }

    public Client(String client_email, String client_f_name, int client_f_age, String client_f_gender) {
        super(client_f_name, client_f_age, client_f_gender);
        this.client_id = client_count++;
        this.setClient_email(client_email);
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_email() {
        return client_email;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Client Email: " + getClient_email());
    }
}
