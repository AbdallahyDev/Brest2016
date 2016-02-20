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
import bean.Ticket;

@Controller
public class AnimationControl {
	
	@Resource
	Dao dao;
	
	Ticket ticket ;
	/*@RequestMapping(value="/listerAnimation",method=RequestMethod.GET)
	public String showForm(){
		return "listerAnimation";
	}
	
	
	@RequestMapping(value="/listerAnimation",method=RequestMethod.GET)
	public @ResponseBody List <Animation> listerAnimation() {
		return dao.listerAnimations();
	}*/

	
	@RequestMapping(value="/listerAnimation")
	public String listerAnimation(ModelMap model){
		model.addAttribute("programs", dao.listerProgram());
		return "listerAnimation";
	}
	
	@RequestMapping(value="/connection")
	public String connection(){
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

