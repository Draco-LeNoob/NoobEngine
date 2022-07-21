package fr.idelia.noobengine.engine.event.engine.sprite;

import fr.idelia.noobengine.engine.motor.scene.Scene;
import fr.idelia.noobengine.engine.motor.scene.Sprite;
import fr.idelia.noobengine.engine.event.Event;

public class SpriteInitializeEvent extends Event {
    private Scene scene;
    private Sprite sprite;

    public SpriteInitializeEvent(Scene scene, Sprite sprite) {
        super();

        this.scene = scene;
        this.sprite = sprite;
    }

    public Scene getScene() { return scene; }
    public Sprite getSprite() { return sprite; }
}