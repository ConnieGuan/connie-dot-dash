# Read Me

Framework: Springboot
Java: 1.8

Note: 
- In this state, the application compiles, but does not properly run. I did not have time to hook up the Demo Application and the Controller. 
- Springboot was not a great choice for the "client" side functions, I've done the best I can with it, but taking in command line inputs is a little awkward. 
- If you want to run with command line args, it can be run as "spring-boot:run -Dspring-boot.run.arguments=--option.value=[argument]", but in it's current state it can only read one command line arg at a time. Given another go at it, I would've tried to create the server using SpringBoot and perhaps done a separate simple java based client, but in the interest of time, I've left it as is. 

Files of note:
-Controller.java 
-DemoApplication.java
-DemoException.java
-ExceptionHandler.java
