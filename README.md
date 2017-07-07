# spring-boot-tomcat-demo
将spring boot项目打包为war，部署至tomcat环境运行。

##### 1、默认情况下，spring boot项目编译打包后的jar包文件包含三个部分：
    
    org：spring boot框架的配置文件（.class）;
    META-INF：项目的版本信息、lib信息、version等信息；
    BOOT-INF：项目依赖的lib及项目的执行文件（.class）.
    
##### 2、如果要将spring boot项目打包为可以部署的war包，首先需要修改项目的pom文件：
    
    ......
    <packaging>war</packaging>
    ......
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
    .....
    
    接下来@SpringBootApplication注解的主程序继承SpringBootServletInitializer，重写config方法，如下所示：
    
    @SpringBootApplication
    public class MainApplication extends SpringBootServletInitializer {
    
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(MainApplication.class);
        }
    
        public static void main(String[] args) throws Exception {
            SpringApplication.run(MainApplication.class, args);
        }
    }


参考链接：
https://coffee0127.github.io/blog/2017/04/26/convert-spring-boot-jar-to-war/
