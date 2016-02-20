package base;
 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bean.Animation;
import bean.Program;
import bean.Reservation;
import bean.Ticket;

public class Base {

	EntityManagerFactory emf = null;
	EntityManager em = null;

	public void ouvrir() {
		emf = Persistence.createEntityManagerFactory("brest2016");
		em = emf.createEntityManager();
	}
	
	public void fermer() {
		em.close();
		emf.close();
	}
	
	
	public static void main(String [] args) {
		
		Base base = new Base();
		
		base.ouvrir();
		
		EntityTransaction tx = base.em.getTransaction();
		tx.begin();
		
		Ticket t = new Ticket("x", "y"); 
		base.em.persist(t);
		System.out.println("id ticket = "+ t.getId());
		Animation a  = new  Animation("loln","animation test" ,"type test",10); 
		Program ap = new Program(1,10,11);
		ap.setAnimation(a);
		base.em.persist(a);
    
		//a.getPrograms().add(ap); 
		System.out.println("id Animation = "+ a.getId());
	//	base.em.persist(a);
		
        base.em.persist(ap);
        
		Reservation r = new  Reservation(); 
		r.setIdAnimation(ap);
		r.setIdTicket(t);
		base.em.persist(r);
		tx.commit();
		
		List <Ticket> lst = base.em.createQuery(
				"select t from Ticket t").getResultList();
		System.out.println("nb Ticket = "+lst.size());
		
		for (Ticket cl : lst) {
			System.out.println("nom = "+cl.getFirstName()+" prénom = "+cl.getLastName());
			for (Program rs : cl.getAnimationReserved()) {
				System.out.println("programmation : "+ rs.getAnimation().getName());
				
			}	
		}



	}

}
