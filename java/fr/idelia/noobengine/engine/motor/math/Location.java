package fr.idelia.noobengine.engine.motor.math;

public class Location {
    private int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void translate(Location vector){
        this.x += vector.getX();
        this.y += vector.getY();
    }

    public void time(int x, int y){
        this.x *= x;
        this.y *= y;
    }

    public void time(Location vector){
        this.x *= vector.getX();
        this.y *= vector.getY();
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}