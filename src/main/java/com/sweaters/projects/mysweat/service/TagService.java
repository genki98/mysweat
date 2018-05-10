package com.sweaters.projects.mysweat.service;

import com.sweaters.projects.mysweat.entity.tag.TagInfo;
import com.sweaters.projects.mysweat.util.MockupDataUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
	public List<TagInfo> getTagInfoList(String userId) {
		return MockupDataUtil.getTagInfoList();
	}

	public boolean register(String userId, String tagId, String tagName) {
		return true;
	}

	public boolean unregister(String userId, String tagId) {
		return true;
	}

	public boolean edit(String tagId, String tagName) {
		return true;
	}
}
