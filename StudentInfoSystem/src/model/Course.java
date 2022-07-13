package model;

public class Course {
	private int courseId;
	private String courseName;
	private int duration;
	private double fee;
	private Qualification qualification;
	//public static int courseIdGenerator=100;
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName, int duration, Double fee, Qualification qualification) {
		super();
		//this.courseId=++courseIdGenerator;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.qualification = qualification;
	}
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Qualification getQualification() {
		return qualification;
	}
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	

}
