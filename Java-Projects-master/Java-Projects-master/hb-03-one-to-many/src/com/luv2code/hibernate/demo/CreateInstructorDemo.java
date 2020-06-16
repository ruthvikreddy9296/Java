package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			Instructor tempInstructor = 
					new Instructor("Suzen", "Public", "susan.public@luv2code.com");
			
			InstructorDetail tempInstructordetail = 
					new InstructorDetail("http://www.youtube.com", "Video Games");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructordetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			//Note : this will also save the details object 
			//because of CascadeType.ALL
			System.out.println("Saving Instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			//clean up code
			session.close();
			
			factory.close();
		}
	}

}





