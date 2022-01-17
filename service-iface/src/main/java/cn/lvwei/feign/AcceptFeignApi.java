package cn.lvwei.feign;

import cn.lvwei.dto.req.TestModelReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lvwei
 * @date 2022/1/17
 */
@FeignClient(value = "accept-service", contextId = "sms")
public interface AcceptFeignApi {

    @GetMapping("/test/get")
    String testGet(@RequestParam String value);

    @PostMapping("/test/post")
    String testPost(@RequestBody TestModelReq testModelReq);
}
