/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aangsutatang.main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

import com.aangsutatang.main.assets.Appointment;
import com.aangsutatang.main.assets.Staff;

/**
 *
 * @author Nicolas Airel V S
 */
public class clientNewBookingPage extends javax.swing.JFrame {
    static ArrayList<Appointment> appointmentList = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    static int currIndex = 0;
    
    // User data field
    static String clientId;
    static String username;
    
    public static void readActiveUser(){
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
    
    public static void readStaff(){
        try {
            // Read staff account data
            File staffData = new File("staffList.txt");
            Scanner myReader2 = new Scanner(staffData);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                String[] temp = data.split("#");
                staffList.add(new Staff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
                System.out.printf("[INFO] Inputted staff with Id %s\n", temp[0]);
            }
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeAppointment() {
        try {
            File database = new File("appointmentList.txt");
            Scanner reader = new Scanner(database);
            while (reader.hasNextLine()) {
                String temp = reader.nextLine();
                String[] tokens = temp.split("#");
                if(tokens[2].equals(clientId)){
                    // 0, 1, 2, 3, 6, 4, 5
                    appointmentList.add(new Appointment(tokens[0], tokens[1], tokens[2], tokens[3], tokens[6], tokens[4], tokens[5]));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void setTxtClientName(){
        txtClientName.setText(username);
    }
    
    public void appendStrToFile(String fileName, String str)
    {
        // Try block to check for exceptions
        try {
            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
 
            // Writing on output stream
            out.write(str);
            // Closing the connection
            out.close();
        }
 
        // Catch block to handle the exceptions
        catch (IOException e) {
 
            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }
    }
    
    public int countAppointment(){
        int counter = 1;
        try {
            File myObj = new File("appointmentList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return counter;
    }
    
    public int generate(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
    
    public String searchStaff(String officeBranch){
        ArrayList<Staff> staffAvailable = new ArrayList<>();
        
        // List any suitable staff based on office branch option
        for(int i = 0 ; i < staffList.size() ; i++){
            if(staffList.get(i).getOfficeBranch().equals(officeBranch)){
                staffAvailable.add(staffList.get(i));
            }
        }
        
        // Assign booking to random suitable staff
        return staffAvailable.get(generate(0, staffAvailable.size() - 1)).getUserId();
    }
    
    public void createNewAppointment(){
        String tempAppointmentDate = txtAppointmentDate.getText();
        String tempCurrFrom = cmbCurrFrom.getSelectedItem().toString();
        String tempCurrTo = cmbCurrTo.getSelectedItem().toString();
        int appointmentSum = countAppointment();
        
        // Nyari staff yang ada di office branch tertentu
        String staffId = searchStaff(cmbOfficeBranch.getSelectedItem().toString());
        
        String temp = "\nAPT" + appointmentSum + "#" + 
                staffId + "#" + 
                clientId + "#" + 
                tempAppointmentDate + "#" + 
                tempCurrFrom + "#" + 
                tempCurrTo + "#" + 
                "ACCEPTED";
        
        appendStrToFile("appointmentList.txt", temp);
    }
    
    public clientNewBookingPage() {
        initComponents();
        readActiveUser();
        readStaff();
        setTxtClientName();
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
        date = new com.raven.datechooser.DateChooser();
        container = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        imgAppIcon = new javax.swing.JLabel();
        containerSideMenu = new com.aangsutatang.main.PanelRound();
        menuConvert = new javax.swing.JLabel();
        menuBooking = new javax.swing.JLabel();
        menuAccount = new javax.swing.JLabel();
        menuAbout = new javax.swing.JLabel();
        containerContent = new com.aangsutatang.main.PanelRound();
        containerForm = new com.aangsutatang.main.PanelRound();
        txtClientName = new com.aangsutatang.main.customTextField();
        txtAppointmentDate = new com.aangsutatang.main.customTextField();
        cmbOfficeBranch = new combobox.Combobox();
        cmbCurrFrom = new combobox.Combobox();
        cmbCurrTo = new combobox.Combobox();
        btnCreate = new com.aangsutatang.main.customButton();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        date.setDateFormat("yyyy-MM-dd");
        date.setTextRefernce(txtAppointmentDate);

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

        containerForm.setBackground(new java.awt.Color(255, 157, 205));
        containerForm.setFocusable(false);
        containerForm.setPreferredSize(new java.awt.Dimension(471, 169));
        containerForm.setRoundBottomLeft(20);
        containerForm.setRoundBottomRight(20);
        containerForm.setRoundTopLeft(20);
        containerForm.setRoundTopRight(20);

        txtClientName.setEditable(false);
        txtClientName.setBackground(new java.awt.Color(255, 157, 205));
        txtClientName.setForeground(new java.awt.Color(255, 255, 255));
        txtClientName.setText("clientName");
        txtClientName.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtClientName.setLabelText("Username");
        txtClientName.setLineColor(new java.awt.Color(255, 93, 172));
        txtClientName.setPreferredSize(new java.awt.Dimension(210, 46));

        txtAppointmentDate.setEditable(false);
        txtAppointmentDate.setBackground(new java.awt.Color(255, 157, 205));
        txtAppointmentDate.setForeground(new java.awt.Color(255, 255, 255));
        txtAppointmentDate.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtAppointmentDate.setLabelText("Appointment Date");
        txtAppointmentDate.setLineColor(new java.awt.Color(255, 93, 172));
        txtAppointmentDate.setPreferredSize(new java.awt.Dimension(210, 46));

        cmbOfficeBranch.setBackground(new java.awt.Color(255, 157, 205));
        cmbOfficeBranch.setForeground(new java.awt.Color(255, 255, 255));
        cmbOfficeBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WangSheng Money Exchange", "Northland Bank" }));
        cmbOfficeBranch.setSelectedIndex(1);
        cmbOfficeBranch.setLabeText("Office Branch");
        cmbOfficeBranch.setLineColor(new java.awt.Color(255, 93, 172));
        cmbOfficeBranch.setPreferredSize(new java.awt.Dimension(210, 46));

        cmbCurrFrom.setBackground(new java.awt.Color(255, 157, 205));
        cmbCurrFrom.setForeground(new java.awt.Color(255, 255, 255));
        cmbCurrFrom.setMaximumRowCount(5);
        cmbCurrFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "DZD", "AOA", "ARS", "AMD", "AUD", "EUR", "AZN", "BHD", "BBD", "BYN", "EUR", "BMD", "BOB", "BAM", "BWP", "BRL", "BGN", "CVE", "KHR", "XAF", "CAD", "KYD", "XAF", "CLP", "CNY", "COP", "CDF", "XAF", "CRC", "HRK", "EUR", "CZK", "DKK", "DOP", "USD", "EGP", "USD", "XAF", "EUR", "ETB", "FJD", "EUR", "EUR", "XAF", "GEL", "EUR", "GHS", "GIP", "EUR", "DKK", "GTQ", "GBP", "GYD", "HNL", "HKD", "HUF", "ISK", "INR", "IDR", "IQD", "EUR", "IMP", "ILS", "EUR", "XOF", "JMD", "JPY", "GBP", "JOD", "KZT", "KES", "KRW", "EUR", "KWD", "KGS", "LAK", "EUR", "LBP", "LYD", "CHF", "EUR", "EUR", "MOP", "MGA", "MWK", "MYR", "MVR", "EUR", "MRU", "MUR", "MXN", "MDL", "MNT", "EUR", "MAD", "MZN", "MMK", "NAD", "EUR", "NZD", "NIO", "NGN", "MKD", "NOK", "OMR", "PKR", "ILS", "PAB", "PGK", "PYG", "PEN", "PHP", "PLN", "EUR", "USD", "QAR", "RON", "RUB", "RWF", "XCD", "SAR", "XOF", "RSD", "SGD", "EUR", "EUR", "ZAR", "EUR", "LKR", "SZL", "SEK", "CHF", "TWD", "TJS", "TZS", "THB", "USD", "TTD", "TND", "TRY", "TMT", "UGX", "UAH", "AED", "GBP", "USD", "UYU", "UZS", "VEF", "VND", "ZMW", "ZWD" }));
        cmbCurrFrom.setSelectedIndex(35);
        cmbCurrFrom.setLabeText("From");
        cmbCurrFrom.setLineColor(new java.awt.Color(255, 93, 172));
        cmbCurrFrom.setPreferredSize(new java.awt.Dimension(89, 46));

        cmbCurrTo.setBackground(new java.awt.Color(255, 157, 205));
        cmbCurrTo.setForeground(new java.awt.Color(255, 255, 255));
        cmbCurrTo.setMaximumRowCount(5);
        cmbCurrTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "DZD", "AOA", "ARS", "AMD", "AUD", "EUR", "AZN", "BHD", "BBD", "BYN", "EUR", "BMD", "BOB", "BAM", "BWP", "BRL", "BGN", "CVE", "KHR", "XAF", "CAD", "KYD", "XAF", "CLP", "CNY", "COP", "CDF", "XAF", "CRC", "HRK", "EUR", "CZK", "DKK", "DOP", "USD", "EGP", "USD", "XAF", "EUR", "ETB", "FJD", "EUR", "EUR", "XAF", "GEL", "EUR", "GHS", "GIP", "EUR", "DKK", "GTQ", "GBP", "GYD", "HNL", "HKD", "HUF", "ISK", "INR", "IDR", "IQD", "EUR", "IMP", "ILS", "EUR", "XOF", "JMD", "JPY", "GBP", "JOD", "KZT", "KES", "KRW", "EUR", "KWD", "KGS", "LAK", "EUR", "LBP", "LYD", "CHF", "EUR", "EUR", "MOP", "MGA", "MWK", "MYR", "MVR", "EUR", "MRU", "MUR", "MXN", "MDL", "MNT", "EUR", "MAD", "MZN", "MMK", "NAD", "EUR", "NZD", "NIO", "NGN", "MKD", "NOK", "OMR", "PKR", "ILS", "PAB", "PGK", "PYG", "PEN", "PHP", "PLN", "EUR", "USD", "QAR", "RON", "RUB", "RWF", "XCD", "SAR", "XOF", "RSD", "SGD", "EUR", "EUR", "ZAR", "EUR", "LKR", "SZL", "SEK", "CHF", "TWD", "TJS", "TZS", "THB", "USD", "TTD", "TND", "TRY", "TMT", "UGX", "UAH", "AED", "GBP", "USD", "UYU", "UZS", "VEF", "VND", "ZMW", "ZWD" }));
        cmbCurrTo.setSelectedIndex(59);
        cmbCurrTo.setLabeText("To");
        cmbCurrTo.setLineColor(new java.awt.Color(255, 93, 172));
        cmbCurrTo.setPreferredSize(new java.awt.Dimension(89, 46));

        javax.swing.GroupLayout containerFormLayout = new javax.swing.GroupLayout(containerForm);
        containerForm.setLayout(containerFormLayout);
        containerFormLayout.setHorizontalGroup(
            containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerFormLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerFormLayout.createSequentialGroup()
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cmbOfficeBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerFormLayout.createSequentialGroup()
                        .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCurrFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(cmbCurrTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        containerFormLayout.setVerticalGroup(
            containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerFormLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOfficeBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCurrFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCurrTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnCreate.setBackground(new java.awt.Color(255, 157, 205));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("CREATE");
        btnCreate.setBorderColor(new java.awt.Color(255, 200, 251));
        btnCreate.setColor(new java.awt.Color(255, 157, 205));
        btnCreate.setColorClick(new java.awt.Color(255, 132, 192));
        btnCreate.setColorOver(new java.awt.Color(255, 172, 213));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreate.setRadius(10);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerContentLayout = new javax.swing.GroupLayout(containerContent);
        containerContent.setLayout(containerContentLayout);
        containerContentLayout.setHorizontalGroup(
            containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerContentLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(containerForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(177, 177, 177))
        );
        containerContentLayout.setVerticalGroup(
            containerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerContentLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(containerForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        createNewAppointment();
        clientBookingPageUI bp = new clientBookingPageUI();
        bp.show();
        this.dispose();
    }//GEN-LAST:event_btnCreateActionPerformed

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
                new clientNewBookingPage().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private com.aangsutatang.main.customButton btnCreate;
    private combobox.Combobox cmbCurrFrom;
    private combobox.Combobox cmbCurrTo;
    private combobox.Combobox cmbOfficeBranch;
    private javax.swing.JPanel container;
    private com.aangsutatang.main.PanelRound containerContent;
    private com.aangsutatang.main.PanelRound containerForm;
    private com.aangsutatang.main.PanelRound containerSideMenu;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel imgAppIcon;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel menuAbout;
    private javax.swing.JLabel menuAccount;
    private javax.swing.JLabel menuBooking;
    private javax.swing.JLabel menuConvert;
    private com.aangsutatang.main.customTextField txtAppointmentDate;
    private com.aangsutatang.main.customTextField txtClientName;
    // End of variables declaration//GEN-END:variables
}
