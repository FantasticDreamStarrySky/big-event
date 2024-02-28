# 用于构建 Spring Boot 应用程序的 Docker 镜像
FROM maven AS build

# 设置工作目录
WORKDIR /app

# 将项目的 pom.xml 文件复制到容器中
COPY pom.xml .

# 将 Maven 的配置文件复制到容器中
COPY config/maven/settings.xml /root/.m2/settings.xml

# 将整个项目复制到容器中
COPY src ./src

# 修改配置文件, 使用 Docker 配置
RUN sed -i 's/active: local/active: docker/g' ./src/main/resources/application.yml

# 构建应用
RUN mvn package -DskipTests

# 使用一个新的轻量级基础镜像来运行应用程序
FROM azul/zulu-openjdk-alpine:21-jre-latest AS runtime

# 将构建阶段输出的 jar 文件复制到容器中
COPY --from=build /app/target/*.jar /app/app.jar

# 暴露应用程序的端口
EXPOSE 8080

# 启动应用程序
CMD ["java", "-jar", "/app/app.jar"]