package fr.idelia.noobengine.game;

import fr.idelia.noobengine.engine.Engine;
import fr.idelia.noobengine.engine.ILooped;
import fr.idelia.noobengine.engine.debug.Log;
import fr.idelia.noobengine.engine.motor.MotorManager;
import fr.idelia.noobengine.engine.render.RenderManager;

public class GameManager implements ILooped {
    private Engine engine;
    private RenderManager render;
    private MotorManager motor;

    public GameManager(Engine engine) {
        Log.print(getClass(), "Constructing GameManager...");

        this.engine = engine;
        this.motor = new MotorManager(engine);
        this.render = new RenderManager();

        Log.print(getClass(), "GameManager Constructed !");
    }

    @Override
    public void initialize() {
        Log.print(getClass(), "Initializing GameManager...");

        this.motor.initialize();
        this.render.initialize();

        Log.print(getClass(), "GameManager Initialized !");
    }

    @Override
    public void update() {
        this.motor.update();
        this.render.update();
    }
}