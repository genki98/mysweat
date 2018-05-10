package com.sweaters.projects.mysweat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
	private boolean successful;
	private String message;
	private boolean hasReturnObject;
	private Object returnObject;

	public ApiResponse() {
		this.successful = false;
		this.hasReturnObject = false;
	}
}
