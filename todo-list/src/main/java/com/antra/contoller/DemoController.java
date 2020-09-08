package com.antra.contoller;

import com.antra.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    private final DemoService demoService;

    //Constructor
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    //Request methods
    // http://localhost:8080/todo-list/hello
    //the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    //http://localhost:8080/todo-list/welcome
    //we use viewResolver which does not require us to add '/', the view will also render ResponseBody
    //prefix + "welcome" + suffix
    @GetMapping("welcome")
    public String welcome(Model model){
        //this line add the attribute "user" into the model
        model.addAttribute("helloMessage", demoService.getHelloMessage("zac"));
        return "welcome"; //the name of MVC view(in this case it is welcome.jsp)

    }

    //http://localhost:8080/todo-list/welcomeUser?user=whatthefoo
    //then 'whatthefoo' will be the query parameter user
    @GetMapping("welcomeUser")
    public String welcomeUser(@RequestParam String user, Model model) {
        model.addAttribute("welcomeUser", demoService.getHelloMessage(user));
        return "welcomeUser";
    }


    //Model attributesx
    @ModelAttribute("welcomeMessage")
    public String welcomeMessagesadf(){
        return demoService.getWelcomeMessage();
    }
}
