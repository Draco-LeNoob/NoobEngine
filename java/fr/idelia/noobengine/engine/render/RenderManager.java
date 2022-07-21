package fr.idelia.noobengine.engine.render;

import fr.idelia.noobengine.engine.Engine;
import fr.idelia.noobengine.engine.ILooped;
import fr.idelia.noobengine.engine.debug.Log;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RenderManager extends Application implements ILooped {
    private Engine engine;
    private Stage window;
    private Scene scene;

    public RenderManager(){}

    @Override
    public void init() throws Exception {
        Log.print(getClass(), "Initializing RenderManager...");

        this.engine = Engine.instance;

        Log.print(getClass(), "RenderManager Initialized !");
    }

    @Override
    public void initialize() {
        this.engine = Engine.instance;

        launch(this.engine.getConfig().getString("engine.jfx.arguments"));
    }

    @Override
    public void start(Stage base) throws Exception {
        Log.print(getClass(), "Initializing Window...");

        Group root = new Group();
        Color background = Color.rgb(
                this.engine.getConfig().getInt("engine.window.background_color.red"),
                this.engine.getConfig().getInt("engine.window.background_color.green"),
                this.engine.getConfig().getInt("engine.window.background_color.blue"),
                this.engine.getConfig().getInt("engine.window.background_color.alpha") / 255.0
        );

        this.window = base;
        this.scene = new Scene(root, background);

        this.window.setTitle(this.engine.getConfig().getString("engine.window.title"));
        this.window.setWidth(this.engine.getConfig().getInt("engine.window.size.width"));
        this.window.setHeight(this.engine.getConfig().getInt("engine.window.size.height"));
        this.window.setResizable(this.engine.getConfig().getBoolean("engine.window.resizable"));
        this.window.setAlwaysOnTop(this.engine.getConfig().getBoolean("engine.window.always_on_top"));
        this.window.setFullScreen(this.engine.getConfig().getBoolean("engine.window.fullscreen"));
        this.window.setOnCloseRequest(event -> engine.stop(50));

        this.window.setForceIntegerRenderScale(true);
        this.window.centerOnScreen();
        this.window.setScene(scene);

        Log.print(getClass(), "Window Initialized !");
        Log.print(getClass(), "Showing Window...");

        this.window.show();

        Log.print(getClass(), "Window Showed !");
    }

    @Override
    public void update() {

    }
}