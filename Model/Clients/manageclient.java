package Model.Clients;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManageClient extends FileHandlingClient implements Displayable {

    ArrayList<Client> clients = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public ManageClient() {
        readClientJsonFile("src/Model/Clients/Clients.json");
    }

    public ArrayList<Client> readClientJsonFile(String Clients.json) {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(Clients.json));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    String firstName = node.get("firstName").asText();
                    String lastName = node.get("lastName").asText();
                    String email = node.get("email").asText();

                    Client client = new Client(client_id, firstName, lastName, email, address, phone);
                    clients.add(client);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public void writeClientJsonFile(String file_path, ArrayList<Client> clients) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), clients);
    }

    public void setClientsTable(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Email");


        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> clientDetails = new ArrayList<>();

        Client client = clients.get(line);
        clientDetails.add(client.getFirstName());
        clientDetails.add(client.getLastName());
        clientDetails.add(client.getEmail());

        return clientDetails;
    }

    // Implement other methods from the Displayable interface

    public ArrayList<Client> getClientList() {
        return clients;
    }
}
