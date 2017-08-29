#hystrix-server-turbine

>1、使用Turbine要引用依赖如下：

```
    <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-turbine</artifactId>
    </dependency>
```

>2、Turbine本身需要注册到Eureka上边，因此还需要进行相应的配置，指定Eureka服务端配置，关键的是clusterConfig和appConfig的配置；

```
    turbine:
      aggregator:
        clusterConfig: USER-SERVER-CONSUMER-FEIGN-WITH-HYSTRIX
      appConfig: user-server-consumer-feign-with-hystrix
```


>3、启动服务提供者，这里是user-server-provider；

>4、启动user-server-consumer-feign-with-hystrix,启动多个实例：9080和9081，并且要确保例如：http://192.168.1.213:9080/hystrix.stream访问这个端口是应有一直有数据产生的；

>5、启动Turbine，端口为8061，游览器中输入：http://localhost:8061/turbine.stream?cluster=USER-SERVER-CONSUMER-FEIGN-WITH-HYSTRIX，在user-server-consumer-feign-with-hystrix有访问的时候是有数据的；

>6、启动Dashboard，访问http://192.168.1.213:8060/hystrix，在界面上的输入框中应该输入5中的地址：http://localhost:8061/turbine.stream?cluster=USER-SERVER-CONSUMER-FEIGN-WITH-HYSTRIX;

>6、如果要配置多个应用，第一种方式示例如下：

```
    turbine:
      aggregator:
        clusterConfig: USER-SERVER-CONSUMER-FEIGN-WITH-HYSTRIX,USER-SERVER-CONSUMER-RIBBON-WITH-HYSTRIX
      appConfig: user-server-consumer-feign-with-hystrix,user-server-consumer-ribbon-with-hystrix
```

>7、第二种方式示例如下：

```
    turbine:
      aggregator:
        clusterConfig: default
      appConfig: user-server-consumer-feign-with-hystrix,user-server-consumer-ribbon-with-hystrix # 需要监控的集群列表
      clusterNameExpression: "'default'"
```

>8、如果是多实例监控的话，采用第二种的方式，此时启动Turbine，直接访问：http://localhost:8061/turbine.stream即可，不再是5中那样还需要设置参数;

>9、然后在启动Dashboard，直接在输入框中输入http://localhost:8061/turbine.stream即可监控数据。