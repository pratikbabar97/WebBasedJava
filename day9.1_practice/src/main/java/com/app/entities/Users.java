package com.app.entities;
import java.time.LocalDate;

import javax.persistence.*;

@Entity //mandtaory class level annotation
@Table(name = "users_tbl")//specifies table name

public class Users { 
	
	
	@Id //mandatory adds primary key constraint
//	@GeneratedValue//Hibernate chooses default database specific strategy for auto PK generation
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoIncrement constraint will be added to the table which is best suitable for mySql 
	@Column(name = "user_id")
	private Integer userid;
	
	@Column(length = 20)//varchar(20)
	private String name; 
	
	@Column(length = 20, unique = true)      //varchar(20),uique constraint
	private String email;
	
	@Column(length = 15,nullable = false)//varchar(20),not null
	private String password;
	
	@Transient//skips from persistence(no corresponding column)
	private String confirmPassword;
	
	@Enumerated(EnumType.STRING)//col type varchar
	@Column(name = "user_role",length=20)
	private UserRole userRole;
	
	@Column(name = "reg_amount")
	private double regAmount;
	
	@Column(name="reg_date")
	private LocalDate regDate;//automatically the column type will be date
	
	@Lob//column type blob:longBlob
	private byte[] image;
	
	
//def contr
	public Users() {
		super();
		System.out.println("in user constructor");
	}


public Users(String name, String email, String password, String confirmPassword, UserRole userRole, double regAmount,
		LocalDate regDate) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.userRole = userRole;
	this.regAmount = regAmount;
	this.regDate = regDate;
}


public Integer getUserid() {
	return userid;
}


public void setUserid(Integer userid) {
	this.userid = userid;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
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


public void setPassword(String password) {
	this.password = password;
}


public String getConfirmPassword() {
	return confirmPassword;
}


public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}


public UserRole getUserRole() {
	return userRole;
}


public void setUserRole(UserRole userRole) {
	this.userRole = userRole;
}


public double getRegAmount() {
	return regAmount;
}


public void setRegAmount(double regAmount) {
	this.regAmount = regAmount;
}


public LocalDate getRegDate() {
	return regDate;
}


public void setRegDate(LocalDate regDate) {
	this.regDate = regDate;
}


public byte[] getImage() {
	return image;
}


public void setImage(byte[] image) {
	this.image = image;
}


@Override
public String toString() {
	return "Users [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password
			+ ", confirmPassword=" + confirmPassword + ", userRole=" + userRole + ", regAmount=" + regAmount
			+ ", regDate=" + regDate +"]";
}
	
	
}
