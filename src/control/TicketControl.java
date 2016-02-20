package control;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import bean.Ticket;

@Controller
public class TicketControl {
	
	
	@Resource
	Dao dao;
	
	@RequestMapping(value="/identifyTicket",method=RequestMethod.POST)
	public @ResponseBody Resultat identifyTicket(
			@RequestBody @Valid Ticket ticket, BindingResult bres) {
		System.out.println("ticket code = "+ticket.getId());
		Resultat res = convertBindingResult(bres);
	
		//Client c = new Client();
		//c.setNom(client.getNom());
		//c.setPrenom(client.getPrenom());
		
		if(res.getRes().equals("SUCCESS")) {
			
			dao.identifyTicket(ticket.getId());
		}
		
		
		
		return res;
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
