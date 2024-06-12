package views;

import common.MessageDialog;
import static common.Validator.isDate;
import static common.Validator.isNumeric;
import static common.Validator.isValidEmail;
import dao.CategoryDAO;
import dao.ProductDAO;
import models.Product;
import services.ProductService;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Category;
import services.CategoryService;

/**
 *
 * @author NGUYEN TRANG
 */
public class ManageProduct extends javax.swing.JFrame {

    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/resources/";

    public ManageProduct() {
        initComponents();
        initializeTable();
        try {
            initializeRoleCombobox();
        } catch (Exception ex) {
            Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackHome = new javax.swing.JButton();
        mainTitle = new javax.swing.JLabel();
        teacherIDLabel = new javax.swing.JLabel();
        codeInput = new javax.swing.JTextField();
        nameTeacherLabel = new javax.swing.JLabel();
        quantityInput = new javax.swing.JTextField();
        addressTeacherLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        createProductBtn = new javax.swing.JButton();
        updateProductBtn = new javax.swing.JButton();
        deleteProductBtn = new javax.swing.JButton();
        clearStaffBtn = new javax.swing.JButton();
        birthdayTeacherLabel = new javax.swing.JLabel();
        priceInput = new javax.swing.JTextField();
        emailTeacherLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        imageBrowse = new javax.swing.JButton();
        nameTeacherLabel1 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        desInput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sản phẩm");

        btnBackHome.setText("Quay về trang chủ");
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Quản lý sản phẩm");

        teacherIDLabel.setText("Mã SP: ");

        nameTeacherLabel.setText("Số lượng tồn kho:");

        quantityInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityInputActionPerformed(evt);
            }
        });

        addressTeacherLabel.setText("Tên SP: ");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        createProductBtn.setText("Thêm");
        createProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProductBtnActionPerformed(evt);
            }
        });

        updateProductBtn.setText("Sửa");
        updateProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductBtnActionPerformed(evt);
            }
        });

        deleteProductBtn.setText("Xóa");
        deleteProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductBtnActionPerformed(evt);
            }
        });

        clearStaffBtn.setText("Nhập lại");
        clearStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStaffBtnActionPerformed(evt);
            }
        });

        birthdayTeacherLabel.setText("Giá bán:");

        emailTeacherLabel.setText("Mô tả:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        imageBrowse.setText("Tải ảnh lên");
        imageBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowseActionPerformed(evt);
            }
        });

        nameTeacherLabel1.setText("Danh mục:");

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Quản lý danh mục");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(desInput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(teacherIDLabel)
                                    .addComponent(addressTeacherLabel)
                                    .addComponent(birthdayTeacherLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(codeInput, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                            .addComponent(nameInput)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(priceInput)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quantityInput, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addGap(40, 40, 40)
                                .addComponent(nameTeacherLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBackHome)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createProductBtn)
                .addGap(77, 77, 77)
                .addComponent(updateProductBtn)
                .addGap(55, 55, 55)
                .addComponent(deleteProductBtn)
                .addGap(61, 61, 61)
                .addComponent(clearStaffBtn)
                .addGap(285, 285, 285))
            .addGroup(layout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(mainTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBackHome)
                            .addComponent(jButton1))
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(mainTitle)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(nameTeacherLabel)
                            .addComponent(teacherIDLabel)
                            .addComponent(codeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTeacherLabel1)
                            .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addressTeacherLabel)
                                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailTeacherLabel))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthdayTeacherLabel)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(clearStaffBtn)
                    .addComponent(deleteProductBtn)
                    .addComponent(updateProductBtn)
                    .addComponent(createProductBtn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeRoleCombobox() throws Exception {
        cboCategory.removeAllItems();
        List<Category> categories = CategoryService.getAllCategories();
        for (Category category : categories) {
            cboCategory.addItem(category.getName()); // Thêm trực tiếp đối tượng Category
        }
        cboCategory.setSelectedIndex(0); // Đặt giá trị mặc định
    }


    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        dispose();
        Home homeScreen = new Home();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btnBackHomeActionPerformed
    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            List<Product> data = ProductService.getAllProducts();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Product tea : data) {
                    String categoryName = CategoryService.getCategoryNameById(tea.getCategoryId());
                    tableModel.addRow(new Object[]{
                        tea.getCode(),
                        tea.getName(), tea.getDescription(),
                        tea.getQuantity(),
                        tea.getPriceSell(),
                        categoryName
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã SP", "Tên SP",
            "Mô tả", "Số lượng", "Giá bán", "Danh mục"});
        productTable.setModel(tableModel);
        loadTableData();
    }
    private void clearStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStaffBtnActionPerformed
        clearField();
    }//GEN-LAST:event_clearStaffBtnActionPerformed

    private void updateProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductBtnActionPerformed
        try {
        int index = productTable.getSelectedRow();
        if (index == -1) {
            MessageDialog.showInfoDialog(this, "Vui lòng chọn sản phẩm muốn sửa", "Thông báo");
            return;
        }
        String codeProduct = (String) productTable.getValueAt(index, 0);
        List<Product> data_products = ProductService.getAllProducts();
        int id = -1;
        for (Product item : data_products) {
            if (item.getCode().equalsIgnoreCase(codeProduct)) {
                id = item.getId();
                break;
            }
        }
        Product selectedProduct = ProductService.getProductById(id);
        String imagePath = selectedProduct.getImagePath();

        if (!selectedImagePath.equals(imagePath)) {
            if (!selectedImagePath.trim().equals("")) {
                selectedProduct.setImagePath(selectedImagePath);
            }
        }

        String productCode = this.codeInput.getText().trim();
        int productQuantity = Integer.parseInt(this.quantityInput.getText().trim());
        String productName = this.nameInput.getText().trim();
        double productPrice = Double.parseDouble(this.priceInput.getText().trim());
        String productDes = this.desInput.getText().trim();

        // Lấy categoryId từ combobox
        int categoryId = 0;
        String selectedCategory = cboCategory.getSelectedItem().toString();
        List<Category> cats = CategoryDAO.readFromFile();
            for (Category cat : cats) {
                if (cat.getName().compareTo(selectedCategory) == 0) {
                    categoryId = cat.getId();
                    break;
                }
         }
        

        // Bắt lỗi, không nhập đủ
        if (productCode.equals("")) {
            MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã sản phẩm", "Thông báo");
            return;
        }

        if (productName.equals("")) {
            MessageDialog.showInfoDialog(this, "Bạn chưa nhập tên sản phẩm", "Thông báo");
            return;
        }

        if (productDes.equals("")) {
            MessageDialog.showInfoDialog(this, "Bạn chưa mô tả", "Thông báo");
            return;
        }
        if (productQuantity < 0) {
            MessageDialog.showInfoDialog(this, "Số lượng không hợp lệ", "Thông báo");
            return;
        }
        if (productPrice < 0.0) {
            MessageDialog.showInfoDialog(this, "Giá bán không hợp lệ", "Thông báo");
            return;
        }
        
        selectedProduct.setCode(productCode);
        selectedProduct.setName(productName);
        selectedProduct.setDescription(productDes);
        selectedProduct.setQuantity(productQuantity);
        selectedProduct.setPriceSell(productPrice);
        selectedProduct.setCategoryId(categoryId);  // Cập nhật categoryId

        ProductService.updateProduct(selectedProduct);
        MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
        clearField();
        loadTableData();
    } catch (Exception e) {
        MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin sản phẩm, chi tiết: " + e.getMessage()
                + "\n" + e.toString() + "\n", "Lỗi");
        e.printStackTrace();
    }

    }//GEN-LAST:event_updateProductBtnActionPerformed

    private void createProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProductBtnActionPerformed
        try {
            String productCode = this.codeInput.getText().trim();
            int productQuantity = Integer.parseInt(this.quantityInput.getText().trim());
            String productName = this.nameInput.getText().trim();
            double productPrice = Double.parseDouble(this.priceInput.getText().trim());
            String productDes = this.desInput.getText().trim();
            String imagePath = "src\\\\resources\\\\user.jpg";
            int categoryId = 0;
            if (!selectedImagePath.trim().isEmpty()) {
                imagePath = selectedImagePath;
            }

            // Hiển thị ảnh
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

            // Bắt lỗi, không nhập đủ
            if (productCode.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã sản phẩm", "Thông báo");
                return;
            }

            if (productName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập tên sản phẩm", "Thông báo");
                return;
            }

            if (productDes.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa mô tả", "Thông báo");
                return;
            }
            if (productQuantity < 0) {
                MessageDialog.showInfoDialog(this, "Số lượng không hợp lệ", "Thông báo");
                return;
            }
            if (productPrice < 0.0) {
                MessageDialog.showInfoDialog(this, "Giá bán không hợp lệ", "Thông báo");
                return;
            }

            // Lấy ID của danh mục từ combobox
            String selectedCategory = cboCategory.getSelectedItem().toString();
            

            List<Category> cats = CategoryDAO.readFromFile();
            for (Category cat : cats) {
                if (cat.getName().compareTo(selectedCategory) == 0) {
                    categoryId = cat.getId();
                    break;
                }
            }

            // Thêm sản phẩm
            if (!ProductService.isCheckCodeProduct(productCode)) {
                ProductService.createNewProduct(imagePath, productCode, productName, productDes, productQuantity, productPrice, categoryId);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông báo");
                clearField();
            } else {
                MessageDialog.showErrorDialog(this, "Mã sản phẩm " + productCode + " đã tồn tại", "Thông báo");
                return;
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi thêm sản phẩm, chi tiết: " + e.getMessage() + "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_createProductBtnActionPerformed

    private void deleteProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductBtnActionPerformed
        try {
            int index = productTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn sản phẩm muốn xóa", "Thông báo");
                return;
            }
            String codeProduct = (String) productTable.getValueAt(index, 0);
            List<Product> data_products = ProductService.getAllProducts();
            int id = -1;
            for (Product item : data_products) {
                if (item.getCode().equalsIgnoreCase(codeProduct)) {
                    id = item.getId();
                    break;
                }
            }
            Product selectedTea = ProductService.getProductById(id);
            String imagePath = selectedTea.getImagePath();
            String imagePathDefault = "src\\\\resources\\\\user.jpg";
            if (imagePath == null) {
                return;
            }
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm " + selectedTea.getName(), "Xác nhận");
            if (keyPress == 0) {
                if (!imagePath.equalsIgnoreCase(imagePathDefault)) {
                    try {
                        // Kiểm tra xem đường dẫn hình ảnh có tồn tại không
                        File imageFile = new File(imagePath);

                        if (imageFile.exists()) {
                            // Kiểm tra quyền truy cập và xóa tập tin
                            if (imageFile.canWrite() && imageFile.canRead()) {
                                if (!imageFile.delete()) {
                                    JOptionPane.showMessageDialog(null, "Ảnh không tồn tại");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Không có quyền truy cập để xóa ảnh.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ảnh không tồn tại");
                        }
                    } catch (SecurityException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Có lỗi khi xóa ảnh: " + e.getMessage());
                    }
                }

                ProductService.deleteProduct(selectedTea.getId());
                loadTableData();
                clearField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n"
                    + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteProductBtnActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        try {
            int index = productTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn sản phẩm", "Thông báo");
                return;
            }
            Product selectedTea = ProductService.getProductByIndex(index);
            codeInput.setText(selectedTea.getCode());
            quantityInput.setText(String.valueOf(selectedTea.getQuantity()));
            priceInput.setText(String.valueOf(selectedTea.getPriceSell()));
            desInput.setText(selectedTea.getDescription());
            nameInput.setText(selectedTea.getName());

            // Hiển thị ảnh
            ImageIcon imageIcon = new ImageIcon(selectedTea.getImagePath());

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void imageBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBrowseActionPerformed
        JFileChooser browseImageFile = new JFileChooser();

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpeg", "jpg", "jfif", "svg");
        browseImageFile.addChoosableFileFilter(fnef);

        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();

            // Tạo đường dẫn mới cho tập tin hình ảnh đến thư mục đích
            Path currentDirectory = Paths.get("").toAbsolutePath();
            Path destinationDirectory = currentDirectory.resolve(Paths.get("src", "resources"));
            Path destinationPath = destinationDirectory.resolve(selectedImageFile.getName());

            try {
                // Sao chép tập tin vào thư mục đích
                Files.copy(selectedImageFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Tải tệp thành công");

                // Lấy đường dẫn tương đối của tập tin đã lưu
                Path relativePath = currentDirectory.relativize(destinationPath);
                selectedImagePath = relativePath.toString();

                // Hiển thị ảnh
                ImageIcon imageIcon = new ImageIcon(selectedImageFile.toURI().toURL()); // Chuyển đổi File thành URL
                Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình lưu tệp");
            }
        }
    }//GEN-LAST:event_imageBrowseActionPerformed

    private void quantityInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityInputActionPerformed

    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed

    }//GEN-LAST:event_cboCategoryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        ManageCategory manageStudentScreen = new ManageCategory();
        manageStudentScreen.setLocationRelativeTo(null);
        manageStudentScreen.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void clearField() {
        codeInput.setText("");
        quantityInput.setText("");
        nameInput.setText("");
        desInput.setText("");
        priceInput.setText("");
        String imagePath = "";
        // Hiển thị ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Chỉnh kích thước ảnh vừa với khung 
        Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ManageProduct().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressTeacherLabel;
    private javax.swing.JLabel birthdayTeacherLabel;
    private javax.swing.JButton btnBackHome;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JButton clearStaffBtn;
    private javax.swing.JTextField codeInput;
    private javax.swing.JButton createProductBtn;
    private javax.swing.JButton deleteProductBtn;
    private javax.swing.JTextArea desInput;
    private javax.swing.JLabel emailTeacherLabel;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameTeacherLabel;
    private javax.swing.JLabel nameTeacherLabel1;
    private javax.swing.JTextField priceInput;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JLabel teacherIDLabel;
    private javax.swing.JButton updateProductBtn;
    // End of variables declaration//GEN-END:variables

}
