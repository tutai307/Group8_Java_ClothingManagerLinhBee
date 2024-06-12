package dao;

import models.Product;
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
public class ProductDAO {

    private static final String filePath = "src/files/Product.json";

    public static List<Product> readFromFile() throws Exception {
        List<Product> data = new ArrayList<>();

        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try (Reader reader = new FileReader(filePath)) {
                JSONArray staffArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(reader);
                for (Object staffObject : staffArray) {
                    JSONObject staffJson = (JSONObject) staffObject;
                    int id = Integer.parseInt(staffJson.get("id").toString());
                    String imagePath = (String)staffJson.get("imagePath");
                    String code = (String) staffJson.get("code");
                    String name = (String) staffJson.get("name");
                    String description = (String) staffJson.get("description");
                    Double price = Double.parseDouble(staffJson.get("price").toString());
                    int categoryId = Integer.parseInt(staffJson.get("categoryId").toString());
                    int quantity = Integer.parseInt(staffJson.get("quantity").toString());
                    Product staff = new Product(id,imagePath, code, name, description, price, quantity, categoryId);                   

                    data.add(staff);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Product data from file", e);
            }
        }
        return data;
    }

    public static void writeToFile(List<Product> staffs) throws Exception {
       
        JSONArray staffArray = new JSONArray();
        for (Product staff : staffs) {
            JSONObject staffJson = new JSONObject();
            staffJson.put("id", staff.getId());
            staffJson.put("imagePath", staff.getImagePath());
            staffJson.put("code", staff.getCode());
            staffJson.put("name", staff.getName());
            staffJson.put("description", staff.getDescription());
            staffJson.put("price", staff.getPriceSell());
            staffJson.put("quantity", staff.getQuantity());
            staffJson.put("categoryId", staff.getCategoryId());
            
            staffArray.add(staffJson);
        }

        try ( FileWriter file = new FileWriter(filePath)) {
            file.write(staffArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
