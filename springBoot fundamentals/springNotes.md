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
7. POST is basically to create PUT is basically to update an existing entry
8. @PutMapping("student/{id}/update")
9. @DeleteMapping("student/{id}/delete")

# ResponseEntity
1. can be used to send responses 
 - it uses all of the stuff => code, headers and body
 - we have to return this through a end point.
 - It is a generic type. Consequently, we can use any type as the response body
2. Can be used in this manner
 - return ResponseEntity.ok().header("custom-header","Rupinder").body(student);

# Let's see how to add 
1. 'student' as a by default api service name to the rest api service
2. @RequestMapping("student") -> define at class level so that all the method will inherit it.