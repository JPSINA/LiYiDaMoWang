FROM openjdk:17
MAINTAINER jiangpeng<1017873431@qq.com>
ADD target/KateSystem-0.0.1-SNAPSHOT.jar KateSystem-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "KateSystem-0.0.1-SNAPSHOT.jar"]