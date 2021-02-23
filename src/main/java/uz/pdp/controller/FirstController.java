package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
//@RequestMapping("/")
public class FirstController {

    private CrudService crudService=new CrudService();

    public FirstController() throws SQLException {
    }

    @GetMapping("/")
    public String get(Model model){
        List<Student> studentList=crudService.getAll();
        model.addAttribute("students",studentList);
        return "main";
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name,@RequestParam("surname") String surname){
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        crudService.post(student);
        return "redirect:/";
    }


    @PostMapping("/edit")
    public String edit(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("surname") String surname){
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);
        crudService.put(student);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        crudService.delete(id);
        return "redirect:/";
    }

}
