package com.demo.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
   @Autowired
   JobRepository jobs;

   @RequestMapping("/")
    public String displayHome()
    {
        return "index";
    }


    @GetMapping("/addjob")
    public String addJob(Model model)
    {
        model.addAttribute("job", new Job ());
        return "addjob";
    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute Job job){
       jobs.save(job);
       return "redirect:/showjobs";
    }

    @RequestMapping("/showjobs")
    public String showJobs(Model model){
       model.addAttribute("jobs", jobs.findAll());
        return "listjobs";
    }
    @RequestMapping("/detail/{id}")
    public String showJob (@PathVariable("id") long id, Model model) {
       model.addAttribute("job",jobs.findById(id).get());
       return "show";
    }
}
