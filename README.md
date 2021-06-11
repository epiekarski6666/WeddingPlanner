# WeddingPlanner
<!--
*** Thanks for checking out the Best-README-Template.
-->


<!-- PROJECT LOGO -->
![image](https://user-images.githubusercontent.com/46848957/121599139-edba6480-ca42-11eb-8304-4ec76a584f67.png)

  <h3 align="center">Wedding Planner Piekarscy</h3>

  <p align="center">
    Mamy przyjemność zaprezentować wam nasz Weeding Planner
    <br />
    <a href="https://github.com/epiekarski6666/WeddinPlannerPiekarscy1/blob/master/README.md"><strong>Explore project</strong></a>
    <br />
    <br />
    <a href="https://weddingplannerpiekarscy.herokuapp.com/">Open application on server</a>
    ·
    <a href="https://github.com/epiekarski6666/WeddingPlanner/issues">Report Bug</a>
    ·
    <a href="https://github.com/epiekarski6666/WeddingPlanner/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#running">Running</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#structure">Structure</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

We are creating Wedding Planner application using JAVA, HTML and other technologies we learn during last months.
Basically we install application at Heroku Cloud Application Platform so the only requirement is to have device using web browser application and internet connecction.
Just click on [link](https://weddinplannerpiekarscy1.herokuapp.com) to run application(first run can take few seconds till server open new session).
Otherwise, there is possibility to run application locally, see the instructions below.

Our foundations:

* Application should be availiable for two or morde users in pararell
* Should be available for any device using web browser
* Available anytime, any where
* Should provide privacy for included content

### Built With

Major frameworks and technologies:
* [Java](https://www.java.com)
* [Spring Boot](https://spring.io)
* [Thymeleaf](https://spring.io)
* [Bootstrap](https://getbootstrap.com)
* [JQuery](https://jquery.com)
* [HTML]
* [Maven](https://maven.apache.org)
* [H2](https://spring.io)
* [MySQL](https://spring.io)
* [Heroku](https://www.heroku.com)


<!-- GETTING STARTED -->
## Getting Started

Use Your IDE to Clone project from GitHub or download package and open.
Have Java 1.8 installed

If You want to use H2 Database Engine:
Just make sure at Application.properties You have below lines uncommented:

![image](https://user-images.githubusercontent.com/46848957/121598635-4e956d00-ca42-11eb-9cb0-dfd64f4e33e6.png)

If You want to use MySQL Database Engine:
You need to have MySQL application installed and configured on Your operating system
Just make sure at Application.properties You have below lines uncommented:

![image](https://user-images.githubusercontent.com/46848957/121598716-5fde7980-ca42-11eb-8ac2-96d03a043c9e.png)

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true

Make sure that required dependencies are active at pom.xml file.

### Prerequisites

Have Java 1.8 installed
Have Java 1.8 enviroment variable added into You system paths
Have MySQL installed if You want tu use

### Running

1. Open project on Your IDE, clone or just open downloaded package
2. Run WeddingPlannerApplication.java and wait for build
3. Open web browser and type http://localhost:8080/home
4. Log as admin(spouse)
wierzbicka@pw.pl
password
5. Log as user(wedding guest)
hapsia@pw.pl
password
6. Enjoy exploring


<!-- USAGE EXAMPLES -->
## Usage

Register and Log into
![image](https://user-images.githubusercontent.com/46848957/121599566-8355f400-ca43-11eb-9707-3d9d81b3642f.png)

View dependent of type of user
![image](https://user-images.githubusercontent.com/46848957/121599642-a4b6e000-ca43-11eb-84d6-e0092fa0cec1.png)

Plan or just view list of task needed to organise wedding
![image](https://user-images.githubusercontent.com/46848957/121599750-cf089d80-ca43-11eb-8285-0f2838bf98f8.png)

Add and edit tasks
![image](https://user-images.githubusercontent.com/46848957/121600834-64586180-ca45-11eb-895d-9ba81095fcc3.png)

Add and edit list of guests
![image](https://user-images.githubusercontent.com/46848957/121599945-1131df00-ca44-11eb-90c1-f9e5855447d2.png)

Add and assing gifts to guests from the list
![image](https://user-images.githubusercontent.com/46848957/121600195-666df080-ca44-11eb-8c23-0f0da7ce6673.png)

<!-- STRUCTURE -->
## Structure

![image](https://user-images.githubusercontent.com/46848957/121600359-a03ef700-ca44-11eb-88a4-db27ab8ea3de.png)


<!-- CONTACT -->
## Contact

Martyna Piekarska - [martyna.wierzbicka.stud@pw.edu.pl](martyna.wierzbicka.stud@pw.edu.pl)
Edwin Piekarski - [edwin.piekarski.stud@pw.edu.pl](edwin.piekarski.stud@pw.edu.pl)


Project Link: [https://github.com/epiekarski6666/WeddinPlannerPiekarscy1)

