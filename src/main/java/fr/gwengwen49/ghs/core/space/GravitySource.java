package fr.gwengwen49.ghs.core.space;

public interface GravitySource<T extends SpaceObject> {

    String getName();

    T getSpaceObject();

    default String getPath(){
        return "space/fundamentals/gravity_source/" + this.getName();
    }
}
