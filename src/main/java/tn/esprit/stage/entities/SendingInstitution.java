package tn.esprit.stage.entities;

import java.io.Serializable;
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
public class SendingInstitution implements Serializable {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	
	private String sname,sfacOrDep,serasmusCode,saddress,scountry;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sendinginstitution")
	@JsonIgnore
	List<Candidature> candidature;
	@ManyToOne
	private ContactPerson contactperson;

}
