package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.dto.AdressDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;

public final class StudentMapper {

    private StudentMapper() {}

    public static StudentDTO toStudentDTO(Student student) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setMatricule(student.getMatricule());
        studentDTO.setClasse(student.getClasse());
        studentDTO.setGenre(student.getGenre());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setMatricule(studentDTO.getMatricule());
        student.setClasse(studentDTO.getClasse());
        student.setGenre(studentDTO.getGenre());
        return student;
    }
}
