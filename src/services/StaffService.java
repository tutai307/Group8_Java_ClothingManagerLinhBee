package services;

import static common.Validator.formatName;
import dao.AccountDAO;
import dao.StaffDAO;
import models.Account;
import models.Staff;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaffService {

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

    public static List<Staff> getAllStaffs() throws Exception {
        return StaffDAO.readFromFile();
    }

    public static Staff getStaffById(int index) throws Exception {
        List<Staff> data = StaffDAO.readFromFile();
        if (data != null) {
            for (Staff item : data) {
                if (item.getId() == index) {
                    return item;
                }
            }
        }
        return null;
    }

    public static boolean isCheckCodeStaff(String newCode) throws Exception {
        List<Staff> staffs = StaffDAO.readFromFile();
        for (Staff next : staffs) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastStaffId() throws Exception {
        List<Staff> data = StaffDAO.readFromFile();
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

    public static void createNewStaff(String imagePath, String code, String name, String address, String phoneNumber, String email, String birthDate, String position) throws Exception {
        if (!isCheckCodeStaff(code)) {
            int lastId = getLastStaffId();
            int id = ++lastId;
            int lastAccountId = getLastAccountId();
            int accountId = ++lastAccountId;
            List<Staff> data = StaffDAO.readFromFile();
            Staff tea = new Staff(id, imagePath, code, FirstName(name), LastName(name), address, phoneNumber, email, birthDate, accountId, position);
            data.add(tea);
            Account acc = new Account(accountId, code, code, "Tài khoản " + position);
            List<Account> dataAccount = AccountDAO.readFromFile();
            dataAccount.add(acc);
            AccountDAO.writeToFile(dataAccount);
            StaffDAO.writeToFile(data);
        }
    }

    public static Staff getStaffByIndex(int index) throws Exception {
        return StaffDAO.readFromFile().get(index);
    }

    public static void updateStaff(Staff staff) throws Exception {
        List<Staff> data = StaffDAO.readFromFile();
        List<Account> dataAccount = AccountDAO.readFromFile();

        for (Staff tea : data) {
            if (tea.getId() == staff.getId()) {
                tea.setCode(staff.getCode());
                tea.setFirstName(staff.getFirstName());
                tea.setLastName(staff.getLastName());
                tea.setPhoneNumber(staff.getPhoneNumber());
                tea.setBirthDate(staff.getBirthDate());
                tea.setEmail(staff.getEmail());
                tea.setAddress(staff.getAddress());
                tea.setImagePath(staff.getImagePath());
                tea.setAccountId(staff.getAccountId());
                tea.setPosition(staff.getPosition());

                // Update the corresponding account
                for (Account acc : dataAccount) {
                    if (acc.getId() == tea.getAccountId()) {
                        acc.setRole("Tài khoản " + staff.getPosition());
                        break;
                    }
                }
                break;
            }
        }
    }
 


    public static void deleteStaff(int staffId) throws Exception {
    List<Staff> data = StaffDAO.readFromFile();
    List<Account> data_accounts = AccountDAO.readFromFile();
    Staff delStaff = null;

    // Tìm nhân viên cần xóa
    for (Staff staff : data) {
        if (staff.getId() == staffId) {
            delStaff = staff;
            break;
        }
    }

    // Nếu nhân viên được tìm thấy, tiến hành xóa
    if (delStaff != null) {
        // Tìm và xóa tài khoản của nhân viên bị xóa
        Iterator<Account> iterator = data_accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getId() == delStaff.getAccountId()) {
                iterator.remove();
                break; // Sau khi tìm thấy và xóa tài khoản, thoát khỏi vòng lặp
            }
        }

        // Xóa nhân viên khỏi danh sách
        data.remove(delStaff);

        // Ghi lại dữ liệu sau khi xóa
        StaffDAO.writeToFile(data);
        AccountDAO.writeToFile(data_accounts);
    }
}


    public static String getStaffNameById(int staffId) throws Exception {
        List<Staff> staffs = StaffDAO.readFromFile();
        for (Staff staff : staffs) {
            if (staff.getId() == staffId) {
                return staff.getLastName() + " " + staff.getFirstName();
            }
        }
        return null;
    }

    public static Staff getStaffByAccountId(int accountId) throws Exception {
        List<Staff> data = StaffDAO.readFromFile();
        for (Staff staff : data) {
            if (staff.getAccountId() == accountId) {
                return staff;
            }
        }
        return null;
    }
    
}
