# spring-boot-demo-api

Simple REST API built using Java and Spring Boot to showcase dockerization and kubernetes deployment.

This repo is organized into multiple branches to show step by step process involved,  starting with creating an executable jar, then dockerize the application then finally deploy the container to k8s/openshift. 

> **Note**
> Feel free to see diff between branches see changes


* step1-jar

* step2-dockerize

* step3-k8s

## Step-1 Build and run app

### Build

```
mvn clean package
```


output

```
[INFO] [1m--- [0;32mjar:3.3.0:jar[m [1m(default-jar)[m @ [36mspring-boot-demo-api[0;1m ---[m
[INFO] Building jar: /Users/vijay/Downloads/demo/target/spring-boot-demo-api-0.0.1-SNAPSHOT.jar

```


### Run

For local testing, set env variable user

```
export user=Openshift or set user=Openshift
java -jar spring-boot-demo-api-0.0.1-SNAPSHOT.jar

```

Output:

```


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2024-02-27T14:17:03.774-05:00  INFO 8788 --- [           main] c.e.demo.SpringBootDemoApplication       : Starting SpringBootDemoApplication using Java 17.0.10 with PID 8788 (/Users/vijay/Downloads/demo/target/classes started by vijay in /Users/vijay/Downloads/demo)
2024-02-27T14:17:03.780-05:00  INFO 8788 --- [           main] c.e.demo.SpringBootDemoApplication       : No active profile set, falling back to 1 default profile: "default"
2024-02-27T14:17:04.657-05:00  INFO 8788 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-02-27T14:17:04.666-05:00  INFO 8788 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-02-27T14:17:04.667-05:00  INFO 8788 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-02-27T14:17:04.718-05:00  INFO 8788 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-02-27T14:17:04.720-05:00  INFO 8788 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 894 ms
2024-02-27T14:17:05.133-05:00  INFO 8788 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2024-02-27T14:17:05.189-05:00  INFO 8788 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-02-27T14:17:05.202-05:00  INFO 8788 --- [           main] c.e.demo.SpringBootDemoApplication       : Started SpringBootDemoApplication in 1.711 seconds (process running for 2.15)


```

### Test


```

curl http://localhost:8080/greeting?name=Docker

```

Output

```json

{"id":1,"content":"Hello, Docker!"}

````


## Step 2 - Dockerize

#### Docker build


```
docker build -t spring-boot-demo-rest-api:1.0 .

```

Output:

```

[+] Building 0.7s (8/8) FINISHED                                                                  
 => [internal] load build definition from Dockerfile                                         0.0s
 => => transferring dockerfile: 140B                                                         0.0s
 => [internal] load .dockerignore                                                            0.0s
 => => transferring context: 2B                                                              0.0s
 => [internal] load metadata for docker.io/library/eclipse-temurin:17-jdk-alpine             0.6s
 => [auth] library/eclipse-temurin:pull token for registry-1.docker.io                       0.0s
 => [internal] load build context                                                            0.0s
 => => transferring context: 170B                                                            0.0s
 => [1/2] FROM docker.io/library/eclipse-temurin:17-jdk-alpine@sha256:854b05154ed3e25ca8171  0.0s
 => CACHED [2/2] COPY target/*.jar app.jar                                                   0.0s
 => exporting to image                                                                       0.0s
 => => exporting layers                                                                      0.0s
 => => writing image sha256:0de2757b3d2123c7592f256f19284977a6921375fd96c40330aba9b7984bd36  0.0s
 => => naming to docker.io/library/spring-boot-demo-rest-api:1.0 
 
```



```

docker images 

````


Output

```

spring-boot-demo-rest-api            1.0            0de2757b3d21   18 minutes ago   338MB


```

#### Run Docker container


```
docker run -p 8080:8080 -e user=Openshift spring-boot-demo-rest-api:1.0

```

Output

```


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2024-02-27T19:49:59.252Z  INFO 1 --- [           main] c.e.demo.SpringBootDemoApplication       : Starting SpringBootDemoApplication v0.0.1-SNAPSHOT using Java 17.0.10 with PID 1 (/app.jar started by root in /)
2024-02-27T19:49:59.263Z  INFO 1 --- [           main] c.e.demo.SpringBootDemoApplication       : No active profile set, falling back to 1 default profile: "default"
2024-02-27T19:50:00.639Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-02-27T19:50:00.650Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-02-27T19:50:00.650Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-02-27T19:50:00.712Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-02-27T19:50:00.714Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1321 ms
2024-02-27T19:50:01.346Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2024-02-27T19:50:01.418Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-02-27T19:50:01.439Z  INFO 1 --- [           main] c.e.demo.SpringBootDemoApplication       : Started SpringBootDemoApplication in 2.78 seconds (process running for 3.348)

```

#### View running containers

```
docker ps
```
Output

```
7d347d559c96   spring-boot-demo-rest-api:1.0   "java -jar /app.jar"     About a minute ago   Up About a minute   0.0.0.0:8080->8080/tcp   reverent_grothendieck

```

#### Test 

call without any parameter should print environment variable

```

curl http://localhost:8080/greeting

```

Output

```json

{"id":1,"content":"Hello, Openshift!"}

````

call with name parameter should print given name


```
curl http://localhost:8080/greeting?name=Vijay


```

Output

```json

{"id":1,"content":"Hello, Vijay!"}

````
