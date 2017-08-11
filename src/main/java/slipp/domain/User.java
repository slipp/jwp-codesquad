package slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	Long id;

	@Column(name = "u_id", nullable = false, unique = true, length = 25)
	String userId;

	@Column(nullable = false, length = 25)
	String password;

	@Column(nullable = false, length = 25)
	String name;

	@Column(length = 50)
	String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean update(User user) {
		if (matchPassword(user.password)) {
			this.name = user.name;
			this.email = user.email;
			
			return true;
		}
		
		return false;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public boolean matchId(Long id) {
		return this.id.equals(id);
	}

	

}
