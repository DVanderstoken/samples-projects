package fr.dva.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonClassDescription(value = "Representation d'une collection.")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Collection {
	
	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Nom de la collection")
	private String nom;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Collection parent")
	private Collection collectionParent;

}
