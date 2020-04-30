package com.example.test.dto;

import java.util.List;

public class ArrayNumberDto {
	private List<Long> array;
	private Long extraNumber;

	public ArrayNumberDto() {}

	public ArrayNumberDto(List<Long> array) {
		this.array = array;
		this.extraNumber = 0L;
	}

	public List<Long> getArray() {
		return array;
	}

	public void setArray(List<Long> array) {
		this.array = array;
	}

	public Long getExtraNumber() {
		return extraNumber;
	}

	public void setExtraNumber(Long extraNumber) {
		this.extraNumber = extraNumber;
	}
}
