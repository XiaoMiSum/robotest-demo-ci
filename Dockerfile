# Robotest GitLab CI 执行镜像：Maven 3.9.9 + JDK 21 + jq
#
# jq 为 .gitlab-ci.yml 解析冻结清单所必需（模板要求镜像内预装）。
# 内置以消除 job 内 apt-get 对 Ubuntu 源的网络依赖——该源在部分网络下
# 返回 502，曾直接导致批次流水线失败。
#
# 优先取 jq 官方静态二进制（单文件、无依赖、可在离线/受限网络构建），
# 下载失败回落 apt 安装并重试，两条路径都失败则构建失败（快速暴露而非带病出镜像）。
FROM maven:3.9.9-eclipse-temurin-21

ARG JQ_VERSION=1.7.1

RUN set -eux; \
    arch="$(dpkg --print-architecture)"; \
    if curl -fsSL -m 60 -o /usr/local/bin/jq \
        "https://github.com/jqlang/jq/releases/download/jq-${JQ_VERSION}/jq-linux-${arch}"; then \
        chmod +x /usr/local/bin/jq; \
    else \
        for i in 1 2 3; do \
            apt-get update -qq \
            && apt-get install -y -qq --no-install-recommends jq \
            && break; \
            sleep 5; \
        done; \
        rm -rf /var/lib/apt/lists/*; \
    fi; \
    jq --version
