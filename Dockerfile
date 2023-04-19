FROM openjdk:11
EXPOSE 8080
ADD target/NutritionApp-0.0.1-SNAPSHOT.jar NutritionApp.jar
ENTRYPOINT ["java","-jar","/NutritionApp.jar"]
