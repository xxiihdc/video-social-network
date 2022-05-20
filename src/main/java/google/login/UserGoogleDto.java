package google.login;

public class UserGoogleDto {
	private String id;
	private String email;
	private String name;
	private String giveName;
	private String familyName;
	private String picture;
	private boolean verifiedEmail;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGiveName() {
		return giveName;
	}
	public void setGiveName(String giveName) {
		this.giveName = giveName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isVerifiedEmail() {
		return verifiedEmail;
	}
	public void setVerifiedEmail(boolean verifiedEmail) {
		this.verifiedEmail = verifiedEmail;
	}
	public UserGoogleDto(String id, String email, String name, String giveName, String familyName, String picture,
			boolean verifiedEmail) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.giveName = giveName;
		this.familyName = familyName;
		this.picture = picture;
		this.verifiedEmail = verifiedEmail;
	}
	public UserGoogleDto() {
		
	}
	@Override
	public String toString() {
		return "UserGoogleDTO [id=" + id + ", email=" + email + ", name=" + name + ", giveName=" + giveName
				+ ", familyName=" + familyName + ", picture=" + picture + ", verifiedEmail=" + verifiedEmail + "]";
	}
	
}