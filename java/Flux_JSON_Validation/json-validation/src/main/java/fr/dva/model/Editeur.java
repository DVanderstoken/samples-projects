package fr.dva.model;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonClassDescription(value = "Representation d'un editeur.")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Editeur {

	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Nom de l'editeur (de la maison d'edition)")
	private String nom;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "logo de la maison d'edition")
	private byte[] logo;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "URL du site Internet de la maison d'edition")
	private String webSiteURL;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Coorodnnees de la maison d'edition")
	private Coordonnees coordonnees;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Maison mere")
	private Editeur maisonMere;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Liste des collections d'ouvrages de la maison d'edition")
	@Valid
	private List<Collection> collections;
}
