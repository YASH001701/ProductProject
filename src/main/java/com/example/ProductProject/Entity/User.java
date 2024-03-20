package com.example.ProductProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	private int userId;
	@NotNull
	private String userName;
	@Min(value = 6000001,message = "Phone number is invalid,Should be greater than 60000000")
	@Max(value = 9000001,message = "phone number is invaild,shooulld be less than 88888888")
	private long phoneNo;
	private String email;
	private String password;

}
