package com.robotest.demo.platform.basic;

import io.github.xiaomisum.ryze.support.testng.annotation.RyzeTest;
import io.github.xiaomisum.ryze.testelement.TestElement;
import org.testng.annotations.Test;

/**
 * 基础 GET 场景：覆盖查询参数、UUID 提取、请求头/响应头回显三类断言关键字，
 * 供平台验证 扫描（双注解）→ YAML 解析 → 执行 → 结果信封回传 全链路。
 */
public class GetTest {

    @Test(description = "基础GET /get 查询参数透传校验")
    @RyzeTest("basic/get/get_query.yaml")
    public void getQuery(TestElement<?> element) {
    }

    @Test(description = "基础GET /uuid 提取UUID并校验格式")
    @RyzeTest("basic/get/get_uuid.yaml")
    public void getUuid(TestElement<?> element) {
    }

    @Test(description = "基础GET /headers 自定义请求头回显校验")
    @RyzeTest("basic/get/get_headers_echo.yaml")
    public void getHeadersEcho(TestElement<?> element) {
    }

    @Test(description = "基础GET /response-headers 响应头与JSON双通道校验")
    @RyzeTest("basic/get/get_response_headers.yaml")
    public void getResponseHeaders(TestElement<?> element) {
    }
}
