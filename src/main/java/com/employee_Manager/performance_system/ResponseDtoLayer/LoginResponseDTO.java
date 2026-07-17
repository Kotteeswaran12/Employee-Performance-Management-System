package com.employee_Manager.performance_system.ResponseDtoLayer;

public class LoginResponseDTO {

    private String token;
    private String Role;
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginResponseDTO() {
        super();
        
    }

}
