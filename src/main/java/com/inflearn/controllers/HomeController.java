package com.inflearn.controllers;     
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.inflearn.beans.Question;    
import com.inflearn.dao.QuestionDao;    
@Controller    
public class HomeController {    
    @Autowired    
    QuestionDao dao;//will inject dao from XML file    
        
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */ 
    @RequestMapping("/")    
    public String showhome(){    
        return "index";   
    }    
    @RequestMapping("/community")    
    public String community(Model m){    
    	List<Question> list=dao.getAllRecords();    
    	m.addAttribute("list",list);  
        return "community";   
    }
    @RequestMapping(value="/question/{id}")
    public String question(@PathVariable int id, Model m) {
    	Question q=dao.getRecordById(id);
    	m.addAttribute("q",q);  
    	return "question";
    }
    @RequestMapping("/questionform")
    public String Question() {
    	return "questionform";
    }
    @RequestMapping(value="/addQuestion", method=RequestMethod.POST)
    public String save(@ModelAttribute("q") Question q) {
    	int i = dao.save(q);
    	if(i > 0) {
    		return "redirect:/community";
    	}
    	else {
    		return "redirect:/addquestion-error";
    	}
    }
    @RequestMapping(value="/deleteQuestion/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable int id) {
    	dao.delete(id);
    	return "redirect:/community";
    }
    @RequestMapping(value="/editQuestion/{id}")
    public String edit(@PathVariable int id, Model m) {
    	Question q=dao.getRecordById(id);
    	m.addAttribute("q", q);
    	return "editform";
    }
    @RequestMapping(value="editQuestion", method=RequestMethod.POST)
    public String editsave(@ModelAttribute("q") Question q) {
    	dao.update(q);
    	return "redirect:/community";
    }

//    /*It saves object into database. The @ModelAttribute puts request data  
//     *  into model object. You need to mention RequestMethod.POST method   
//     *  because default request is GET*/    
//    @RequestMapping(value="/save",method = RequestMethod.POST)    
//    public String save(@ModelAttribute("emp") Emp emp){    
//        dao.save(emp);    
//        return "redirect:/viewemp";//will redirect to viewemp request mapping    
//    }    
//    /* It provides list of employees in model object */    
//    @RequestMapping("/viewemp")    
//    public String viewemp(Model m){    
//        List<Emp> list=dao.getEmployees();    
//        m.addAttribute("list",list);  
//        return "viewemp";    
//    }    
//    /* It displays object data into form for the given id.   
//     * The @PathVariable puts URL data into variable.*/    
//    @RequestMapping(value="/editemp/{id}")    
//    public String edit(@PathVariable int id, Model m){    
//        Emp emp=dao.getEmpById(id);    
//        m.addAttribute("command",emp);  
//        return "empeditform";    
//    }    
//    /* It updates model object. */    
//    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
//    public String editsave(@ModelAttribute("emp") Emp emp){    
//        dao.update(emp);    
//        return "redirect:/viewemp";    
//    }    
//    /* It deletes record for the given id in URL and redirects to /viewemp */    
//    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
//    public String delete(@PathVariable int id){    
//        dao.delete(id);    
//        return "redirect:/viewemp";    
//    }     
}  