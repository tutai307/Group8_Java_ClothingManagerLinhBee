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
                JSONArray staffArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(reader);
                for (Object staffObject : staffArray) {
                    JSONObject staffJson = (JSONObject) staffObject;
                    int id = Integer.parseInt(staffJson.get("id").toString());
                    String imagePath = (String)staffJson.get("imagePath");
                    String code = (String) staffJson.get("code");
                    String firstname = (String) staffJson.get("firstname");
                    String lastname = (String) staffJson.get("lastname");
                    String email = (String) staffJson.get("email");
                    String address = (String) staffJson.get("address");
                    String phone = (String) staffJson.get("phoneNumber");
                    String birthDate = (String) staffJson.get("birthDate");
                    int accountId = Integer.parseInt(staffJson.get("accountId").toString());
                    String position = (String) staffJson.get("position").toString();
                    Staff staff = new Staff(id,imagePath, code, firstname, lastname, address, phone, email, birthDate, accountId,position);
//                    JSONArray toursArray = (JSONArray) staffJson.get("tours");
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

                    data.add(staff);
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
