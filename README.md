# Spring Boot + 本地DeepSeek

# 环境
- CentOS 8
- JDK 23
- IntelliJ IDEA 2024.1.1

# Steps
## 1. docker 安装 redis
```shell
docker run -d --name redis \
  -p 6379:6379 \
  --restart unless-stopped \
  -e REDIS_PASSWORD=123456 \
  redis:latest redis-server --requirepass 123456 --port 6379

```

## 2. 安装 ollama
```shell
docker run -d \
  --name ollama \
  -v /var/docker/ollama:/root/.ollama \
  -p 11434:11434 \
  --restart unless-stopped \
  ollama/ollama:0.6.2

```

## 3. 安装 DeepSeek-r1:7b
```shell
docker exec -it ollama ollama pull deepseek-r1:7b
```

## 4. 启动后端
```java
com.leonard.apriori.ds.AppApplication
```

## 5. 打开前端页面
```shell
项目根目录/frontend/chat.html
```
