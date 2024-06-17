/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.StaffDAO;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.Customer.CustomerType;

/**
 *
 * @author Admin
 */
public class ExportFile {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;
    
    public ExportFile() {
        try {
            fontData = new Font(BaseFont.createFont("libs/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("libs/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("libs/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }
    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private String getFilePath(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        java.awt.Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }
    
    public void writePhieuNhap(String orderCode) throws Exception {
        String url = "";
        try {
            fd.setTitle("In đơn hàng");
            fd.setLocationRelativeTo(null);
            url = getFilePath(orderCode);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            
            String productCode = null;
            String orderCodeExp = null;
            String orderNameExp = null;
            String orderDateExp = null;
            int quantity = 0;
            String productName = null;
            double priceSell = 0;
            String orderDetailCodeStaff = null;
            String staffName = null;
            String customerCode = null;
            String customerName = null;
            
            setTitle("THÔNG TIN ĐƠN HÀNG");

            List<Order> orderList = OrderDAO.readFromFile();
            List<OrderDetail> orderDetailList = OrderDAO.readOrderDetailsFromFile();
            List<Product> productList = ProductDAO.readFromFile();
            List<Staff> staffList = StaffDAO.readFromFile();
            List<Customer> customerList = CustomerDAO.readFromFile();
            Customer cus = null;
            for(Order order : orderList){
                if(order.getCode().equalsIgnoreCase(orderCode)){
                    orderCodeExp = order.getCode();
                    orderNameExp = order.getName();
                    orderDateExp = order.getCreateDate();
                    for(OrderDetail orderDetail : orderDetailList){
                        if(orderDetail.getOrderCode().equalsIgnoreCase(order.getCode())){
                            productCode = orderDetail.getProductCode();
                            quantity = orderDetail.getQuantity();
                            orderDetailCodeStaff = orderDetail.getStaffCode();
                            customerCode = orderDetail.getCustomerCode();
                        }
                    }
                }
            }
            for(Product product : productList){
                if(product.getCode().equalsIgnoreCase(productCode)){
                    productName = product.getName();
                    priceSell = product.getPriceSell();
                }
            }
            for(Staff staff : staffList){
                if(staff.getCode().equalsIgnoreCase(orderDetailCodeStaff)){
                    staffName = staff.getLastName() + " " + staff.getFirstName();
                }
            }
            for(Customer customer : customerList){
                if(customer.getCode().equalsIgnoreCase(customerCode)){
                    customerName = customer.getLastName() + " " + customer.getFirstName();
                    cus = customer;
                }
            }
            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add("Mã phiếu: " + orderCodeExp);
            para1.add("\nThời gian tạo: " + orderDateExp);
            para1.setIndentationLeft(40);
            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.add(String.valueOf("Người tạo: " + staffName));
            para2.add(String.valueOf("\nKhách hàng: " + customerName));
            para2.add(String.valueOf("\nLoại khách hàng: " + cus.getCustomerType()));
            para2.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            PdfPCell cell;
            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã SP", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên SP", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));
            
            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }
            CustomerType type = cus.getCustomerType();
            double sum = 0;
            switch (type) {
                case VIP -> sum = (priceSell * (double)quantity)*(85.0/100.0);
                case STUDENT -> sum = (priceSell * (double)quantity)*(90.0/100.0) ;
                case NORMAL -> sum = (priceSell * (double)quantity);
                default -> {
                }
            }
            //Truyen thong tin tung chi tiet vao table
            pdfTable.addCell(new PdfPCell(new Phrase(productCode, fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(productName, fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(priceSell) + "đ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(quantity), fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(sum) + "đ", fontData)));

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(sum) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }
}
