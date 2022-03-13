FROM java:8
RUN mkdir /app
COPY ./service/service_ucenter/target/service_ucenter-1.0-SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "service_ucenter-1.0-SNAPSHOT.jar"]