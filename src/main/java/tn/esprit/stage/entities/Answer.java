package tn.esprit.stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAnswer;
    String answer;

    @ManyToOne
    @JsonIgnore
    private Question question;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Boolean correct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return idAnswer.equals(answer1.idAnswer) && answer.equals(answer1.answer) && correct.equals(answer1.correct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnswer, answer, correct);
    }
}
