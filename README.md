# CSE2102 Group Project
### Lab Group: Joseph Vincento, Bruno Viera, Lyles Williams

## Instructions to Run
These instructions assume that the user is on a Redhat Linux distribution with mavan installed.  
The github repo containing the lab project can be found at: https://github.com/joseph-vincento/group_project  
  
Step 1: Clone the git repo using the command git clone https://github.com/joseph-vincento/group_project  
Step 2: From the directory where the git repo was cloned into, run the command ./mvnw package  
Step 3: From the directory where the git repo was cloned to, run the command ./mvnw spring-boot:run. The app can then be accessed at the url: http://localhost:8093/  

NOTES ON CURRENT FUNCTIONALITY:
Users are prompted to enter login credentials at the the login screen. Basic checks are performed
on the information the user enters, but there is no formal login process in place - all users are directed to the login page where they can begin a quiz.

Scoring has not yet been implemented. As such, when selected an answer to a quiz question, the page will ismply refresh with a new question.