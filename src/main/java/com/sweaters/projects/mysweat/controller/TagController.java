package com.sweaters.projects.mysweat.controller;

import com.sweaters.projects.mysweat.entity.ApiResponse;
import com.sweaters.projects.mysweat.entity.MessageSet;
import com.sweaters.projects.mysweat.entity.tag.TagInfo;
import com.sweaters.projects.mysweat.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	TagService tagService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ApiResponse getRegisteredTagList(String userId) {
		ApiResponse result = new ApiResponse();

		List<TagInfo> tagInfoList = tagService.getTagInfoList(userId);
		result.setSuccessful(true);
		result.setMessage(MessageSet.OK);
		result.setHasReturnObject(true);
		result.setReturnObject(tagInfoList);

		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ApiResponse registerTag(String userId, String tagId, String tagName) {
		ApiResponse result = new ApiResponse();

		boolean isRegisterd = tagService.register(userId, tagId, tagName);
		if (isRegisterd) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.REGISTER_TAG_SUCCESS);
		} else {
			result.setMessage(MessageSet.REGISTER_TAG_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public ApiResponse unregisterTag(String userId, String tagId) {
		ApiResponse result = new ApiResponse();

		boolean isUnregistered = tagService.unregister(userId, tagId);
		if (isUnregistered) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.UNREGISTER_TAG_SUCCESS);
		} else {
			result.setMessage(MessageSet.UNREGISTER_TAG_FAILED);
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ApiResponse unregisterTag(String userId, String tagId, String tagName) {
		ApiResponse result = new ApiResponse();

		boolean isEdited = tagService.edit(tagId, tagName);
		if (isEdited) {
			result.setSuccessful(true);
			result.setMessage(MessageSet.EDIT_TAG_SUCCESS);
		} else {
			result.setMessage(MessageSet.EDIT_TAG_FAILED);
		}

		return result;
	}
}
