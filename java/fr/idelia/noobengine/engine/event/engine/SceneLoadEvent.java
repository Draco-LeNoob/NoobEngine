package fr.idelia.noobengine.engine.event.engine;

import fr.idelia.noobengine.engine.motor.scene.Scene;
import fr.idelia.noobengine.engine.event.Event;

public class SceneLoadEvent extends Event {
    private Scene scene;

    public SceneLoadEvent(Scene scene) {
        super();

        this.scene = scene;
    }

    public Scene getScene() { return scene; }
}