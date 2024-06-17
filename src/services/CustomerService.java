/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Admin
 */
import dao.CustomerDAO;
import dao.StaffDAO;
import models.Account;
import models.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gialo
 */
public class CustomerService {

    public static boolean isExistedCustomerCode(String customer_code) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        for (Customer staff : data) {
            if (staff.getCode().trim().equals(customer_code.trim())) {
                return true;
            }
        }
        return false;
    }

    public static List<Customer> getAllCustomers() throws Exception {
        return CustomerDAO.readFromFile();
    }

    public static int getLastCustomerId() throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }

    public static Customer getCustomerByIndex(int index) throws Exception {
        return CustomerDAO.readFromFile().get(index);
    }

//    public static List<Customer> getCustomerByType(int classId) throws Exception {
//        List<Student> data = StudentDAO.readFromFile();
//        List<Student> trueData = new ArrayList<Student>();
//        if (data != null) {
//            for (Student stu : data) {
//                // sua lai kieu du lieu cua student classId thanh string
//                if (stu.getClassId() == classId) {
//                    trueData.add(stu);
//                }
//            }
//        }
//        return trueData;
//    }

    public static void createNewCustomer(String code, String imagePath, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, Customer.CustomerType customerType) throws Exception {
        int lastId = getLastCustomerId();
        lastId++;
        Customer customer = new Customer(lastId, imagePath, code, firstName, lastName, address, phoneNumber, email, birthDate, customerType);
        List<Customer> data = CustomerDAO.readFromFile();
        data.add(customer);
        CustomerDAO.writeToFile(data);
    }

    public static void updateCustomer(Customer customer) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        for (Customer stu : data) {
            if (stu.getCode().equals(customer.getCode())) {
                stu.setCode(customer.getCode());
                stu.setFirstName(customer.getFirstName());
                stu.setLastName(customer.getLastName());
                stu.setAddress(customer.getAddress());
                stu.setPhoneNumber(customer.getPhoneNumber());
                stu.setEmail(customer.getEmail());
                stu.setBirthDate(customer.getBirthDate());
                stu.setImagePath(customer.getImagePath());
                stu.setCustomerType(customer.getCustomerType());

                break;
            }
        }
        CustomerDAO.writeToFile(data);
    }

    public static void deleteCustomer(int customerId) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        Customer delStu = null;
        for (Customer stu : data) {
            if (stu.getId() == customerId) {
                delStu = stu;
                break;
            }
        }
        if (delStu != null) {
            data.remove(delStu);
            CustomerDAO.writeToFile(data);
        }
    }

    public static Customer getById(int studentId) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        for (Customer student : data) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public static Customer getByCode(String code) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        for (Customer student : data) {
            if (student.getCode().equals(code.trim())) {
                return student;
            }
        }
        return null;
    }

    public static Customer getByIdFromList(int studentId, List<Customer> data) {
        for (Customer student : data) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

}

