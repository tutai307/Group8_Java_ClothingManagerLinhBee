package services;

import dao.AccountDAO;
import dao.CategoryDAO;
import models.Account;
import java.util.List;
import models.Category;

public class CategoryService {
    public static List<Category> getAllCategories() throws Exception {
        return CategoryDAO.readFromFile();
    }

    public static Category getCategoryById(int index) throws Exception {
        List<Category> data = CategoryDAO.readFromFile();
        if (data != null) {
            for (Category item : data) {
                if (item.getId() == index) {
                    return item;
                }
            }
        }
        return null;
    }

    public static boolean isCheckCodeCategory(String newCode) throws Exception {
        List<Category> staffs = CategoryDAO.readFromFile();
        for (Category next : staffs) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastCategoryId() throws Exception {
        List<Category> data = CategoryDAO.readFromFile();
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

    public static void createNewCategory(String code, String name, String des) throws Exception {
        if (!isCheckCodeCategory(code)) {
            int lastId = getLastCategoryId();
            int id = ++lastId;
            int lastAccountId = getLastAccountId();
            int accountId = ++lastAccountId;
            List<Category> data = CategoryDAO.readFromFile();
            Category tea = new Category(id,code, name, des);
            data.add(tea);   
            CategoryDAO.writeToFile(data);
        }
    }

    public static Category getCategoryByIndex(int index) throws Exception {
        return CategoryDAO.readFromFile().get(index);
    }

    public static void updateCategory(Category staff) throws Exception {
        List<Category> data = CategoryDAO.readFromFile();

        for (Category tea : data) {
            if (tea.getId() == staff.getId()) {
                tea.setCode(staff.getCode());
                tea.setName(staff.getName());
                tea.setDescription(staff.getDescription());
                break;
            }
        }

        CategoryDAO.writeToFile(data);
    }

    public static void deleteCategory(int staffId) throws Exception {
    List<Category> data = CategoryDAO.readFromFile();
    List<Account> data_accounts = AccountDAO.readFromFile();
    Category delCategory = null;

    // Tìm nhà phân phối cần xóa
    for (Category staff : data) {
        if (staff.getId() == staffId) {
            delCategory = staff;
            break;
        }
    }

    // Nếu nhà phân phối được tìm thấy, tiến hành xóa
    if (delCategory != null) {
        // Xóa nhà phân phối khỏi danh sách
        data.remove(delCategory);

        // Ghi lại dữ liệu sau khi xóa
        CategoryDAO.writeToFile(data);
        AccountDAO.writeToFile(data_accounts);
    }
}


    public static String getCategoryNameById(int staffId) throws Exception {
        List<Category> staffs = CategoryDAO.readFromFile();
        for (Category staff : staffs) {
            if (staff.getId() == staffId) {
                return staff.getName();
            }
        }
        return null;
    }
}
