package services;

import static common.Validator.formatName;
import dao.AccountDAO;
import dao.DistributorDAO;
import models.Account;
import models.Distributor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistributorService {

    public static String LastName(String name) {
        String[] splitName = formatName(name).split(" ");
        String lastName = "";
        for (int i = 0; i < splitName.length - 1; i++) {
            lastName += (splitName[i] + " ");
        }
        return lastName.trim();
    }

    public static String FirstName(String name) {
        String[] splitName = formatName(name).split(" ");
        return splitName[splitName.length - 1].trim();
    }

    public static List<Distributor> getAllDistributors() throws Exception {
        return DistributorDAO.readFromFile();
    }

    public static Distributor getDistributorById(int index) throws Exception {
        List<Distributor> data = DistributorDAO.readFromFile();
        if (data != null) {
            for (Distributor item : data) {
                if (item.getId() == index) {
                    return item;
                }
            }
        }
        return null;
    }

    public static boolean isCheckCodeDistributor(String newCode) throws Exception {
        List<Distributor> staffs = DistributorDAO.readFromFile();
        for (Distributor next : staffs) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastDistributorId() throws Exception {
        List<Distributor> data = DistributorDAO.readFromFile();
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

    public static void createNewDistributor(String imagePath, String code, String name, String address, String phoneNumber, String email, String birthDate) throws Exception {
        if (!isCheckCodeDistributor(code)) {
            int lastId = getLastDistributorId();
            int id = ++lastId;
            int lastAccountId = getLastAccountId();
            int accountId = ++lastAccountId;
            List<Distributor> data = DistributorDAO.readFromFile();
            Distributor tea = new Distributor(id, imagePath, code, FirstName(name), LastName(name), address, phoneNumber, email, birthDate);
            data.add(tea);   
            DistributorDAO.writeToFile(data);
        }
    }

    public static Distributor getDistributorByIndex(int index) throws Exception {
        return DistributorDAO.readFromFile().get(index);
    }

    public static void updateDistributor(Distributor staff) throws Exception {
        List<Distributor> data = DistributorDAO.readFromFile();

        for (Distributor tea : data) {
            if (tea.getId() == staff.getId()) {
                tea.setCode(staff.getCode());
                tea.setFirstName(staff.getFirstName());
                tea.setLastName(staff.getLastName());
                tea.setPhoneNumber(staff.getPhoneNumber());
                tea.setBirthDate(staff.getBirthDate());
                tea.setEmail(staff.getEmail());
                tea.setAddress(staff.getAddress());
                tea.setImagePath(staff.getImagePath());
                break;
            }
        }

        DistributorDAO.writeToFile(data);
    }

    public static void deleteDistributor(int staffId) throws Exception {
    List<Distributor> data = DistributorDAO.readFromFile();
    List<Account> data_accounts = AccountDAO.readFromFile();
    Distributor delDistributor = null;

    // Tìm nhà phân phối cần xóa
    for (Distributor staff : data) {
        if (staff.getId() == staffId) {
            delDistributor = staff;
            break;
        }
    }

    // Nếu nhà phân phối được tìm thấy, tiến hành xóa
    if (delDistributor != null) {
        // Xóa nhà phân phối khỏi danh sách
        data.remove(delDistributor);

        // Ghi lại dữ liệu sau khi xóa
        DistributorDAO.writeToFile(data);
        AccountDAO.writeToFile(data_accounts);
    }
}


    public static String getDistributorNameById(int staffId) throws Exception {
        List<Distributor> staffs = DistributorDAO.readFromFile();
        for (Distributor staff : staffs) {
            if (staff.getId() == staffId) {
                return staff.getLastName() + " " + staff.getFirstName();
            }
        }
        return null;
    }
}
