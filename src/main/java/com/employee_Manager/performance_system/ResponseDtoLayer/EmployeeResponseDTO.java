package com.employee_Manager.performance_system.ResponseDtoLayer;

public class EmployeeResponseDTO {

    private Integer id;
    private String empcode;
    private String firstname;
    private String lastname;
    private String designation;
    private String departmentname;
    private String managername;
    private Double sal;
    private Long phone;
    private String address;
	private String gender ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    /**
     * @return int return the sal
     */
    public Double getSal() {
        return sal;
    }

    /**
     * @param sal the sal to set
     */
    public void setSal(Double sal) {
        this.sal = sal;
    }

    /**
     * @return int return the phone
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
/**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
	

    @Override
    public String toString() {
        return "EmployeeResponseDTO [id=" + id + ", empcode=" + empcode + ", firstname=" + firstname + ", lastname="
                + lastname + ", designation=" + designation + ", departmentname=" + departmentname + ", managername="
                + managername + "Salaray" + sal + "Address" + address + "gender" +  gender + "Phone " + phone + "]";
    }

    

}
