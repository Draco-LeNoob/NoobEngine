package fr.idelia.noobengine.engine;

import java.io.*;

public class NoobEngine {
    // Fonctions pour écrire une ou plusieurs dans un fichier, en les ajoutant au contenu du fichier existant ou en remplaçant ce-dernier
    public static void writeInFile(File file, String lines){ NoobEngine.writeInFile(file, new String[] { lines }, false); }
    public static void writeInFile(File file, String[] lines){ NoobEngine.writeInFile(file, lines, false); }
    public static void writeInFile(File file, String line, boolean append){ NoobEngine.writeInFile(file, new String[]{ line }, append); }
    public static void writeInFile(File file, String[] lines, boolean append){
        File parent = file.getParentFile();

        if(parent != null && !parent.exists())
            parent.mkdir();

        if(!file.exists()){
            try {
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        try(FileWriter write = new FileWriter(file, append); BufferedWriter writer = new BufferedWriter(write)){
            for(String line : lines) {
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer toutes les lignes d'un fichier
    public static String[] readLinesOf(File file){
        try(FileReader read = new FileReader(file); BufferedReader reader = new BufferedReader(read)){
            return reader.lines().toList().toArray(new String[0]);
        }catch(IOException e){
            e.printStackTrace();
        }

        return new String[0];
    }
}