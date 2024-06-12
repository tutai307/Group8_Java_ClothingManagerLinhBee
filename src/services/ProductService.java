package services;

import static common.Validator.formatName;
import dao.AccountDAO;
import dao.ProductDAO;
import models.Account;
import models.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService {

    public static List<Product> getAllProducts() throws Exception {
        return ProductDAO.readFromFile();
    }

    public static Product getProductById(int index) throws Exception {
        List<Product> data = ProductDAO.readFromFile();
        if (data != null) {
            for (Product item : data) {
                if (item.getId() == index) {
                    return item;
                }
            }
        }
        return null;
    }

    public static boolean isCheckCodeProduct(String newCode) throws Exception {
        List<Product> staffs = ProductDAO.readFromFile();
        for (Product next : staffs) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastProductId() throws Exception {
        List<Product> data = ProductDAO.readFromFile();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }

    public static int getLastAccountId() throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }

    public static void createNewProduct(String imagePath, String code, String name, String des, int quantity, double price, int categoryId) throws Exception {
        if (!isCheckCodeProduct(code)) {
            int lastId = getLastProductId();
            int id = ++lastId;
            int lastAccountId = getLastAccountId();
            int accountId = ++lastAccountId;
            List<Product> data = ProductDAO.readFromFile();
            Product tea = new Product(id, imagePath, code, name, des, price, quantity, categoryId);
            data.add(tea);
            ProductDAO.writeToFile(data);
        }
    }

    public static Product getProductByIndex(int index) throws Exception {
        return ProductDAO.readFromFile().get(index);
    }

    public static void updateProduct(Product product) throws Exception {
        List<Product> data = ProductDAO.readFromFile();

        for (Product existingProduct : data) {
            if (existingProduct.getId() == product.getId()) {
                existingProduct.setCode(product.getCode());
                existingProduct.setName(product.getName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setQuantity(product.getQuantity());
                existingProduct.setPriceSell(product.getPriceSell());
                existingProduct.setImagePath(product.getImagePath());
                existingProduct.setCategoryId(product.getCategoryId());
                break;
            }
        }

        // Ghi lại dữ liệu sau khi cập nhật
        ProductDAO.writeToFile(data);
    }

    public static void deleteProduct(int productId) throws Exception {
        List<Product> data = ProductDAO.readFromFile();
        Product delProduct = null;

        // Tìm sản phẩm cần xóa
        for (Product product : data) {
            if (product.getId() == productId) {
                delProduct = product;
                break;
            }
        }

        // Nếu sản phẩm được tìm thấy, tiến hành xóa
        if (delProduct != null) {
            // Xóa sản phẩm khỏi danh sách
            data.remove(delProduct);

            // Ghi lại dữ liệu sau khi xóa
            ProductDAO.writeToFile(data);
        }
    }

    public static String getProductNameById(int staffId) throws Exception {
        List<Product> staffs = ProductDAO.readFromFile();
        for (Product staff : staffs) {
            if (staff.getId() == staffId) {
                return staff.getName();
            }
        }
        return null;
    }

}
