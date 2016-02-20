package control;

import java.util.List;
import org.springframework.stereotype.Service;
import bean.Animation;
import bean.Program;
import bean.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class Dao {
 
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public Dao() {
		emf = Persistence.createEntityManagerFactory("brest2016");
		em = emf.createEntityManager();
	}
	

	
	public List<Animation>listerAnimations()  {
		List <Animation> lst = em.createQuery("select t from Animation t").getResultList();
		return lst;
	}
	
	public List<Program>listerProgram()  {
		List <Program> lst = em.createQuery("select g from Program g").getResultList();
		return lst;
	}
	
	
	public void init() {
		System.out.println("init dao");
	}

}
