package cn.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PackageName: cn.itz.cloud
 * @ClassName: EurekaApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/11 14:38
 * @Version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class,args);
  }
}
