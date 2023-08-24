package in.fssa.mynotes.model;

public abstract class UserEntity {
	
	private int id;
	private String user_name;
	private String email;
	private String password;
	private boolean is_active;
	
	public UserEntity() {
		
	}
	
	public UserEntity(int id, String user_name, String email, String password, boolean is_active) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.is_active = is_active;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return user_name;
	}
	public void setName(String user_name) {
		this.user_name = user_name;
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
	public boolean isActive() {
		return is_active;
	}
	public void setActive(boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", email=" + email + 
				 ", password=" + password + ", is_active=" + is_active + "]";
	}
	
	public int compareTo(UserEntity o) {

		if (this.getId() == o.getId()) {
			return 0;
		} else {
			if (this.getId() > o.getId()) {
				return 1;
			} else {
				return -1;
			}
//			 return ( this.getId() > o.getId()) ? 1: -1;
		}
	}

}