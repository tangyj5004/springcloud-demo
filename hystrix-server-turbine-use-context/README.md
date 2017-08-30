#hystrix-server-turbine-use-context

>1、如果监控设置了context-path和home-page-url-path的话，请求的方式变成,在user-server-consumer-ribbon-with-hystrix-use-context项目中访问的地址变成http://localhost:9009/ribbon/hystrix.stream；

>2、在Turbine中访问的方式变成：http://localhost:8062/turbine.stream?cluster=USER-SERVER-CONSUMER-RIBBON-WITH-HYSTRIX-USE-CONTEXT；

>3、然后将2中的地址输入到Dashboard中(http://localhost:8060/hystrix)，这样的话就可以监控；