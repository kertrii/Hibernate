package org.example.demo;

import org.example.model.Client;
import org.example.service.ClientService;

public class DemoClientCrudService {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        Client newClient = new Client();

        newClient.setName("Lila");
        clientService.saveClient(newClient);
        System.out.println("Saved new client: " + newClient.getName());
        System.out.println();

        Client client = clientService.findClientById(10L);
        System.out.println("Find client with id 10: " + client.getName());
        System.out.println();

        newClient.setName("Lilya");
        clientService.updateClient(newClient);
        System.out.println("Client name was updated: " + newClient.getName());
        System.out.println();

        clientService.deleteClient(newClient);
        System.out.println("Client '" + newClient.getName() + "' was deleted");
        System.out.println();
    }
}
