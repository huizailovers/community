package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangch
 */
@Controller
public class HelloController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(value = "name",required = false,defaultValue = "liuzz") String name,
                           Model model){
        model.addAttribute("name",name);
        return "greeting";
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
