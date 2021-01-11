package cn.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud
 * @Version 1.0
 * @date 2021/1/11 21:27
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * 开启通用mapper的包扫描
 *
 */
@MapperScan(basePackages = {"cn.itz.cloud.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
