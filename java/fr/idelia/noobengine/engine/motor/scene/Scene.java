package fr.idelia.noobengine.engine.motor.scene;

import fr.idelia.noobengine.engine.ILooped;
import fr.idelia.noobengine.engine.debug.Log;
import fr.idelia.noobengine.engine.motor.component.Component;
import fr.idelia.noobengine.engine.motor.component.Script;
import fr.idelia.noobengine.engine.event.engine.SceneLoadEvent;

import java.util.ArrayList;
import java.util.List;

public class Scene implements ILooped {
    private List<Sprite> sprites;

    public Scene() {
        Log.print(getClass(), "Constructing Scene...");

        this.sprites = new ArrayList<>();

        Log.print(getClass(), "Scene constructed !");
    }

    public void load(){
        Log.print(getClass(), "Loading Scene");
        Log.print(getClass(), "Loading Sprites");

        for(Sprite sprite : this.getSprites()) {
            for (Component component : sprite.getComponents()) {
                if (component instanceof Script script) {
                    script.onSceneLoad(new SceneLoadEvent(this));
                }
            }
        }

        Log.print(getClass(), "Sprites Loaded");
        Log.print(getClass(), "Scene Loaded (" + this.sprites.size() + " sprites loaded)");
    }

    @Override
    public void initialize() {
        Log.print(getClass(), "Initializing Scene");

        for(Sprite sprite : this.getSprites()){
            sprite.initialize();
        }

        Log.print(getClass(), "Scene Initialized");
    }

    @Override
    public void update() {
        for(Sprite sprite : this.getSprites()){
            sprite.update();
        }
    }

    public Sprite[] getSprites(){ return sprites.toArray(new Sprite[0]); }
}