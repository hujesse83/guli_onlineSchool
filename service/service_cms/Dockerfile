FROM java:8
RUN mkdir /app
COPY ./service/service_cms/target/service_cms-1.0-SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "service_cms-1.0-SNAPSHOT.jar"]