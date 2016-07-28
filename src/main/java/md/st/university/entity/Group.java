package md.st.university.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import md.st.university.dao.Identification;


@Entity(name = "group")
public class Group implements Identification<Integer> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
    @Column(name = "nameGroup")
	public String nomGroup;
    @Column(name = "faculty")
	public String faculty;
	@OneToMany(mappedBy="group")
    private Set<Student> students;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomGroup() {
		return nomGroup;
	}

	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public Group nomGroup(String nomGroup){
		this.nomGroup = nomGroup;
		return this;
	}

	public Group faculty(String faculty){
		this.faculty = faculty;
		return this;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public Group build(){
		Group group = new Group();
		group.setNomGroup(nomGroup);
		group.setFaculty(faculty);
		group.setStudents(students);
		return group;
	}
	

	

	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " nameGroup: " + nomGroup+ "\n" +
				" faculty: " + faculty + "\n" +
				" students: "+students+ "\n\n";
	}


}
