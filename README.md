BOURGEOIS Thibault ING3 FISA/A
DM-ONLINE-BANKING
===================

This is homework for Gokan EKINCI.
This document present the project and who use it.
For any problem, please contact thibault.bourgeois@etu.u-pec.fr

----------

###<i class="icon-folder-open"></i>Project

It is a multi-module Maven project with next modules

> **aspectj-aop-utils :**
>This module is for AOP process
>
> **client-management-services :**
>This module is for advisor
>
> **client-services :**
>This module is for client
>
> **client-models :**
>This module is for models share (Dto)
>
> **data-access-services :**
>This module is for access to bdd (contains entities)
>
> **rest-client-utils :**
>This module is for share methode with specifique methods


### <i class="icon-file"></i> Log file (*deprecied*)
This project manage logging in console and in file. Log config is located in **application.properties** file.

    logging.file=c:/Temp/mylog.log

###<i class="icon-download"></i> Clone repository
Execute this commande in personnal folder.

    git clone https://github.com/BourgeoisThibault/dm-online-banking.git

###<i class="icon-cog"></i> Build project
Place in the folder "dm-online-banking". Execute commande.

    mvn clean package

## <i class="icon-cog"></i> Launch application
For this project, you need mysql with database named "banking".
Mysql url must be *jdbc:mysql://localhost:3306/banking*
Mysql login/pass must be *esibank/esibank*
Database is populate when app start.

Place in the folder "dm-online-banking"  and execute this commande to start data-access rest.

    java data-access-services/target/data-access-services.jar
    
 Then execute this commande for client-management
 
    java client-management-services/target/client-management-services.jar

 Then execute this commande for client
  
    java client-services/target/client-services.jar

###<i class="icon-cog"></i> Swagger doc
Import YAML file on swagger.io

    swagger_client.yml
    swagger_clientmanagement.yml

----------

For test REST services, use Postman application

    http://www.getpostman.com/

> **Collection share:**

> - Download postman
> - Access to my sharing collection with [this link](https://www.getpostman.com/collections/7f44df12418bf36ad638?_ga=2.1526577.180127832.1508328354-1042454206.1508328354)
> - Accept to use the new collection
> 
> **REST Methods:**

> - GET method return JSON
> - PUT method return String
> - POST method return String
> - DELETE method return String

