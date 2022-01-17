package cn.lvwei.controller;

import cn.lvwei.dto.req.TestModelReq;
import cn.lvwei.feign.AcceptFeignApi;
import com.alibaba.fastjson.JSONObject;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author lvwei
 * @date 2022/1/17
 */
@Slf4j
@RestController
@Api(tags = "测试接口")
public class TestController implements AcceptFeignApi {

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "测试get请求")
    public String testGet(@RequestParam String value) {
        log.info("accept-service-test-get");
        return "value : " + value;
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "测试post请求")
    public String testPost(@RequestBody TestModelReq testModelReq) {
        log.info("accept-service-test-post");

        return "testReq : " + JSONObject.toJSONString(testModelReq);
    }
}
