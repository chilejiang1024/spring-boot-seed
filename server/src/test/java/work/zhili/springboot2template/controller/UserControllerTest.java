package work.zhili.springboot2template.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import work.zhili.springboot2template.Application;
import work.zhili.springboot2template.service.IUserService;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/9 15:37
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class UserControllerTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testQueryAll() throws Exception {
        UserController c = new UserController(userService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(c).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
