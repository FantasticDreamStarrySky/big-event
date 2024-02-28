# 使用 Maven 官方提供的 OpenJDK 镜像作为基础镜像
FROM maven AS build

# 设置工作目录
WORKDIR /app

# 将项目的 pom.xml 文件复制到容器中
COPY pom.xml .

# 下载依赖并构建项目
RUN mkdir -p $HOME/.m2 && \
    echo "<settings><mirrors><mirror><id>aliyun-maven</id><url>https://maven.aliyun.com/repository/public</url><mirrorOf>central</mirrorOf></mirror></mirrors></settings>" > $HOME/.m2/settings.xml && \
    mvn dependency:go-offline

# 将整个项目复制到容器中
COPY src ./src

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