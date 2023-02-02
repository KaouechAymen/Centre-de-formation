FROM openjdk:8
EXPOSE 8080
ADD target/MyPipeline.jar MyPipeline.jar
ENTRYPOINT ["java","-jar","/MyPipeline.jar"]