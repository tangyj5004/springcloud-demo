#api-gateway-zuul

>1、使用Zuul需要添加相关依赖：

```
 <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zuul</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
    </dependencies>
```

>2、启动主类中添加注解@EnableZuulProxy即可。

>3、需要把Zuul注册到Eureka上，需要相应的配置,下边是最基本的配置：

```
 eureka:
   client:
     service-url: #Eureka服务的地址
       defaultZone: http://${eureka-server.security.user.name}:${eureka-server.security.user.password}@${eureka-server.hostname}:${eureka-server.port}/eureka/
   instance:
     prefer-ip-address: true #在Eureka注册管理界面上显示微服务真是的IP地址
```

>4、配置Zuul的路由功能：

```
#第一种配置的方式
zuul:
  routes:
    user-server-provider: /user-provider/**
```

第一种配置的方式直接访问未配置路由的路径http://192.168.1.213:8030/user-server-provider/user/1和配置后的路径都可以进行访问http://192.168.1.213:8030/user-provider/user/1

```
#第二种配置的方式
zuul:
  ignoredServices: '*' #禁止所有的微服务，除了下边进行的配置，多个之间用逗号隔开
  routes:
    user-server-provider: /user-provider/**
```   
第二种配置的方式只可以访问http://192.168.1.213:8030/user-provider/user/1，另外一种不可以进行访问
 
```   
#第三种配置的方式，可以带对路由进行更细粒度的控制
zuul:
  ignoredServices: '*'
  routes:
    user-server-provider:               #这个可以随意写，便于区分即可
      path: /user-provider/**           #最终访问的路径
      serviceId: user-server-provider   #注册到Eureka的serviceId
    abc:                             
      path: /user-provider/**        
      serviceId: user-server-provider2

```

```  
#第四种配置的方式，可以带对路由进行更细粒度的控制
#使用URL的方式不会使用Ribbon进行负载均衡，也不会使用Hystrix的功能
zuul:
  ignoredServices: '*'
  routes:
    user-server-provider:               #这个可以随意写，便于区分即可
      path: /user-url/**                #最终访问的路径
      url: http://localhost:8085        #指定微服务的URL地址
```  
使用第四种配置的方式，URL的方式不会使用Ribbon进行负载均衡，也不会使用Hystrix的功能，其他三种都可以实现负载均衡等；

>5、使用上述第四种的方式的话，如果需要使用负载均衡，请使用下边的方式:

``` 
zuul:
  ignoredServices: '*'
  routes:
    user-provider:               #这个可以随意写，便于区分即可
      path: /user-provider/**               #最终访问的路径
      serviceId: user-server-provider   #注册到Eureka的serviceId

ribbon:
  eureka:
    enabled: false

user-server-provider: #是serviceId
  ribbon:
    listOfServers: http://localhost:8085 ,http://localhost:8086
```