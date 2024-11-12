package org.example.service;

import org.example.dao.ClientDao;
import org.example.model.Client;

public class ClientService {
    private ClientDao dao = new ClientDao();

    public void saveClient(Client client) {
        dao.save(client);
    }

    public Client findClientById(Long id) {
        return dao.findById(id);
    }

    public void updateClient(Client client) {
        dao.update(client);
    }

    public void deleteClient(Client client) {
        dao.delete(client);
    }
}
