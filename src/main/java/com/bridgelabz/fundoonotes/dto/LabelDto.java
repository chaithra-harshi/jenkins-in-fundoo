package com.bridgelabz.fundoonotes.dto;

import lombok.Data;

/**
 * 
 * @author chaithra B N
 *
 */
@Data
public class LabelDto {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
