FROM openjdk:17
ARG JAR_FILE=/build/libs/seoul_backend-0.0.1-SNAPSHOT.jar
COPY  ${JAR_FILE} seoul_data.jar
ENTRYPOINT ["java","-jar","/seoul_data.jar", "--spring.profiles.active=prod"]