#eureka-server-discovery

>1、application-standalone.yml配置的是单一的注册中心；

>2、application-peer1.yml和application-peer2.yml 分别是构造两台机器的Eureka高可用注册中心；
    并且application name要一样，这样的话才会是在一个分片上：

```
    spring:
      application:
        name: eureka-server
```

>3、要修/etc/hosts文件使之对应的可以访问。

>4、在两个Eureka高可用实例中peer1的注册中心指向了peer2，peer2的注册中心指向了peer1，这样就可以相互注册，现实的结果中：在peer1可以看到
    peer2的注册信息，在peer2可以看到peer1的注册信息；

>5、在进行项目打包的时候，要注意使用的plugin为如下：

```
    <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <version>${spring-boot.version}</version>
                    <configuration>
                        <maimClass>com.xuliugen.springcloud.EurekaServerDiscoveryApplication</maimClass>
                    </configuration>
                    <executions>
                        <execution>
                            <goals>
                                <goal>repackage</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
```

>6、启动两个peer的命令，在编译好的target目录中使用如下命令：

```
java -jar eureka-server-discovery-0.0.1-SNAPSHOT.jar  --spring.profiles.active=peer1
```

```
java -jar eureka-server-discovery-0.0.1-SNAPSHOT.jar  --spring.profiles.active=peer2
```

>7、最后的结果访问eureka界面，会分别显示两个eureka实例：

<table class="table table-bordered table-striped table-condensed">  
    <tr>  
        <td>﻿Application</td>  
        <td>﻿AMIs</td>  
        <td>﻿Availability Zones</td>  
        <td>﻿Statuss</td>  
    </tr>  
    <tr>  
        <td>﻿EUREKA-SERVER</td>  
        <td>﻿n/a (2)</td>  
        <td>﻿(2)</td>  
        <td>﻿UP (2) - 192.168.1.108:eureka-server:1111 , 192.168.1.108:eureka-server:1112</td>  
    </tr>  
</table>