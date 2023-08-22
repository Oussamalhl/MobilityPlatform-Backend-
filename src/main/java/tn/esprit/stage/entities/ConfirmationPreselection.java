package tn.esprit.stage.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ToString
public class ConfirmationPreselection {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    Long id;
    Boolean Confirmed,Preselected;
    Date PreselectectionD,ConfirmationD;
    @ManyToOne
    private Student cpstudent;


}
