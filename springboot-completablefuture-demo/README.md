# springboot-completablefuture-demo

## 模拟CompletableFuture并发处理任务
- 实现并发从从A服务获取用户签名，从B服务获取用户头像
- 最后收集多方返回的数据，组合一个完整数据用户返回给客户端
- 任意一个服务执行异常由exceptionally方法中处理
- 使用Spring自定义线程池ThreadPoolTaskExecutor
