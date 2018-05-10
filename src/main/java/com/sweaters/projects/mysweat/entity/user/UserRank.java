package com.sweaters.projects.mysweat.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRank {
	private String title;
	private int level;
}
