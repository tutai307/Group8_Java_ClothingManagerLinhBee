/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.StaffDAO;
import java.util.Iterator;
import java.util.List;
import models.Customer;
import models.Order;
import models.OrderDetail;
import models.Product;
import models.Staff;

/**
 *
 * @author Admin
 */
public class OrderService {
    // check xem mã order đã tồn tại hay chưa
    public static boolean isExistedOrderCode(String orderCode) throws Exception {
        List<Order> data = OrderDAO.readFromFile();
        for (Order order : data) {
            if (order.getCode().trim().equals(orderCode.trim())) {
                return true;
            }
        }
        return false;
    }
    
    // check xem mã khách hàng đã tồn tại hay chưa
    public static boolean isExistedCustomerCode(String customerCode) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        for (Customer customer : data) {
            if (customer.getCode().trim().equals(customerCode.trim())) {
                return true;
            }
        }
        return false;
    }
    
    // check xem mã sản phẩm đã tồn tại hay chưa
    public static boolean isExistedProductCode(String productCode) throws Exception {
        List<Product> data = ProductDAO.readFromFile();
        for (Product product : data) {
            if (product.getCode().trim().equals(productCode.trim())) {
                return true;
            }
        }
        return false;
    }
    
    // check xem mã nhân viên đã tồn tại hay chưa
    public static boolean isExistedStaffCode(String staffCode) throws Exception {
        List<Staff> data = StaffDAO.readFromFile();
        for (Staff staff : data) {
            if (staff.getCode().trim().equals(staffCode.trim())) {
                return true;
            }
        }
        return false;
    }
    
    // đọc dữ liệu file Order
    public static List<Order> getAllImports() throws Exception {
        return OrderDAO.readFromFile();
    }
    
    public static void createNewOrder(String code, String name, String description, String createDate, String customerCode, String staffCode, String productCode, int quantity) throws Exception {
        if (!isExistedOrderCode(code)) {
            List<Order> orderData = OrderDAO.readFromFile();
            List<OrderDetail> orderDetailData = OrderDAO.readOrderDetailsFromFile(); // Method to read ImportDetail data

            // Tạo đối tượng Import mới và thêm vào danh sách
            Order newOrder = new Order(code, name, description, createDate);
            orderData.add(newOrder);

            // Tạo đối tượng ImportDetail mới và thêm vào danh sách
            OrderDetail newOrderDetail = new OrderDetail(code, customerCode, staffCode, productCode, quantity);
            orderDetailData.add(newOrderDetail);

            // Ghi dữ liệu vào cả hai tệp Order.json và OrderDetail.json
            OrderDAO.writeToFile(orderData, orderDetailData);
        }
    }
    public static Order getOrderByIndex(int index) throws Exception {
        return OrderDAO.readFromFile().get(index);
    }
    
    public static void updateOrder(Order updatedOrder, OrderDetail updatedOrderDetail) throws Exception {
        // Đọc dữ liệu từ tệp Import.json
        List<Order> orderData = OrderDAO.readFromFile();
        boolean orderFound = false;

        // Cập nhật dữ liệu trong danh sách Import
        for (Order orderItem : orderData) {
            if (orderItem.getCode().equals(updatedOrder.getCode())) {
                orderItem.setName(updatedOrder.getName());
                orderItem.setDescription(updatedOrder.getDescription());
                orderItem.setCreateDate(updatedOrder.getCreateDate());
                orderFound = true;
                break;
            }
        }

        if (!orderFound) {
            throw new Exception("Không tìm thấy phiếu nhập với mã: " + updatedOrder.getCode());
        }

        // Đọc dữ liệu từ tệp ImportDetail.json
        List<OrderDetail> orderDetailData = OrderDAO.readOrderDetailsFromFile();
        boolean orderDetailFound = false;

        // Cập nhật dữ liệu trong danh sách ImportDetail
        for (OrderDetail orderDetailItem : orderDetailData) {
            if (orderDetailItem.getOrderCode().equals(updatedOrderDetail.getOrderCode())) {
                orderDetailItem.setProductCode(updatedOrderDetail.getProductCode());
                orderDetailItem.setQuantity(updatedOrderDetail.getQuantity());
                orderDetailItem.setCustomerCode(updatedOrderDetail.getCustomerCode());
                orderDetailItem.setStaffCode(updatedOrderDetail.getStaffCode());
                orderDetailFound = true;
                break;
            }
        }

        if (!orderDetailFound) {
            throw new Exception("Không tìm thấy chi tiết phiếu nhập với mã: " + updatedOrderDetail.getOrderCode());
        }

        // Ghi lại dữ liệu đã cập nhật vào tệp Import.json và ImportDetail.json
        OrderDAO.writeToFile(orderData, orderDetailData);
    }
    
    public static void deleteOrder(int orderId) throws Exception {
        List<Order> orderData = OrderDAO.readFromFile();
        List<OrderDetail> orderDetailData = OrderDAO.readOrderDetailsFromFile(); // Đọc danh sách chi tiết phiếu nhập

        Order delOrder = null;

        // Tìm phiếu nhập cần xóa dựa trên ID
        for (Order imp : orderData) {
            if (imp.getId() == orderId) {
                delOrder = imp;
                break;
            }
        }

        // Nếu phiếu nhập được tìm thấy, tiến hành xóa
        if (delOrder != null) {
            // Xóa phiếu nhập khỏi danh sách phiếu nhập
            orderData.remove(delOrder);

            // Xóa các chi tiết phiếu nhập tương ứng
            Iterator<OrderDetail> iterator = orderDetailData.iterator();
            while (iterator.hasNext()) {
                OrderDetail orderDetail = iterator.next();
                if (orderDetail.getOrderCode().equals(delOrder.getCode())) {
                    iterator.remove(); // Xóa chi tiết phiếu nhập khỏi danh sách
                }
            }

            // Ghi lại dữ liệu sau khi xóa vào tệp
            OrderDAO.writeToFile(orderData, orderDetailData);
        } else {
            throw new Exception("Không tìm thấy phiếu nhập có ID: " + orderId);
        }
    }
}
