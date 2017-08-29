#hystrix-server-dashboard

>1、Dalston.SR2默认是开启Hystrix的，加入未开启，要在配置文件中或者通过注解的方式打开；

>2、引入依赖，在Dalston.SR2版本中只需要引入即可：

```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
    </dependency>
```

>3、要访问运行了Hystrix的服务，例如：http://localhost:9080/hystrix.stream，而该hystrix-server-dashboard实例端口是8060，要区分开；

>4、最后访问的界面是http://localhost:8060/hystrix,在新建界面上输入的是http://localhost:9080/hystrix.stream地址，要区分开；

>5、要正确的启动各个服务：Eureka、Hystrix、Hystrix-Dashboard这样的话才会有数据;

>6、dashboard是对单个节点的监控，实现分布式的监控的是Turbine;