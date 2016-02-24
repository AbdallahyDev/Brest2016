package control;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sun.org.apache.regexp.internal.recompile;

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
	private Boolean identify;

	public Dao() {
		emf = Persistence.createEntityManagerFactory("brest2016");
		em = emf.createEntityManager();
		identify=false;
	}
	
	
	
	public Boolean getIdentify() {
		return identify;
	}


	public void setIdentify(Boolean identify) {
		this.identify = identify;
	}




	public void identifyTicket(int id){
		
		System.out.println("I am in the identify method");
		List <Ticket> lst = em.createQuery("select t from Ticket t ").getResultList();
		for(Ticket  t: lst){
			
			if(t.getTicketId()==id){  
				//System.out.println("I am in the identify method, clouse true");
				identify= true;
			}else{
				//System.out.println("I am in the identify method clouse false");
				identify= false;  
			} 
				  
		}
		System.out.println("I am in the end of identify methode"+identify);
		
		
		
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
