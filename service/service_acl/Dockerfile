FROM java:8
RUN mkdir /app
ADD ./target/service_acl-1.0-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java", "-jar", "service_acl-1.0-SNAPSHOT.jar"]
