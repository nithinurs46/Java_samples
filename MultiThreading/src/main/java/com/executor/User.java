package com.executor;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {

	private int userId;
	private String userName;
	private String emailId;

}
