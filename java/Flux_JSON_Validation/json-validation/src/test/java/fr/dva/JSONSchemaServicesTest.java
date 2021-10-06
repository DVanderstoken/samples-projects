package fr.dva;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.ValidationMessage;

import fr.dva.services.JSONSchemaServices;

@SpringBootTest
public class JSONSchemaServicesTest {

	@Autowired
	private JSONSchemaServices services;

	@Test
	@Order(value = 10)
	public void OutputJSONSchemaForLibrairieClass() {
		String result = services.getJsonSchema().toPrettyString();
		assertNotNull(result);
	}

	@Test
	@Order(value = 20)
	public void validateFakeLibrairieDatasFile() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File dataFile = new File("src/test/resources/librairie-fake-datas.json");
		assertTrue(dataFile.exists());
		JsonNode node = objectMapper.readTree(dataFile);
		Set<ValidationMessage> errors = services.validateInputFileFromJsonSchema(node.toString());
		errors.forEach(error -> System.out.println(error.toString()));
		assertTrue(errors.isEmpty());
	}
}
