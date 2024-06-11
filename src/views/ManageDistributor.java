package views;

import common.MessageDialog;
import static common.Validator.isDate;
import static common.Validator.isNumeric;
import static common.Validator.isValidEmail;
import models.Distributor;
import services.DistributorService;
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
public class ManageDistributor extends javax.swing.JFrame {

    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/resources/";

    public ManageDistributor() {
        initComponents();
        initializeTable();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackHome = new javax.swing.JButton();
        mainTitle = new javax.swing.JLabel();
        teacherIDLabel = new javax.swing.JLabel();
        distributorIDField = new javax.swing.JTextField();
        nameTeacherLabel = new javax.swing.JLabel();
        nameDistributorField = new javax.swing.JTextField();
        addressTeacherLabel = new javax.swing.JLabel();
        addressDistributorField = new javax.swing.JTextField();
        phoneNumberTeacherLabel = new javax.swing.JLabel();
        phoneNumberDistributorField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        distributorTable = new javax.swing.JTable();
        createDistributorBtn = new javax.swing.JButton();
        updateDistributorBtn = new javax.swing.JButton();
        deleteDistributorBtn = new javax.swing.JButton();
        clearDistributorBtn = new javax.swing.JButton();
        birthdayTeacherLabel = new javax.swing.JLabel();
        birthdayDistributorField = new javax.swing.JTextField();
        emailTeacherLabel = new javax.swing.JLabel();
        emailDistributorField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        imageBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhà phân phối");

        btnBackHome.setText("Quay về trang chủ");
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Quản lý nhà phân phối");

        teacherIDLabel.setText("Mã đối tác: ");

        nameTeacherLabel.setText("Tên đối tác:");

        nameDistributorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDistributorFieldActionPerformed(evt);
            }
        });

        addressTeacherLabel.setText("Địa chỉ: ");

        phoneNumberTeacherLabel.setText("Số điện thoại: ");

        distributorTable.setModel(new javax.swing.table.DefaultTableModel(
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
        distributorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                distributorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(distributorTable);

        createDistributorBtn.setText("Thêm");
        createDistributorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDistributorBtnActionPerformed(evt);
            }
        });

        updateDistributorBtn.setText("Sửa");
        updateDistributorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDistributorBtnActionPerformed(evt);
            }
        });

        deleteDistributorBtn.setText("Xóa");
        deleteDistributorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDistributorBtnActionPerformed(evt);
            }
        });

        clearDistributorBtn.setText("Nhập lại");
        clearDistributorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDistributorBtnActionPerformed(evt);
            }
        });

        birthdayTeacherLabel.setText("Ngày hợp tác");

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
                                            .addComponent(distributorIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                            .addComponent(addressDistributorField)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(birthdayDistributorField)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneNumberTeacherLabel)
                                    .addComponent(nameTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailTeacherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(phoneNumberDistributorField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                        .addComponent(nameDistributorField, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(emailDistributorField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(294, 294, 294))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBackHome)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createDistributorBtn)
                .addGap(58, 58, 58)
                .addComponent(updateDistributorBtn)
                .addGap(66, 66, 66)
                .addComponent(deleteDistributorBtn)
                .addGap(57, 57, 57)
                .addComponent(clearDistributorBtn)
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
                            .addComponent(distributorIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameDistributorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTeacherLabel)
                            .addComponent(addressDistributorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberTeacherLabel)
                            .addComponent(phoneNumberDistributorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthdayDistributorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthdayTeacherLabel)
                            .addComponent(emailDistributorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTeacherLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(clearDistributorBtn)
                    .addComponent(deleteDistributorBtn)
                    .addComponent(updateDistributorBtn)
                    .addComponent(createDistributorBtn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        dispose();
        Home homeScreen = new Home();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btnBackHomeActionPerformed
    private DefaultTableModel tableModel;

    private void loadTableData() {
        try {
            List<Distributor> data = DistributorService.getAllDistributors();
            tableModel.setRowCount(0);
            if (data != null) {
                for (Distributor tea : data) {
                    tableModel.addRow(new Object[]{tea.getCode(), tea.getLastName() + " " + tea.getFirstName(), tea.getAddress(),
                        tea.getPhoneNumber(), tea.getEmail(), tea.getBirthDate()
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
        tableModel.setColumnIdentifiers(new String[]{"Mã nhà phân phối", "Họ tên",
            "Địa chỉ", "Điện thoại", "Email", "Ngày hợp tác"});
        distributorTable.setModel(tableModel);
        loadTableData();
    }
    private void clearDistributorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDistributorBtnActionPerformed
        clearField();
    }//GEN-LAST:event_clearDistributorBtnActionPerformed

    private void updateDistributorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDistributorBtnActionPerformed
        try {
            int index = distributorTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn nhân viên muốn sửa", "Thông báo");
                return;
            }
            String codeDistributor = (String) distributorTable.getValueAt(index, 0);
            List<Distributor> data_distributors = DistributorService.getAllDistributors();
            int id = -1;
            for (Distributor item : data_distributors) {
                if (item.getCode().equalsIgnoreCase(codeDistributor)) {
                    id = item.getId();
                    break;
                }
            }
            Distributor selectedTea = DistributorService.getDistributorById(id);
            String imagePath = selectedTea.getImagePath();

            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    selectedTea.setImagePath(selectedImagePath);
                }
            }

            String distributorID = this.distributorIDField.getText().trim();
            String distributorName = this.nameDistributorField.getText().trim();
            String distributorAddress = this.addressDistributorField.getText().trim();
            String distributorPhoneNumber = this.phoneNumberDistributorField.getText().trim();
            String distributorBirthday = this.birthdayDistributorField.getText().trim();
            String distributorEmail = this.emailDistributorField.getText().trim();

            // Bắt lỗi, không nhập đủ
            if (distributorID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã nhà phân phối", "Thông báo");
                return;
            }

            if (distributorName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên nhà phân phối", "Thông báo");
                return;
            }

            if (distributorAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (distributorPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(distributorPhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (distributorBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(distributorBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (distributorEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(distributorEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }

            selectedTea.setCode(distributorID);
            selectedTea.setFirstName(DistributorService.FirstName(distributorName));
            selectedTea.setLastName(DistributorService.LastName(distributorName));
            selectedTea.setPhoneNumber(distributorPhoneNumber);
            selectedTea.setBirthDate(distributorBirthday);
            selectedTea.setEmail(distributorEmail);
            selectedTea.setAddress(distributorAddress);

            DistributorService.updateDistributor(selectedTea);
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearField();
            loadTableData();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin nhà phân phối, chi tiết: " + e.getMessage() + 
                    "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_updateDistributorBtnActionPerformed

    private void createDistributorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDistributorBtnActionPerformed
        try {
            String distributorID = this.distributorIDField.getText().trim();
            String distributorName = this.nameDistributorField.getText().trim();
            String distributorAddress = this.addressDistributorField.getText().trim();
            String distributorPhoneNumber = this.phoneNumberDistributorField.getText().trim();
            String distributorBirthday = this.birthdayDistributorField.getText().trim();
            String distributorEmail = this.emailDistributorField.getText().trim();
            String imagePath = "src\\\\resources\\\\user.jpg";
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
            if (distributorID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã nhà phân phối", "Thông báo");
                return;
            }

            if (distributorName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên nhà phân phối", "Thông báo");
                return;
            }

            if (distributorAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (distributorPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(distributorPhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (distributorBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(distributorBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (distributorEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(distributorEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            // Thêm nhà phân phối
            if (!DistributorService.isCheckCodeDistributor(distributorID)) {
                DistributorService.createNewDistributor(imagePath, distributorID, distributorName, distributorAddress, distributorPhoneNumber, distributorEmail, distributorBirthday);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông  báo");
                clearField();
            } else {
                MessageDialog.showErrorDialog(this, "Mã nhân viên " + distributorID + " đã tồn tại", "Thông báo");
                return;
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi thêm nhà phân phối, chi tiết: " + e.getMessage() + "\n" + e.toString() + "\n", "Lỗi");
            e.printStackTrace();
        }

    }//GEN-LAST:event_createDistributorBtnActionPerformed

    private void deleteDistributorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDistributorBtnActionPerformed
        try {
            int index = distributorTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn nhà phân phối muốn xóa", "Thông báo");
                return;
            }
            String codeDistributor = (String) distributorTable.getValueAt(index, 0);
            List<Distributor> data_distributors = DistributorService.getAllDistributors();
            int id = -1;
            for (Distributor item : data_distributors) {
                if (item.getCode().equalsIgnoreCase(codeDistributor)) {
                    id = item.getId();
                    break;
                }
            }
            Distributor selectedTea = DistributorService.getDistributorById(id);
            String imagePath = selectedTea.getImagePath();
            String imagePathDefault = "src\\\\resources\\\\user.jpg";
            if (imagePath == null) {
                return;
            }
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa nhà phân phối " + selectedTea.getLastName() + " " + selectedTea.getFirstName(), "Xác nhận");
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
            
                DistributorService.deleteDistributor(selectedTea.getId());
                loadTableData();
                clearField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa, chi tiết: " + ex.getMessage() + "\n" 
                    + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteDistributorBtnActionPerformed

    private void distributorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_distributorTableMouseClicked
        try {
            int index = distributorTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn nhà phân phối", "Thông báo");
                return;
            }
            Distributor selectedTea = DistributorService.getDistributorByIndex(index);
            distributorIDField.setText(selectedTea.getCode());
            nameDistributorField.setText(selectedTea.getLastName() + " " + selectedTea.getFirstName());
            phoneNumberDistributorField.setText(selectedTea.getPhoneNumber());
            birthdayDistributorField.setText(selectedTea.getBirthDate());
            emailDistributorField.setText(selectedTea.getEmail());
            addressDistributorField.setText(selectedTea.getAddress());
            
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
    }//GEN-LAST:event_distributorTableMouseClicked

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

    private void nameDistributorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDistributorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameDistributorFieldActionPerformed

    public void clearField() {
        distributorIDField.setText("");
        nameDistributorField.setText("");
        phoneNumberDistributorField.setText("");
        addressDistributorField.setText("");
        emailDistributorField.setText("");
        birthdayDistributorField.setText("");
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
            new ManageDistributor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressDistributorField;
    private javax.swing.JLabel addressTeacherLabel;
    private javax.swing.JTextField birthdayDistributorField;
    private javax.swing.JLabel birthdayTeacherLabel;
    private javax.swing.JButton btnBackHome;
    private javax.swing.JButton clearDistributorBtn;
    private javax.swing.JButton createDistributorBtn;
    private javax.swing.JButton deleteDistributorBtn;
    private javax.swing.JTextField distributorIDField;
    private javax.swing.JTable distributorTable;
    private javax.swing.JTextField emailDistributorField;
    private javax.swing.JLabel emailTeacherLabel;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField nameDistributorField;
    private javax.swing.JLabel nameTeacherLabel;
    private javax.swing.JTextField phoneNumberDistributorField;
    private javax.swing.JLabel phoneNumberTeacherLabel;
    private javax.swing.JLabel teacherIDLabel;
    private javax.swing.JButton updateDistributorBtn;
    // End of variables declaration//GEN-END:variables

}
