package com.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @author telzhou618
 **/
@RestController
@RequestMapping("test")
@Tag(name = "测试接口")
public class TestController {

    /**
     * 测试请求处理方法
     *
     * @param fileResp 接收前端上传的文件响应信息
     * @return 返回处理结果，包含文件响应信息
     */
    @Operation(summary = "test请求")
    @PostMapping("/test")
    public Result<FileResp> test(@RequestBody FileResp fileResp){
        return Result.ok(fileResp);
    }

    /**
     * 测试请求处理方法
     *
     * @param a 接收一个String类型的参数，本示例中未使用
     * @param b 接收一个Integer类型的参数，本示例中未使用
     * @return 返回一个Result对象，表示操作结果，本示例中总是返回成功状态
     */
    @Operation(summary = "test请求")
    @PostMapping("/test2")
    public Result test2(String a , Integer b){
        // 生成一个成功结果并返回
        return Result.ok(null);
    }
}
