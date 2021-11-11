# springboot-smart-docs-demo
在springboot项目中使用 smart-docs 生成接口文档,相比swagger,smart-docs侵入性小。

## step1
在pom.xml中添加插件依赖
```xml
    <plugin>
        <groupId>com.github.shalousun</groupId>
        <artifactId>smart-doc-maven-plugin</artifactId>
        <version>2.2.7</version>
        <configuration>
            <configFile>./src/main/resources/smart-doc.json</configFile>
            <projectName>${project.name}</projectName>
        </configuration>
    </plugin>
```

## step2 
配置文件 smart-doc.json,存放在resources目录下
```json
{
  "serverUrl": "http://localhost:8080",
  "outPath": "src/main/resources/static/doc",
  "allInOne": true,
  "createDebugPage": true,
  "allInOneDocFileName":"index.html",
  "projectName": "springboot-smart-docs-demo"
}
```
- serverUrl 服务器地址，填写在文档测试很方便
- outPath 文档保存位置
- allInOne 文档是否合并在一个html中
- createDebugPage 是否支持在文档中调试
- allInOneDocFileName 文件名称
- projectName 项目名称
## step3

在idea maven插件找到 smart-doc,执行 smart-doc:html 生成接口文档。


