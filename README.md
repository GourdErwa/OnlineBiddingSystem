
springMvc4 + hibernate5 + maven 构建

1.环境 jdk 1.7+ 、 tomcat 7 、 Mysql 5 、 maven 3 、UTF-8编码

2.sql 见 src 目录下 sql 文件 , 默认 hibernate 自动建表

3.配置文件见 src/resources 目录 

    springMvc 以 location="classpath:*-gourderwa.properties" 装载配置,若修改配置文件名称对应修改此处
    
    指定 ehcache.xml 中 diskStore path 存储目录
    
    数据库连接 jdbc-hibernate-config-gourderwa.properties
    
