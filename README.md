
springMvc4 + hibernate5 + maven 构建

1.环境 jdk 1.7+ 、 tomcat 7 、 Mysql 5 、 maven 3 、UTF-8编码

2.sql 见 src 目录下 sql 文件 , 默认 hibernate 自动建表

3.配置文件见 src/resources 目录 

    1.springMvc 以 location="classpath:*-gourderwa.properties" 装载配置,若修改配置文件名称对应修改此处
    
    2.指定 ehcache.xml 中 diskStore path 存储目录
    
    3.数据库连接配置见 jdbc-hibernate-config-gourderwa.properties

    4.jdbc-hibernate-config-gourderwa.properties 中默认hibernate.hbm2ddl.auto=create ，如做好demo数据后请修改为validate
    
    5.将doc中文件放置于 pdfUploadAddress 配置目录下，项目启动后自动设置为demo数据文件

    6.修改project-gourderwa.properties配置文件内容与预期一致