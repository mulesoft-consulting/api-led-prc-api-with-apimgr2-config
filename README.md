# api-led-prc-api-with-apimgr2-config
This is a starting Mule project template for building an HTTP REST Process API in Mule. The pom.xml contains automated API configuration for Anypoint API Manager 2.x. 

The template assumes four deployment environments (NP1, NP2, NP3 and PROD). These should be changed to reflect the correct environment names.

**API Configuration**

The automated API configuration will create the API and version in Exchange if it does not already exist. No content will be created or published for the API/version.

The automated API configuration registers the API into all the [NP1, NP2, NP3 and PROD] environments at the same time. In addition, the configuration property files in src/main/resources are updated to include the API registration information. 

API configuration is executed with ApiConfigTool (using the exec-maven-plugin).

**API Runtime Deployment**

The API deployable archive can be deployed to only one deployment (Runtime) environment at a time.

The deployment environment server configuration information is stored in the Maven settings.xml file. This means that a separation between developer accessible environments and devops (or CI/CD) environments can be maintained in the settings.

Deployment is executed with the deploy goal (it uses the mule-maven-plugin). This will also push the deployable archive file to a Maven distribution repository if one is configured and the Maven property skip.publish.artifact is set to false.

## Prerequisites for Using Template
1. Java 1.8 JDK needs to be installed.
2. Maven 3.3.9 needs to be installed and configured for use.
3. The sample-settings.xml file needs to be taken from the project, updated to have appropriate user credentials, Anypoint configuration values (like environment, server and business group names).
4. The timerInterceptor project needs to be download and built (mvn clean install). See [https://github.com/mulesoft-consulting/mule3-timerInterceptor](https://github.com/mulesoft-consulting/mule3-timerInterceptor)
5. The ApiConfigTool project needs to be download and built (mvn clean install). See [https://github.com/mulesoft-consulting/api-config-tool](https://github.com/mulesoft-consulting/api-config-tool)

## General Instructions for Using the Template

1. Import the template project (as a Maven project) into Anypoint Studio.
2. Do a file search and locate all the occurrences of the string "skeleton" and replace them with your API's name.
3. Update the configuration files in the src/main/resources directory to have the correct implementation values.
4. Add the API's RAML to the api directory
5. Generate the ApiKit flows from the RAML
6. Move the generated code to the proper logic.xml file
7. Remove any duplicated code
8. Add minimal logging (timerInterceptor) to each of the ApiKit generated flows
4. Update the *-policies.json files to have the correct policy definitions. The standard is client id enforcement
5. Save all the changes.
6. Configure the API with the mvn command.
7. Test the API in Studio (use mule.env=local and mule.key=Mulesoft12345678).
8. Register the API/version in Anypoint with the ```mvn -Pconfig-api``` command
8. Save all changes to GitHub.
9. Deploy the API to NP1 using ```mvn clean install deploy -Denv=NP1``` command.
10. Add processing logic to the API flows as required


## Recap of Configuring API

Configuring API's only needs to be run once, the API Manager will be updated for all four environments (NP1..NP3 and PROD). The configuration property files for each environment will be updated with the API Manager assigned values. To configure the APIs, use this command:

```
mvn clean install -Pconfig-api
```

## Recap of Deploying the API to an environment

The deployable archive is built from the project's source code and pushed to the specified deployment environment using the
Anypoint Runtime Manager. Note that the API should be configured prior to deploying. Use the following command to deploy to the NP1
environment:

```
mvn clean install deploy -Denv=np1
```
## Combined Configure API and Deploy

Use this command to configure the API and deploy:

```
mvn clean install deploy -Denv=np1 -Pconfig-api
```


