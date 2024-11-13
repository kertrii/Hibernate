package org.example.demo;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientService;
import org.example.service.PlanetService;
import org.example.service.TicketService;

public class DemoTicketCrudService {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        ClientService clientService = new ClientService();
        PlanetService planetService = new PlanetService();

        Ticket newTicket = new Ticket();

        Client client = clientService.findClientById(1L);
        if (client == null) {
            throw new IllegalArgumentException("Client with id 1 not found");
        }
        newTicket.setClient(client);

        Planet fromPlanet = planetService.findPlanetById("MARS");
        if (fromPlanet == null) {
            throw new IllegalArgumentException("Planet with id 'MARS' does not exist");
        }
        newTicket.setFromPlanet(fromPlanet);

        Planet toPlanet = planetService.findPlanetById("VEN");
        if (toPlanet == null) {
            throw new IllegalArgumentException("Planet with id 'VEN' does not exist");
        }
        newTicket.setToPlanet(toPlanet);

        try {
            ticketService.saveTicket(newTicket);
            System.out.println("Saved new ticket:" +
                    "\n - Client: " + client.getName() +
                    "\n - From: " + fromPlanet.getName() +
                    "\n - To: " + toPlanet.getName());
        } catch (IllegalArgumentException e) {
            System.err.println("Error saving ticket :" + e.getMessage());
        }

        System.out.println();

        Ticket ticket = ticketService.findTicketById(1L);
        if (ticket != null) {
            System.out.println("Ticket with id 1:" +
                    "\n Client: " + ticket.getClient().getName() +
                    "\n From: " + ticket.getFromPlanet().getName() +
                    "\n To: " + ticket.getToPlanet().getName());
        } else {
            System.out.println("Ticket with id 1 not found");
        }

        System.out.println();

        Planet newFromPlanet = planetService.findPlanetById("SAT");
        if (newFromPlanet != null) {
            newTicket.setFromPlanet(newFromPlanet);
        } else {
            throw new IllegalArgumentException("New 'from' planet does not exist.");
        }
        ticketService.updateTicket(newTicket);
        System.out.println("Ticket in the name " + client.getName() +
                " from " + fromPlanet.getName() +
                " to " + toPlanet.getName() +
                " was updated: ");
        System.out.println("New 'from': " + newTicket.getFromPlanet().getName());

        System.out.println();

        if (newTicket != null) {
            ticketService.deleteTicket(newTicket);
            System.out.println("Ticket in the name " + newTicket.getClient().getName() +
                    " from " + newTicket.getFromPlanet().getName() +
                    " to " + newTicket.getToPlanet().getName() +
                    " was deleted");
        }
    }
}
