package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repository.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save Student : {}", studentDTO);
        Student student= StudentMapper.toEntity(studentDTO);
        student=studentRepository.save(student);
        return StudentMapper.toStudentDTO(student);

    }

   /* @Override
    public Student update(Student student) {
        Optional<Student> studentOptional = studentRepository.findById(student.getId());
        if (studentOptional.isPresent()) {
            Student updatedStudent = studentOptional.get();
            updatedStudent.setMatricule(student.getMatricule());
            updatedStudent.setClasse(student.getClasse());
            return save(updatedStudent);
        } else {
            throw new IllegalArgumentException("Student not found");
        }
    }*/

    @Override

    public StudentDTO update(StudentDTO studentDTO) {
        log.debug("Request to update Student : {}", studentDTO);
            Student student= StudentMapper.toEntity(studentDTO);
            student=studentRepository.save(student);
            StudentMapper.toStudentDTO(student);
            return findOne(studentDTO.getId()).map(existingStudent ->{
                existingStudent.setMatricule(studentDTO.getMatricule());
                existingStudent.setClasse(studentDTO.getClasse());
                existingStudent.setGenre(studentDTO.getGenre());
                return save(existingStudent);

            }).orElseThrow(() -> new IllegalArgumentException("Student not find"));
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        log.debug("Request to find Student : {}", id);
        return studentRepository.findById(id).map(StudentMapper::toStudentDTO);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student ->{
            return StudentMapper.toStudentDTO(student);
        } ).toList();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
