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
C:\Users\xuliu\Downloads\curl-7.55.1-win64-mingw\bin>curl.exe -X POST http://localhost:8090/encrypt -d abc
AQCjyWQKnAiG53texg4yWdo8kW7+uFMFZAsbdLT/0sY8sGO1zGVwj47Rf+5t+l5ulsVY6U40BkjzGmF6bC5WKVVhUoU5QQV96Q/iAbaKYjz77nPBmyzmjOTzWkWBvj2Z7E/hO+RTEcSlMPE+txl5AFEXkZqUlzg2KSC+z26aKamgjKoufpNnzEPVwsACaml3k4rhU26SibUfJ9A7UZo3YMqjqqmnrbEvic9/Gb+nZWZFHgCPsSxcmWc82FrObjfK7BZGAQsEynLOEIeG0in8HLD0AHOV8/Y9AWhnXUI8gaq1mjP+P2xWXXMrLok9BKq+ox5hntcgS984m8IE1HAtDRPRttx89IES4AM/BQHs9Mt4lqGCrl7a8Hl/RbgXFp6aQQw=
```

注意：如果实在Windows平台下使用的话，要是用windows下的cmd请求curl，这就需要下载curl工具，因为修改的jdk是在windows平台下的，否则结果不正确。

>5、将内容存放到git仓库中

如果是application.yml类型的文件，格式如下,要加引号：

```
profile : '{cipher}AQCb2gXCI2n7qN+86eITodzGmx+d6zm/oJSV3412iD/61fiQaVZlYXelTmRkVtiKfP3MMan0zQqGYMsj8cAIVGbQ2XMTCj8c8ibDUpUgLGEB+xoR/Elt2OsFP0s2fKejyNRaQoB/VjosrJybjSgwXTYR/SsSdhLohfJqxrw9bn6h/yGv4IOIdkNTPcWFx484/2K4nDq6iXV/y3Zi78frut1WFco3zR0RJrl42nH89TsL3Kt11Eh4BRwQZlXPKmXyhCbFdhBXLxx6Bp3/peVkxoj5hizqb+xIurwlmK6+BJKUhuV1HkOcdmG4+RkqoNDzjcWQGBhsyvoaziIN8NZKeFgsIfpgVn/Ezbn95By8dLqbkDNPTgrK4F0FDTAJfAjLvCk='
```

如果是application.properties类型的文件，格式如下,不加引号：
```
profile : {cipher}AQCb2gXCI2n7qN+86eITodzGmx+d6zm/oJSV3412iD/61fiQaVZlYXelTmRkVtiKfP3MMan0zQqGYMsj8cAIVGbQ2XMTCj8c8ibDUpUgLGEB+xoR/Elt2OsFP0s2fKejyNRaQoB/VjosrJybjSgwXTYR/SsSdhLohfJqxrw9bn6h/yGv4IOIdkNTPcWFx484/2K4nDq6iXV/y3Zi78frut1WFco3zR0RJrl42nH89TsL3Kt11Eh4BRwQZlXPKmXyhCbFdhBXLxx6Bp3/peVkxoj5hizqb+xIurwlmK6+BJKUhuV1HkOcdmG4+RkqoNDzjcWQGBhsyvoaziIN8NZKeFgsIfpgVn/Ezbn95By8dLqbkDNPTgrK4F0FDTAJfAjLvCk=
```

>5、config client直接可以访问: