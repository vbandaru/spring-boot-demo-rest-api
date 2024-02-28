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
