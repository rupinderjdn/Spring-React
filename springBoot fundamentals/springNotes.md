# Problems with spring solved by spring boot
- lot to configure for a boiler plate code, spring boot basically resolve it
 1. like AppContext, AppInitializer, WebMvcConfig needs to be configured in spring while using spring we configure it in the pom.xml file itself
 2. spring boot also provides embedded tomcat server


# Spring Boot Starters
1. sprin-boot-starter-data-jpa contains all the commonly used jars, so it pulls it automatically similar thing happens when setting up spring-boot with web.
2. Eased the way to externalized teh configurations
3. Spring Boot Actuator -> production ready features
 
# REST web service ?
1. Able to send data in formats XML, JSON etc. using standard HTTP protocols like GET, POST, PUT, DELETE
2. Basically in SOAP you will have to provide the whole XML for the service while in REST apis if your doing a simple get request may not pass any object

# Code snippets
1. @ResponseBody // -> to convert java object into json
2. @RestController // -> combination of controller and responseBody
3. @GetMapping("/hello-world") //-> used to map http get request onto specific handler
4. @GetMapping("student/{id}") // -> 'id' is a variable passed on the URL
   - public Student studentPathVariable(@PathVariable int id)  => @PathVariable used to bind it to the URI template variable
5. @PostMapping("student/create") -> just like get Mapping a postMapping ont he url
6. @RequestBody -> to fetch the json from the request body and convert it to a java object