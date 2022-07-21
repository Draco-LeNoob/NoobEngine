package fr.idelia.noobengine.engine.motor.component;

import fr.idelia.noobengine.engine.event.engine.SceneLoadEvent;
import fr.idelia.noobengine.engine.event.engine.sprite.SpriteCollideSpriteEvent;
import fr.idelia.noobengine.engine.event.engine.sprite.SpriteDestroyEvent;

public abstract class Script extends Component{
    public abstract void onCollide(SpriteCollideSpriteEvent event);
    public abstract void onSceneLoad(SceneLoadEvent event);
    public abstract void onDestroy(SpriteDestroyEvent event);
}