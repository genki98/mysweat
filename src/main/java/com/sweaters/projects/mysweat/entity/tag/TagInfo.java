package com.sweaters.projects.mysweat.entity.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagInfo {
	private String tagId;
	private String tagName;
	private String registerdDateTime;
	private String unregisterdDateTime;
}
