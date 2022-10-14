package com.review.Review.pozo;

/**
 * @author z0049vuf on 10/10/2022
 */
public class Employee {

    String empID;

    public Employee(String empID, String name, String managerId, String departmentId) {
        this.empID = empID;
        this.name = name;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    String name;
    String managerId;
    String departmentId;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
