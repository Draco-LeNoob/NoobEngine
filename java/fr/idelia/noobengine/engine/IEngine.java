package fr.idelia.noobengine.engine;

// Interface pour la classe Engine
public abstract class IEngine {
    // Initialiser le moteur
    protected abstract void init();
    // Lancer le moteur
    public abstract void launch();
    // Actualise le moteur
    protected abstract void update();
    // Stopper le moteur
    public abstract void stop(int code);
}