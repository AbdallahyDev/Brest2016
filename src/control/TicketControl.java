package control;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Animation;
import bean.Program;
import bean.Ticket;

@Controller
public class TicketControl {
	
	
	@Resource
	Dao dao;
	/*
	@RequestMapping(value="/listerAnimation")
	public String listerAnimation(ModelMap model){
		model.addAttribute("programs", dao.listerProgram());
		return "listerAnimation"; 
	}*/
	
	@RequestMapping(value="/listerAnimation",method=RequestMethod.GET)
	public @ResponseBody List <Program> listerProgram() {
		System.out.println("listerAnimations");  
		return dao.listerProgram();  
	}
	
	
	@RequestMapping(value="/connection",method=RequestMethod.POST)
	public @ResponseBody Resultat connection(
			@RequestBody @Valid Ticket ticket, BindingResult bres) {
		System.out.println("ticket code venant du controleur1 = "+ticket.getTicketId());
		Resultat res = convertBindingResult(bres);
	
		//Client c = new Client(); 
		//c.setNom(client.getNom());
		//c.setPrenom(client.getPrenom());
		
		if(res.getRes().equals("SUCCESS")) { 
			System.out.println("ticket code venant du controleur2 = "+ticket.getTicketId());
			dao.identifyTicket(ticket.getTicketId());
		}else
			System.out.println("ticket code = ");
		
		
		
		return res;
	}
	
	@RequestMapping(value="/connection",method=RequestMethod.GET)
	//@ResponseBody
	public String  connectionGet() {
		System.out.println("ticket code = ");
		
		
		//Client c = new Client();
		//c.setNom(client.getNom());
		//c.setPrenom(client.getPrenom());
		
		

			return "connection";
		
		
		
	}
	
	
	public Resultat convertBindingResult(BindingResult bres) {
		Resultat res = new Resultat();
		if(!bres.hasErrors()){
			res.setRes("SUCCESS");
		}else{
			res.setRes("FAIL");
		}
		
		
		for (FieldError fe : bres.getFieldErrors()) {
			System.out.println(fe.getField()+" "+fe.getDefaultMessage());
			res.getErr().put(fe.getField(), fe.getDefaultMessage());
		}
		
		return res;

	}

}
