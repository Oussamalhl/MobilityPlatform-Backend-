package tn.esprit.stage.entities;


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

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Candidature implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Boolean confirmed,preselected;

    private Boolean quizPass;

    private String specialty;
    private Date confirmationD;
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER)
    private SendingInstitution sendinginstitution;
    @ManyToOne(fetch = FetchType.EAGER)
    private ReceivingInstitution receivinginstitution;
    @OneToOne(cascade = CascadeType.ALL)
    Quiz quiz;

}
