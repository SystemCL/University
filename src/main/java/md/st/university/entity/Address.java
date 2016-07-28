package md.st.university.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import md.st.university.dao.Identification;

//import md.st.entity.annotations.*;


//@Entity(tableName = "Address")
@Entity(name = "address" )
public class Address implements Identification<Integer> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id = null;
	@Column(name = "nameAddress")
	private String nameAddress;
    @Column(name = "nrPhone")
	private String nrPhone;
    private Student student;
	
	

	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}
	
	public String getNameAddress() {
		return nameAddress;
	}

	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}

	public String getNrPhone() {
		return nrPhone;
	}

	public void setNrPhone(String nrPhone) {
		this.nrPhone = nrPhone;
	}
	

	public Address nameAddress(String nameAddress){
		this.nameAddress = nameAddress;
		return this;
	}
	
	public Address nrPhone(String nrPhone){
		this.nrPhone = nrPhone;
		return this;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public Address build(){
		Address address = new Address();
		address.setNameAddress(nameAddress);
		address.setNrPhone(nrPhone);
		return address;
	}

	
	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " nameAddress: " + nameAddress+ "\n" +
				" nrPhone: " + nrPhone + "\n" +
	            " student: " + student +  "\n";
	}
}
