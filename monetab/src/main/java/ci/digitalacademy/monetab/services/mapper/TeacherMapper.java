package ci.digitalacademy.monetab.services.mapper;


import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapper {

    private TeacherMapper() {}

    public static TeacherDTO toTeacherDTO(Teacher teacher) {

        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setMatiere(teacher.getMatiere());
        teacherDTO.setGmail(teacher.getGmail());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setLastName(teacher.getLastName());
       // teacherDTO.setGenre(teacher.getGenre());
        return teacherDTO;

    }


    public static Teacher toEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setMatiere(teacherDTO.getMatiere());
        teacher.setGmail(teacherDTO.getGmail());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        //teacher.setGenre(teacherDTO.getGenre());
        return teacher;
    }


}
