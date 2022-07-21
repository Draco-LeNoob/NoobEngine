package fr.idelia.noobengine.test;

import fr.idelia.noobengine.engine.Engine;
import fr.idelia.noobengine.json.JSON;

public class Test {
    public static void main(String[] args) {
        JSON config = new JSON("config.json");
        Engine engine = new Engine(config);
        engine.launch();
    }
}