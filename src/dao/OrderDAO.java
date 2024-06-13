/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import models.Order;
import models.OrderDetail;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Admin
 */
public class OrderDAO {
    private static final String filePath = "src/files/Order.json";
    private static final String filePath1 = "src/files/OrderDetail.json";
    
    public static List<Order> readFromFile() throws Exception {
        List<Order> data = new ArrayList<>();

        Path path = Paths.get(filePath);
        if (Files.exists(path) && Files.size(path) > 0) {
            try (Reader reader = new FileReader(filePath)) {
                JSONArray importArray = (JSONArray) new JSONParser().parse(reader);

                for (Object importObject : importArray) {
                    JSONObject importJson = (JSONObject) importObject;

                    String code = (String) importJson.get("code");
                    String name = (String) importJson.get("name");
                    String description = (String) importJson.get("description");
                    String createDate = (String) importJson.get("createDate");

                    Order orderData = new Order(code, name, description, createDate);
                    data.add(orderData);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Order data from file", e);
            }
        }

        return data;
    }
    
    public static List<OrderDetail> readOrderDetailsFromFile() throws Exception {
        List<OrderDetail> data = new ArrayList<>();

        Path path1 = Paths.get(filePath1);
        if (Files.exists(path1) && Files.size(path1) > 0) {
            try (Reader reader = new FileReader(filePath1)) {
                JSONArray importDetailArray = (JSONArray) new JSONParser().parse(reader);

                for (Object importDetailObject : importDetailArray) {
                    JSONObject importDetailJson = (JSONObject) importDetailObject;

                    String code = (String) importDetailJson.get("code");
                    String customerCode = (String) importDetailJson.get("customerCode");
                    String staffCode = (String) importDetailJson.get("staffCode");
                    String productCode = (String) importDetailJson.get("productCode");
                    int quantity = Integer.parseInt(importDetailJson.get("quantity").toString());

                    OrderDetail orderDetail = new OrderDetail( code, customerCode, staffCode, productCode, quantity);
                    data.add(orderDetail);
                }
            } catch (Exception e) {
                throw new IOException("Error reading OrderDetail data from file", e);
            }
        }
        return data;
    }
    
    public static void writeToFile(List<Order> orders, List<OrderDetail> orderDetails) throws Exception {
        // Ghi dữ liệu vào Order.json
        JSONArray OrderArray = new JSONArray();
        for (Order orderItem : orders) {
            JSONObject orderJson = new JSONObject();
            orderJson.put("code", orderItem.getCode());
            orderJson.put("name", orderItem.getName());
            orderJson.put("description", orderItem.getDescription());
            orderJson.put("createDate", orderItem.getCreateDate());
            OrderArray.add(orderJson);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(OrderArray.toJSONString());
        } catch (IOException e) {
            throw new IOException("Error writing Order data to file", e);
        }

        // Ghi dữ liệu vào OrderDetail.json
        JSONArray orderDetailArray = new JSONArray();
        for (OrderDetail orderDetailItem : orderDetails) {
            JSONObject orderDetailJson = new JSONObject();
            orderDetailJson.put("code", orderDetailItem.getOrderCode());
            orderDetailJson.put("customerCode", orderDetailItem.getCustomerCode());
            orderDetailJson.put("staffCode", orderDetailItem.getStaffCode());
            orderDetailJson.put("productCode", orderDetailItem.getProductCode());
            orderDetailJson.put("quantity", orderDetailItem.getQuantity());
            orderDetailArray.add(orderDetailJson);
        }

        try (FileWriter file = new FileWriter(filePath1)) {
            file.write(orderDetailArray.toJSONString());
        } catch (IOException e) {
            throw new IOException("Error writing OrderDetail data to file", e);
        }
    }
    
    public static boolean isCheckCodeOrder(String code) {
        // Implement actual check logic
        return false;
    }
}
