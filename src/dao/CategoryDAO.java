package dao;

import models.Category;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author NGUYEN TRANG
 */
public class CategoryDAO {

    private static final String filePath = "src/files/Category.json";

    public static List<Category> readFromFile() throws Exception {
        List<Category> data = new ArrayList<>();

        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try (Reader reader = new FileReader(filePath)) {
                JSONArray teacherArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(reader);
                for (Object teacherObject : teacherArray) {
                    JSONObject teacherJson = (JSONObject) teacherObject;
                    int id = Integer.parseInt(teacherJson.get("id").toString());
                    String code = (String) teacherJson.get("code");
                    String name = (String) teacherJson.get("name");
                    String des = (String) teacherJson.get("description");
                    Category tea = new Category(id,code, name, des);
                   

                    data.add(tea);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Category data from file", e);
            }
        }

        return data;
    }

    public static void writeToFile(List<Category> staffs) throws Exception {
       
        JSONArray staffArray = new JSONArray();
        for (Category staff : staffs) {
            JSONObject staffJson = new JSONObject();
            staffJson.put("id", staff.getId());
            staffJson.put("code", staff.getCode());
            staffJson.put("name", staff.getName());
            staffJson.put("description", staff.getDescription());

            staffArray.add(staffJson);
        }

        try ( FileWriter file = new FileWriter(filePath)) {
            file.write(staffArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
