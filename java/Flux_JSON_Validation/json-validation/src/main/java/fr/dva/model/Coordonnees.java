package fr.dva.model;

import java.util.List;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonClassDescription(value = "Representation de coordoonnees.")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coordonnees {
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Adresse(s) mail(s) de contact")
	@Email
	private List<String> adressesMails;
	
	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Adresse de contact")
	private Adresse adresse;
	

}
