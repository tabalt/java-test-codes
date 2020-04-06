# hello-maven-multimodule

### 生成项目

* 生成父模块

```
mvn archetype:generate -DgroupId=net.tabalt -DartifactId=hello-maven-multimodule -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

删除src目录，修改pom.xml文件中packaging为pom
```
cd hello-maven-multimodule
rm src
vim pom.xml
```

* 生成domain子模块

```
mvn archetype:generate -DgroupId=net.tabalt -DartifactId=hello-domain -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

删除hello-domain/pom.xml中的 groupId和version，添加`<packaging>jar</packaging>`

* 生成dao模块

```
mvn archetype:generate -DgroupId=net.tabalt -DartifactId=hello-dao -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

删除hello-dao/pom.xml中的 groupId和version，添加`<packaging>jar</packaging>`，添加对hello-domain模块的依赖

```
    <dependency>
      <groupId>net.tabalt</groupId>
      <artifactId>hello-domain</artifactId>
      <version>${project.version}</version>
    </dependency>
```

* 生成service模块

```
mvn archetype:generate -DgroupId=net.tabalt -DartifactId=hello-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
删除hello-service/pom.xml中的 groupId和version，添加`packaging>jar</packaging>`，添加对hello-dao模块的依赖

* 生成web模块

```
mvn archetype:generate -DgroupId=net.tabalt -DartifactId=hello-web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

删除hello-web/pom.xml中的 groupId和version，添加对hello-service模块的依赖

system-web模块添加jetty支持
```
    <plugins>
      <plugin>
        <groupId>org.mortbay.jetty</groupId>
        <artifactId>maven-jetty-plugin</artifactId>
      </plugin>
    </plugins>
```

### 编译与启动

```
tree ./
mvn clean install
tree ./


cd hello-web
mvn jetty:run
```

### 访问
```
curl "http://localhost:8080/hello-web/"
```
