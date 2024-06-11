/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.AccountDAO;
import dao.StaffDAO;
import models.Account;
import models.Staff;
import java.util.List;

/**
 *
 * @author PC
 */
public class AccountService {

    public static Account currentLoginUser;

    public static boolean isExisted(Account account) throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        for (Account acc : data) {
            if (acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistedUsername(String username) throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        for (Account acc : data) {
            if (acc.getUsername().trim().equals(username.trim())) {
                return true;
            }
        }
        return false;
    }

    public static List<Account> getAllAccounts() throws Exception {
        return AccountDAO.readFromFile();
    }

    public static Account getAccountByUsername(String username) throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        for (Account acc : data) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
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

    public static Account getAccountByIndex(int index) throws Exception {
        return AccountDAO.readFromFile().get(index);
    }

    public static Account createNewAccount(String username, String password, String role) throws Exception {
        int lastId = getLastAccountId();
        lastId++;
        Account acc = new Account(lastId, username, password, role);
        List<Account> data = AccountDAO.readFromFile();
        data.add(acc);
        AccountDAO.writeToFile(data);
        return acc;
    }

    public static Account updateAccount(Account account) throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        for (Account acc : data) {
            if (acc.getId() == account.getId()) {
                acc.setPassword(account.getPassword());
                acc.setUsername(account.getUsername());
                acc.setRole(account.getRole());
                break;
            }
        }
        AccountDAO.writeToFile(data);
        return account;
    }

    public static void deleteAccount(int accountId) throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        Account deleteAccount = null;
        for (Account acc : data) {
            if (acc.getId() == accountId) {
                deleteAccount = acc;
                break;
            }
        }
        if (deleteAccount != null) {
            data.remove(deleteAccount);
            AccountDAO.writeToFile(data);
        }
    }

    public static Account getById(int accountId) throws Exception {
        List<Account> data = AccountDAO.readFromFile();
        for (Account acc : data) {
            if (acc.getId() == accountId) {
                return acc;
            }
        }
        return null;
    }

//    public static Account getAccountByStaffId(int studentId) throws Exception {
//        List<Staff> staffData = StaffDAO.readFromFile();
//        int accountId = -1;
//        for (Staff staff : staffData) {
//            if (staff.getId() == studentId) {
//                accountId = staff.getAccountId();
//                breaks;
//            }
//        }
//        if (accountId != -1) {
//            return getById(accountId);
//        }
//        return null;
//    }
}
