package com.example.test.controller;

import com.example.test.dto.ArrayNumberDto;
import com.example.test.dto.DateDto;
import com.example.test.service.ArrayService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping
public class ArrayNumberController {
	private final ArrayService arrayService;

	public ArrayNumberController(ArrayService arrayService) {
		this.arrayService = arrayService;
	}

	@PostMapping("/array")
	public ArrayNumberDto parseString(@RequestBody ArrayNumberDto arrayNumberDto) {
		return arrayService.parseArray(arrayNumberDto);
	}

	@GetMapping("/data")
	public DateDto getData()
	{
		DateDto dateDto = new DateDto(new Date());
		return dateDto;
	}
}
