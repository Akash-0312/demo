package controller;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;
import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;

public class StudentController {

	StudentDao dao=new StudentDaoImplDatabase();
	public String addNewStudent(Student student) {
	
		if(student.getMobileNo().length()!=10)
		{
			try
			{
				throw new PhoneException("Invalid phone number");
			}catch(PhoneException e)
			{
				return e.getMessage();
			}
		}
		dao.addNewStudent(student);
		return "New Student added Successfully";

	}


	public void updateStudentProfile(Student student) {
		

	}

	
	public void registration(Student student, Course course) {
	

	}
	public String registrationDb(Registration registration)
	{
		String message="";
		Student student=dao.findStudentByRollNo(registration.getRollNo());
		Course course=dao.findCourseById(registration.getCourseId());
		if(student!=null) {
			if(course!=null) {
				if(student.getQualification().equals(course.getQualification())) {
					message=dao.registrationDb(registration);
				}
				else {
					message="You are not eligible.";
				}
			}
			else {
				message="Course not found.";
			}
		}
		else {
			message="Student does not exist.";
		}
		return message;
	}

	public Map<Student, Course> viewAllRegistrations() {
		
		return null;
	}

	
	public Student findStudentByRollNo(int rollNo) {
	
		return dao.findStudentByRollNo(rollNo);
	}

	
	public List<Student> viewAllStudents() {

		return dao.viewAllStudents();
	}

	
	public String addNewCourse(Course course) {
		return dao.addNewCourse(course);

	}

	public Course findCourseById(int courseId) {
		
		return null;
	}

	public List<Course> viewAllCourses() {
		
		return null;
	}

}


