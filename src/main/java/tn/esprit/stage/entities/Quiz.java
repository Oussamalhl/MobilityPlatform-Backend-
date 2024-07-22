package tn.esprit.stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long quizId;
    int requiredToSuccess;

    @OneToMany(mappedBy="quiz", cascade = CascadeType.ALL)
    private Set<Question> questions;

    @OneToOne(mappedBy = "quiz")
    @JsonIgnore
    Candidature candidature;
}