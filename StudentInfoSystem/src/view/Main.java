package view;

import dao.StudentDaoImplInMemory;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

import dao.StudentDao;
import model.Qualification;
import model.Student;
import model.Course;

public class Main {

	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImplInMemory();
		Student student1 = new Student("John", LocalDate.of(2000, 10, 12), Qualification.Graduate, "9999999999",
				"John@lti.com", "Mumbai");
		Student student2 = new Student("Mike", LocalDate.of(2000, 10, 12), Qualification.Intermediate, "9999999998",
				"Mike@lti.com", "Pune");
		Student student3 = new Student("Kevin", LocalDate.of(2000, 10, 12), Qualification.Masters, "9999999997",
				"Kevin@lti.com", "Chennai");
		Student student4 = new Student("Brett", LocalDate.of(2000, 10, 12), Qualification.Matric, "9999999996",
				"Breatt@lti.com", "Banglore");
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		dao.addNewStudent(student4);
		
		Course course1=new Course("java",6,4000.0,Qualification.Intermediate);
		Course course2=new Course("python",3,2000.0,Qualification.Graduate);
		Course course3=new Course("c",8,8000.0,Qualification.Masters);
		Course course4=new Course("c++",5,5000.0,Qualification.Matric);
		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);
		List<Course> courses=dao.viewAllCourses();
		Iterator<Course> courseIterator=courses.iterator();
		while(courseIterator.hasNext())
		{
			Course course=courseIterator.next();
			System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getDuration()+" "+course.getFee());
		}
		
//		List<Student> students=dao.viewAllStudents();
//		Iterator<Student> iterator=students.iterator();
//		while(iterator.hasNext())
//		{
//			Student student=iterator.next();
//			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getMobileNo());
//		}
//		System.out.println("Enter RollNo");
//		int rollNo = sc.nextInt();
//		Student student5 = dao.findStudentByRollNo(rollNo);
//		if (student5 != null) {
//			System.out.println("Enter mobile number");
//			String phno = sc.next();
//			student5.setMobileNo(phno);
//			dao.updateStudentProfile(student5);
//		}
//
//		else
//			System.out.println("student not found");
//				
		List<Student> students1=dao.viewAllStudents();
		Iterator<Student> iterator1=students1.iterator();
		while(iterator1.hasNext())
		{
			Student student=iterator1.next();
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getMobileNo()+" "+student.getCollegename());
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student roll no and course applying for ");
		int rollNo=sc.nextInt();
		int courseId=sc.nextInt();
		Student stud1=dao.findStudentByRollNo(rollNo);
		Course c1=dao.findCourseById(courseId);
		if(stud1!=null)
		{
			if(c1!=null)
			{
			dao.registration(stud1,c1);
			System.out.println("Registration Successfull");
			}
			else
			{
				System.out.println("Course not found");
			}
		}
		else {
			System.out.println("Student not found");
		}
		System.out.println("View all registrations");
		Map<Student,Course> registrations=dao.viewAllRegistrations();
		Set<Map.Entry<Student,Course>> regs=registrations.entrySet();
		for(Map.Entry<Student, Course> r:regs)
		{
			Student s=r.getKey();
			Course c=r.getValue();
			System.out.println(s.getRollNo()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
		}

	}
}
