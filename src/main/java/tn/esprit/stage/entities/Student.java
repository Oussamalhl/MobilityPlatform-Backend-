package tn.esprit.stage.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
public class Student implements Serializable {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	private String firstName,lastName,nationality,studyCycle,educationField,email;
	private Boolean sex;
	@Temporal (TemporalType.DATE)
	private Date birthDate;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	List<Candidature> candidatures;

}
