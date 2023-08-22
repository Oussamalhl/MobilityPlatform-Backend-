package tn.esprit.stage.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Candidature {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;



@ManyToOne
private Student student;
@ManyToOne
private SendingInstitution sendinginstitution;
@ManyToOne
private ReceivingInstitution receivinginstitution;

	 
	
	

}
