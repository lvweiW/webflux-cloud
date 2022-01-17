package cn.lvwei.controller;

import cn.lvwei.dto.req.TestModelReq;
import cn.lvwei.feign.AcceptFeignApi;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lvwei
 * @date 2022/1/17
 */
@RestController
@Api(tags = "测试接口")
public class TestController {

    @Autowired
    AcceptFeignApi acceptFeignApi;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "测试get请求")
    @GetMapping("/test/get")
    public String test(@RequestParam String value) {
        return acceptFeignApi.testGet(value);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "测试post请求")
    @PostMapping("/test/post")
    public String test(@RequestBody TestModelReq testModelReq) {
        return acceptFeignApi.testPost(testModelReq);
    }
}
