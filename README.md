# GitHub User Repository API
This is simple REST Api written in Java, using GitHub Api (https://developer.github.com/v3) to display all repository from account by given username. If someone account doesn't exist api throwing 404 error and send message: _"This account doesn't exist on GitHub"_.

## Main technologies:
 * Java 21
 * Spring Boot 3.2.2
 * Gradle

## How to deploy:
  * First you need to copy the link to repository from _Code_ options in right bottom corner above file list
    ![image](https://github.com/maciejsachajdak/githubUserReposApi/assets/119767371/c01e27e8-bcae-4b25-964b-0845ebda1f33)
  * Next step you need to open Java IDE for example _IntelliJ IDEA_, choose  option _Get from VSC_, paste there link copied before and choose path where you want to copy my repository
    ![image](https://github.com/maciejsachajdak/githubUserReposApi/assets/119767371/15df4534-aaea-4460-aa9e-16e6cc9490e4)
  * Now you can enjoy from using my repo

## How to use:
  * Start application in Intellij, then open the _Postman_, create new WorkSpace, choose GET method and write this link: http://localhost:8080/repos/{username} with choosen GitHub username of account which repository you want to see.
    ![image](https://github.com/maciejsachajdak/ASP.NET-Project/assets/119767371/9bcf55aa-b067-443e-ae9f-99b2c9388520)
  If account exists you will see Json response from REST API with all public repositories which not be a fork, the Json include information like: repository name, user login and for each branches: branch name and last commit SHA
    ![image](https://github.com/maciejsachajdak/ASP.NET-Project/assets/119767371/1360a851-45ec-49d2-81a4-495f11fe0297)
  If account doesn't exist you will see error 404 with message: _"This account doesn't exist on GitHub"_
