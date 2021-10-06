package fr.dva.model;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import fr.dva.model.validation.ValidDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonClassDescription(value = "Representation d'un auteur.")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Auteur {

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Prenom")
	private String prenom;

	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Nom")
	private String nom;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Date de naissance")
	@ValidDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@Pattern(regexp = "yyyyMMdd")
	private String naissance;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Date de deces")
	@ValidDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@Pattern(regexp = "yyyyMMdd")
	private String deces;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Pays de nationalite")
	private Pays nationalite;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Biographie")
	private String biographie;

}
