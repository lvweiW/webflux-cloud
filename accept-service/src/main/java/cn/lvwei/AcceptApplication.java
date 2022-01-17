package cn.lvwei;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author lvwei
 * @date 2022/1/17
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "cn.lvwei")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.lvwei")
public class AcceptApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(AcceptApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = ObjectUtil.isEmpty(env.getProperty("server.servlet.context-path")) ? "" : Objects.requireNonNull(env.getProperty("server.servlet.context-path")).trim();
        log.info("\n----------------------------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: http://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
        log.info("启动成功");
    }
}
