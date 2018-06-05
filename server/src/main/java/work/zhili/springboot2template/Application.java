package work.zhili.springboot2template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Title : work.zhili.springboot2template <br>
 * Description :
 *  <p>
 *  <ul>
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/21 18:10
 */
@SpringBootApplication
public class Application {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        LOG.info("application was started ...");
    }
}
