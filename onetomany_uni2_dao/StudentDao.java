package onetomany_uni2_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomany_uni2.dto.School;
import onetomany_uni2.dto.Student;

public class StudentDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
		return entityManagerFactory.createEntityManager();
		
		
	}
	
//	public void saveStudent(int id,Student student) {
//		EntityManager entityManager=getEntityManager();
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		School school=entityManager.find(School.class, id);
//		entityTransaction.begin();
//		entityManager.persist(student);
//		entityTransaction.commit();
//		
//	}

	public void updateStudent(int id,Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student2=entityManager.find(Student.class, id);
		if(student2!=null) {
			student.setId(id);
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		}
		else 
			System.out.println("no student is present with the id");
		
	}
	
	public void deleteStudent(int id)  throws Exception{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student2=entityManager.find(Student.class, id);
		if(student2!=null) {
			
		entityTransaction.begin();
		entityManager.remove(student2);
		entityTransaction.commit();
		}
		else 
			System.out.println("no student is present with the id");
	}
	
	public void displayStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student!=null)
		System.out.println(student);
		else
			System.out.println("No student ");
		
	}
	
	public void displayAllStudent(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from Student a");
		List<Student>list =query.getResultList();
		System.out.println(list);
		
	}
}
