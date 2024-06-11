/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Admin
 */
import models.Customer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static final String filePath = "src/files/Customer.json";
    public static Customer.CustomerType getEnum(JSONObject jsonObject, String key) {
        String value = (String) jsonObject.get(key);
        return Customer.CustomerType.valueOf(value.toUpperCase());
    }

    public static List<Customer> readFromFile() throws IOException {
        List<Customer> data = new ArrayList<>();

        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try {
                JSONParser parser = new JSONParser();
                JSONArray customerArray = (JSONArray) parser.parse(Files.newBufferedReader(path));

                for (Object customerObject : customerArray) {
                    JSONObject customerJson = (JSONObject) customerObject;

                    int id = getInteger(customerJson, "id");
                    String imagePath = getString(customerJson, "imagePath");
                    String code = getString(customerJson, "code");
                    String username = getString(customerJson, "username");
                    String password = getString(customerJson, "password");
                    String role = getString(customerJson, "role");
                    String firstName = getString(customerJson, "firstName");
                    String lastName = getString(customerJson, "lastName");
                    String address = getString(customerJson, "address");
                    String phoneNumber = getString(customerJson, "phoneNumber");
                    String email = getString(customerJson, "email");
                    String birthDate = getString(customerJson, "birthDate");
                    Customer.CustomerType customerType = getEnum(customerJson, "customerType");
                    Customer customer = new Customer(id, imagePath, code, firstName, lastName, address, phoneNumber, email, birthDate, customerType);                                                      

                    data.add(customer);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Customer data from file", e);
            }
        }
        return data;
    }

    public static void writeToFile(List<Customer> customers) throws IOException {
        JSONArray customerrArray = new JSONArray();

        for (Customer customer : customers) {
            JSONObject customerJson = new JSONObject();
            customerJson.put("id", customer.getId());
            customerJson.put("imagePath", customer.getImagePath());
            customerJson.put("code", customer.getCode());
            customerJson.put("firstName", customer.getFirstName());
            customerJson.put("lastName", customer.getLastName());
            customerJson.put("address", customer.getAddress());
            customerJson.put("phoneNumber", customer.getPhoneNumber());
            customerJson.put("email", customer.getEmail());
            customerJson.put("birthDate", customer.getBirthDate());
            customerJson.put("customerType", customer.getCustomerType().toString());
            customerrArray.add(customerJson);
        }

        try {
            Files.write(Paths.get(filePath), customerrArray.toJSONString().getBytes());
        } catch (IOException e) {
            throw new IOException("Error writing Student data to file", e);
        }
    }

    private static String getString(JSONObject jsonObject, String key) {
        return (jsonObject.get(key) != null) ? jsonObject.get(key).toString() : "";
    }

    private static int getInteger(JSONObject jsonObject, String key) {
        return (jsonObject.get(key) != null) ? Integer.parseInt(jsonObject.get(key).toString()) : 0;
    }
}

