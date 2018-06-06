package work.zhili.springboot2template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import work.zhili.springboot2template.core.http.response.Response;
import work.zhili.springboot2template.core.util.UUIDUtils;
import work.zhili.springboot2template.model.User;
import work.zhili.springboot2template.service.IUserService;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description : <br>
 *   RESTful API examples
 * @author chile
 * @version 1.0
 * @date 2018/5/4 14:27
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * query all, just for testing
     * @return {user, user, ...}
     */
    @GetMapping
    Object queryAll() {
        return userService.queryAllForTesting();
    }

    /**
     * add a new user
     * @param username user name
     * @param password password
     * @return ok
     */
    @PostMapping
    Object add(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setId(UUIDUtils.getUuid());
        user.setUsername(username);
        user.setPassword(password);
        userService.insert(user);
        return Response.SUCCESSFUL_MESSAGE;
    }

    /**
     * invalid a user
     * @param userId the user's id
     * @return ok
     */
    @DeleteMapping
    Object delete(String userId) {
        userService.invalid(userId);
        return Response.SUCCESSFUL_MESSAGE;
    }

    /**
     * update a user
     * @param user user
     * @return ok
     */
    @PatchMapping
    Object update(@RequestBody User user) {
        userService.update(user);
        return Response.SUCCESSFUL_MESSAGE;
    }

    /**
     * get a user's details
     * @param userId the user's id
     * @return the user
     */
    @GetMapping("/{userId}")
    ResponseEntity<User> select(@PathVariable String userId) {
        User user = userService.select(userId);
        return ResponseEntity.ok(user);
    }
}
