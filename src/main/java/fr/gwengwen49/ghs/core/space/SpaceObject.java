package fr.gwengwen49.ghs.core.space;

import fr.gwengwen49.ghs.registry.GravitySources;

public interface SpaceObject {

    <T extends SpaceObject>GravitySource<T> getGravitySource();

   interface Planet extends SpaceObject {


   }

   interface NaturalSattelite extends SpaceObject {


   }

   interface Comet extends SpaceObject {


   }

   interface ExoPlanet extends SpaceObject {


   }

   interface Asteroid extends SpaceObject {


   }

   interface Sun extends SpaceObject {


   }

}
