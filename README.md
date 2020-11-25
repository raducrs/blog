# Microservices architecture Blog implementation

An implementation of a blog application and infrastructure to support the deployment.

Microservices build with ```Spring``` backend in ```Java 8```, ```Angular``` frontend, ```MongoDB``` databases.

## Code organisation

- [app/blog-pages](app/blog-pages) - [src](app/blog-pages/src/main/java/com/apptozee/blogpages)
   - REST service for content
   - DB in ```MongoDB```
- [app/users](app/users) - [src](app/users/src/main/java/com/apptozee/users)
   - REST service for users
- [app/www](app/www) 
   - backend for frontend in ```Node```
   - UI developed with ```Angular 6``` and ```Bootstrap 4```
- [app/service-discovery](app/service-discovery) - [src](app/service-discovery/src/main/java/com/apptozee/servicediscovery)
- [app/api-gateway](app/api-gateway) - [src](app/api-gateway/src/main/java/com/apptozee/apigateway)

## Deployment

Deployment in ```Docker``` containers and with ```Docker compose``` for local deployment

### Databases

- [deployment/databases/blog-pages](deployment/databases/blog-pages) - [Docker compose](deployment/databases/blog-pages/mongodb-Docker_Compose.yml)

### Services 

- [deployment/services/api-gateway](deployment/services/api-gateway) - [Dockerfile](eployment/services/api-gateway/api_gateway-Dockerfile), [Docker compose](deployment/services/api-gateway/api_gateway-Docker_Compose.yml)
- [deployment/services/service-discovery](deployment/services/service-discovery) - [Dockerfile](deployment/services/service-discovery/service_discovery-Dockerfile), [Docker compose](deployment/services/service-discovery/service_discovery-Docker_Compose.yml)

### Support

- [deployment/support/artifactory](deployment/support/artifactory) - [Docker compose](deployment/support/artifactory/docker_artifactory-Docker_Compose.yml)
- [deployment/support/docker_registry](deployment/support/docker_registry) - [Docker compose](deployment/support/docker_registry/docker_registry-Docker_Compose.yml)
- [deployment/support/portainer](deployment/support/portainer) - [Docker compose](deployment/support/portainer/portainer-Docker_Compose.yml)
- [deployment/support/oracle-java-8](deployment/support/oracle-java-8) - [Dockerfile](deployment/support/oracle-java-8/dockerfile)



