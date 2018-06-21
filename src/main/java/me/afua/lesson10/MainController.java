package me.afua.lesson10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

@Controller
public class MainController {

//    private ArrayList<Course> courses = new ArrayList<>();
   @Autowired
   CourseRepository courses;

    @GetMapping("/addcourse")
    public String addCourse()
    {
        Course c = new Course();
        c.setName("Course "+(courses.count()+1));
        courses.save(c);
        return "redirect:/showcourses";
    }

    @RequestMapping("/showcourses")
    public String saveCourse(Model model)
    {
        model.addAttribute("courses",courses.findAll());
        return "listcourses";
    }
}
