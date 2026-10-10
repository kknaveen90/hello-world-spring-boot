# Hello, World (Java / Spring Boot)

A standalone Spring Boot app with greetings and a health endpoint.

## Run locally

Install JDK 17 and set JAVA_HOME to its installation folder. No database, Docker,
Kubernetes, or separately installed Gradle is required. The Gradle wrapper downloads
Gradle and dependencies on the first run, so internet access is needed initially.

From this project folder in PowerShell:

```powershell
.\gradlew.bat bootRun
```

On macOS or Linux:

```sh
sh ./gradlew bootRun
```

Open http://localhost:8080/ or http://localhost:8080/hello.
Health is available at http://localhost:8080/actuator/health.
Press Ctrl+C in the terminal to stop the app.

If port 8080 is already in use:

```powershell
.\gradlew.bat bootRun --args="--server.port=8081"
```

The greeting uses `local` as its build profile by default. Set the optional
BUILD_PROFILE environment variable to change the label.

## Test and package

```powershell
.\gradlew.bat test bootJar
java -jar build/libs/hello-forge-springboot-0.0.1-SNAPSHOT.jar
```

The tests start the server on a random port and verify both greeting routes and health.
In an IDE, import this folder as a Gradle project, select JDK 17, and run
`io.datawire.labs.hellospring.HelloSpringApplication`.

## Deployment files

`Dockerfile`, `k8s/`, and `service.yaml` contain the original container and
Kubernetes deployment setup. They are not required for local execution.

## License

Licensed under Apache 2.0. See [LICENSE](LICENSE).
