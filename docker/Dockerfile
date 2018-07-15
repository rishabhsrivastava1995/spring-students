FROM openjdk:8-alpine
VOLUME /tmp
COPY spring-students.jar spring-students.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-students.jar"]
