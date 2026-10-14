package com.robotest.demo.platform.basic;

import io.github.xiaomisum.ryze.support.testng.annotation.RyzeTest;
import io.github.xiaomisum.ryze.testelement.TestElement;
import org.testng.annotations.Test;

/**
 * 基础写操作场景：POST（JSON / 表单两种请求体）、PUT、DELETE，
 * 覆盖平台 method/config 关键字转换与 JSONPath 断言往返。
 */
public class PostTest {

    @Test(description = "基础POST /post JSON请求体回显校验")
    @RyzeTest("basic/post/post_json.yaml")
    public void postJsonBody(TestElement<?> element) {
    }

    @Test(description = "基础POST /post 表单数据回显校验")
    @RyzeTest("basic/post/post_form.yaml")
    public void postFormData(TestElement<?> element) {
    }

    @Test(description = "基础PUT /put 请求体更新回显校验")
    @RyzeTest("basic/post/put_update.yaml")
    public void putUpdate(TestElement<?> element) {
    }

    @Test(description = "基础DELETE /delete 查询参数回显校验")
    @RyzeTest("basic/post/delete_resource.yaml")
    public void deleteResource(TestElement<?> element) {
    }
}
