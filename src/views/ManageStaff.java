package views;

import common.MessageDialog;
import static common.Validator.isDate;
import static common.Validator.isNumeric;
import static common.Validator.isValidEmail;
import models.Staff;
import services.StaffService;
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

/**
 *
 * @author NGUYEN TRANG
 */
public class ManageStaff extends javax.swing.JFrame {

    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/resources/";

    public ManageStaff() {
        initComponents();
        initializeTable();
        try {
            initializeRoleCombobox();
        } catch (Exception ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackHome = new javax.swing.JButton();
        mainTitle = new javax.swing.JLabel();
        teacherIDLabel = new javax.swing.JLabel();
        staffIDField = new javax.swing.JTextField();
        nameTeacherLabel = new javax.swing.JLabel();
        nameStaffField = new javax.swing.JTextField();
        addressTeacherLabel = new javax.swing.JLabel();
        addressStaffField = new javax.swing.JTextField();
        phoneNumberTeacherLabel = new javax.swing.JLabel();
        phoneNumberStaffField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        createStaffBtn = new javax.swing.JButton();
        updateStaffBtn = new javax.swing.JButton();
        deleteStaffBtn = new javax.swing.JButton();
        clearStaffBtn = new javax.swing.JButton();
        birthdayTeacherLabel = new javax.swing.JLabel();
        birthdayStaffField = new javax.swing.JTextField();
        emailTeacherLabel = new javax.swing.JLabel();
        emailStaffField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        imageBrowse = new javax.swing.JButton();
        nameTeacherLabel1 = new javax.swing.JLabel();
        cboPosition = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý giáo viên");

        btnBackHome.setText("Quay về trang chủ");
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Quản lý nhân viên");

        teacherIDLabel.setText("Mã NV: ");

        nameTeacherLabel.setText("Họ tên:");

        nameStaffField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameStaffFieldActionPerformed(evt);
            }
        });

        addressTeacherLabel.setText("Địa chỉ: ");

        phoneNumberTeacherLabel.setText("Số điện thoại: ");

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
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
        staffTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(staffTable);

        createStaffBtn.setText("Thêm");
        createStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStaffBtnActionPerformed(evt);
            }
        });

        updateStaffBtn.setText("Sửa");
        updateStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStaffBtnActionPerformed(evt);
            }
        });

        deleteStaffBtn.setText("Xóa");
        deleteStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStaffBtnActionPerformed(evt);
            }
        });

        clearStaffBtn.setText("Nhập lại");
        clearStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStaffBtnActionPerformed(evt);
            }
        });

        birthdayTeacherLabel.setText("Ngày sinh:");

        emailTeacherLabel.setText("Email:");

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

        nameTeacherLabel1.setText("Chức vụ");

        cboPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPositionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
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
                                            .addComponent(staffIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                            .addComponent(addressStaffField)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(birthdayStaffField)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneNumberTeacherLabel)
                                    .addComponent(nameTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(phoneNumberStaffField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                        .addComponent(nameStaffField, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(emailStaffField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(nameTeacherLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBackHome)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createStaffBtn)
                .addGap(58, 58, 58)
                .addComponent(updateStaffBtn)
                .addGap(66, 66, 66)
                .addComponent(deleteStaffBtn)
                .addGap(57, 57, 57)
                .addComponent(clearStaffBtn)
                .addGap(331, 331, 331))
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
                        .addComponent(btnBackHome)
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(mainTitle)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(nameTeacherLabel)
                            .addComponent(teacherIDLabel)
                            .addComponent(staffIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameStaffField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTeacherLabel1)
                            .addComponent(cboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTeacherLabel)
                            .addComponent(addressStaffField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberTeacherLabel)
                            .addComponent(phoneNumberStaffField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthdayStaffField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthdayTeacherLabel)
                            .addComponent(emailStaffField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTeacherLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(clearStaffBtn)
                    .addComponent(deleteStaffBtn)
                    .addComponent(updateStaffBtn)
                    .addComponent(createStaffBtn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeRoleCombobox() throws Exception {
        cboPosition.removeAllItems();
        cboPosition.addItem("Admin");        
        cboPosition.addItem("Nhân viên bán hàng");
        cboPosition.addItem("Nhân viên thủ kho");
        cboPosition.setSelectedIndex(1);
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
            List<Staff> data = StaffService.getAllStaffs();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Staff tea : data) {
                    tableModel.addRow(new Object[]{tea.getCode(), tea.getLastName() + " " + tea.getFirstName(), tea.getAddress(),
                        tea.getPhoneNumber(), tea.getEmail(), tea.getBirthDate(),tea.getPosition()
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
        tableModel.setColumnIdentifiers(new String[]{"Mã NV", "Họ tên",
            "Địa chỉ", "Điện thoại", "Email", "Ngày sinh", "Chức vụ"});
        staffTable.setModel(tableModel);
        loadTableData();
    }
    private void clearStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStaffBtnActionPerformed
        clearField();
    }//GEN-LAST:event_clearStaffBtnActionPerformed

    private void updateStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStaffBtnActionPerformed
        try {
            int index = staffTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn nhân viên muốn sửa", "Thông báo");
                return;
            }
            String codeStaff = (String) staffTable.getValueAt(index, 0);
            List<Staff> data_staffs = StaffService.getAllStaffs();
            int id = -1;
            for (Staff item : data_staffs) {
                if (item.getCode().equalsIgnoreCase(codeStaff)) {
                    id = item.getId();
                    break;
                }
            }
            Staff selectedTea = StaffService.getStaffById(id);
            String imagePath = selectedTea.getImagePath();

            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    selectedTea.setImagePath(selectedImagePath);
                }
            }

            String staffID = this.staffIDField.getText().trim();
            String staffName = this.nameStaffField.getText().trim();
            String staffAddress = this.addressStaffField.getText().trim();
            String staffPhoneNumber = this.phoneNumberStaffField.getText().trim();
            String staffBirthday = this.birthdayStaffField.getText().trim();
            String staffEmail = this.emailStaffField.getText().trim();

            // Bắt lỗi, không nhập đủ
            if (staffID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã giáo viên", "Thông báo");
                return;
            }

            if (staffName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên giáo viên", "Thông báo");
                return;
            }

            if (staffAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (staffPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(staffPhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (staffBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(staffBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (staffEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(staffEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }

            selectedTea.setCode(staffID);
            selectedTea.setFirstName(StaffService.FirstName(staffName));
            selectedTea.setLastName(StaffService.LastName(staffName));
            selectedTea.setPhoneNumber(staffPhoneNumber);
            selectedTea.setBirthDate(staffBirthday);
            selectedTea.setEmail(staffEmail);
            selectedTea.setAddress(staffAddress);

            StaffService.updateStaff(selectedTea);
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearField();
            loadTableData();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin giáo viên, chi tiết: " + e.getMessage() + 
                    "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_updateStaffBtnActionPerformed

    private void createStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStaffBtnActionPerformed
        try {
            String staffID = this.staffIDField.getText().trim();
            String staffName = this.nameStaffField.getText().trim();
            String staffAddress = this.addressStaffField.getText().trim();
            String staffPhoneNumber = this.phoneNumberStaffField.getText().trim();
            String staffBirthday = this.birthdayStaffField.getText().trim();
            String staffEmail = this.emailStaffField.getText().trim();
            String imagePath = "src\\\\resources\\\\user.jpg";
            String staffPosition = this.cboPosition.getSelectedItem().toString();
            if (selectedImagePath.trim() != "") {
                imagePath = selectedImagePath;
            }

            // Hiển thị ảnh
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

            // Bắt lỗi, không nhập đủ
            if (staffID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã giáo viên", "Thông báo");
                return;
            }

            if (staffName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên giáo viên", "Thông báo");
                return;
            }

            if (staffAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (staffPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(staffPhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (staffBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(staffBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (staffEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(staffEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            // Thêm giáo viên
            if (!StaffService.isCheckCodeStaff(staffID)) {
                StaffService.createNewStaff(imagePath, staffID, staffName, staffAddress, staffPhoneNumber, staffEmail, staffBirthday, staffPosition);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông  báo");
                clearField();
            } else {
                MessageDialog.showErrorDialog(this, "Mã nhân viên " + staffID + " đã tồn tại", "Thông báo");
                return;
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi thêm giáo viên, chi tiết: " + e.getMessage() + "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_createStaffBtnActionPerformed

    private void deleteStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStaffBtnActionPerformed
        try {
            int index = staffTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn giáo viên muốn xóa", "Thông báo");
                return;
            }
            String codeStaff = (String) staffTable.getValueAt(index, 0);
            List<Staff> data_staffs = StaffService.getAllStaffs();
            int id = -1;
            for (Staff item : data_staffs) {
                if (item.getCode().equalsIgnoreCase(codeStaff)) {
                    id = item.getId();
                    break;
                }
            }
            Staff selectedTea = StaffService.getStaffById(id);
            String imagePath = selectedTea.getImagePath();
            String imagePathDefault = "src\\\\resources\\\\user.jpg";
            if (imagePath == null) {
                return;
            }
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa giáo viên " + selectedTea.getLastName() + " " + selectedTea.getFirstName(), "Xác nhận");
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
            
                StaffService.deleteStaff(selectedTea.getId());
                loadTableData();
                clearField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n" 
                    + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteStaffBtnActionPerformed

    private void staffTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTableMouseClicked
        try {
            int index = staffTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn giáo viên", "Thông báo");
                return;
            }
            Staff selectedTea = StaffService.getStaffByIndex(index);
            staffIDField.setText(selectedTea.getCode());
            nameStaffField.setText(selectedTea.getLastName() + " " + selectedTea.getFirstName());
            phoneNumberStaffField.setText(selectedTea.getPhoneNumber());
            birthdayStaffField.setText(selectedTea.getBirthDate());
            emailStaffField.setText(selectedTea.getEmail());
            addressStaffField.setText(selectedTea.getAddress());
            
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
    }//GEN-LAST:event_staffTableMouseClicked

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

    private void nameStaffFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameStaffFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameStaffFieldActionPerformed

    private void cboPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPositionActionPerformed

    }//GEN-LAST:event_cboPositionActionPerformed

    public void clearField() {
        staffIDField.setText("");
        nameStaffField.setText("");
        phoneNumberStaffField.setText("");
        addressStaffField.setText("");
        emailStaffField.setText("");
        birthdayStaffField.setText("");
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
            new ManageStaff().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressStaffField;
    private javax.swing.JLabel addressTeacherLabel;
    private javax.swing.JTextField birthdayStaffField;
    private javax.swing.JLabel birthdayTeacherLabel;
    private javax.swing.JButton btnBackHome;
    private javax.swing.JComboBox<String> cboPosition;
    private javax.swing.JButton clearStaffBtn;
    private javax.swing.JButton createStaffBtn;
    private javax.swing.JButton deleteStaffBtn;
    private javax.swing.JTextField emailStaffField;
    private javax.swing.JLabel emailTeacherLabel;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField nameStaffField;
    private javax.swing.JLabel nameTeacherLabel;
    private javax.swing.JLabel nameTeacherLabel1;
    private javax.swing.JTextField phoneNumberStaffField;
    private javax.swing.JLabel phoneNumberTeacherLabel;
    private javax.swing.JTextField staffIDField;
    private javax.swing.JTable staffTable;
    private javax.swing.JLabel teacherIDLabel;
    private javax.swing.JButton updateStaffBtn;
    // End of variables declaration//GEN-END:variables

}
