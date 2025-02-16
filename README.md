# Authentication Microservice

### To Build And Run Docker Image
- Setup Docker Desktop
- Run in CMD
   - docker build -t authentication-microservice . 
   - docker run -d -p 8081:8081 --name authentication-microservice authentication-microservice
- To verify that image is running: docker ps

### Build Docker-Compose
docker-compose up --build
