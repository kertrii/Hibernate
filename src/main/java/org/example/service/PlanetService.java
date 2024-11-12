package org.example.service;

import org.example.dao.PlanetDao;
import org.example.model.Planet;

public class PlanetService {
    private PlanetDao dao = new PlanetDao();

    public void savePlanet(Planet planet) {
        dao.save(planet);
    }

    public Planet findPlanetById(String id) {
        return dao.findById(id);
    }

    public void updatePlanet(Planet planet) {
        dao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        dao.delete(planet);
    }
}
