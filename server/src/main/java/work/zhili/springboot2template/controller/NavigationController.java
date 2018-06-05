package work.zhili.springboot2template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/2 13:28
 */
@Controller
public class NavigationController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user/register")
    public String user() {
        return "/user/register";
    }

    @GetMapping("/test/1")
    public String test1(HttpServletRequest request, RedirectAttributes attributes) {
        attributes.addAttribute("2", "2");
        return "redirect:/test/{2}";
    }

    @GetMapping("/test/2")
    public String test2() {
        return "/test/2";
    }

}
