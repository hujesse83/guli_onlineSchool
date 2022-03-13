FROM java:8
RUN mkdir /app
COPY ./service/service_vod/target/service_vod-0.0.1-SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "service_vod-0.0.1-SNAPSHOT.jar"]