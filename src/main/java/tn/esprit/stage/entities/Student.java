package tn.esprit.stage.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Student {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	private String firstName,lastName,nationality,studyCycle,educationField,email;
	private Boolean sex;
	@Temporal (TemporalType.DATE)
	private Date birthDate;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	List<Candidature> candidature;



	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cpstudent")
	List<ConfirmationPreselection> confirmationpreselection;
	
	
	

}
