# SPRING BOOT 学习

## 关于启动Spring boot
有两种方式，可执行jar的方式，记得添加 spring-boot-maven-plugin：
* mvn spring-boot:run
* mvn package && java -jar target/bsh.war
* 或者将其在IDE的tomcat中运行

## Spring MVC 配置
* 如果忘记配置spring.view.mvc.prefix和suffix，也就是没有指定默认的视图处理器

会出现spring boot Circular view path [login]: would dispatch back to the current handler URL
这个异常，循环视图。