package com.employee_Manager.performance_system.RequestDTO;

public class ChangePassDTO {

    private String currentPass;
    private String newPass;

    /**
     * @return String return the currentPass
     */
    public String getCurrentPass() {
        return currentPass;
    }

    /**
     * @param currentPass the currentPass to set
     */
    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    /**
     * @return String return the newPass
     */
    public String getNewPass() {
        return newPass;
    }

    /**
     * @param newPass the newPass to set
     */
    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public ChangePassDTO(String currentPass, String newPass) {
        this.currentPass = currentPass;
        this.newPass = newPass;
    }

}
