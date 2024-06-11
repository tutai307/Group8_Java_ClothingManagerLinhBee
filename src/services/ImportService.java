package services;

import static common.Validator.formatName;
import dao.AccountDAO;
import dao.CustomerDAO;
import dao.ImportDAO;
import models.Account;
import models.Import;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import models.Customer;
import models.ImportDetail;

public class ImportService {

    public static boolean isExistedImportCode(String customer_code) throws Exception {
        List<Customer> data = CustomerDAO.readFromFile();
        for (Customer staff : data) {
            if (staff.getCode().trim().equals(customer_code.trim())) {
                return true;
            }
        }
        return false;
    }

    public static List<Import> getAllImports() throws Exception {
        return ImportDAO.readFromFile();
    }

    public static Import getImportById(int index) throws Exception {
        List<Import> data = ImportDAO.readFromFile();
        if (data != null) {
            for (Import item : data) {
                if (item.getId() == index) {
                    return item;
                }
            }
        }
        return null;
    }

    public static boolean isCheckCodeImport(String newCode) throws Exception {
        List<Import> staffs = ImportDAO.readFromFile();
        for (Import next : staffs) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastImportId() throws Exception {
        List<Import> data = ImportDAO.readFromFile();
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

    public static void createNewImport(String code, String name, String description, String createDate, String distributorName, String staffName, String productCode, String productName, int quantity, double priceImport) throws Exception {
        if (!isCheckCodeImport(code)) {
            List<Import> importData = ImportDAO.readFromFile();
            List<ImportDetail> importDetailData = ImportDAO.readImportDetailsFromFile(); // Method to read ImportDetail data

            // Tạo đối tượng Import mới và thêm vào danh sách
            Import newImport = new Import(code, name, description, createDate);
            importData.add(newImport);

            // Tạo đối tượng ImportDetail mới và thêm vào danh sách
            ImportDetail newImportDetail = new ImportDetail(code, distributorName, staffName, productCode, productName, quantity, priceImport);
            importDetailData.add(newImportDetail);

            // Ghi dữ liệu vào cả hai tệp Import.json và ImportDetail.json
            ImportDAO.writeToFile(importData, importDetailData);
        }
    }

    public static Import getImportByIndex(int index) throws Exception {
        return ImportDAO.readFromFile().get(index);
    }

    public static void updateImport(Import updatedImport, ImportDetail updatedImportDetail) throws Exception {
        // Đọc dữ liệu từ tệp Import.json
        List<Import> importData = ImportDAO.readFromFile();
        boolean importFound = false;

        // Cập nhật dữ liệu trong danh sách Import
        for (Import importItem : importData) {
            if (importItem.getCode().equals(updatedImport.getCode())) {
                importItem.setName(updatedImport.getName());
                importItem.setDescription(updatedImport.getDescription());
                importItem.setCreateDate(updatedImport.getCreateDate());
                importFound = true;
                break;
            }
        }

        if (!importFound) {
            throw new Exception("Không tìm thấy phiếu nhập với mã: " + updatedImport.getCode());
        }

        // Đọc dữ liệu từ tệp ImportDetail.json
        List<ImportDetail> importDetailData = ImportDAO.readImportDetailsFromFile();
        boolean importDetailFound = false;

        // Cập nhật dữ liệu trong danh sách ImportDetail
        for (ImportDetail importDetailItem : importDetailData) {
            if (importDetailItem.getImportCode().equals(updatedImportDetail.getImportCode())) {
                importDetailItem.setDistributorName(updatedImportDetail.getDistributorName());
                importDetailItem.setStaffName(updatedImportDetail.getStaffName());
                importDetailItem.setProductCode(updatedImportDetail.getProductCode());
                importDetailItem.setProductName(updatedImportDetail.getProductName());
                importDetailItem.setQuantity(updatedImportDetail.getQuantity());
                importDetailItem.setPriceImport(updatedImportDetail.getPriceImport());
                importDetailFound = true;
                break;
            }
        }

        if (!importDetailFound) {
            throw new Exception("Không tìm thấy chi tiết phiếu nhập với mã: " + updatedImportDetail.getImportCode());
        }

        // Ghi lại dữ liệu đã cập nhật vào tệp Import.json và ImportDetail.json
        ImportDAO.writeToFile(importData, importDetailData);
    }

    public static void deleteImport(int importId) throws Exception {
        List<Import> importData = ImportDAO.readFromFile();
        List<ImportDetail> importDetailData = ImportDAO.readImportDetailsFromFile(); // Đọc danh sách chi tiết phiếu nhập

        Import delImport = null;

        // Tìm phiếu nhập cần xóa dựa trên ID
        for (Import imp : importData) {
            if (imp.getId() == importId) {
                delImport = imp;
                break;
            }
        }

        // Nếu phiếu nhập được tìm thấy, tiến hành xóa
        if (delImport != null) {
            // Xóa phiếu nhập khỏi danh sách phiếu nhập
            importData.remove(delImport);

            // Xóa các chi tiết phiếu nhập tương ứng
            Iterator<ImportDetail> iterator = importDetailData.iterator();
            while (iterator.hasNext()) {
                ImportDetail importDetail = iterator.next();
                if (importDetail.getImportCode().equals(delImport.getCode())) {
                    iterator.remove(); // Xóa chi tiết phiếu nhập khỏi danh sách
                }
            }

            // Ghi lại dữ liệu sau khi xóa vào tệp
            ImportDAO.writeToFile(importData, importDetailData);
        } else {
            throw new Exception("Không tìm thấy phiếu nhập có ID: " + importId);
        }
    }

//    public static String getImportNameById(int staffId) throws Exception {
//        List<Import> staffs = ImportDAO.readFromFile();
//        for (Import staff : staffs) {
//            if (staff.getId() == staffId) {
//                return staff.getLastName() + " " + staff.getFirstName();
//            }
//        }
//        return null;
//    }
    public static Import getImportDetailByIndex(int index) throws Exception {
        return ImportDAO.readFromFile().get(index);
    }
}
