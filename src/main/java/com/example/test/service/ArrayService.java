package com.example.test.service;

import com.example.test.dto.ArrayNumberDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ArrayService {
	public ArrayNumberDto parseArray(ArrayNumberDto arrayNumberDto) {
		List<Long> parseArray = arrayNumberDto.getArray();
		List<Long> result = new ArrayList<>();
		int sizeArray = arrayNumberDto.getArray().size();

		for (int i = 0; i < sizeArray - 1; i += 2) {
			result.add(parseArray.get(i) * parseArray.get(i + 1));
		}
		if (!isEven(arrayNumberDto.getArray().size())) {
			arrayNumberDto.setExtraNumber(parseArray.get(parseArray.size() - 1));
		}
		arrayNumberDto.setArray(result);
		return arrayNumberDto;
	}

	private boolean isEven(int number) {
		return number % 2 == 0;
	}
}
