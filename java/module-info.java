module fr.idelia.noobengine {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires org.jetbrains.annotations;

    opens fr.idelia.noobengine.engine.render to javafx.graphics;

    exports fr.idelia.noobengine.engine;
    exports fr.idelia.noobengine.engine.render;
    exports fr.idelia.noobengine.game;
    exports fr.idelia.noobengine.json;
    exports fr.idelia.noobengine.test;
}