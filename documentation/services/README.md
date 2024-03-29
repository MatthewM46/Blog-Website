
Microservices Breakdown
=======================

This is a breakdown of the microservices that make up the application. Documentation
for each service is available in its respective directory. We have decided in this preliminary
stage that each group will implement their service using Java with Spring Boot, as this is
what everyone is most comfortable with. This may change in the future.

📌 **Please Note**: Sequence diagrams can be viewed by navigating to individual usecases using the
links provided here.

==⚠️ TODO: Please double check that we're not missing anything from the milestone 2 requirements.==

<!-- TOC -->
  * [Group Allocation](#group-allocation)
  * [Component and Connector Diagram](#component-and-connector-diagram)
  * [Deployment Diagram](#deployment-diagram)
  * [Services](#services)
    * [Accounts and Notifications Service](#accounts-and-notifications-service)
    * [Ads and Monetization Service](#ads-and-monetization-service)
    * [Posts and Moderation Service](#posts-and-moderation-service)
<!-- TOC -->

## Group Allocation

The members of our group will work on the following services:

| Service          | Team Members       |
|------------------|--------------------|
| Posts/Moderation | Aaron Y and Matt M |
| Advertisements   | Jack H             |
| Accounts         | Drew P and Matt L  |
| Frontend         | Jack H and Matt L  |

## Component and Connector Diagram

![component-connector-diagram](component_diagram.png)

The Account and Notifications microservice is being built Springboot and JWT for authentication. The other microservices will need to authenticate the user through the Accounts component using the JWT issued to every user on log in. The notifications microservice will be connecting to all the other services to set up notifications to be sent to users. There will be a encrypted database of users account information that only Accounts will have access to read and write to. 

The Ads microservice is being built with Springboot. The Ads microservice will need the Accounts component to authenticate the user using the JWT. The Ads microservice will also need the notification service to send notifications to the advertisement user about their advertisements being created, deleted, or edited.

The Posts and Moderation microservice is being built with Springboot. This microservice will require the Accounts service to assign posts and comments to their respective Users, as well as to assign the status of an Account based on moderation. This microservice will also require the Notification service to send notifications to Users on new posts, comments, or replies.


## Deployment Diagram
![deployment-diagram](https://github.com/uvic-teach/project-m1-team3/assets/145606087/1e3564bb-f042-43a1-b5d3-e15d0ec70410)

We are deploying to AWS Lightsail. Each microservice will be in a dockercontainer, and communicates with each other via a bridge network. We will have a central PostgreSQL database running in a container which services all microservices. The Accounts/Notification Service will be written in java with Spring Boot. The Posts/Moderation Service will be written in java with Spring Boot. The Ads Service will be written in java with Spring Boot. The frontend will be written with SvelteKit and deployed with Node.js.


## Services

### Accounts and Notifications Service

The API documentation for this service can be found [here.](AccountsNotifications/openapi.yaml)

This service is responsible for handling user accounts and notifications. The documentation
for the usecases that this service implements can be found [here.](../usecases/AccountManagement/README.md)

### Ads and Monetization Service

The API documentation for this service can be found [here.](AdsMonetization/openapi.yaml)

This service is responsible for handling advertisements. The documentation
for the usecases that this service implements can be found [here.](../usecases/AdsMonetization/README.md)

### Posts and Moderation Service

The API documentation for this service can be found [here.](PostsModeration/openapi.yaml)

This service is reponsible for handling posts and comments. The documentation
for the usecases that this service implements can be found [here.](../usecases/Posting/README.md)
