package com.example.test;

import com.example.test.dto.ArrayNumberDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApplicationTest {
	@LocalServerPort
	private int localPort;
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void testPost(){
		String baseUrl = "http://localhost:" + localPort + "/array";
		ArrayList<Long> arrayList = new ArrayList<>(Arrays.asList(3L, 4L, 5L, 6L, 7L, 8L));
		ArrayNumberDto arrayNumberDto = new ArrayNumberDto(arrayList);
		HttpEntity<ArrayNumberDto> resp = new HttpEntity<>(arrayNumberDto);
		ResponseEntity<ArrayNumberDto> response = restTemplate.postForEntity(baseUrl, resp, ArrayNumberDto.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertNotNull(response.getBody());
		Assert.assertNotNull(response.getBody().getArray());
		Assert.assertEquals(Arrays.asList(12L, 30L, 56L), response.getBody().getArray()); // проверка чисел
		Assert.assertEquals(Long.valueOf(0L), response.getBody().getExtraNumber()); // проверка на лишнее число
	}
}
