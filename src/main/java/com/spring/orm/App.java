package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		Student student = new Student(02, "Rohan Mahato", "Tulin");
//		int r=studentDao.insert(student);
//		System.out.println("done" + r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {

			System.out.println("Press 1 for adding a new Student.");
			System.out.println("Press 2 for Dispaly all the Students.");
			System.out.println("Press 3 for detail of a single Student.");
			System.out.println("press 4 for delete Student.");
			System.out.println("Press 5 for update Student.");
			System.out.println("Press 6 for Exit.");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1: {
					System.out.println("Enter User Id");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter User Name");
					String uName = br.readLine();

					System.out.println("Enter User City");
					String uCity = br.readLine();

					Student s = new Student();
					s.setId(uId);
					s.setName(uName);
					s.setCity(uCity);

					int r = studentDao.insert(s);
					System.out.println(r + " Student Added");
					System.out.println("_______________________________________");
					System.out.println();
					break;
				}
				case 2: {

					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println(st.getId());
						System.out.println(st.getName());
						System.out.println(st.getCity());
						System.out.println();
					}
					break;
				}
				case 3: {

					System.out.println("Enter User Id");
					int userId = Integer.parseInt(br.readLine());
					
					Student stt = studentDao.getStudent(userId);
					System.out.println("Id = " + stt.getId());
					System.out.println("Name = " + stt.getName());
					System.out.println("City = " + stt.getCity());
					System.out.println("_______________________________________________");
					break;
				}
				case 4: {

					System.out.println("Enter Student Id");
					int uid = Integer.parseInt(br.readLine());
					studentDao.delete(uid);
					
					System.out.println("Student Details Deleted");
					break;
				}
				case 5: {

					System.out.println("Enter Student Id");
					int uId=Integer.parseInt(br.readLine());

					System.out.println("Enter User Name");
					String uName = br.readLine();

					System.out.println("Enter User City");
					String uCity = br.readLine();

					Student s = new Student();
					s.setId(uId);
					s.setName(uName);
					s.setCity(uCity);
					studentDao.updateStudent(s);
					break;
				}
				case 6: {
					go = false;
					break;
				}
				}
			} catch (Exception e) {
				System.out.println("Invalid Input try with another input");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thank you for using my Application");
		System.out.println("see you soon !!");

	}
}
