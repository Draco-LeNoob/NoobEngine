package fr.idelia.noobengine.engine.event.engine.sprite;

import fr.idelia.noobengine.engine.motor.scene.Sprite;
import fr.idelia.noobengine.engine.event.Event;

public class SpriteCollideSpriteEvent extends Event {
    private Sprite other;

    public SpriteCollideSpriteEvent(Sprite other) {
        super();

        this.other = other;
    }

    public Sprite getOther() { return other; }
}