package dao;

import models.Import;
import models.ImportDetail;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImportDAO {
    private static final String filePath = "src/files/Import.json";
    private static final String filePath1 = "src/files/ImportDetail.json";

    public static List<Import> readFromFile() throws Exception {
        List<Import> data = new ArrayList<>();

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

                    Import importData = new Import(code, name, description, createDate);
                    data.add(importData);
                }
            } catch (Exception e) {
                throw new IOException("Error reading Import data from file", e);
            }
        }

        return data;
    }

    public static List<ImportDetail> readImportDetailsFromFile() throws Exception {
        List<ImportDetail> data = new ArrayList<>();

        Path path1 = Paths.get(filePath1);
        if (Files.exists(path1) && Files.size(path1) > 0) {
            try (Reader reader = new FileReader(filePath1)) {
                JSONArray importDetailArray = (JSONArray) new JSONParser().parse(reader);

                for (Object importDetailObject : importDetailArray) {
                    JSONObject importDetailJson = (JSONObject) importDetailObject;

                    String importCode = (String) importDetailJson.get("importCode");
                    String distributorName = (String) importDetailJson.get("distributorName");
                    String staffName = (String) importDetailJson.get("staffName");
                    String productCode = (String) importDetailJson.get("productCode");
                    String productName = (String) importDetailJson.get("productName");
                    int quantity = Integer.parseInt(importDetailJson.get("quantity").toString());
                    double priceImport = Double.parseDouble(importDetailJson.get("priceImport").toString());

                    ImportDetail importDetail = new ImportDetail(importCode, distributorName, staffName, productCode, productName, quantity, priceImport);
                    data.add(importDetail);
                }
            } catch (Exception e) {
                throw new IOException("Error reading ImportDetail data from file", e);
            }
        }

        return data;
    }

    public static void writeToFile(List<Import> imports, List<ImportDetail> importDetails) throws Exception {
        // Ghi dữ liệu vào Import.json
        JSONArray importArray = new JSONArray();
        for (Import importItem : imports) {
            JSONObject importJson = new JSONObject();
            importJson.put("code", importItem.getCode());
            importJson.put("name", importItem.getName());
            importJson.put("description", importItem.getDescription());
            importJson.put("createDate", importItem.getCreateDate());

            importArray.add(importJson);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(importArray.toJSONString());
        } catch (IOException e) {
            throw new IOException("Error writing Import data to file", e);
        }

        // Ghi dữ liệu vào ImportDetail.json
        JSONArray importDetailArray = new JSONArray();
        for (ImportDetail importDetailItem : importDetails) {
            JSONObject importDetailJson = new JSONObject();
            importDetailJson.put("importCode", importDetailItem.getImportCode());
            importDetailJson.put("distributorName", importDetailItem.getDistributorName());
            importDetailJson.put("staffName", importDetailItem.getStaffName());
            importDetailJson.put("productCode", importDetailItem.getProductCode());
            importDetailJson.put("productName", importDetailItem.getProductName());
            importDetailJson.put("quantity", importDetailItem.getQuantity());
            importDetailJson.put("priceImport", importDetailItem.getPriceImport());

            importDetailArray.add(importDetailJson);
        }

        try (FileWriter file = new FileWriter(filePath1)) {
            file.write(importDetailArray.toJSONString());
        } catch (IOException e) {
            throw new IOException("Error writing ImportDetail data to file", e);
        }
    }

    // Dummy implementation of isCheckCodeImport to avoid compilation errors
    public static boolean isCheckCodeImport(String code) {
        // Implement actual check logic
        return false;
    }
}
