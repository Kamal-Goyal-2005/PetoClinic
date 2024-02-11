FROM openjdk:11
EXPOSE 8080
ADD target/ClinicSpringProject-0.0.1-SNAPSHOT.war ClinicSpringProject-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","ClinicSpringProject-0.0.1-SNAPSHOT.war" ]