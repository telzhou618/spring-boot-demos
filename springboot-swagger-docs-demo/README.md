# springboot-template

## swagger3.0整合springboot步骤

1. 引入jar包

```xml

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

2. 配置

```java

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API接口文档")
                .description("某某某管理系统")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller")) //这里写的是API接口所在的包位置
                .paths(PathSelectors.any())
                .build();
    }
}
```

3. 写接口，添加注解

```java

@Slf4j
@RestController
@Api(value = "用户信息管理")
public class UserController {

    @ApiOperation(value = "获取用户信息", notes = "通过用户ID获取用户信息")
    @GetMapping("/user/detail")
    public User detail(@ApiParam(value = "用户ID", required = true) @RequestParam Integer id) {
        return new User().setId(1).setUsername("zhangsan").setAge(10);
    }

    @ApiOperation(value = "保存用户信息", notes = "通过用户姓名获取用户信息")
    @PostMapping("/user/save")
    public Boolean detail(@ApiParam @RequestBody User user) {
        log.info("user:{}", user);
        return true;
    }
}
```

3. 启动服务后访问

http://localhost:8080/swagger-ui/#/


