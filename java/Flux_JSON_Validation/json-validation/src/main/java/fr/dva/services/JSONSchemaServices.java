package fr.dva.services;

import java.io.IOException;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victools.jsonschema.generator.Option;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.jackson.JacksonOption;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import fr.dva.model.Librairie;

@Service
public class JSONSchemaServices {

	public Set<ValidationMessage> validateInputFileFromJsonSchema(final String jsonContent) throws IOException {
		final JsonNode jsonSchema = getJsonSchema();
		ObjectMapper objectMapper = new ObjectMapper();
		final JsonSchema schema = JsonSchemaFactory
				.builder(JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909))
				.objectMapper(objectMapper)
				.build()
				.getSchema(jsonSchema);
		final JsonNode node = objectMapper.readTree(jsonContent);
		return schema.validate(node);
	}

	public JsonNode getJsonSchema() {
		SchemaGenerator generator = getSchemaGenerator();
		return generator.generateSchema(Librairie.class);
	}

	private SchemaGenerator getSchemaGenerator() {
		JavaxValidationModule javaxValidationModule = new JavaxValidationModule(
				JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
		JacksonModule jacksonModule = new JacksonModule(JacksonOption.RESPECT_JSONPROPERTY_REQUIRED,
				JacksonOption.FLATTENED_ENUMS_FROM_JSONVALUE);
		// formatter:off
		SchemaGeneratorConfigBuilder builder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09,
				OptionPreset.PLAIN_JSON)
						.with(Option.PLAIN_DEFINITION_KEYS, Option.SCHEMA_VERSION_INDICATOR,
								Option.FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT)
						.with(javaxValidationModule).with(jacksonModule);
		SchemaGeneratorConfig config = builder.build();
		return new SchemaGenerator(config);
	}

}
