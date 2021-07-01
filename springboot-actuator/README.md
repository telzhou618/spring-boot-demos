# springboot-actuator
springboot健康检查

## 验证健康检查
启动项目访问：http://localhost:8080/actuator/health
```json
{
  "status": "DOWN",
  "components": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 250685575168,
        "free": 81286369280,
        "threshold": 10485760
      }
    },
    "ping": {
      "status": "UP"
    },
    "rocketMQ": {
      "status": "DOWN",
      "details": {
        "errorCode": 500
      }
    }
  }
}

```
## 获取自定义的检查参数
http://localhost:8080/actuator/info
```json
{
  "app": {
    "name": "springboot-actuator-app",
    "version": 1.0
  }
}
```
