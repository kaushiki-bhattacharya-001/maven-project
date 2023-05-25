FROM openjdk:11.0.18
VOLUME /tmp
ADD training/target/scholar-project.jar scholar-project
ENTRYPOINT ["java", "-jar","scholar-project"]
EXPOSE 8080