package in.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "field is required.")
	@Size(min = 4, max = 30, message = "min 4 chars & max 30 chars allowed")
	private String name;

	@Column(name = "date_of_birth")
	@NotNull(message = "INVALI_DATE_FORMAT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy")
	private String dateOfBirth;

	@NotEmpty(message = "field is required.")
	@Email(message = "please enter valid email adress.")
	@Column(unique = true)
	private String email;

	// @NotEmpty(message = "field is required.")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "please pass only numberic/digits ")
	@NotEmpty(message = "mobile number can't be empty")
	@Column(unique = true)
	private String mobile;
	@NotNull(message = "possible user types are Developer,HR,Manager")
	@Column(name = "user_type")
	private String userType;

	public User() {

	}

	public User(Long id, String name, String dateOfBirth, String email, String mobile, String userType) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile = mobile;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
}
