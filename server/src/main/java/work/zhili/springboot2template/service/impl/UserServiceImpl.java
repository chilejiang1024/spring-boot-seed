package work.zhili.springboot2template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import work.zhili.springboot2template.dao.IUserMapper;
import work.zhili.springboot2template.model.User;
import work.zhili.springboot2template.service.IUserService;

import java.util.List;

/**
 * Title : work.zhili.springboot2template.service.impl <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/4 14:19
 */
@Service
public class UserServiceImpl implements IUserService {

    private final IUserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable(cacheNames = "users")
    public List<User> queryAllForTesting() {
        return userMapper.queryAllForTesting();
    }

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public void delete(String userId) {
        userMapper.delete(userId);
    }

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public void invalid(String userId) {
        userMapper.invalid(userId);
    }

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    @Cacheable(cacheNames = "users", key = "#userId")
    public User select(String userId) {
        return userMapper.select(userId);
    }
}
