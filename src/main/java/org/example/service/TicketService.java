package org.example.service;

import org.example.dao.TicketDao;
import org.example.model.Ticket;

public class TicketService {
    private TicketDao dao = new TicketDao();

    public void saveTicket(Ticket ticket) {
        dao.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return dao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        dao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        dao.delete(ticket);
    }
}
