package com.sweaters.projects.mysweat.service;

import com.sweaters.projects.mysweat.entity.user.UserAccount;
import com.sweaters.projects.mysweat.util.MockupDataUtil;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
	public UserAccount signUp(String email, String name, String gender, String birthYear, String cellphone,
	                          String password) {
		return MockupDataUtil.getUserAccount();
	}

	public void signOff(String userId) {
	}

	public UserAccount login(String email, String password) {
		return MockupDataUtil.getUserAccount();
	}

	public boolean isExistingEmail(String email) {
		return false;
	}

	public String requestIdentificationCode(String name, String gender, String birthYear, String cellphone) {
		return MockupDataUtil.getIdentificationCode();
	}

	public boolean confirmIdentificationCode(String name, String gender, String birthYear, String cellphone,
	                                         String identificationCode) {
		return true;
	}

	public String findEmail(String identificaionCode) {
		return MockupDataUtil.getEmail();
	}

	public String findPassword(String email) {
		return MockupDataUtil.getPassword();
	}

	public boolean changePassword(String userId, String currentPassword, String newPassword1, String newPassowrd2) {
		return true;
	}

	public UserAccount edit(String userId, double height, double weight) {
		return MockupDataUtil.getUserAccount(height, weight);
	}
}
