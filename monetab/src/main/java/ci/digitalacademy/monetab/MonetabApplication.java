package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private TeacherService teacherService;

	@Autowired

	private FicheNoteService ficheNoteService;

	@Autowired

	private AdressService adressService;

	@Autowired

	private UserService userService;

	@Autowired
	private StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	/*


	@Override
	public void run(String... args) throws Exception {

		/*FicheNote noteFile1 = new FicheNote();
		noteFile1.setNote(12);
		noteFile1.setAnnee(2023);
		FicheNote noteFile2 = new FicheNote();
		noteFile2.setNote(18);
		noteFile2.setAnnee(2024);

		Teacher teacher = new Teacher();
		teacher.setMatiere("ALGO");
		teacherService.save(teacher);

		FicheNote ficheNote1 = new FicheNote();
		ficheNote1.setAnnee(2021);
		ficheNote1.setNote(18);
		ficheNote1.setTeacher(teacher);


		FicheNote ficheNote2 = new FicheNote();
		ficheNote2.setAnnee(2026);
		ficheNote2.setNote(19);
		ficheNote2.setTeacher(teacher);

		ficheNoteService.save(ficheNote1);
		ficheNoteService.save(ficheNote2);

		Set<FicheNote> ficheNoteSet = new HashSet<>();
		ficheNoteSet.add(ficheNote1);
		ficheNoteSet.add(ficheNote2);

		teacher.setFicheNotes(ficheNoteSet);
		teacherService.save(teacher);

		*/


	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setMatricule("AG001");
		student.setGmail("lelouch32@gmail.com");
		student.setFirstName("sitionon");
		student.setLastName("anicet");
		student.setClasse("ADA");


		Student student1 = new Student();
		student1.setMatricule("AG002");
		student1.setGmail("zouzouko01@gmail.com");
		student1.setFirstName("liade");
		student1.setLastName("jean-phillippe");
		student1.setClasse("ADAS");

		studentService.save(student);
		studentService.save(student1);

		//teacher

		Teacher teacher = new Teacher();
		teacher.setMatiere("algorithme");
		teacher.setGmail("laboss42@gmail.com");
		teacher.setFirstName("Kouakou");
		teacher.setLastName("bertin");


		Teacher teacher1 = new Teacher();
		teacher1.setMatiere("Merise");
		teacher1.setGmail("zouzouko01@gmail.com");
		teacher1.setFirstName("liade");
		teacher1.setLastName("jean-phillippe");

		teacherService.save(teacher);
		teacherService.save(teacher1);


		//USER

		User user = new User();
		user.setPseudo("gnokson");
		user.setPassword("lelouch@01");
		user.setCreationDate(Instant.now());


		User user1 = new User();
		user1.setPseudo("kpriss");
		user1.setPassword("Debo2021");
		user1.setCreationDate(Instant.now());

		userService.save(user);
		userService.save(user1);


	}
}

