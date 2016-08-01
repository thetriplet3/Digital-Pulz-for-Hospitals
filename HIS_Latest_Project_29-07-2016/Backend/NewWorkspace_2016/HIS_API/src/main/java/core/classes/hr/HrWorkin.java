package core.classes.hr;

// default package
// Generated Aug 25, 2014 2:45:14 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * HrWorkin generated by hbm2java
 */
public class HrWorkin implements java.io.Serializable {

	private HrWorkinId id;
	private HrDesignation hrDesignation;
	private HrDepartment hrDepartment;
	private HrEmployee hrEmployee;
	private Date startDate;
	private Date endDate;
	private String description;
	private boolean isActive;

	public HrWorkin() {
	}

	public HrWorkin(HrWorkinId id, HrDesignation hrDesignation,
			HrDepartment hrDepartment, HrEmployee hrEmployee, Date startDate,
			Date endDate, String description, boolean isActive) {
		this.id = id;
		this.hrDesignation = hrDesignation;
		this.hrDepartment = hrDepartment;
		this.hrEmployee = hrEmployee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.isActive = isActive;
	}

	public HrWorkinId getId() {
		return this.id;
	}

	public void setId(HrWorkinId id) {
		this.id = id;
	}

	public HrDesignation getHrDesignation() {
		return this.hrDesignation;
	}

	public void setHrDesignation(HrDesignation hrDesignation) {
		this.hrDesignation = hrDesignation;
	}

	public HrDepartment getHrDepartment() {
		return this.hrDepartment;
	}

	public void setHrDepartment(HrDepartment hrDepartment) {
		this.hrDepartment = hrDepartment;
	}

	public HrEmployee getHrEmployee() {
		return this.hrEmployee;
	}

	public void setHrEmployee(HrEmployee hrEmployee) {
		this.hrEmployee = hrEmployee;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}