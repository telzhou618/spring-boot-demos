# springboot-sentinel-demo

## sentinel 服务端

下载 sentinel-dashboard.jar 后执行以下命令启动
``` shell
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
```

## 客户端启动参数

```shell
-Dproject.name=springboot-sentinel-demo
-Dcsp.sentinel.dashboard.server=localhost:8080
-Dserver.port=9090
```