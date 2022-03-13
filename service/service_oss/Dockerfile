FROM java:8
RUN mkdir /app
COPY ./service/service_oss/target/service_oss-1.0-SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "service_oss-1.0-SNAPSHOT.jar"]