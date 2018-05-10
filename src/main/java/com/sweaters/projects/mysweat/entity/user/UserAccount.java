package com.sweaters.projects.mysweat.entity.user;

import lombok.Data;

@Data
public class UserAccount {
	public String id;
	public String email;
	public String password;
	public String name;
	public String gender;
	public String birthYear;
	public String cellphone;
	public double height;
	public double weight;

	public UserRank userRank;
}
