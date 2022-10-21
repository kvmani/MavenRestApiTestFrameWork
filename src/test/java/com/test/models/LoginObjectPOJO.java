package com.test.models;

public class LoginObjectPOJO {
 private String username;
 private String password;
 
 public LoginObjectPOJO (String usrName, String pwd) {
	 this.username=usrName;
	 this.password= pwd;
 }
 public String getUsername() {
	 return username;
 }
 public void setUsername(String usrname) {
	 this.username=usrname;
 }
 public String getPassword() {
	 return password;
 }
 public void setPassWord(String pwd) {
	 this.password=pwd;
 }
}

