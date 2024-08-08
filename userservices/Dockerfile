FROM openjdk:17
EXPOSE 9095
ADD target/user.jar user.jar
ENTRYPOINT [ "java","-jar","/user.jar" ]