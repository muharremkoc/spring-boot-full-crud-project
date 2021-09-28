FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dockerizeappapplication.jar

ENTRYPOINT ["java","-jar","/dockerizeappapplication.jar"]




#WORKDIR /usr/src/myapp
#RUN javac SpringBootFullCrudProjectApplication.java
#CMD ["java", "Main"]