package com.simple.basic.command;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {
	
	/*
	 * @NotNull - null값만 허용하지 않음.
	 */
	
	@NotNull
	private String name;
	private int salary;
	private String phone;
	private String email;

}
