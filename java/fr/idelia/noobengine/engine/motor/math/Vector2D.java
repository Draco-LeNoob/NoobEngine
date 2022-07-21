package fr.idelia.noobengine.engine.motor.math;

import javafx.geometry.Dimension2D;

public class Vector2D {
    private Location location;
    private int rotation;
    private Dimension2D scale;

    public Vector2D(Location location, int rotation, Dimension2D scale) {
        this.location = location;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Location getLocation() { return location; }
    public int getRotation() { return rotation; }
    public Dimension2D getScale() { return scale; }

    public void setLocation(Location location) { this.location = location; }
    public void setRotation(int rotation) { this.rotation = rotation; }
    public void setScale(Dimension2D scale) { this.scale = scale; }
}