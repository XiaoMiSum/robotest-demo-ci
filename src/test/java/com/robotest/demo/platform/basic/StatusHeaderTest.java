package com.robotest.demo.platform.basic;

import io.github.xiaomisum.ryze.support.testng.annotation.RyzeTest;
import io.github.xiaomisum.ryze.testelement.TestElement;
import org.testng.annotations.Test;

/**
 * 状态码与鉴权场景：除 4 个有效用例外，刻意保留 2 个"非用例"：
 * 块注释方法与仅 @Test 方法，用于验证平台扫描只统计双注解且描述非空的方法（BR-1.6）。
 */
public class StatusHeaderTest {

    @Test(description = "基础状态码 GET /status/200 返回200")
    @RyzeTest("basic/status/status_ok.yaml")
    public void statusOk(TestElement<?> element) {
    }

    @Test(description = "基础状态码 GET /status/404 返回404")
    @RyzeTest("basic/status/status_not_found.yaml")
    public void statusNotFound(TestElement<?> element) {
    }

    @Test(description = "基础鉴权 Basic Auth携带凭据访问成功")
    @RyzeTest("basic/status/basic_auth.yaml")
    public void basicAuthAuthorized(TestElement<?> element) {
    }

    @Test(description = "基础鉴权 Bearer令牌缺失401携带200")
    @RyzeTest("basic/status/bearer_token.yaml")
    public void bearerTokenAuthorized(TestElement<?> element) {
    }

/*
    // 非用例①：整段位于块注释内，扫描应排除
    @Test(description = "基础状态码 块注释内的用例扫描应排除")
    @RyzeTest("basic/status/should_be_ignored.yaml")
    public void commentedOutCase(TestElement<?> element) {
    }
 */

    // 非用例②：仅 @Test 缺少 @RyzeTest，扫描应排除（本地执行为空实现，可通过）
    @Test(description = "基础场景 仅TestNG注解缺少RyzeTest扫描应排除")
    public void testNgOnlyCase() {
    }
}
