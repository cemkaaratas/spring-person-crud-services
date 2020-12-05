package spring.boot.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot.person.domain.Person;
import spring.boot.person.service.PersonCrudServiceImpl;

@Controller
public class PersonController {

    private final PersonCrudServiceImpl personCrudService;

    public PersonController(PersonCrudServiceImpl personCrudService) {
        this.personCrudService = personCrudService;
    }

    @RequestMapping("/person")
    public String getAllPerson(Model model){
        model.addAttribute("people",personCrudService.findAllPerson());
        return  "person";
    }

    @RequestMapping("/person/{id}")
    public String findPerson(@PathVariable("id") Integer id, Model model){
        model.addAttribute("person",personCrudService.getPersonById((long)id));
        return "persondetail";
    }

    @GetMapping("/person/new")
    public String personSaveForm(Model model){
        model.addAttribute("person",new Person());
        return "adduser";
    }
    @PostMapping(value = "/person/new" )
    public String savePersonSubmit(@ModelAttribute("person")Person person,Model model){
        model.addAttribute("person",person);
        Person person1 = new Person();
        person1.setId(person.getId());
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        personCrudService.save(person1);
        return "redirect:/person/" + person.getId();
    }

    @RequestMapping("/person/{id}/delete")
    public String deletePerson(@PathVariable("id") Integer id, Model model){
        model.addAttribute("person",personCrudService.findPersonById((long)id));
        personCrudService.deletePersonById((long)id);
        return "redirect:/person";
    }

    @RequestMapping("/person/{id}/update")
    public String updateUserForm(@PathVariable("id") Integer id, Model mOdel){
        mOdel.addAttribute("person",personCrudService.findPersonById((long)id));
        return "updateform";
    }

    @PostMapping("/person/{id}/update")
    public String updateUserSubmit(@ModelAttribute("person")Person person,Model model){
        model.addAttribute("person",personCrudService.save(person));
        personCrudService.save(person);
        return "redirect:/person";}
}