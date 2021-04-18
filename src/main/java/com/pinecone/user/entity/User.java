package com.pinecone.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@NotNull
	@NotBlank
	@Min(1)
	private String firstName;

	@NotNull
	@NotBlank
	@Min(1)
	private String lastName;
	
	@NotNull
	@NotBlank
	@Min(1)
	@Email(message = "Not a Valid Email")
	private String emailId;
	
	@NotNull
	private Long departmentId;
}
