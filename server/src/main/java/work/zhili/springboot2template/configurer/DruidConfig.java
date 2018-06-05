package work.zhili.springboot2template.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Title : work.zhili.springboot2template.configurer <br>
 * Description :
 *   druid config
 *
 * @author chile
 * @version 1.0
 * @date 2018-4-17 13:43:39
 */
@Configuration
public class DruidConfig {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        //用户名
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        //密码
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        //初始化时建立物理连接的个数
        dataSource.setInitialSize(env.getProperty("spring.datasource.initialPoolSize", Integer.class));
        //最小连接池数量
        dataSource.setMinIdle(env.getProperty("spring.datasource.minPoolSize", Integer.class));
        //最大连接池数量
        dataSource.setMaxActive(env.getProperty("spring.datasource.maxPoolSize", Integer.class));
        //获取连接时最大等待时间，单位毫秒
        dataSource.setMaxWait(env.getProperty("spring.datasource.maxWait", Long.class));
        //用来检测连接是否有效的sql
        dataSource.setValidationQuery("SELECT 1");
        //申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestOnBorrow(false);
        //归还连接时执行validationQuery检测连接是否有效
        dataSource.setTestOnReturn(false);
        //建议配置为true，不影响性能，并且保证安全性
        dataSource.setTestWhileIdle(true);
        //是否缓存preparedStatement，也就是PSCache
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(
            env.getProperty("spring.datasource.maxPoolPreparedStatementPerConnectionSize", Integer.class));
        dataSource.setTimeBetweenEvictionRunsMillis(
            env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis", Long.class));
        dataSource.setMinEvictableIdleTimeMillis(
            env.getProperty("spring.datasource.minEvictableIdleTimeMillis", Long.class));
        return dataSource;
    }

}