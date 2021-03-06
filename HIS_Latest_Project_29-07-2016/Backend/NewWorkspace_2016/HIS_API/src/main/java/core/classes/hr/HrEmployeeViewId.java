package core.classes.hr;

// default package
// Generated Sep 18, 2014 6:25:19 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * HrEmployeeViewId generated by hbm2java
 */
public class HrEmployeeViewId implements java.io.Serializable {

	private int empId;
	private String title;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String gender;
	private String civilStatus;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String nic;
	private String epf;
	private String drivingLicence;
	private String deptName;
	private String designationName;

	public HrEmployeeViewId() {
	}

	public HrEmployeeViewId(int empId, String title, String firstName,
			String lastName, Date birthday, String gender, String civilStatus) {
		this.empId = empId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.civilStatus = civilStatus;
	}

	public HrEmployeeViewId(int empId, String title, String firstName,
			String lastName, Date birthday, String gender, String civilStatus,
			String address, String phone, String mobile, String email,
			String nic, String epf, String drivingLicence, String deptName,
			String designationName) {
		this.empId = empId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.civilStatus = civilStatus;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.nic = nic;
		this.epf = epf;
		this.drivingLicence = drivingLicence;
		this.deptName = deptName;
		this.designationName = designationName;
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCivilStatus() {
		return this.civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNic() {
		return this.nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getEpf() {
		return this.epf;
	}

	public void setEpf(String epf) {
		this.epf = epf;
	}

	public String getDrivingLicence() {
		return this.drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HrEmployeeViewId))
			return false;
		HrEmployeeViewId castOther = (HrEmployeeViewId) other;

		return (this.getEmpId() == castOther.getEmpId())
				&& ((this.getTitle() == castOther.getTitle()) || (this
						.getTitle() != null && castOther.getTitle() != null && this
						.getTitle().equals(castOther.getTitle())))
				&& ((this.getFirstName() == castOther.getFirstName()) || (this
						.getFirstName() != null
						&& castOther.getFirstName() != null && this
						.getFirstName().equals(castOther.getFirstName())))
				&& ((this.getLastName() == castOther.getLastName()) || (this
						.getLastName() != null
						&& castOther.getLastName() != null && this
						.getLastName().equals(castOther.getLastName())))
				&& ((this.getBirthday() == castOther.getBirthday()) || (this
						.getBirthday() != null
						&& castOther.getBirthday() != null && this
						.getBirthday().equals(castOther.getBirthday())))
				&& ((this.getGender() == castOther.getGender()) || (this
						.getGender() != null && castOther.getGender() != null && this
						.getGender().equals(castOther.getGender())))
				&& ((this.getCivilStatus() == castOther.getCivilStatus()) || (this
						.getCivilStatus() != null
						&& castOther.getCivilStatus() != null && this
						.getCivilStatus().equals(castOther.getCivilStatus())))
				&& ((this.getAddress() == castOther.getAddress()) || (this
						.getAddress() != null && castOther.getAddress() != null && this
						.getAddress().equals(castOther.getAddress())))
				&& ((this.getPhone() == castOther.getPhone()) || (this
						.getPhone() != null && castOther.getPhone() != null && this
						.getPhone().equals(castOther.getPhone())))
				&& ((this.getMobile() == castOther.getMobile()) || (this
						.getMobile() != null && castOther.getMobile() != null && this
						.getMobile().equals(castOther.getMobile())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getNic() == castOther.getNic()) || (this.getNic() != null
						&& castOther.getNic() != null && this.getNic().equals(
						castOther.getNic())))
				&& ((this.getEpf() == castOther.getEpf()) || (this.getEpf() != null
						&& castOther.getEpf() != null && this.getEpf().equals(
						castOther.getEpf())))
				&& ((this.getDrivingLicence() == castOther.getDrivingLicence()) || (this
						.getDrivingLicence() != null
						&& castOther.getDrivingLicence() != null && this
						.getDrivingLicence().equals(
								castOther.getDrivingLicence())))
				&& ((this.getDeptName() == castOther.getDeptName()) || (this
						.getDeptName() != null
						&& castOther.getDeptName() != null && this
						.getDeptName().equals(castOther.getDeptName())))
				&& ((this.getDesignationName() == castOther
						.getDesignationName()) || (this.getDesignationName() != null
						&& castOther.getDesignationName() != null && this
						.getDesignationName().equals(
								castOther.getDesignationName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmpId();
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getFirstName() == null ? 0 : this.getFirstName().hashCode());
		result = 37 * result
				+ (getLastName() == null ? 0 : this.getLastName().hashCode());
		result = 37 * result
				+ (getBirthday() == null ? 0 : this.getBirthday().hashCode());
		result = 37 * result
				+ (getGender() == null ? 0 : this.getGender().hashCode());
		result = 37
				* result
				+ (getCivilStatus() == null ? 0 : this.getCivilStatus()
						.hashCode());
		result = 37 * result
				+ (getAddress() == null ? 0 : this.getAddress().hashCode());
		result = 37 * result
				+ (getPhone() == null ? 0 : this.getPhone().hashCode());
		result = 37 * result
				+ (getMobile() == null ? 0 : this.getMobile().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getNic() == null ? 0 : this.getNic().hashCode());
		result = 37 * result
				+ (getEpf() == null ? 0 : this.getEpf().hashCode());
		result = 37
				* result
				+ (getDrivingLicence() == null ? 0 : this.getDrivingLicence()
						.hashCode());
		result = 37 * result
				+ (getDeptName() == null ? 0 : this.getDeptName().hashCode());
		result = 37
				* result
				+ (getDesignationName() == null ? 0 : this.getDesignationName()
						.hashCode());
		return result;
	}

}
