BOURGEOIS Thibault ING3 FISA/A

DM-ONLINE-BANKING
===================

    This is homework for Gokan EKINCI.
    This document present the project and who use it.
    For any problem, please contact thibault.bourgeois@etu.u-pec.fr

**First part: Explication of Build and Launch**

**Second part: Use REST services**

----------

FIRST PART
-------------------

###<i class="icon-folder-open"></i>Project

It is a multi-module Maven project with only one module named **module-clientmanagement-services**

    This module have a pom file and 5 subpackages named like
    
    -controllers
    -models
    -repositories
    -services
    -utils


### <i class="icon-file"></i> Log file
This project manage logging in console and in file. Log config is located in **application.properties** file.

    logging.file=c:/Temp/mylog.log

###<i class="icon-download"></i> Clone repository
Execute this commande in personnal folder.

    git clone https://github.com/BourgeoisThibault/dm-online-banking.git

###<i class="icon-cog"></i> Build project
Place in the folder "dm-online-banking". Execute commande.

    mvn clean package

## <i class="icon-cog"></i> Launch application
PLace in the folder "dm-online-banking" and then in folder "module-clientmanagement-services". Execute commande.

    java target/client-management-services.jar

----------


SECOND PART
-------------------

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

#### <i class="icon-code"></i> Get all users
Use request from the collection Postman.

    User GET all
    
#### <i class="icon-code"></i> Get users by firstname
Use request from the collection Postman.

    User GET byfirstname
    
#### <i class="icon-code"></i> Get users by lastname
Use request from the collection Postman.

    User GET bylastname
    
#### <i class="icon-code"></i> Get user by firstname and lastname
Use request from the collection Postman.

    User GET byuser
    
#### <i class="icon-code"></i> PUT user with params
Use request from the collection Postman.

    User PUT
    
#### <i class="icon-code"></i> POST user with params
Use request from the collection Postman.

    User POST
    
#### <i class="icon-code"></i> DELETE user with params
Use request from the collection Postman.

    User DELETE
    