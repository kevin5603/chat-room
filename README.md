# 簡易聊天室

### 前端 Angular

run frontend server

```
ng serve
```

### 後端 Java

run backend server

```
./mvnw spring-boot:run
```

### 消息對列 RabbitMQ

使用docker

```
docker run -d --hostname my-rabbit -p 5672:5672 -p 61613:61613 -p15672:15672 --name my-rabbit rabbitmq:3.9.14
```
