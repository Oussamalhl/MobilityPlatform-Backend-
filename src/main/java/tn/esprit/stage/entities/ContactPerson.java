package tn.esprit.stage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ContactPerson {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	
	private String name,cpemail;
	private int phone;
	
	/*@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contactperson")
	List<ReceivingInstitution> receivinginstitution;*/
	/*@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contactperson")
	List<SendingInstitution> sendinginstitution;*/

}
