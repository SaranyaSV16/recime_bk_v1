package com.edex.recime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Register")

public class Register {
@Id    
@GeneratedValue
private int Id;
private String name;
private String mobileNumber;
private String email;
private String password;
private String city;
private String role;

public int getId() {
    return Id;
}
public void setId(int id) {
    Id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getMobileNumber() {
    return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getPassword() {
    return password;
}
public void setPasscode(String password) {
    this.password = password;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public void setPassword(String password) {
	this.password = password;
}

}

