package cn.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PackageName: cn.itz.cloud
 * @ClassName: FileApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/12 11:12
 * @Version 1.0
 * 忽略数据的自动配置
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class FileApplication {
  public static void main(String[] args) {
    SpringApplication.run(FileApplication.class);
  }
}
