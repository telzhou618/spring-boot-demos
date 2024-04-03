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

    @Operation(summary = "test请求")
    @PostMapping("/test")
    public Result<FileResp> test(@RequestBody FileResp fileResp){
        return Result.ok(fileResp);
    }
}
