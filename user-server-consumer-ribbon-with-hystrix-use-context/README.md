#user-server-consumer-ribbon-with-hystrix-use-context

>1、加上了context-path之后，接口请求的方式要加上这个路径，例如最后变成：http://localhost:9009/ribbon/user/hyxstric/1
 
 
>2、访问hystrix的链接为：http://localhost:9009/ribbon/hystrix.stream

>3、不管访问什么需要加这一个前缀