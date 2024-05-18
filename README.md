# dropwizard-multi-module-microservice
Template to start building a Multi Module Dropwizard microservice, this includes some features by default:

## Modules

- App : Dropwizard application
- Model : DTOs and Model classes (POJOs + JSON, NO Entities)
- Client: Client to call endpoints exposed by the App module

## Features included

- Dropwizard
- GUICE for dependency injection
- Health Check
- Checkstyle for code style
- FAT Jar creation
- Testing
- - Client Tests
- - Integration Tests
- - Unit Tests
- - Mocks with Mockito