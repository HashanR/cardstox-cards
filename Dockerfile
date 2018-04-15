FROM java:8
VOLUME /tmp
ADD card-service.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]