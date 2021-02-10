package com.hari.restapi.services.repository.user.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Table(name = "USER_MTB")
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "IS_AUTHENTICATED")
	private Boolean isAuthenticated;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "VERSION")
	@Version
	private Long version;

}
