# springboot-profile-demo

## 方式一 application.properties 多文件

- application-dev.properties
```properties
server.port = 8080
```
- application-test.properties
```properties
server.port = 8081
```
- application-uat.properties
```properties
server.port = 8082
```
- application-prd.properties
```properties
server.port = 8083
```
通过 application.properties 中指定 spring.profiles.active 激活哪个环境。
- application.properties
```properties
spring.profiles.active = test
```

## 方式二  application.yml 单文件
```yaml
spring:
  profiles:
    active: dev # 激活dev环境
    
--- # dev
spring:
  profiles: dev
server:
  port: 9090

--- # test
spring:
  profiles: test
server:
  port: 9091

--- # uat
spring:
  profiles: uat
server:
  port: 9092

--- # prd
spring:
  profiles: prd
server:
  port: 9093
```
## 激活环境的四种方法

- 通过应用程序参数设置
```shell
--spring.profiles.active=test  #program args
```

- 通过JAVA系统属性设置
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","dev");
        SpringApplication.run(Application.class, args);
    }

}
```

- 通过jvm参数设置
```shell
 -Dspring.profiles.active=test  #vm参数
```

- 通过配置文件设置
```properties
spring.profiles.active=test
```
或
```yaml
spring:
  profiles:
    active: test
```
-优先级排序 ：应用程序参数 > JAVA系统属性 > VM参数 > 配置文件参数