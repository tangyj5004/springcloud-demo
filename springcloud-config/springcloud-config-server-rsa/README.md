#springcloud-config-server-rsa

>先决条件：替换原有jdk和jre中的JCE
    
    Prerequisites: to use the encryption and decryption features you need the full-strength JCE installed in your 
    JVM (it’s not there by default). You can download the "Java Cryptography Extension (JCE) Unlimited Strength 
    Jurisdiction Policy Files" from Oracle, and follow instructions for installation (essentially replace the 2 
    policy files in the JRE lib/security directory with the ones that you downloaded).
    
    JCE url:http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

window环境的话，上搜索JCE中需要替换的jar会出现两个位置，全部替换即可！

>1、执行命令：

```
keytool -genkeypair -alias mysqlPassword -keyalg RSA \
  -dname "CN=Spring Cloud Config Server,OU=Unit,O=Organization,L=Chengdu,S=State,C=CN" \
  -keypass root123456 -keystore server.jks -storepass root888888
```

>2、添加配置：

```
encrypt:
  keyStore:
    location: classpath:/server.jks
    password: root888888    #storepass
    alias: mysqlPassword    #对应alias
    secret: root123456      #keypass
```

>3、在cmd输入 ``` keytool -genkeypair --help``` 可以查看命令的参数意义：
```

C:\Users\xuliugen> keytool -genkeypair --help
keytool -genkeypair [OPTION]...

生成密钥对

选项:

 -alias <alias>                  要处理的条目的别名
 -keyalg <keyalg>                密钥算法名称
 -keysize <keysize>              密钥位大小
 -sigalg <sigalg>                签名算法名称
 -destalias <destalias>          目标别名
 -dname <dname>                  唯一判别名
 -startdate <startdate>          证书有效期开始日期/时间
 -ext <value>                    X.509 扩展
 -validity <valDays>             有效天数
 -keypass <arg>                  密钥口令
 -keystore <keystore>            密钥库名称
 -storepass <arg>                密钥库口令
 -storetype <storetype>          密钥库类型
 -providername <providername>    提供方名称
 -providerclass <providerclass>  提供方类名
 -providerarg <arg>              提供方参数
 -providerpath <pathlist>        提供方类路径
 -v                              详细输出
 -protected                      通过受保护的机制的口令

使用 "keytool -help" 获取所有可用命令
```
>4、使用curl生成秘钥：curl -X POST http://localhost:8090/encrypt -d abc, 要加密的内容内容是abc，生成结果如下：
```
753AQABl+GoElKXC/j0pSQ8C7tfccLVYrWehxp30HcETe8BpN7nXUa7JJpfHfehVJ1gcBPf3rsh8rY+S95cujck8ciyvnh
cn+MkY4GGzjYcDRyQjIrE/nxAUIIUvbkNg2IyKxczbUBE43vprDDoj80ZGLREV0sySAS2dEMi6K/+lhSKfkWJkyurS+xAQ
bf3TtLSQZOOKO+VlhVQoewlk5oZx94U3ujKMlfMma5kx1ISJvFDwFU5hr3YcbIpeRLEwsywJjgqGTHBO60Q0z5db1AvPMwz
g/wNkAj9b+dFmiaSMYpm9dU1bmtzrR5yY/uXQGn1tPpu3P+PYN7oUX6GuVriwU+Q+vYIb9NDI3a6d1mQvTl4FZH1uC/wVtu
ym5WZJk1Y+vs=
```

>5、将内容存放到git仓库中

>5、config client直接可以访问: