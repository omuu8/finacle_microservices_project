Docker:

We are going to make use of jin instead of buildpacks and dockerfile, following are the reasons:

1) Jib will take less time to generate the docker image compared to buildpacks
2) Less memory inside my system
3) Buildpacks have some issues with macoperating system


-----------------------------------------------------------------------------------------------------------------------------

Command to push the docker image into remote repsository:
docker image push dokcer.io/rykoond3/accounts:s4

Command to pull the docker image into local repsository from remote:
docker pull rykoond3/accounts:s4

-----------------------------------------------------------------------------------------------------------------------------

Docker Compose:Its a best confugurable file in yml format for common microservices running on common server
To create docker images:
docker compose up -d

To remove docker images
docker compose down

To start docker images
docker compose start

To stop docker images
docker compose stop: it will not stop containers immediate effectively but will do gracefully by closing db connection or file system and then it stops

-----------------------------------------------------------------------------------------------------------------------------

Logs Explorer:
It helps in bifurcating the logs of each microservice

-----------------------------------------------------------------------------------------------------------------------------

#CNA (Cloud Native Applications):
Designed to specifically leverage the cloud computing principles and take full adv of cloud native features (layman terms)

CNCF:
This empowers orgs to build scalable application in dynamic envs such as hubrid, pvt, public clouds. This enables in loose coupling of the 
systems and makes them more secure with minimal toil

Important Characteristics of Cloud Native Applications:
1) Microservices (Where whole app is broken down into small services which are loosely copuled and which scale, deploy and developed indep.)
2) Containers (Dockers)
3) Scalability and Elasticity (Kubernetes)
4) Devops Practices (Embrace Devops principles, promoting collabs between devs and ops team)
5) Resilience and Fault Tolerance (Designed to be resilient in face of failurs, utilizes distibuted architectures, load balancing, automated fail recovery system and fault-tolerant )
6) Cloud Native Services (Managed dbs, messaging queues, caching systems, identity services, etc)


-----------------------------------------------------------------------------------------------------------------------------

Dev Principles while building CNA:

1) 12 Factors and Beyond (Heroku)
2) 15 Factors (Kevin Hoffman)

-----------------------------------------------------------------------------------------------------------------------------

15 Factor Methodology:
1) One codebase for 1 app: One codebase/repo maintained for each kind of env for its deployment
2) API First: In Dep pipeline we can write integration with other systems and if it works we do deployment
3) Dependency Management: Declaring all required deps in one manifest and ensuring they are accessible for everyone (Gradle, Maven)
4) Design , build, release, run: Design Stage = Determine everything req to dev of feature
                                 Build Stage = Each build will have its unique identification and will be Immutable Artifact
                                 Release Stage = Each release will have its semantic version and will be Immutable Artifact. Central Repo storage facilitates easy access including rollbacks if needed.
                                 Run Stage = Execute the app in the designated runtime env using specific release.
5) Configuration, Credentials and code: Each configurable entities such username, databasenames, passwords should be configurable i.e changeable
Also its imp that what would be the risk factor on exposing the database configurations to the ext envs. So avoid embedding the credentials in the code else for each env we would need a new docker image (Spring Cloud Config Server)
6) Logs: In uservices arch each app should direct their logs to the std o/p, treating them as sequential ordered events based on time,
The resp of storage and rotation is now shifted to an external tool known as log aggregator (ELK = Elasticsearch, [Logstash], Kibana)
7) Disposability: Here it focuses on quick startup of app when a new instance is required ensuring robustness and resiliency, and graceful
shutdown of existing instances and ensuring to complete ongoing requests and then exiting (Kubernetes inherently satisfies this).
8) Backing Services: This refers to external resources for an app which relies on providing its functionality (SMTP, DB, caching or REST)
like app couples with db using URLs for easy swaps
9) Env Parity: This aims in minimizing the differences betn various envs and avoiding costly shortcuts. This addresses 3 gaps:
  a) Time Gap (It encourages automation and Continuous development to reduce t bewn code and prod env deployments)
  b) People Gap (Devops team acts as sandwiched layer betn operators and users) 
  c) Tools Gap (To achieve env parity It's suggested to use similar kind of db to reflect the same behaviour in both envs
10) Administrative Processes: This ensures that the same set of ops tasks are performed on both dev and prod envs like batch jobs, maintenance tasks, db migrations
We can maintain a separate uservice for triggering maintenance tasks etc.
11) Port Binding: Cloud native apps should be self-contained and expose their services through port bindings
12) Stateless Processes: This refers to microservices which are stateless and independent of each other, also when there is need to share 
a state let say user state in that case it should rely on another system to store such instances of state like Redis caching, etc, hence app becomes true stateless
13) Concurrency: This refers to the number of concurrent requests that can be processed by a single instance of the app. It relates to the Horizontal and Vertical Scaling. In java we already have support for this using thread pools. Focus on Horizontal Scaling . Also categorizing the processes based on their requirements like web processes, worker processes helps in achieving concurrency.
14) Telemetry (Observability) : This refers to the ability to monitor and measure the performance and health of an app and its components.
15) Auth and Authorization: Focus on 0 trust approach (SSL, HTTPS, etc) and use identity and access management tools like Okta, Auth0, etc.

-----------------------------------------------------------------------------------------------------------------------------

Configuration Management in Microservices:
1) How are u going to separate config/properties from your uservice business logic?
2) How are u going to inject configs or props file into your uservice?
3) How are u going to keep/maintain the configs in a centralized repository?


Following are some solutions:
1) Configuring Spring Boot with properties and profiles
2) Applying external Config with SB
3) Implementing a configuration server with Spring Cloud Config Server

#Externalize the config props:
1) Props file
2) YAML file
3) env variables
4) cmd
Bydefault SB looks inside the classpath for a props file named application.properties

#Commonly used methods to read props

1) @Value annotation: @Value("${key}")
2) Environment interface: env.getProperty("key") (its a interface basically)
3) ConfigurationProperties annotation: @ConfigurationProperties(prefix = "key") or @ConfigurationProperties("prefix")


-----------------------------------------------------------------------------------------------------------------------------

1) So basically we can configure the properties using spring profiles, and also we can activate using command line
2) Also using JVM system props
3) Using Environment variables





