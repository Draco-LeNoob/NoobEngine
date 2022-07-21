package fr.idelia.noobengine.engine.motor;

import fr.idelia.noobengine.engine.Engine;
import fr.idelia.noobengine.engine.ILooped;
import fr.idelia.noobengine.engine.debug.Log;
import fr.idelia.noobengine.engine.motor.scene.Scene;

public class MotorManager implements ILooped {
    private Engine engine;
    private Scene scene;

    public MotorManager(Engine engine) {
        Log.print(getClass(), "Constructing MotorManager...");

        this.engine = engine;
        this.scene = new Scene();

        Log.print(getClass(), "MotorManager constructed !");
    }

    @Override
    public void initialize() {
        Log.print(getClass(), "Initializing MotorManager...");

        this.scene.load();
        this.scene.initialize();

        Log.print(getClass(), "MotorManager Initialized !");
    }

    @Override
    public void update() {
        this.scene.update();
    }
}