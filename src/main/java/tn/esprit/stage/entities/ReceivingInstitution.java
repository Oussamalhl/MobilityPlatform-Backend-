package tn.esprit.stage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceivingInstitution {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	
	private String organisationLegalName;
	private String proposalNumber;
	private String pic;
	private String oid;
	//private String facOrDep;
	private String erasmusCode;
	private String street;
	private String postalCode;
	private String city;
	private String country;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receivinginstitution")
	List<Candidature> candidature;
	@ManyToOne
	private ContactPerson contactperson;
	

}
