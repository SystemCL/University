package md.st.university.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import md.st.university.dao.Identification;

@Entity(name = "course")
public class Course implements Identification<Integer> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id = null;
	@Column(name = "nameCourse")
	private String nameCourse;
	@Column(name = "nameProf")
	private String nameProf;
	@Column(name = "startDate")
	private Date startDate;
	@Column(name = "endDate")
	private Date endDate;
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="courses")
	private Set<Student> students;
	
	
	public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public String getNameProf() {
		return nameProf;
	}

	public void setNameProf(String nameProf) {
		this.nameProf = nameProf;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Course nameCourse(String nameCourse){
		this.nameCourse = nameCourse;
		return this;
	}
	
	public Course nameProf(String nameProf){
		this.nameProf = nameProf;
		return this;
	}
	
	public Course startDate(Date startDate){
		this.startDate = startDate;
		return this;
	}
	
	public Course endDate(Date endDate){
		this.endDate = endDate;
		return this;
	}
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="courses")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
	public Course build(){
		Course course = new Course();
		course.setNameCourse(nameCourse);
		course.setNameProf(nameProf);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		course.setStudents(students);
		return course;
	}

	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " nameCourse: " + nameCourse+ "\n" +
			   " nameProf: " + nameProf + "\n" +
			   "startDate: "	+  startDate +"\n" +
			   "endDate: " + endDate + "\n"+
			   "students: " + students +"\n";
	}
	


}
