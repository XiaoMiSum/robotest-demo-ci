package com.robotest.demo.platform.advanced;

import io.github.xiaomisum.ryze.support.testng.annotation.RyzeTest;
import io.github.xiaomisum.ryze.testelement.TestElement;
import org.testng.annotations.Test;

/**
 * 进阶多步场景：重定向跟随、响应体整体断言、跨步骤变量提取与引用，
 * 用于验证平台多步骤场景解析、提取器转换与变量串联执行。
 */
public class AdvancedScenarioTest {

    @Test(description = "进阶场景 /redirect/2重定向跟随最终200")
    @RyzeTest("advanced/redirect_follow.yaml")
    public void redirectFollowed(TestElement<?> element) {
    }

    @Test(description = "进阶场景 /base64响应体解码文本校验")
    @RyzeTest("advanced/base64_decode.yaml")
    public void base64DecodedBody(TestElement<?> element) {
    }

    @Test(description = "进阶场景 /anything提取回显串联第二步")
    @RyzeTest("advanced/anything_trace.yaml")
    public void anythingEchoTrace(TestElement<?> element) {
    }

    @Test(description = "进阶场景 提取UUID串联第二步query校验")
    @RyzeTest("advanced/uuid_chain.yaml")
    public void uuidChain(TestElement<?> element) {
    }
}
