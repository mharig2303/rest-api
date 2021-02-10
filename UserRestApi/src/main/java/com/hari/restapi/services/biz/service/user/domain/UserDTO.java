package com.hari.restapi.services.biz.service.user.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String userId;

	private String password;

	private String displayName;

	private String emailId;

	private String mobileNumber;

	private Boolean isAuthenticated;

	private String createdBy;

	private Date createdDate;

	private String modifiedBy;

	private Date modifiedDate;

	private String status;

	private Long version;

}
