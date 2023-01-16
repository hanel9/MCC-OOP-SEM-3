/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aangsutatang.main.assets;

/**
 *
 * @author Nicolas Airel V S
 */
public class Staff extends User{
    protected String officeBranch;
    
    

    public Staff(String newUserId, String newUserType, String newOfficeBranch, String newName, String newUsername, String newPassword){
        this.userId = newUserId;
        this.userType = newUserType;
        this.officeBranch = newOfficeBranch;
        this.name = newName;
        this.username = newUsername;
        this.password = newPassword;
    }
    
    // Getter
//    public String getStaffId(){
//        return this.userId;
//    }
//    public String getStaffName(){
//        return this.name;
//    }
    public String getOfficeBranch(){
        return this.officeBranch;
    }
}

