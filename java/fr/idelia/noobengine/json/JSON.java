package fr.idelia.noobengine.json;

import fr.idelia.noobengine.engine.NoobEngine;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

// Une classe servant à lire ou écrire dans des fichiers json
public class JSON {
    private static final String splitter = "/";

    // Le fichier json
    private File file;
    // Object Json (HashMap) représentant le fichier
    private JSONObject json;

    // Constructeur
    public JSON(String path){ this(new File(System.getProperty("user.dir"), "src/main/resources/" + path)); }
    public JSON(File file){
        this.file = file;

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            this.json = (JSONObject) new JSONParser().parse(reader);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire une valeur dans le fichier json
    public String getString(@NotNull String key) {
        key = key.replace(".", splitter);

        // On cherche une valeur directe
        if(!key.contains(splitter)){
            Object value = json.get(key);
            return value == null ? "null" : value.toString();
        }

        // La valeur n'est pas accessible directement, mais par un chemin dans le fichier json
        String[] keys = key.split(splitter);
        JSONObject value = (JSONObject) json.get(keys[0]);

        for(int i = 1; i < keys.length - 1; i++)
            value = (JSONObject) value.get(keys[i]);

        return value == null ? "null" : value.get(keys[keys.length - 1]).toString();
    }

    // Méthodes pour lire une valeur dans le fichier json sous la forme d'un objet précis
    public int getInt(@NotNull String key){ return Integer.parseInt(this.getString(key)); }
    public long getLong(@NotNull String key){ return Long.parseLong(this.getString(key)); }
    public short getShort(@NotNull String key){ return Short.parseShort(this.getString(key)); }
    public boolean getBoolean(@NotNull String key){ return Boolean.parseBoolean(this.getString(key)); }
    public byte getByte(@NotNull String key){ return Byte.parseByte(this.getString(key)); }
    public double getDouble(@NotNull String key){ return Double.parseDouble(this.getString(key)); }
    public float getFloat(@NotNull String key){ return Float.parseFloat(this.getString(key)); }

    // Méthode pour écrire dans le fichier json
    public void set(@NotNull String key, @NotNull String value){
        // On remplace la valeur dans la HashMap si la clef existe, sinon, on ajoute la valeur dans la HashMap
        if(json.containsKey(key))
            json.replace(key, value);
        else
            json.put(key, value);

        // Écrire dans le fichier
        NoobEngine.writeInFile(this.file, json.toJSONString());
    }
}