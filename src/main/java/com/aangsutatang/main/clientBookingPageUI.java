/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aangsutatang.main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import com.aangsutatang.main.assets.Appointment;
import com.aangsutatang.main.assets.Staff;

/**
 *
 * @author Nicolas Airel V S
 */
public class clientBookingPageUI extends javax.swing.JFrame {
    ArrayList<Appointment> appointmentList = new ArrayList<>();
    ArrayList<Staff> staffList = new ArrayList<>();
    int currIndex = 0;
    // User data field
    static String clientId;
    static String username;

    public void readActiveUser(){
        try {
            // Read staff account data
            File activeUserData = new File("activeUser.txt");
            Scanner myReader2 = new Scanner(activeUserData);
            String data = myReader2.nextLine();
            String[] temp = data.split("#");
            clientId = temp[0];
            username = temp[3];
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void readStaff(){
        try {
            // Read staff account data
            File staffData = new File("staffList.txt");
            Scanner myReader2 = new Scanner(staffData);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                String[] temp = data.split("#");
                staffList.add(new Staff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
//                System.out.printf("[INFO] Inputted staff with Id %s\n", temp[0]);
            }
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean readAppointment() {
        boolean isEmpty = false;
        try {
            File database = new File("appointmentList.txt");
            Scanner reader = new Scanner(database);
            while (reader.hasNextLine()) {
                String temp = reader.nextLine();
                String[] tokens = temp.split("#");
                if(tokens[2].equals(clientId)){
                    // 0, 1, 2, 3, 6, 4, 5
                    isEmpty = true;
                    appointmentList.add(new Appointment(tokens[0], tokens[1], tokens[2], tokens[3], tokens[6], tokens[4], tokens[5]));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return isEmpty;
    }
    
    public Staff searchStaff(String keyStaffId){
        int i;
        boolean isFound = false;
        for(i = 0 ; i < staffList.size() ; i++){
            if(staffList.get(i).getUserId().equals(keyStaffId)){
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("[INFO] INVALID STAFF");
        }
        return staffList.get(i);
    }
    
    public void display(){
        Staff tempStaff = searchStaff(appointmentList.get(currIndex).getStaffId());
        Appointment tempAppointment = appointmentList.get(currIndex);
        txtStaffName.setText(tempStaff.getName());
        txtOfficeBranch.setText(tempStaff.getOfficeBranch());
        txtAppointmentDate.setText(tempAppointment.getAppointmentDate());
        txtCurrFrom.setText(tempAppointment.getCurrFrom());
        txtCurrTo.setText(tempAppointment.getCurrTo());
    }
    
    public void displayEmpty(){
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        txtStaffName.setText("--empty--");
        txtOfficeBranch.setText("--empty--");
        txtAppointmentDate.setText("--empty--");
        txtCurrFrom.setText("--empty--");
        txtCurrTo.setText("--empty--");
    }
    
    public void next(){
        if(currIndex != appointmentList.size() - 1){
            currIndex++;
            // When displayed not the first data
            if(currIndex != 0){
                btnPrevious.setEnabled(true);
            }
            // Displayed last data
            if(currIndex == appointmentList.size() - 1){
                btnNext.setEnabled(false);
            }
            display();
        }
    }
    
    public void previous(){
        if(currIndex != 0){
            currIndex--;
            // When displayed not the first data
            if(currIndex != appointmentList.size() - 1){
                btnNext.setEnabled(true);
            }
            // Displayed last data
            if(currIndex == 0){
                btnPrevious.setEnabled(false);
            }
            display();
        }
    }
            
    public void displayStaff(){
        for(int i = 0 ; i < staffList.size() ; i++){
            System.out.println(staffList.get(i).getName());
        }
    }
    
    public void displayAppointment(){
        for(int i = 0 ; i < appointmentList.size() ; i++){
            System.out.println(appointmentList.get(i).getAptId());
            System.out.println(appointmentList.get(i).getStaffId());
        }
    }
    
    public clientBookingPageUI() {
        initComponents();
        readActiveUser();
        readStaff();
        if(readAppointment()){
            display();
        }
        else{
            displayEmpty();
        }
        btnPrevious.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        container = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        imgAppIcon = new javax.swing.JLabel();
        containerSideMenu = new com.aangsutatang.main.PanelRound();
        menuConvert = new javax.swing.JLabel();
        menuBooking = new javax.swing.JLabel();
        menuAccount = new javax.swing.JLabel();
        menuAbout = new javax.swing.JLabel();
        containerContent = new com.aangsutatang.main.PanelRound();
        containerUserCard = new com.aangsutatang.main.PanelRound();
        txtStaffName = new com.aangsutatang.main.customTextField();
        txtOfficeBranch = new com.aangsutatang.main.customTextField();
        txtAppointmentDate = new com.aangsutatang.main.customTextField();
        txtCurrFrom = new com.aangsutatang.main.customTextField();
        txtCurrTo = new com.aangsutatang.main.customTextField();
        btnPrevious = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnCreateNew = new com.aangsutatang.main.customButton();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        container.setBackground(new java.awt.Color(0, 0, 0));
        container.setFocusable(false);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/btn_close.png"))); // NOI18N
        btnClose.setToolTipText("Close app");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        imgAppIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/app_icon.png"))); // NOI18N
        imgAppIcon.setPreferredSize(new java.awt.Dimension(128, 52));

        containerSideMenu.setBackground(new java.awt.Color(0, 0, 0));
        containerSideMenu.setMinimumSize(new java.awt.Dimension(0, 0));
        containerSideMenu.setPreferredSize(new java.awt.Dimension(70, 234));
        containerSideMenu.setRoundBottomLeft(20);
        containerSideMenu.setRoundBottomRight(20);
        containerSideMenu.setRoundTopLeft(20);
        containerSideMenu.setRoundTopRight(20);

        menuConvert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/menu_exchange.png"))); // NOI18N
        menuConvert.setPreferredSize(new java.awt.Dimension(27, 27));
        menuConvert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConvertMouseClicked(evt);
            }
        });

        menuBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/menu_booking_selected.png"))); // NOI18N
        menuBooking.setPreferredSize(new java.awt.Dimension(27, 27));

        menuAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/menu_account.png"))); // NOI18N
        menuAccount.setPreferredSize(new java.awt.Dimension(27, 27));
        menuAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAccountMouseClicked(evt);
            }
        });

        menuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/menu_about.png"))); // NOI18N

        javax.swing.GroupLayout containerSideMenuLayout = new javax.swing.GroupLayout(containerSideMenu);
        containerSideMenu.setLayout(containerSideMenuLayout);
        containerSideMenuLayout.setHorizontalGroup(
            containerSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerSideMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(containerSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuAbout)
                    .addComponent(menuAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        containerSideMenuLayout.setVerticalGroup(
            containerSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerSideMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(menuConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(menuBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(menuAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(menuAbout)
                .addGap(21, 21, 21))
        );

        containerContent.setBackground(new java.awt.Color(255, 200, 251));
        containerContent.setPreferredSize(new java.awt.Dimension(70, 234));
        containerContent.setRoundBottomLeft(20);
        containerContent.setRoundBottomRight(20);
        containerContent.setRoundTopLeft(20);
        containerContent.setRoundTopRight(20);

        containerUserCard.setBackground(new java.awt.Color(255, 157, 205));
        containerUserCard.setFocusable(false);
        containerUserCard.setPreferredSize(new java.awt.Dimension(471, 169));
        containerUserCard.setRoundBottomLeft(20);
        containerUserCard.setRoundBottomRight(20);
        containerUserCard.setRoundTopLeft(20);
        containerUserCard.setRoundTopRight(20);

        txtStaffName.setEditable(false);
        txtStaffName.setBackground(new java.awt.Color(255, 157, 205));
        txtStaffName.setForeground(new java.awt.Color(255, 255, 255));
        txtStaffName.setText("staffName");
        txtStaffName.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtStaffName.setLabelText("Staff Name");
        txtStaffName.setLineColor(new java.awt.Color(255, 93, 172));
        txtStaffName.setPreferredSize(new java.awt.Dimension(210, 46));

        txtOfficeBranch.setEditable(false);
        txtOfficeBranch.setBackground(new java.awt.Color(255, 157, 205));
        txtOfficeBranch.setForeground(new java.awt.Color(255, 255, 255));
        txtOfficeBranch.setText("officeBranch");
        txtOfficeBranch.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtOfficeBranch.setLabelText("Office Branch");
        txtOfficeBranch.setLineColor(new java.awt.Color(255, 93, 172));
        txtOfficeBranch.setPreferredSize(new java.awt.Dimension(210, 46));

        txtAppointmentDate.setEditable(false);
        txtAppointmentDate.setBackground(new java.awt.Color(255, 157, 205));
        txtAppointmentDate.setForeground(new java.awt.Color(255, 255, 255));
        txtAppointmentDate.setText("appointmentDate");
        txtAppointmentDate.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtAppointmentDate.setLabelText("Appointment Date");
        txtAppointmentDate.setLineColor(new java.awt.Color(255, 93, 172));
        txtAppointmentDate.setPreferredSize(new java.awt.Dimension(210, 46));

        txtCurrFrom.setEditable(false);
        txtCurrFrom.setBackground(new java.awt.Color(255, 157, 205));
        txtCurrFrom.setForeground(new java.awt.Color(255, 255, 255));
        txtCurrFrom.setText("currFrom");
        txtCurrFrom.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCurrFrom.setLabelText("From");
        txtCurrFrom.setLineColor(new java.awt.Color(255, 93, 172));
        txtCurrFrom.setPreferredSize(new java.awt.Dimension(89, 46));

        txtCurrTo.setEditable(false);
        txtCurrTo.setBackground(new java.awt.Color(255, 157, 205));
        txtCurrTo.setForeground(new java.awt.Color(255, 255, 255));
        txtCurrTo.setText("currFrom");
        txtCurrTo.setCaretColor(new java.awt.Color(51, 255, 51));
        txtCurrTo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCurrTo.setLabelText("To");
        txtCurrTo.setLineColor(new java.awt.Color(255, 93, 172));
        txtCurrTo.setPreferredSize(new java.awt.Dimension(89, 46));

        javax.swing.GroupLayout containerUserCardLayout = new javax.swing.GroupLayout(containerUserCard);
        containerUserCard.setLayout(containerUserCardLayout);
        containerUserCardLayout.setHorizontalGroup(
            containerUserCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerUserCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(containerUserCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(containerUserCardLayout.createSequentialGroup()
                        .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtOfficeBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerUserCardLayout.createSequentialGroup()
                        .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCurrFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCurrTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        containerUserCardLayout.setVerticalGroup(
            containerUserCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerUserCardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(containerUserCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOfficeBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(containerUserCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurrFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurrTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/btnPrevious_default.png"))); // NOI18N
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aangsutatang/main/images/btnNext_default.png"))); // NOI18N
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        btnCreateNew.setBackground(new java.awt.Color(255, 157, 205));
        btnCreateNew.setBorder(null);
        btnCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateNew.setText("CREATE NEW BOOKING");
        btnCreateNew.setBorderColor(new java.awt.Color(255, 200, 251));
        btnCreateNew.setColor(new java.awt.Color(255, 157, 205));
        btnCreateNew.setColorClick(new java.awt.Color(255, 106, 179));
        btnCreateNew.setColorOver(new java.awt.Color(255, 179, 216));
        btnCreateNew.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreateNew.setPreferredSize(new java.awt.Dimension(471, 37));
        btnCreateNew.setRadius(10);
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerContentLayout = new javax.swing.GroupLayout(containerContent);
        containerContent.setLayout(containerContentLayout);
        containerContentLayout.setHorizontalGroup(
            containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerContentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnPrevious)
                .addGap(25, 25, 25)
                .addGroup(containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerContentLayout.createSequentialGroup()
                        .addComponent(containerUserCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnNext)))
                .addGap(102, 102, 102))
        );
        containerContentLayout.setVerticalGroup(
            containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrevious)
                .addGap(92, 92, 92))
            .addGroup(containerContentLayout.createSequentialGroup()
                .addGroup(containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerContentLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnNext))
                    .addGroup(containerContentLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(containerUserCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnCreateNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(containerSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(containerContent, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imgAppIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose)
                .addGap(19, 19, 19))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnClose)
                .addGap(14, 14, 14)
                .addComponent(imgAppIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(containerSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void menuConvertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConvertMouseClicked
        clientMainPageExchangeUI mpe = new clientMainPageExchangeUI();
        mpe.show();
        this.dispose();
    }//GEN-LAST:event_menuConvertMouseClicked

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        previous();
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        next();
    }//GEN-LAST:event_btnNextMouseClicked

    private void menuAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAccountMouseClicked
        clientAccountPageUI ap = new clientAccountPageUI();
        ap.show();
        this.dispose();
    }//GEN-LAST:event_menuAccountMouseClicked

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        clientNewBookingPage nbp = new clientNewBookingPage();
        nbp.show();
        this.dispose();
    }//GEN-LAST:event_btnCreateNewActionPerformed

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
            java.util.logging.Logger.getLogger(clientMainPageExchangeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientMainPageExchangeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientMainPageExchangeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientMainPageExchangeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientBookingPageUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private com.aangsutatang.main.customButton btnCreateNew;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPrevious;
    private javax.swing.JPanel container;
    private com.aangsutatang.main.PanelRound containerContent;
    private com.aangsutatang.main.PanelRound containerSideMenu;
    private com.aangsutatang.main.PanelRound containerUserCard;
    private javax.swing.JLabel imgAppIcon;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel menuAbout;
    private javax.swing.JLabel menuAccount;
    private javax.swing.JLabel menuBooking;
    private javax.swing.JLabel menuConvert;
    private com.aangsutatang.main.customTextField txtAppointmentDate;
    private com.aangsutatang.main.customTextField txtCurrFrom;
    private com.aangsutatang.main.customTextField txtCurrTo;
    private com.aangsutatang.main.customTextField txtOfficeBranch;
    private com.aangsutatang.main.customTextField txtStaffName;
    // End of variables declaration//GEN-END:variables
}
