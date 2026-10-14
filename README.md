# robotest-demo-ci

robotest 平台 **GitLab 集成** 的示例外部工程：Maven + TestNG + Ryze，目标接口为
[httpbin.org](https://httpbin.org/)。用于验证 平台扫描 → YAML 解析 → 冻结清单 CI 执行 →
结果信封回传 的全链路契约。

## 结构

```
.
├── .gitlab-ci.yml                 # 平台 4 步契约模板（robotest-batch，逐字复制）
├── pom.xml                        # ryze / ryze-testng 6.1.2 + testng 7.11.0 + surefire 3.5.x
└── src/test/
    ├── java/com/robotest/demo/platform/
    │   ├── basic/                 # GetTest / PostTest / StatusHeaderTest（各 4 个有效用例）
    │   └── advanced/              # AdvancedScenarioTest（4 个多步/提取场景）
    └── resources/
        ├── common/env/env.yaml    # 默认环境（envFilePath 缺省值），首条无 ref_name 即默认
        ├── basic/{get,post,status}/*.yaml   # 步骤模板（与测试方法一一对应）
        └── advanced/*.yaml
```

## 用例口径

- **有效用例 16 个**：方法同时具备 `@Test(description=...)` 与 `@RyzeTest("path/to.yaml")`。
- **刻意非用例 2 个**（`StatusHeaderTest`，验证扫描 BR-1.6）：
  - `commentedOutCase`：整段位于块注释内；
  - `testNgOnlyCase`：仅有 `@Test`、缺少 `@RyzeTest`。
- 断言关键字按平台可回读口径书写：`status`→状态码、`json`+JSONPath→字段、
  `http`+`header.X`→响应头、`result`→响应体；`rule` 仅使用
  `equals / not_equals / contains / gt / lt / gte / lte / regex`。

## 本地执行

```bash
mvn test                          # 全量（17 个 TestNG 方法，16 个 Ryze 用例产信封）
mvn test -Dtest="com.robotest.demo.platform.basic.GetTest#getQuery"   # 单方法过滤（CI 同款）
```

结果信封输出至 `./__Ryze_Native_Result__/<testClass>#<testMethod>.json`（ryze-testng ≥ 6.1.2）。

## GitLab CI 接入

`.gitlab-ci.yml` 为平台模板逐字拷贝，四步固定：取冻结清单 → 按 `sourceRef` 过滤执行 →
上传 `__Ryze_Native_Result__` artifact → 回报完成。需在 GitLab CI/CD 变量配置：

- `ROBOTEST_PLATFORM_URL`：平台地址（结尾不留 `/`）
- `ROBOTEST_CI_TOKEN`：平台签发的只读令牌（Masked）
- `ROBOTEST_BATCH_ID`：平台触发流水线时注入（手动触发无此变量时不执行 job）
