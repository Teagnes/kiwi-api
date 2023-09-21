FROM openjdk:8-jdk-alpine

MAINTAINER kiwi-b

# 设置时区，构建镜像时执行的命令
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

WORKDIR /tmp

#COPY ../../../target/kiwi-api-1.0-SNAPSHOT.jar kiwi-api-1.0-SNAPSHOT.jar
ADD *.jar  app.jar
# 统一启动端口
ENV PARAMS = "--server.port=8088"

EXPOSE 8088

ENTRYPOINT ["/bin/sh","-c","java -Dfile.encoding=utf8 -Djava.security.egd=file:/dev/./urandom -jar app.jar ${PARAMS}"]


