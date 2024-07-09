package com.mem.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name ="member")
public class MemVO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="mem_no")
	private Integer memNo;
	
	
	@Column(name ="mem_email" ,unique = true)
	private String memEmail;
	
	@Column(name ="mem_name")
	private String memName;
	
	@Column(name ="mem_password")
	private String memPassword;
	
	
	@Column(name ="mem_address")
	private String memAddress;
	
	
	@Column(name ="mem_phone")
	private String memPhone;
	
	
	@Column(name ="mem_uid")
	private String memUid;
	
	
	@Column(name ="mem_sex")
	private String memSex;
	
	
	@Column(name ="mem_dob")
	private Date memDob;
	
	
	@Column(name ="mem_update")
	private Timestamp memUpdate;
	
	
//	@Column(name ="mem_photo")
////	@NotEmpty(message="照片: 請上傳照片") --> 由MemController.java 第60行處理錯誤信息
//	private byte[] upFiles; //修改 +get.set
//	
	
	
	
	
	
	
  
	
	
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemUid() {
		return memUid;
	}
	public void setMemUid(String memUid) {
		this.memUid = memUid;
	}
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	public Date getMemDob() {
		return memDob;
	}
	public void setMemDob(Date memDob) {
		this.memDob = memDob;
	}
	public Timestamp getMemUpdate() {
		return memUpdate;
	}
	public void setMemUpdate(Timestamp memUpdate) {
		this.memUpdate = memUpdate;
	}
//	public byte[] getUpFiles() {
//		return upFiles;
//	}
//	public void setUpFiles(byte[] upFiles) {
//		this.upFiles = upFiles;
//	}
	
	
	
	
	
}
