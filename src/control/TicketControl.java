package control;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Animation;
import bean.Program;
import bean.Ticket;

@Controller
public class TicketControl {
	
	 Ticket ticket; 
	
	@Resource 
	Dao dao;
	
	@RequestMapping(value="/listerAnimation")
	public String listerAnimation(ModelMap model){
		List <Program> lst =dao.listerProgram();
		//List <Boolean> lstB = new 
		
		model.addAttribute("programs", lst); 
		return "listerAnimation"; 
	}	

    
    @RequestMapping(value="/connection",method=RequestMethod.POST)
	public @ResponseBody Resultat submitForm(
			@RequestBody @Valid Ticket tckt, BindingResult bres, ModelMap m) {
		Resultat res = convertBindingResult(bres);

		if(res.getRes().equals("SUCCESS")) {
			Ticket aticket =dao.identifyTicket(tckt.getTicketId());
			if(aticket!= null){	
					ticket =aticket;
			}else{
				res.setRes("FAIL");
				return res; 
			}
		} 
		
		return res;  
	}

		
		 
	
	@RequestMapping(value="/connection",method=RequestMethod.GET)
	public String  connectionGet() {
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
