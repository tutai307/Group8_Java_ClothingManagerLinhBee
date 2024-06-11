package dao;

import models.Distributor;
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
public class DistributorDAO {

    private static final String filePath = "src/files/Distributor.json";

    public static List<Distributor> readFromFile() throws Exception {
        List<Distributor> data = new ArrayList<>();

        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try (Reader reader = new FileReader(filePath)) {
                JSONArray teacherArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(reader);
                for (Object teacherObject : teacherArray) {
                    JSONObject teacherJson = (JSONObject) teacherObject;
                    int id = Integer.parseInt(teacherJson.get("id").toString());
                    String imagePath = (String)teacherJson.get("imagePath");
                    String code = (String) teacherJson.get("code");
                    String firstname = (String) teacherJson.get("firstname");
                    String lastname = (String) teacherJson.get("lastname");
                    String email = (String) teacherJson.get("email");
                    String address = (String) teacherJson.get("address");
                    String phone = (String) teacherJson.get("phoneNumber");
                    String birthDate = (String) teacherJson.get("birthDate");
                    Distributor tea = new Distributor(id,imagePath, code, firstname, lastname, address, phone, email, birthDate);
                   

                    data.add(tea);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Company data from file", e);
            }
        }

        return data;
    }

    public static void writeToFile(List<Distributor> staffs) throws Exception {
       
        JSONArray staffArray = new JSONArray();
        for (Distributor staff : staffs) {
            JSONObject staffJson = new JSONObject();
            staffJson.put("id", staff.getId());
            staffJson.put("imagePath", staff.getImagePath());
            staffJson.put("code", staff.getCode());
            staffJson.put("firstname", staff.getFirstName());
            staffJson.put("lastname", staff.getLastName());
            staffJson.put("email", staff.getEmail());
            staffJson.put("phoneNumber", staff.getPhoneNumber());
            staffJson.put("address", staff.getAddress());
            staffJson.put("birthDate", staff.getBirthDate());

            staffArray.add(staffJson);
        }

        try ( FileWriter file = new FileWriter(filePath)) {
            file.write(staffArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
