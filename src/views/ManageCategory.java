package views;

import common.MessageDialog;
import models.Category;
import services.CategoryService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN TRANG
 */
public class ManageCategory extends javax.swing.JFrame {

    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/resources/";

    public ManageCategory() {
        initComponents();
        initializeTable();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackHome = new javax.swing.JButton();
        mainTitle = new javax.swing.JLabel();
        teacherIDLabel = new javax.swing.JLabel();
        codeInput = new javax.swing.JTextField();
        nameTeacherLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        addressTeacherLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        createCategoryBtn = new javax.swing.JButton();
        updateCategoryBtn = new javax.swing.JButton();
        deleteCategoryBtn = new javax.swing.JButton();
        clearDistributorBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        desInput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý danh mục");

        btnBackHome.setText("Quay về trang chủ");
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Quản lý danh mục");

        teacherIDLabel.setText("Mã danh mục: ");

        codeInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeInputActionPerformed(evt);
            }
        });

        nameTeacherLabel.setText("Tên danh mục:");

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });

        addressTeacherLabel.setText("Mô tả:");

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        categoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoryTable);

        createCategoryBtn.setText("Thêm");
        createCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCategoryBtnActionPerformed(evt);
            }
        });

        updateCategoryBtn.setText("Sửa");
        updateCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCategoryBtnActionPerformed(evt);
            }
        });

        deleteCategoryBtn.setText("Xóa");
        deleteCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryBtnActionPerformed(evt);
            }
        });

        clearDistributorBtn.setText("Nhập lại");
        clearDistributorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDistributorBtnActionPerformed(evt);
            }
        });

        desInput.setColumns(20);
        desInput.setRows(5);
        jScrollPane2.setViewportView(desInput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBackHome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teacherIDLabel)
                            .addComponent(addressTeacherLabel))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(codeInput))
                        .addGap(32, 32, 32)
                        .addComponent(nameTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createCategoryBtn)
                .addGap(82, 82, 82)
                .addComponent(updateCategoryBtn)
                .addGap(99, 99, 99)
                .addComponent(deleteCategoryBtn)
                .addGap(92, 92, 92)
                .addComponent(clearDistributorBtn)
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(mainTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackHome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(mainTitle)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(nameTeacherLabel)
                            .addComponent(teacherIDLabel)
                            .addComponent(codeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressTeacherLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(clearDistributorBtn)
                    .addComponent(deleteCategoryBtn)
                    .addComponent(updateCategoryBtn)
                    .addComponent(createCategoryBtn))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        dispose();
        ManageProduct manageStudentScreen = new ManageProduct();
        manageStudentScreen.setLocationRelativeTo(null);
        manageStudentScreen.setVisible(true);
    }//GEN-LAST:event_btnBackHomeActionPerformed
    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            List<Category> data = CategoryService.getAllCategories();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Category tea : data) {
                    tableModel.addRow(new Object[]{tea.getCode(), tea.getName(), tea.getDescription()});
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
        tableModel.setColumnIdentifiers(new String[]{"Mã danh mục", "Tên danh mục","Mô tả"});
        categoryTable.setModel(tableModel);
        loadTableData();
    }
    private void clearDistributorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDistributorBtnActionPerformed
        clearField();
    }//GEN-LAST:event_clearDistributorBtnActionPerformed

    private void updateCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCategoryBtnActionPerformed
        try {
            int index = categoryTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn danh mục muốn sửa", "Thông báo");
                return;
            }
            String codeCategory = (String) categoryTable.getValueAt(index, 0);
            List<Category> data_categorys = CategoryService.getAllCategories();
            int id = -1;
            for (Category item : data_categorys) {
                if (item.getCode().equalsIgnoreCase(codeCategory)) {
                    id = item.getId();
                    break;
                }
            }
            Category selectedTea = CategoryService.getCategoryById(id);    

            String categoryID = this.codeInput.getText().trim();
            String categoryName = this.nameInput.getText().trim();
            String categoryAddress = this.desInput.getText().trim();   

            // Bắt lỗi, không nhập đủ
            if (categoryID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã danh mục", "Thông báo");
                return;
            }

            if (categoryName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập tên danh mục", "Thông báo");
                return;
            }

            if (categoryAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mô tả", "Thông báo");
                return;
            }
           

            selectedTea.setCode(categoryID);
            selectedTea.setName(categoryName);
            selectedTea.setDescription(categoryAddress);

            CategoryService.updateCategory(selectedTea);
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearField();
            loadTableData();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin danh mục, chi tiết: " + e.getMessage() + 
                    "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_updateCategoryBtnActionPerformed

    private void createCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCategoryBtnActionPerformed
        try {
            String code = this.codeInput.getText().trim();
            String name = this.nameInput.getText().trim();
            String des = this.desInput.getText().trim();
            // Bắt lỗi, không nhập đủ
            if (code.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã danh mục", "Thông báo");
                return;
            }

            if (name.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập tên danh mục", "Thông báo");
                return;
            }

            if (des.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mô tả", "Thông báo");
                return;
            }
            
            // Thêm danh mục
            if (!CategoryService.isCheckCodeCategory(code)) {
                CategoryService.createNewCategory(code, name, des);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông  báo");
                clearField();
            } else {
                MessageDialog.showErrorDialog(this, "Mã danh mục " + code + " đã tồn tại", "Thông báo");
                return;
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi thêm danh mục, chi tiết: " + e.getMessage() + "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_createCategoryBtnActionPerformed

    private void deleteCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryBtnActionPerformed
        try {
            int index = categoryTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn danh mục muốn xóa", "Thông báo");
                return;
            }
            String codeCategory = (String) categoryTable.getValueAt(index, 0);
            List<Category> data_categorys = CategoryService.getAllCategories();
            int id = -1;
            for (Category item : data_categorys) {
                if (item.getCode().equalsIgnoreCase(codeCategory)) {
                    id = item.getId();
                    break;
                }
            }
            Category selectedTea = CategoryService.getCategoryById(id);
 
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa danh mục " + selectedTea.getName(), "Xác nhận");
            if (keyPress == 0) {             
            
                CategoryService.deleteCategory(selectedTea.getId());
                loadTableData();
                clearField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n" 
                    + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteCategoryBtnActionPerformed

    private void categoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryTableMouseClicked
        try {
            int index = categoryTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn danh mục", "Thông báo");
                return;
            }
            Category selectedTea = CategoryService.getCategoryByIndex(index);
            codeInput.setText(selectedTea.getCode());
            nameInput.setText(selectedTea.getName());
            desInput.setText(selectedTea.getDescription());
            

        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_categoryTableMouseClicked

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void codeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeInputActionPerformed

    public void clearField() {
        codeInput.setText("");
        nameInput.setText("");
        desInput.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ManageCategory().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressTeacherLabel;
    private javax.swing.JButton btnBackHome;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton clearDistributorBtn;
    private javax.swing.JTextField codeInput;
    private javax.swing.JButton createCategoryBtn;
    private javax.swing.JButton deleteCategoryBtn;
    private javax.swing.JTextArea desInput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameTeacherLabel;
    private javax.swing.JLabel teacherIDLabel;
    private javax.swing.JButton updateCategoryBtn;
    // End of variables declaration//GEN-END:variables

}
