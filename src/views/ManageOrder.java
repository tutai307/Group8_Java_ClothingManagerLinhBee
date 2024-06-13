/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import common.MessageDialog;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.StaffDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.Distributor;
import models.Order;
import models.OrderDetail;
import models.Product;
import models.Staff;
import services.DistributorService;
import services.OrderService;
import services.ProductService;

/**
 *
 * @author Admin
 */
public class ManageOrder extends javax.swing.JFrame {
    /**
     * Creates new form ManageOrder
     */
    private int teacherId = -200;
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
        loadComboBox();
        initializeTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnAddOrder = new javax.swing.JButton();
        btnChangeOrder = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        btnAgain = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtOrderCode = new javax.swing.JTextField();
        txtOrderName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescription = new javax.swing.JTextArea();
        cboCustomerCode = new javax.swing.JComboBox<>();
        txtOrderDate = new javax.swing.JTextField();
        cboStaffCode = new javax.swing.JComboBox<>();
        cboProductCode = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý đơn hàng");

        btnBack.setText("Quay lại trang chủ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Tên đơn hàng", "Mô tả", "Ngày nhập"
            }
        ));
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        btnAddOrder.setText("Thêm");
        btnAddOrder.setPreferredSize(new java.awt.Dimension(90, 30));
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        btnChangeOrder.setText("Sửa");
        btnChangeOrder.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChangeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeOrderActionPerformed(evt);
            }
        });

        btnDeleteOrder.setText("Xóa");
        btnDeleteOrder.setPreferredSize(new java.awt.Dimension(90, 30));
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        btnAgain.setText("Nhập lại");
        btnAgain.setPreferredSize(new java.awt.Dimension(90, 30));
        btnAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgainActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã đơn hàng:");

        jLabel3.setText("Tên đơn hàng:");

        jLabel4.setText("Mô tả:");

        jLabel5.setText("Ngày đặt hàng:");

        jLabel6.setText("Mã khách hàng:");

        jLabel7.setText("Mã nhân viên:");

        jLabel8.setText("Mã sản phẩm:");

        jLabel10.setText("Số lượng bán:");

        txtOrderCode.setPreferredSize(new java.awt.Dimension(300, 30));
        txtOrderCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderCodeActionPerformed(evt);
            }
        });

        txtOrderName.setPreferredSize(new java.awt.Dimension(300, 30));
        txtOrderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderNameActionPerformed(evt);
            }
        });

        areaDescription.setColumns(20);
        areaDescription.setRows(5);
        areaDescription.setPreferredSize(new java.awt.Dimension(500, 60));
        jScrollPane2.setViewportView(areaDescription);

        cboCustomerCode.setMinimumSize(new java.awt.Dimension(300, 30));
        cboCustomerCode.setPreferredSize(new java.awt.Dimension(300, 30));

        txtOrderDate.setMinimumSize(new java.awt.Dimension(300, 30));
        txtOrderDate.setPreferredSize(new java.awt.Dimension(300, 30));
        txtOrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderDateActionPerformed(evt);
            }
        });

        cboStaffCode.setMinimumSize(new java.awt.Dimension(76, 30));
        cboStaffCode.setPreferredSize(new java.awt.Dimension(76, 20));

        cboProductCode.setPreferredSize(new java.awt.Dimension(76, 30));
        cboProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductCodeActionPerformed(evt);
            }
        });

        txtQuantity.setPreferredSize(new java.awt.Dimension(300, 30));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboProductCode, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboStaffCode, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboCustomerCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrderCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnChangeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(465, 465, 465))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCustomerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboStaffCode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChangeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void cboProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProductCodeActionPerformed

    private void txtOrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderDateActionPerformed

    private void txtOrderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderNameActionPerformed

    private void txtOrderCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderCodeActionPerformed

    private void btnAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgainActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btnAgainActionPerformed

    private void btnChangeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeOrderActionPerformed
        try {
            int index = tblOrder.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn một phiếu nhập", "Thông báo");
                return;
            }

            // Lấy dữ liệu từ các ô nhập
            String importOrderCode = this.txtOrderCode.getText().trim();
            String importOrderName = this.txtOrderName.getText().trim();
            String importDes = this.areaDescription.getText().trim();
            String importDate = this.txtOrderDate.getText().trim();
            String importCustomerCode = this.cboCustomerCode.getSelectedItem().toString();
            String importStaffCode = this.cboStaffCode.getSelectedItem().toString();
            String importProductCode = this.cboProductCode.getSelectedItem().toString();
            int quantity = Integer.parseInt(this.txtQuantity.getText().trim());
            
           
            if (importOrderCode.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Mã phiếu nhập không được để trống", "Thông báo");
                return;
            }
            if (importOrderName.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Tên phiếu nhập không được để trống", "Thông báo");
                return;
            }
            
            if (importDes.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Mô tả không được để trống", "Thông báo");
                return;
            }
            if (importDate.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Ngày nhập không được bỏ trống", "Thông báo");
                return;
            }

            if (quantity <= 0) {
                MessageDialog.showInfoDialog(this, "Số lượng nhập không hợp lệ", "Thông báo");
                return;
            }

            // Cập nhật dữ liệu Import
            Order selectedOrder = OrderService.getOrderByIndex(index);
            selectedOrder.setName(importOrderName);
            selectedOrder.setCode(importOrderCode);
            selectedOrder.setDescription(importDes);
            selectedOrder.setCreateDate(importDate);

            // Cập nhật dữ liệu ImportDetail
            List<OrderDetail> orderDetailData = OrderDAO.readOrderDetailsFromFile();
            OrderDetail selectedOrdertDetail = null;

            for (OrderDetail data : orderDetailData) {
                if (data.getOrderCode().equals(importOrderCode)) {
                    selectedOrdertDetail = data;
                    break;
                }
            }

            if (selectedOrdertDetail != null) {
                selectedOrdertDetail.setCustomerCode(importCustomerCode);
                selectedOrdertDetail.setStaffCode(importStaffCode);
                selectedOrdertDetail.setProductCode(importProductCode);
                selectedOrdertDetail.setQuantity(quantity);
                

                // Lưu dữ liệu đã chỉnh sửa
                OrderService.updateOrder(selectedOrder, selectedOrdertDetail);
                MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
                clearAllFields();
                loadTableData();
            } else {
                MessageDialog.showInfoDialog(this, "Không tìm thấy chi tiết phiếu nhập tương ứng", "Thông báo");
            }

        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi sửa thông tin phiếu nhập, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnChangeOrderActionPerformed

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        try {
            String importCode = this.txtOrderCode.getText().trim();
            String importName = this.txtOrderName.getText().trim();
            String importDes = this.areaDescription.getText().trim();
            String importDate = this.txtOrderDate.getText().trim();
            String importCodeCustomer = this.cboCustomerCode.getSelectedItem().toString();
            String importCodeStaff = this.cboStaffCode.getSelectedItem().toString();
            String importCodeProduct = this.cboProductCode.getSelectedItem().toString();
            int importQuality = Integer.parseInt(this.txtQuantity.getText().trim());

            if (importCode.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mã đơn hàng không được để trống", "Thông báo");
                return;
            }
            if (importName.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Tên đơn hàng không được để trống", "Thông báo");
                return;
            }
            if (importDes.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mô tả không được để trống", "Thông báo");
                return;
            }
            if (importDate.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Ngày xuất đơn hàng không được để trống", "Thông báo");
                return;
            }

            if (importQuality <= 0) {
                MessageDialog.showInfoDialog(this, "Số lượng bán không hợp lệ", "Thông báo");
                return;
            }

            if (OrderService.isExistedOrderCode(importCode)) {
                MessageDialog.showInfoDialog(this, "Trùng mã phiếu nhập", "Thông báo");
            } else {
                OrderService.createNewOrder(importCode, importName, importDes, importDate, importCodeCustomer, importCodeStaff, importCodeProduct, importQuality);
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                loadTableData();
                clearAllFields();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi thêm mới, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        Home homeScreen = new Home();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        try {
            int index = tblOrder.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn một phiếu nhập", "Thông báo");
                return;
            }
            Order selectedOrder = OrderService.getOrderByIndex(index);
            int keyPress = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn xóa phiếu nhập này?", "Xác nhận");
            if (keyPress == 0) { // Nếu người dùng xác nhận xóa
                OrderService.deleteOrder(selectedOrder.getId()); // Xóa phiếu nhập và chi tiết phiếu nhập tương ứng
                loadTableData(); // Cập nhật bảng
                clearAllFields(); // Xóa dữ liệu trong các ô nhập
                MessageDialog.showInfoDialog(this, "Đã xóa phiếu nhập và chi tiết phiếu nhập thành công!", "Thông báo");
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Xảy ra lỗi khi xóa phiếu nhập, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        try {
            int index = tblOrder.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn một phiếu nhập", "Thông báo");
                return;
            }

            Order selectedOrder = OrderService.getOrderByIndex(index);
            String orderCode = selectedOrder.getCode();

            // Hiển thị dữ liệu của Import lên các ô nhập
            txtOrderCode.setText(selectedOrder.getCode());
            areaDescription.setText(selectedOrder.getDescription());
            txtOrderDate.setText(selectedOrder.getCreateDate());
            txtOrderName.setText(selectedOrder.getName());

            // Lấy dữ liệu từ ImportDetail
            List<OrderDetail> orderDetailData = OrderDAO.readOrderDetailsFromFile();
            for (OrderDetail detail : orderDetailData) {
                if (detail.getOrderCode().equals(orderCode)) {
                    cboProductCode.setSelectedItem(detail.getProductCode());
                    cboStaffCode.setSelectedItem(detail.getStaffCode());
                    cboProductCode.setSelectedItem(detail.getProductCode());
                    txtQuantity.setText(String.valueOf(detail.getQuantity()));
                   
                    break; // Chỉ lấy chi tiết phiếu nhập đầu tiên tìm thấy
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi lấy thông tin chi tiết phiếu nhập, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tblOrderMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManageOrder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescription;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnAgain;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangeOrder;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JComboBox<String> cboCustomerCode;
    private javax.swing.JComboBox<String> cboProductCode;
    private javax.swing.JComboBox<String> cboStaffCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtOrderCode;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtOrderName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
    
    private DefaultTableModel tableModel;
    
    private void loadTableData() {
        try {
            List<Order> order_data = OrderService.getAllImports();
            tableModel.setRowCount(0);
            if (order_data != null) {
                for (Order impor : order_data) {
                    tableModel.addRow(new Object[]{ impor.getCode(),
                                                    impor.getName(),
                                                    impor.getDescription(),
                                                    impor.getCreateDate()
                                                    });
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void clearAllFields() {
        txtOrderCode.setText("");
        txtOrderName.setText("");
        areaDescription.setText("");
        txtOrderDate.setText("");
        txtQuantity.setText("");
        cboCustomerCode.setSelectedIndex(0);
        cboStaffCode.setSelectedIndex(0);
        cboProductCode.setSelectedIndex(0);
    }
    
    private void loadComboBox() {
        try {
            // Đọc danh sách khách hàng
            List<Customer> customerList = CustomerDAO.readFromFile();

            // Xóa các mục cũ trong combobox
            cboCustomerCode.removeAllItems();

            // Thêm code của nhân viên bán hàng vào combobox
            for (Customer customer : customerList) {
                cboCustomerCode.addItem(customer.getCode());
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Đã xảy ra lỗi khi tải danh sách khách hàng từ tệp: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
        try {
            // Đọc danh sách nhân viên từ tệp
            List<Staff> staffList = StaffDAO.readFromFile();

            // Xóa các mục cũ trong combobox
            cboStaffCode.removeAllItems();

            // Thêm code của nhân viên bán hàng vào combobox
            for (Staff staff : staffList) {
                if ("Nhân viên bán hàng".equals(staff.getPosition())) {
                    cboStaffCode.addItem(staff.getCode());
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Đã xảy ra lỗi khi tải danh sách nhân viên từ tệp: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }

        try {
            // Đọc danh sách sản phẩm từ tệp
            List<Product> products = ProductDAO.readFromFile();

            // Xóa các mục cũ trong combobox
            cboProductCode.removeAllItems();

            // Thêm code của từng khách hàng vào combobox
            for (Product product : products) {
                cboProductCode.addItem(product.getCode());
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Đã xảy ra lỗi khi tải danh sách nhà phân phối từ tệp: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã đơn hàng", "Tên đơn hàng", "Mô tả",
            "Ngày nhập"});
        tblOrder.setModel(tableModel);
        if (teacherId >= 0) {
            btnDeleteOrder.setEnabled(false);
            btnBack.setText("Quay lại trang trước");
        }
        loadTableData();
    }
   
}
