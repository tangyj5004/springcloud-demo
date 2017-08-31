#springcloud-config

>1、使用的依赖版本有要求的，这里使用的是：

```
<spring-boot.version>1.5.6.RELEASE</spring-boot.version>
<spring-cloud.version>Dalston.SR3</spring-cloud.version>

```

>2、访问的方式为：http://localhost:8080/springcloudconfig/dev/master，返回的格式为：


```
{
    name: "springcloudconfig",
    profiles: [
        "dev"
    ],
    label: "master",
    version: "b35671e5862798d571e2a6a6fbacb93ad7191d47",
    state: null,
    propertySources: [
        {
            name: "https://git.oschina.net/xuliugen/spring-cloud-config/configs/springcloudconfig-dev.yml",
            source: {
                profile: "profile-dev"
            }
        },
        {
            name: "https://git.oschina.net/xuliugen/spring-cloud-config/configs/springcloudconfig.yml",
            source: {
                document: "profile:profile"
            }
        }
    ]
}

```

>3、另外，还可以这样访问：http://localhost:8080/springcloudconfig-prod.json

```
{
    document: "profile:profile",
    profile: "profile-prod"
}
```

>4、http://localhost:8080/springcloudconfig-prod.yml

```
document: profile:profile
profile: profile-prod
```