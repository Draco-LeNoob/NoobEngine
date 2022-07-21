package fr.idelia.noobengine.engine.motor.scene;

import fr.idelia.noobengine.engine.ILooped;
import fr.idelia.noobengine.engine.motor.component.Component;
import fr.idelia.noobengine.engine.motor.math.Vector2D;
import fr.idelia.noobengine.engine.event.engine.sprite.SpriteInitializeEvent;
import fr.idelia.noobengine.engine.event.engine.sprite.SpriteUpdateEvent;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Sprite implements ILooped {
    private final Scene scene;
    private final Vector2D vector;
    private Image texture;
    private final List<Component> components;

    public Sprite(Scene scene, Vector2D vector, Image texture) {
        this.scene = scene;
        this.vector = vector;
        this.texture = texture;
        this.components = new ArrayList<>();
    }

    @Override
    public void initialize() {
        for(Component component : this.components)
            component.initialize(new SpriteInitializeEvent(this.scene, this));
    }

    @Override
    public void update() {
        for(Component component : this.components)
            component.update(new SpriteUpdateEvent(this.scene, this));
    }

    public Scene getScene() { return scene; }
    public Vector2D getVector() { return vector; }
    public Image getTexture() { return texture; }
    public void setTexture(Image texture) { this.texture = texture; }
    public Component[] getComponents() { return components.toArray(new Component[0]); }
    public void addComponent(Component component) { this.components.add(component); }
}