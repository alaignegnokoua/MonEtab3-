package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
 //@Table(name="student")
@DiscriminatorValue(value="student")
public class Student extends Person{

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

     */

    @Column(name="classe")
    private String classe;

    @Column(name="matricule")
    private String matricule;
}
