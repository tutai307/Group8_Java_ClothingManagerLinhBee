package dao;

import models.Staff;
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
public class StaffDAO {

    private static final String filePath = "src/files/Staff.json";

    public static List<Staff> readFromFile() throws Exception {
        List<Staff> data = new ArrayList<>();

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
                    int accountId = Integer.parseInt(teacherJson.get("accountId").toString());
                    String position = (String) teacherJson.get("position").toString();
                    Staff tea = new Staff(id,imagePath, code, firstname, lastname, address, phone, email, birthDate, accountId,position);
                    JSONArray toursArray = (JSONArray) teacherJson.get("tours");
//                    if (toursArray != null) {
//                        List<Tour> tours = new ArrayList<>();
//                        for (Object tourObject : toursArray) {
//                            JSONObject tourJson = (JSONObject) tourObject;
//                            Tour tour = new Tour();
//                            tour.setId(Integer.parseInt(tourJson.get("id").toString()));
//                            tour.setCode((String) tourJson.get("code"));
//                            tour.setName((String) tourJson.get("name"));
//                            tour.setDescription((String) tourJson.get("description"));
//                            tour.setStartDate((String) tourJson.get("startDate"));
//                            tour.setAvailables(Integer.parseInt(tourJson.get("availables").toString()));
//                            tour.setCompanyId(Integer.parseInt(tourJson.get("companyId").toString()));
//                            tour.setTeacherId(Integer.parseInt(tourJson.get("teacherId").toString()));
//                            tour.setPresentator((String) tourJson.get("presentator"));
//                            tours.add(tour);
//                        }
//                        tea.setTours(tours);
//                    }

                    data.add(tea);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Company data from file", e);
            }
        }

        return data;
    }

    public static void writeToFile(List<Staff> staffs) throws Exception {
       
        JSONArray staffArray = new JSONArray();
        for (Staff staff : staffs) {
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
            staffJson.put("accountId", staff.getAccountId());
            staffJson.put("position", staff.getPosition());

            staffArray.add(staffJson);
        }

        try ( FileWriter file = new FileWriter(filePath)) {
            file.write(staffArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
