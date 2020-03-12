# 如何启动一个简单的spring-boot-web工程

## 添加依赖
 ```
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
 ```

## 配置注解
  ```
@SpringBootApplication
public class CoreApplication {
  public static void main(String[] args) {
    SpringApplication.run(CoreApplication.class, args);
  }
}
  ```