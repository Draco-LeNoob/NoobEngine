package fr.idelia.noobengine.engine;

import fr.idelia.noobengine.engine.debug.Log;
import fr.idelia.noobengine.game.GameManager;
import fr.idelia.noobengine.json.JSON;

public class Engine extends IEngine{
    public static Engine instance;

    private boolean running;
    private int fps_limit, fps;
    private JSON config;
    private GameManager manager;
    private int exitCode;

    public Engine(JSON config) {
        Log.print(getClass(), "Constructing Engine...");

        this.config = config;
        this.running = false;
        this.manager = new GameManager(this);

        Log.print(getClass(), "Engine Constructed !");
    }

    @Override
    protected void init() {
        Log.print(getClass(), "Initializing Engine...");

        this.running = true;
        this.fps_limit = config.getInt("engine.fps_limit");

        this.manager.initialize();

        Log.print(getClass(), "Engine Initialized !");
    }

    @Override
    public void launch() {
        Log.print(getClass(), "Launching Engine...");

        Engine.instance = this;

        this.init();

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / fps_limit;
        double delta = 0;
        int frames = 0;

        Log.print(getClass(), "Engine launched !");

        while(this.running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                update();
                delta--;
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                this.fps = frames;
                frames = 0;
            }
        }

        Log.print(getClass(), "Engine Stopped...");
        Log.print(getClass(), "-".repeat(20));
        System.exit(exitCode);
    }

    @Override
    protected void update(){
        manager.update();
    }

    @Override
    public void stop(int exitCode) {
        Log.print(getClass(), "Stopping Engine...");

        this.running = false;
        this.exitCode = exitCode;
    }

    public double getDeltaTime(){ return (double)this.fps_limit / (double)fps; }
    public JSON getConfig(){ return config; }
    public int getFps(){ return fps; }
}