package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="teacher")
//@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;*/

    @Column(name="matiere", nullable=false)
    private String matiere;

    @Column(name="genre" , nullable = false)
    private String genre;
    /*
    @OneToMany(fetch = FetchType.EAGER,mappedBy ="teacher")
    private Set<FicheNote> ficheNotes;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", matiere='" + matiere + '\'' +
                ", ficheNotes=" + ficheNotes +
                '}';
    } */


}
