package com.example.payroll.employeeService;

import com.example.payroll.departmentService.Department;
import com.example.payroll.security.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

  private @Id @GeneratedValue Long id;
  private String name;
  private String role;
  private String email;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  // Constructor
  public Employee() {
  }

  public Employee(String name, String role, String email) {
    this.name = name;
    this.role = role;
    this.email = email;
  }

  // Getter and Setter for id
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  // Getter and Setter for name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Getter and Setter for role
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  // Getter and Setter for email
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Getter and Setter for department
  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  // Getter and Setter for user
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
