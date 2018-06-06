package work.zhili.springboot2template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.zhili.springboot2template.service.impl.TestServiceImpl;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description :
 *   api test controller
 *
 * @author chile
 * @version 1.0
 * @date 2018/3/21 18:10
 */
@Controller
@RequestMapping("/api")
public class TestController {

    private final TestServiceImpl firstService;

    @Autowired
    public TestController(TestServiceImpl firstService) {
        this.firstService = firstService;
    }

    /**
     * test global exception handler
     * @return nothing
     */
    @GetMapping("/v1/first/get")
    @ResponseBody Object firstGet() {
        firstService.firstMethod();
        return "haha";
    }

}
