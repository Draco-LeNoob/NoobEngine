package fr.idelia.noobengine.engine.motor.component;

import fr.idelia.noobengine.engine.event.engine.sprite.SpriteInitializeEvent;
import fr.idelia.noobengine.engine.event.engine.sprite.SpriteUpdateEvent;

public abstract class Component {
    public abstract void initialize(SpriteInitializeEvent event);
    public abstract void update(SpriteUpdateEvent event);
}