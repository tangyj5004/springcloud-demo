#springcloud-config-client-refresh

>1、添加actuator依赖:

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

```

添加actuator依赖的原因：

```
For a Spring Boot Actuator application there are some additional management endpoints:

POST to /env to update the Environment and rebind @ConfigurationProperties and log levels

/refresh for re-loading the boot strap context and refreshing the @RefreshScope beans

/restart for closing the ApplicationContext and restarting it (disabled by default)

/pause and /resume for calling the Lifecycle methods (stop() and start() on the ApplicationContext)

```

>2、在具体的Controller上添加注解：@RefreshScope,但是需要进行手动刷新配置;

>3、在cmd中访问：curl -X POST http://localhost:8080/refresh 即可刷新属性信息的更改