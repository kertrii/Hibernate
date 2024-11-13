package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, ticket.getClient().getId());
            if (client == null) {
                throw new IllegalArgumentException("This client does not exist");
            }

            Planet fromPlanet = session.get(Planet.class, ticket.getFromPlanet().getId());
            Planet toPlanet = session.get(Planet.class, ticket.getToPlanet().getId());
            if (fromPlanet == null || toPlanet == null) {
                throw new IllegalArgumentException("One or more planets do not exist");
            }

            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        }
    }

    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }
}
