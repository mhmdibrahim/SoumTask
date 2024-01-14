package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONClass {

    public static String readJson(String filePath, String key){
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("./" +filePath));
            return jsonObject.get(key).toString();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
