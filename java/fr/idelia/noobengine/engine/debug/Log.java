package fr.idelia.noobengine.engine.debug;

import fr.idelia.noobengine.engine.NoobEngine;

import java.io.File;

public class Log {
    public static void print(Class<?> from, String message){
        printInFile(from, Time.timeToString() + "[" + from.getSimpleName() + "]" + ": " + message);
        printInConsole(from, Time.timeToString() + "[" + from.getSimpleName() + "]" + ": " + message);
    }

    private static void printInFile(Class<?> from, String message){
        NoobEngine.writeInFile(new File(System.getProperty("user.dir"), "src/main/resources/logs/" + Time.dateToString() + ".nel"), message, true);
    }

    private static void printInConsole(Class<?> from, String message){
        System.out.println(message);
    }
}