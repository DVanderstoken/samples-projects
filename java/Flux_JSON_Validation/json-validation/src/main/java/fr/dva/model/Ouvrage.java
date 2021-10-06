package fr.dva.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import fr.dva.model.validation.ValidDate;
import fr.dva.model.validation.ValidGS1;
import fr.dva.model.validation.ValidISBN;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonClassDescription(value = "Representation d'un ouvrage (d'un livre).")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ouvrage {

	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Titre de l'ouvrage")
	private String titre;

	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Editeur (ou edition)")
	private Editeur editeur;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Collection")
	private Collection collection;

	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Numero ISBN")
	@Pattern(regexp = "\\d{3}-\\d-\\d{4}-\\d{4}-\\d")
	@ValidISBN
	private String ISBN;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Numero EAN (Code Barre)")
	@Pattern(regexp = "\\d{8,18}")
	@ValidGS1
	private String EAN;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Date de parution")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@Pattern(regexp = "yyyyMMdd")
	@ValidDate
	private String parution;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Reference (dans la collection)")
	private String reference;

	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Resume")
	private String resume;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Auteur(s)")
	@Valid
	private List<Auteur> auteurs;

	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Couverture")
	private byte[] premiereDeCouverture;

}
