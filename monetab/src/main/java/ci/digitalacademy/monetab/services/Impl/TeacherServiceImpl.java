package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repository.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save teacher : {}", teacherDTO);
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.toTeacherDTO(teacher);

    }

 /*   @Override
    public Teacher update(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacher.getId());
        if (teacherOptional.isPresent()) {
            Teacher updatedTeacher = teacherOptional.get();
            updatedTeacher.setMatiere(teacher.getMatiere());
            return save(updatedTeacher);
        } else {
            throw new IllegalArgumentException("Teacher not found");
        }
    } */


    @Override

    public TeacherDTO update(TeacherDTO teacherDTO) {
        log.debug("Request to update teacher : {}", teacherDTO);
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return findOne(teacherDTO.getId()).map(existingTeacher -> {
            existingTeacher.setMatiere(teacherDTO.getMatiere());
            existingTeacher.setGmail(teacherDTO.getGmail());
            existingTeacher.setFirstName(teacherDTO.getFirstName());
            existingTeacher.setLastName(teacherDTO.getLastName());
            return save(existingTeacher);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        log.debug("Request to save one teacher : {}", id);
        return teacherRepository.findById(id).map(TeacherMapper::toTeacherDTO);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);

    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(tacher -> {
           return TeacherMapper.toTeacherDTO(tacher);
        } ).toList();
    }
}
