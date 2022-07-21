package fr.idelia.noobengine.engine.event;

import fr.idelia.noobengine.engine.Engine;

public class Event {
    private Engine engine;

    public Event() {
        this.engine = Engine.instance;
    }

    public Engine getEngine() { return engine; }
}