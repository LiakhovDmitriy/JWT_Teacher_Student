package com.gmail.dimaliahov.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gmail.dimaliahov.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties (ignoreUnknown = true)
public class UserDto {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;

	public static UserDto fromUser (User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());

		return userDto;
	}

	public User toUser () {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		return user;
	}

	@Override
	public String toString () {
		return "UserDto{" +
				"id=" + id +
				", username='" + username + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
