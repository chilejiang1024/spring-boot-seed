package work.zhili.springboot2template.service;

import org.springframework.stereotype.Service;
import work.zhili.springboot2template.model.User;

import java.util.List;

/**
 * Title : work.zhili.springboot2template.service <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/4 14:18
 */
public interface IUserService {

    /**
     * just for testing
     * @return {User, ...}
     */
    List<User> queryAllForTesting();

    /**
     * insert a user
     * @param user the user
     */
    void insert(User user);

    /**
     * delete a user (physically delete) <br>
     * <b>DO NOT USE THIS unless you're pretty sure about it</b>
     * @param userId the user's id
     */
    void delete(String userId);

    /**
     * invalid a user
     * @param userId the user's id
     */
    void invalid(String userId);

    /**
     * update a user
     * @param user the user
     */
    void update(User user);

    /**
     * select a user
     * @param userId the user's id
     * @return
     */
    User select(String userId);
}
