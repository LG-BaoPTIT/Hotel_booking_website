package learncode.spring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
	@Id
	@Column(name="userName",length = 50)
	private String userName;
	
	@Column(name="passWord",length = 50)
	private String passWord;
	
	@Column(name="fullName",length = 50)
	private String fullName;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="gender")
	private boolean gender;
	public User() {
		super();
	}
	public User(String userName, String passWord, String fullName, Integer age, boolean gender) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", fullName=" + fullName + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
}
