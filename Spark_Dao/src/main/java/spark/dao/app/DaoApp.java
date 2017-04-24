package main.java.spark.dao.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import ch.qos.logback.core.net.SyslogOutputStream;
import main.java.spark.dao.dao.IAssigningTaskDao;
import main.java.spark.dao.dao.IClassDao;
import main.java.spark.dao.dao.IStudentDao;
import main.java.spark.dao.dao.ITaskDao;
import main.java.spark.dao.dao.ITeacherDao;
import main.java.spark.dao.dao.IUserDao;
import main.java.spark.dao.model.AssigningTask;
import main.java.spark.dao.model.Class;
import main.java.spark.dao.model.Student;
import main.java.spark.dao.model.Task;
import main.java.spark.dao.model.Teacher;
import main.java.spark.dao.model.user.User;
import main.java.spark.dao.model.user.UserRole;

@SpringBootApplication
@ImportResource(locations={"classpath:SparkDao_Spring.xml"})
@PropertySource(value={"classpath:dao.properties"})
public class DaoApp  implements CommandLineRunner {

	@Autowired
	IClassDao classDao;
	
	@Autowired
	ITeacherDao teacherDao;
	
	@Autowired
	IStudentDao studentDao;
	
	@Autowired
	ITaskDao taskDao;
	
	@Autowired
	IAssigningTaskDao assigningTaskDao;
	
	@Autowired
	IUserDao userDao;
	
    public static void main(String[] args) throws Exception {

        SpringApplication.run(DaoApp.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

    	//Init teacher
    	Teacher teacherToSave = new Teacher();
    	teacherToSave.setFirstName("Angelina");
    	teacherToSave.setLastName("Whitehouse");
    	teacherToSave.setUsername("awhitehouse");
    	teacherToSave.setPassword("password1");
    	
    	teacherDao.saveOrUpateTeacher(teacherToSave);
    	
    	//Init Class
    	Class classDetailToSave = new Class();
    	classDetailToSave.setYear(1);
    	classDetailToSave.setClassNumber(1);
    	classDao.saveOrUpateClass(classDetailToSave);
    	
    	//Find class and teacher
    	Teacher teacher = teacherDao.findByTeacherId(1);
    	Class classDetail = classDao.findByYearAndClassNumber(1, 1);
    	
    	//Init Student
    	List<Student> students = new ArrayList<>();
    	
    	Student student1 = new Student();
    	student1.setFirstName("Madeleine");
    	student1.setLastName("Strehlow");
    	student1.setUsername("mstrehlow");
    	student1.setAddress("29 Scenic Road, BLUE COW NSW 2624");
    	student1.setPassword("password1");
    	student1.setTeacher(teacher);
    	student1.setClassDetail(classDetail);
    	
    	students.add(student1);
    	
    	Student student2 = new Student("Harrison", "McLaren", "hmclaren", "password2", "62 Bresnahans Lane, BERRIMA NSW 2577", teacher, classDetail);
    	students.add(student2);
    	Student student3 = new Student("Mulan", "Chu", "mchu", "password3", "93 Adavale Road, BRISBANE GROVE NSW 2580", teacher, classDetail);
    	students.add(student3);
    	Student student4 = new Student("Sheng", "Tsou", "stsou", "password4", "3 Pipeclay Road, HYNDMANS CREEK NSW 2446", teacher, classDetail);
    	students.add(student4);
    	Student student5 = new Student("Lucas", "Kalb", "lkalb", "password5", "66 Kogil Street, CROPPA CREEK NSW 2411", teacher, classDetail);
    	students.add(student5);
    	Student student6 = new Student("Frank", "Kirsch", "fkirsch", "password6", "21 Peninsula Drive, LUCAS HEIGHTS NSW 2234", teacher, classDetail);
    	students.add(student6);
    	Student student7 = new Student("Agnes", "Milano", "amilano", "password7", "76 Lewin Street, COMBANING NSW 2666", teacher, classDetail);
    	students.add(student7);
    	Student student8 = new Student("Guisepinna", "Toscani", "gtoscani", "password8", "42 Edgecliff Road, DARLING ISLAND NSW 2009", teacher, classDetail);
    	students.add(student8);
    	Student student9 = new Student("Eika", "Niita", "eniita", "password9", "12 Wagga Road, WALLACETOWN NSW 2650", teacher, classDetail);
    	students.add(student9);
    	Student student10 = new Student("Ichiha", "Yasui", "iyasui", "password10", "56 Carolina Park Road, ST HUBERTS ISLAND NSW 2257", teacher, classDetail);
    	students.add(student10);
    	Student student11 = new Student("Snjezana", "Zaytseva", "szaytseva", "password11", "76 Shamrock Avenue, CONGO NSW 2537", teacher, classDetail);
    	students.add(student11);
    	Student student12 = new Student("Yesenia", "Alexandrova", "yalexandrova", "password12", "93 Frencham Street, JAGUNGAL WILDERNESS NSW 2642", teacher, classDetail);
    	students.add(student12);
    	Student student13 = new Student("Anas", "Wallin", "awallin", "password13", "88 Kerma Crescent, BEN BULLEN NSW 2790", teacher, classDetail);
    	students.add(student13);
    	Student student14 = new Student("Ilvana", "Pejovnik", "ipejovnik", "password14", "56 Tennyson Road, WOLLI CREEK NSW 2205", teacher, classDetail);
    	students.add(student14);
    	Student student15= new Student("Zoe", "Wootton", "zwootton", "password15", "10 Faunce Crescent, MONIA GAP NSW 2675", teacher, classDetail);
    	students.add(student15);
    	Student student16 = new Student("Emily", "Grover", "egrover", "password16", "39 Round Drive, MARYLAND NSW 2287", teacher, classDetail);
    	students.add(student16);
    	Student student17 = new Student("Jai", "Saville", "jsaville", "password17", "68 Sydney Road, MULLAMUDDY NSW 2850", teacher, classDetail);
    	students.add(student17);
    	Student student18 = new Student("Jasmine", "Mein", "jmein", "password18", "41 Bass Street, BUNGABBEE NSW 2480", teacher, classDetail);
    	students.add(student18);
    	Student student19 = new Student("Cameron", "Scerri", "cscerri", "password19", "24 McGregor Street, COPI HOLLOW NSW 2879", teacher, classDetail);
    	students.add(student19);
    	Student student20 = new Student("Jessica", "Schmidt", "jschmidt", "password20", "90 Albacore Crescent, BREADALBANE NSW 2581", teacher, classDetail);
    	students.add(student20);
    	
    	
    	for(Student student : students)
    		studentDao.saveOrUpateStudent(student);
    	
    	List<Task> tasks = new ArrayList<>();
    	
    	tasks.add(new Task("Choose a topic, research and plan a discussion on it, produce a hand-written draft, and a final draft is published using a computer."));
    	tasks.add(new Task("Write an informative text in the form of an explanation about how and why floods occur."));
    	tasks.add(new Task("Research an animal that lives in the rainforest, select relevant facts and write an information report. Edit and publish the report."));
    	tasks.add(new Task("Analyse the persuasive strategies used in some advertisements, then design your own advertisement for a magazine or newspaper."));
    	tasks.add(new Task("Select a visual image, make notes on it and create a draft description and write a factual description."));
    	tasks.add(new Task("Plan, draft and write a review of a film. "));
    	tasks.add(new Task("Recommend three poems for inclusion in a poetry anthology. Write a response to each one, giving reasons for the recommendations."));
    	tasks.add(new Task("Research the contribution of an Aboriginal person to Australian society and write an imaginative narrative."));
    	tasks.add(new Task("Compose a persuasive letter to a potential tourist to Australia on behalf of a tourist office."));
    	tasks.add(new Task("Write a letter to a friend in which you relate what you have learnt about the theme you have been studying in class."));
    	tasks.add(new Task("Write the script of a television talk show interview on the novel you have been reading in class."));
    	tasks.add(new Task("Compose a short narrative in response to one of a selection of stimulus items related to the concept of \"the monster\" which has been the focus of recent study."));
  
    	
    	for(Task task : tasks){
    		taskDao.saveOrUpateTask(task);
    	}
    	
    	
    	List<AssigningTask> assigningTasks = new ArrayList<>();
    	String dueDate = "20170425";
    	assigningTasks.add(new AssigningTask(taskDao.findById(1), studentDao.findById(1), 1, 84, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(1), studentDao.findById(2), 1, 58, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(1), studentDao.findById(3), 1, 90, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(1), studentDao.findById(4), 1, 81, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(1), studentDao.findById(5), 1, 62, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(2), studentDao.findById(6), 1, 100, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(2), studentDao.findById(7), 1, 97, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(2), studentDao.findById(8), 1, 69, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(2), studentDao.findById(9), 1, 54, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(2), studentDao.findById(10), 1, 56, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(3), studentDao.findById(11), 1, 72, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(3), studentDao.findById(12), 1, 90, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(3), studentDao.findById(13), 1, 83, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(3), studentDao.findById(14), 1, 86, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(3), studentDao.findById(15), 1, 69, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(4), studentDao.findById(16), 1, 77, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(4), studentDao.findById(17), 1, 97, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(4), studentDao.findById(18), 1, 63, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(4), studentDao.findById(19), 1, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(4), studentDao.findById(20), 1, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(5), studentDao.findById(1), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(5), studentDao.findById(2), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(5), studentDao.findById(3), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(5), studentDao.findById(4), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(5), studentDao.findById(5), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(6), studentDao.findById(6), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(6), studentDao.findById(7), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(6), studentDao.findById(8), 1, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(6), studentDao.findById(9), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(6), studentDao.findById(10), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(7), studentDao.findById(11), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(7), studentDao.findById(12), 1, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(7), studentDao.findById(13), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(7), studentDao.findById(14), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(7), studentDao.findById(15), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(8), studentDao.findById(16), 1, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(8), studentDao.findById(17), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(8), studentDao.findById(18), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(8), studentDao.findById(19), 0, 0, dueDate));
    	assigningTasks.add(new AssigningTask(taskDao.findById(8), studentDao.findById(20), 0, 0, dueDate));
    	for(AssigningTask assigningTask : assigningTasks)
    		assigningTaskDao.saveOrUpateAssigningTask(assigningTask);
    	
    	
    	//Init User
    	User user = new User("jj", "$2a$10$mqNwcSc7GYEPcdep3n2v5.4i2/S33B0Rzyhxn6pVQFyzNmLwZVnma", true);
    	UserRole userRole = new UserRole();
    	userRole.setRole("ROLE_ADMIN");
    	userRole.setUser(user);
    	user.setUserRole(Arrays.asList(userRole));
    	userDao.saveOrUpateUser(user);
    	
    	
    	System.out.println(assigningTaskDao.findById(2));
    }
}