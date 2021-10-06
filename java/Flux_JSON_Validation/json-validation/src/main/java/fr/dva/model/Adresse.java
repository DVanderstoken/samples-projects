package fr.dva.model;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dvenderstoken
 * @see <a href=
 *      "https://www.espacetechniqueetqualite.laposte.fr/sites/cw_u1/files/inline-files/Guide-pratique-Courrier-Jan2019.pdf">Guide
 *      pratique courrier - La Poste, janvier 2019</a>
 * 
 *      Modèle de représentation d'une adresse selon les préconisations de La
 *      Poste. Toutes les adresses doivent au moins comporter les lignes 1, 4 et
 *      6. La ligne 6 est obligatoirement en majuscules non accentuées et sans
 *      caractère de ponctuation. Les lignes 2, 3 et 5 doivent apparaître si des
 *      éléments constitutifs existent.
 */
@Data
@NoArgsConstructor
@JsonClassDescription(value = "Representation d'une adresse.")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adresse {

	/**
	 * Qualité, prénom et nom. Eventuellement titre ou profession
	 * 
	 */
	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Qualite, prenom et nom. Eventuellement titre ou profession")
	private String ligne1;

	/**
	 * Numéro de boîte aux lettres ou appartement, ou Chez ..., ou Escalier, étage
	 * 
	 */
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Numero de boite aux lettres ou appartement, ou Chez ..., ou Escalier, etage")
	private String ligne2;

	/**
	 * Entrée, Tour, Imeuble, Batiment, Résidence, Zone Industrielle, ...
	 */
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Entree, Tour, Imeuble, Batiment, Residence, Zone Industrielle, ...")
	private String ligne3;

	/**
	 * Numéro de la voie, type et nom de la voie
	 * 
	 */
	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Numero de la voie, type et nom de la voie")
	private String ligne4;

	/**
	 * Lieu dit, ou Service particulier de distribution (BP)
	 * 
	 */
	@JsonProperty(required = false)
	@JsonPropertyDescription(value = "Lieu dit, ou Service particulier de distribution (BP)")
	private String ligne5;

	/**
	 * Code postal et localité de destination
	 */
	@JsonProperty(required = true)
	@JsonPropertyDescription(value = "Code postal et localite de destination")
	@Pattern(regexp = "\\d{5}\\s\\w+")
	private String ligne6;

}
