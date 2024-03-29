package Model.Records;

// Defining an interface named RecordsDesc
interface RecordsDesc {

    // Interface method to delete records
    void delete_records(int client_id);

    // Interface method to update records
    void update_records(int client_id);

    // Interface method to display records
    void display_records(int client_id);
    
    // Interface method to display status
    void display_status(int client_id);
}