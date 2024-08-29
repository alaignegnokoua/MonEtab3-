package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO extends PersonDTO {

    private Long id;

    private String matiere;

    private String gmail;

    private String firstName;

    private String lastName;

    private String genre;


}
