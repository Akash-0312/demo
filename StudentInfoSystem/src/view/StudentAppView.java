package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.Qualification;
import model.Registration;
import model.Student;
import model.Course;

public class StudentAppView {
	public static void main(String[] args) {
		StudentController controller = new StudentController();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Student \n 2.Admin\n3.Exit");
			int userType = sc.nextInt();
			if (userType == 1) {
				String choice = "y";
				do {
					System.out.println(
							"1.Sign up\n2.Update Phone number\n3.View all Courses\n4.Register for a course\n5. Sign out.");
					int option = sc.nextInt();

					switch (option) {
					case 1:
						System.out.println("Enter Name,Date of birth(dd/mm/yyyy),Phone number,email,address");
						String name = sc.next();

						String dateOfBirth = sc.next();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dob = LocalDate.parse(dateOfBirth, formatter);

						String phoneNumber = sc.next();
						String email = sc.next();
						String address = sc.next();

						System.out.println("1. Masters 2.Graduate 3.Intermediate 4.Matric");
						int q = sc.nextInt();
						Qualification qualification = null;
						if (q == 1)
							qualification = Qualification.Masters;
						if (q == 2)
							qualification = Qualification.Graduate;
						if (q == 3)
							qualification = Qualification.Intermediate;
						if (q == 4)
							qualification = Qualification.Matric;

						Student student = new Student(name, dob, qualification, phoneNumber, email, address);

						String message = controller.addNewStudent(student);
						System.out.println(message);
						break;
					case 4:
						System.out.println("Enter your rollno and course you want to register for");
						int rollNo=sc.nextInt();
						int courseId=sc.nextInt();
						String regDateString=sc.next();
						DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate regDate=LocalDate.parse(regDateString, formatter2);
						
						Registration registration=new Registration(regDate, courseId, rollNo);
					
						message= controller.registrationDb(registration);
						System.out.println(message);
						break;

					}
					System.out.println("Continue(y/n)");
					choice = sc.next();
				} while (choice == "y" || choice == "Y");
			} 
			else if (userType == 2) {
				System.out.println("1.view all students \n2.find student by rollno\n3.Add new course");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					List<Student> students = controller.viewAllStudents();
					Iterator<Student> iterator = students.iterator();
					while (iterator.hasNext()) {
						Student st = iterator.next();
						System.out.println(st.getRollNo() + " " + st.getName() + " " + st.getEmail());
					}
					break;
				case 2:
					System.out.println("enter roll no");
					int rollNo = sc.nextInt();
					Student st = controller.findStudentByRollNo(rollNo);
					if (st != null) {
						System.out.println(st.getRollNo() + " " + st.getName() + " " + st.getEmail());
					} else {
						System.out.println("Student not found");
					}
					break;
				case 3:
					System.out.println("Enter coursename,duration,fee");
					String courseName=sc.next();
					int duration=sc.nextInt();
					double fee=sc.nextDouble();
					System.out.println("1. Masters 2.Graduate 3.Intermediate 4.Matric");
					int q = sc.nextInt();
					Qualification eligibilty = null;
					if (q == 1)
						 eligibilty = Qualification.Masters;
					if (q == 2)
						 eligibilty = Qualification.Graduate;
					if (q == 3)
						 eligibilty = Qualification.Intermediate;
					if (q == 4)
						 eligibilty = Qualification.Matric;
					Course course=new Course(courseName,duration,fee, eligibilty);
					String message=controller.addNewCourse(course);
					System.out.println(message);
					break;

				}

			} 
			else {
				System.exit(0);
			}
		}
	}

}
