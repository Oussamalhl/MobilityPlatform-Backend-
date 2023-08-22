package tn.esprit.stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hei {
	
	private String proposalNumber,
	erasmusCode,pic,oid,organisationLegalName,street,
	postalCode,city,country,webpage;
	

}
