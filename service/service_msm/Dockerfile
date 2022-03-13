FROM java:8
RUN mkdir /app
COPY ./service/service_msm/target/service_msm-1.0-SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "service_msm-1.0-SNAPSHOT.jar"]