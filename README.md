BOURGEOIS Thibault ING3 FISA/A

DM-ONLINE-BANKING
===================

This is homework for Gokan EKINCI.
This document present the project and who use it.
For any problem, please contact thibault.bourgeois@etu.u-pec.fr

All constraints from exam are respected.

![Alt text](https://github.com/BourgeoisThibault/dm-online-banking/blob/master/_Diagrams/EntityDiagram.jpg "Entity")

![Alt text](https://github.com/BourgeoisThibault/dm-online-banking/blob/master/_Diagrams/DeploiementDiagram.jpg "Deploiement")

----------

### <i class="icon-folder-open"></i> Project

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

### <i class="icon-download"></i> Clone repository
Execute this commande in personnal folder.

    git clone https://github.com/BourgeoisThibault/dm-online-banking.git

### <i class="icon-cog"></i> Build project
Place in the folder "dm-online-banking". Execute commande.

    mvn clean package

### <i class="icon-cog"></i> Launch application
For this project, you need mysql with database named "banking".

Mysql url must be *jdbc:mysql://localhost:3306/banking*

Mysql login/pass must be *esibank/esibank*

Database is populate when app start.

Place in the folder "dm-online-banking"  

 Execute this commande to install project
 
	mvn clean install

 Then execute this commande to start data-access rest.

    cd data-access-services
	mvn spring-boot:run
    
 Then execute this commande for client-management
 
	cd ..
    cd client-management-services
	mvn spring-boot:run

 Then execute this commande for client
 
	cd ..
    cd client-services
	mvn spring-boot:run

### <i class="icon-cog"></i> Swagger doc
Import YAML file on swagger.io there are no YAML for data-access because note use directly by client.

    swagger_client.yml
    swagger_clientmanagement.yml

----------

For test REST services, curl_request.request file

    There are in this file all CURL from swagger. Test on my environment.
