package testwithrelationships;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import md.st.university.entity.Student;

public class StoreData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Student s1 = new Student();
			s1.setId(11);
			s1.setFirstName("QWERTY");
			s1.setLastName("CCCCCCC");
			s1.setAge(21);
			s1.setEnrolment_date(null);
			s1.setGroup(null);
			
			session.persist(s1);
			t.commit();
			
			
		} catch (Exception e) {
			if(t!=null) t.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}	
		
		session.close();
		System.out.println("Success insert!");
	}
	
	
}
