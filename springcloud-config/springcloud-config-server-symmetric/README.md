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

>2、application.yml添加对称秘钥配置：

```
encrypt:
  key: www.123xuliugen..  #设置的对称秘钥
```

>3、使用curl生成秘钥：curl -X POST http://localhost:8090/encrypt -d abc, 要加密的内容内容是abc，生成结果如下：
```
C:\Users\xuliu\Downloads\curl-7.55.1-win64-mingw\bin>curl -X POST http://localhost:8090/encrypt -d abc
aaee035be4f3877ce345a4eb8403d72e4f1b16c163346e87dc14c8575226663c
```

注意：如果实在Windows平台下使用的话，要是用windows下的cmd请求curl，这就需要下载curl工具，因为修改的jdk是在windows平台下的，否则结果不正确。

>5、将内容存放到git仓库中

>5、config client直接可以访问: