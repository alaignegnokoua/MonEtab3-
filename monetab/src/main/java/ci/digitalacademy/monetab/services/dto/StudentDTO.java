package ci.digitalacademy.monetab.services.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends PersonDTO {

    private String classe;

    private String matricule;

    private String genre;

    private String telephone;
}
