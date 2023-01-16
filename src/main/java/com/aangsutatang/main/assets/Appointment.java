/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aangsutatang.main.assets;

/**
 *
 * @author Nicolas Airel V S
 */
public class Appointment {
    
    protected String aptId;
    protected String staffId;
    protected String clientId;
    
    protected String appointmentDate;
    protected String currFrom;
    protected String currTo;
    protected String status;

    // aptId # staffId # clientId # appointmentDate # officeBranch # status

    public Appointment(String newAptId, String newStaffId, String newClientId, String newAppointmentDate, String newStatus, String newCurrFrom, String newCurrTo) {
        if(!newStatus.equals("OPEN") || !newStatus.equals("DECLINED")){
            this.staffId = newStaffId;
        }
        this.currFrom = newCurrFrom;
        this.currTo = newCurrTo;
        this.aptId = newAptId;
        this.clientId = newClientId;
        this.appointmentDate = newAppointmentDate;
        this.status = "OPEN"; // OPEN;CANCELLED;DECLINED;ACCEPTED;COMPLETED
    }

    // Getter
    public String getAptId() {
        return this.aptId;
    }
    public String getStaffId() {
        return this.staffId;
    }
    public String getClientId() {
        return this.clientId;
    }
    public String getAppointmentDate() {
        return this.appointmentDate;
    }
    public String getStatus() {
        return this.status;
    }
    public String getCurrFrom(){
        return this.currFrom;
    }
    public String getCurrTo(){
        return this.currTo;
    }

    // Setter
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setStaffId(String newStaffId) {
        this.staffId = newStaffId;
    }
}
