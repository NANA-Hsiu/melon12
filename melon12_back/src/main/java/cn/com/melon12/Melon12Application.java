package cn.com.melon12;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("cn.com.melon12.*.mapper")
public class Melon12Application {

    public static void main(String[] args) {
        SpringApplication.run(Melon12Application.class, args);
    }

    //mybatis-plus插件加入ioc容器 //将方法返回的对象加入ioc容器
//    @Bean
//    public MybatisPlusInterceptor plusInterceptor(){
//        //mybatis-plus的插件集合【插入到这个集合种即可，分页插件，乐观锁插件】
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();//
//
//        return mybatisPlusInterceptor；
//    }
}
