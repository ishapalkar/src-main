package Model.Records;

import java.util.ArrayList;
import java.util.List;

/**
 * Identification comments:
 *   Name: Soham patil
 *   Group:10
 *   Experiment No: 02
 *   Experiment Title: Record Class
 *   Experiment Date:15-02-2024
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Records.java
 * @author:  Soham patil
 * Overview: This is the Records class.
 * This class represents a set of records related to a client's activities and health metrics.
 * In this file we have achieved the following
 * - Created Attributes
 * ---  int steps;
 * ---  int sleephrs;
 * ---  int hydration;
 * ---  boolean meditation;
 *
 * - Created Setters and Getters
 * - Created a Display Function to call the getters and display Instance data
 * - Implementation of interface methods to
 * ---  display_records(int client_id);
 * ---  display_status(int client_id);
 * ---  delete_records(int client_id);
 * ---  update_records(int client_id);
 *
 */

 //Records class implementing the RecordsDesc interface, providing methods to interact with and manage records.
public class Records implements RecordsDesc{

    int steps;
    int sleephrs;
    int hydration;
    boolean meditation;

    // Constructor to initialize the Records object with given values
    public Records(int steps, int sleephrs, int hydration, boolean meditation)
    {
        this.steps = steps;
        this.sleephrs = sleephrs;
        this.hydration = hydration;
        this.meditation = meditation;
    }

    // Setter methods to set values for attributes
    public void setsteps(int steps) {
        this.steps = steps;
    }

    public void setsleephrs(int sleephrs) {
        this.sleephrs = sleephrs;
    }

    public void sethydration(int hydration) {
        this.hydration = hydration;
    }

    public void setmeditation(boolean meditation) { 
        this.meditation = meditation;
    }
   
    // Getter methods to retrieve values of attributes
    public int getsteps() {
        return steps;
    }

    public int getsleephrs() {
        return sleephrs;
    }

    public int gethydration() {
        return hydration;
    }

    public boolean getmeditation() {
        return meditation;
    }


    //Implementation of inteface methods 
    @Override
    public void display_records(int client_id) {
        List<Records> recordsList = new ArrayList<>();
        for (Records record : recordsList) 

        {
            System.out.println("Steps: " + record.getsteps());
            System.out.println("Sleep Hours: " + record.getsleephrs());
            System.out.println("Water Consumed: " + record.gethydration());
            System.out.println("Meditation: " + record.getmeditation());
            System.out.println();
        }
    }

    @Override
    public void display_status(int client_id)
    {
        System.out.println("Client stepsstatus: "+getsteps());
        System.out.println("Client sleephrs status: "+getsleephrs());
        System.out.println("Client hydraion status: "+gethydration());
        System.out.println("Client meditation status: "+getmeditation()); 
    }

    @Override
    public void delete_records(int client_id) {
        // Implement delete_records method here
        System.out.println("Deleted records for client ID: " + client_id);
    }

    @Override
    public void update_records(int client_id) {
        // Implement update_records method here
        System.out.println("Updated records for client ID: " + client_id);
    }
}



