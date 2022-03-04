# springboot-event-demo

## spring 事件监听
spring 已封装了事件发布和订阅相关的处理方案，可以帮助开发解耦，减少不同模块之间的依赖，实现包含三个步骤。
1. 定义事件，需继承 ApplicationEvent。
2. 发布事件，需要 ApplicationEventPublisher 对象，可通过实现 ApplicationEventPublisherAware 获得。
3. 监听事件，有两种，一种是实现 ApplicationListener 接口，一种是给方法加上@EventListener注解。

## 应用实例
模拟用户注册成功后，给用发优惠券，发邮件通知的业务场景。
1. 定义自定义事件对象,需要继承 ApplicationEvent。

```java
public class UserRegisterEvent extends ApplicationEvent {

    private String username;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
```

2. 定义事件发布器器，事件发布需要ApplicationEventPublisher对象，实现 ApplicationEventPublisherAware 可获取发布器对象，调用它的 publishEvent 方法可发布事件。

```java

@Service
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void register() {
        System.out.println("用户注册成功!");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, "tom"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

```

3. 定义事件监听类，有两种方法，一种是实现 ApplicationListener 接口，可通过泛型指定关心的事件， 另一种是给方法加上 @EventListener 注解同样可实现事件监听。

```java
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("发邮件给:" + event.getUsername());
    }
}
```

```java
@Service
public class CouponService {

    @EventListener
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("发优惠券给:" + event.getUsername());
    }
}
```