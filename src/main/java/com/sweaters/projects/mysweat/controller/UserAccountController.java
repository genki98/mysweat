package com.sweaters.projects.mysweat.controller;

import com.sweaters.projects.mysweat.entity.ApiResponse;
import com.sweaters.projects.mysweat.entity.MessageSet;
import com.sweaters.projects.mysweat.entity.user.UserAccount;
import com.sweaters.projects.mysweat.service.UserAccountService;
import com.sweaters.projects.mysweat.util.NotificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAccountController {
	@Autowired
	UserAccountService userAccountService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ApiResponse signUp(String email, String name, String gender, String birthYear, String cellphone,
	                          String password1, String password2) {
		ApiResponse result = new ApiResponse();
		UserAccount newUserAccount = userAccountService.signUp(email, name, gender, birthYear, cellphone, password1);

		if (newUserAccount != null) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.SIGNUP_SUCCESS);
		} else {
			result.setMessage(MessageSet.SIGNUP_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/check_email", method = RequestMethod.GET)
	public ApiResponse checkEmail(String email) {
		ApiResponse result = new ApiResponse();

		if (!userAccountService.isExistingEmail(email)) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.EMAIL_AVAILABLE);
		} else {
			result.setMessage(MessageSet.EMAIL_DUPLICATED);
		}

		return result;
	}

	@RequestMapping(value = "/request_identification_code", method = RequestMethod.GET)
	public ApiResponse requestIdentificationCode(String name, String gender, String birthYear, String cellphone) {
		ApiResponse result = new ApiResponse();

		String identificationCode = userAccountService.requestIdentificationCode(name, gender, birthYear, cellphone);
		if (!identificationCode.isEmpty()) {
			if (NotificationUtil.sendIdentificationCodeSMS(cellphone, identificationCode)) {
				result.setSuccessful(true);
				result.setMessage(MessageSet.REQUEST_IDENTIFICATION_CODE_SUCCESS);
			} else {
				result.setMessage(MessageSet.REQUEST_IDENTIFICATION_CODE_FAILED);
			}
		} else {
			result.setMessage(MessageSet.USER_NOT_FOUND);
		}

		return result;
	}

	@RequestMapping(value = "/confirm_identification_code", method = RequestMethod.GET)
	public ApiResponse confirmIdentificationCode(String name, String gender, String birthYear, String cellphone,
	                                             String identificationCode) {
		ApiResponse result = new ApiResponse();

		boolean isCorrect = userAccountService.confirmIdentificationCode(name, gender, birthYear, cellphone,
				identificationCode);
		if (isCorrect) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.CONFIRM_IDENTIFICATION_CODE_SUCCESS);
		} else {
			result.setMessage(MessageSet.CONFIRM_IDENTIFICATION_CODE_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ApiResponse login(String email, String password) {
		ApiResponse result = new ApiResponse();

		UserAccount userAccount = userAccountService.login(email, password);
		if (userAccount != null) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.LOGIN_SUCCESS);
			result.setHasReturnObject(true);
			result.setReturnObject(userAccount);
		} else {
			result.setMessage(MessageSet.LOGIN_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/find_email", method = RequestMethod.GET)
	public ApiResponse findEmail(String identificationCode) {
		ApiResponse result = new ApiResponse();

		String email = userAccountService.findEmail(identificationCode);
		if (!email.isEmpty()) {
			result.setSuccessful(true);
			result.setMessage(String.format(MessageSet.FIND_EMAIL_SUCCESS));
			result.setHasReturnObject(true);
			result.setReturnObject(email);
		} else {
			result.setMessage(String.format(MessageSet.FIND_EMAIL_FAILED));
		}
		return result;
	}

	@RequestMapping(value = "/find_password", method = RequestMethod.GET)
	public ApiResponse findPassword(String identificationCode) {
		ApiResponse result = new ApiResponse();

		String email = userAccountService.findEmail(identificationCode);
		String newPassword = userAccountService.findPassword(email);
		if (NotificationUtil.sendPasswordResetEmail(email, newPassword)) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.FIND_PASSWORD_SUCCESS);
		} else {
			result.setMessage(MessageSet.FIND_PASSWORD_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/change_password", method = RequestMethod.POST)
	public ApiResponse changePassword(String userId, String currentPassword, String newPassword1, String newPassword2) {
		ApiResponse result = new ApiResponse();

		boolean isChanged = userAccountService.changePassword(userId, currentPassword, newPassword1, newPassword2);
		if (isChanged) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.CHANGE_PASSWORD_SUCCESS);
		} else {
			result.setMessage(MessageSet.CHANGE_PASSWORD_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ApiResponse edit(String userId, double height, double weight) {
		ApiResponse result = new ApiResponse();

		UserAccount userAccount = userAccountService.edit(userId, height, weight);
		if (userAccount != null) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.EDIT_USERACCOUNT_SUCCESS);
		} else {
			result.setMessage(MessageSet.EDIT_USERACCOUNT_FAILED);
		}

		return result;
	}
}
