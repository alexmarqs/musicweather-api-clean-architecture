## MusiWeather API - Spring Boot Clean Architecture example  
An API system that returns playlist suggestions based on the current weather/temperature using a clean architecture with Spring Boot.  
  
Environment requirements:  
- JDK 11        
- Maven        
- Docker    

Technologies / Libs:
- Spring Boot
- Lombok 
- Swagger
- Mapstruct 
- OpenFeign 
- Redis 

### Requirements  
External API's: 
- Weather info (temperature data) - [OpenWeatherMaps API](https://openweathermap.org/current)  
- Playlist suggestions - [Spotify API](https://developer.spotify.com/documentation/web-api/quick-start/)  
  
Business rules:  
- If temperature (in celsius) is below 15, suggest jazz musics   
- (...) between 15 and 19, suggest indie musics
- (...) between 20 and 26, suggest reggae musics
- (...) above 26, suggest party musics
  
Use cases:  
- Get suggested playlist by city name
- Get suggested playlist by location coordinates (lat and lon)

### Architecture  
A Clean & Hexagonal Architecture approach was followed as you can see in the diagram below: 

  
### Instructions to build and run the application   
With docker-compose:  

  
Without docker-compose:

### TODO actions (under development):

-[ ] Tests (Junit + ArchUnit)
-[ ] CI/CD integration  

### References
[https://beyondxscratch.com/2017/08/19/decoupling-your-technical-code-from-your-business-logic-with-the-hexagonal-architecture-hexarch/](https://beyondxscratch.com/2017/08/19/decoupling-your-technical-code-from-your-business-logic-with-the-hexagonal-architecture-hexarch/)
[https://medium.com/sciforce/another-story-about-microservices-hexagonal-architecture-23db93fa52a2](https://medium.com/sciforce/another-story-about-microservices-hexagonal-architecture-23db93fa52a2)
[https://madewithlove.com/hexagonal-architecture-demystified/](https://madewithlove.com/hexagonal-architecture-demystified/)
[https://medium.com/swlh/hexagonal-architecture-in-java-b980bfc07366](https://medium.com/swlh/hexagonal-architecture-in-java-b980bfc07366)
[https://medium.com/@fabiojose/dipower-a76f453b38fd](https://medium.com/@fabiojose/dipower-a76f453b38fd)
[https://blog.wick.technology/sensible-feign/](https://blog.wick.technology/sensible-feign/)
[https://medium.com/@darguelles.rojas91/amazing-rest-clients-with-mr-feign-6195d5499a38](https://medium.com/@darguelles.rojas91/amazing-rest-clients-with-mr-feign-6195d5499a38)
[https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html)
[https://www.baeldung.com/mapstruct-custom-mapper](https://www.baeldung.com/mapstruct-custom-mapper)