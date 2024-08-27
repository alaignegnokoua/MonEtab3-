package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repository.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacher.getId());
        if (teacherOptional.isPresent()) {
            Teacher updatedTeacher = teacherOptional.get();
            updatedTeacher.setMatiere(teacher.getMatiere());
            return save(updatedTeacher);
        } else {
            throw new IllegalArgumentException("Teacher not found");
        }
    }

    @Override
    public Optional<Teacher> findOne(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);

    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
