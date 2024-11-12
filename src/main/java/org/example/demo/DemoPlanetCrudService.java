package org.example.demo;

import org.example.model.Planet;
import org.example.service.PlanetService;

public class DemoPlanetCrudService {
    public static void main(String[] args) {
        PlanetService planetService = new PlanetService();

        Planet newPlanet = new Planet();

        newPlanet.setName("Earth");
        newPlanet.setId("EARTH");
        planetService.savePlanet(newPlanet);
        System.out.println("Saved new planet: " + newPlanet.getName());
        System.out.println();

        Planet planet = planetService.findPlanetById("MARS");
        System.out.println("Planet with id 'MARS': " + planet.getName());
        System.out.println();

        newPlanet.setName("Neptune");
        planetService.updatePlanet(newPlanet);
        System.out.println("New planet was updated:\n" +
                " - new name: " + newPlanet.getName());
        System.out.println();

        planetService.deletePlanet(newPlanet);
        System.out.println("Planet '" + newPlanet.getName() + "' was deleted");
        System.out.println();
    }
}
