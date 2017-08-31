#api-gateway-zuul

>1、使用正则的方式进行匹配，需要加入代码：
```
@Bean
public PatternServiceRouteMapper serviceRouteMapper() {
    return new PatternServiceRouteMapper(
            "(?<name>^.+)-(?<version>v.+$)",
            "${version}/${name}");
}
```


>2、使用这种方式的话，每一个serviceId的实例就需要是：user-server-provider-v1
访问的URL格式为：http://192.168.1.213:8031/v1/user-server-provider/user/1