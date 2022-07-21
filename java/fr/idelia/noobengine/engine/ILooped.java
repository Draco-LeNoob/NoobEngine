package fr.idelia.noobengine.engine;

// Interface pour toutes les classes faisant partie de la boucle du moteur
public interface ILooped {
    // Initialiser l'objet (méthode appelée après l'instanciation
    void initialize();
    // Actualiser l'objet (méthode appelée à chaque frame)
    void update();
}