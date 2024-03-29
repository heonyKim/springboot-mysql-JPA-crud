# springboot + mysql + JPA + CRUD + SERVICE + Transaction
###SQL
```sql
create user 'ssar'@'%' identified by 'bitc5600';
grant all privileges on *.* to 'ssar'@'%';
create database ssar;
use ssar;
```
###application.yml문
```yml
server:
  port: 8070
  servlet:
    context-path: /

spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ssar?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true
    username: ssar
    password: bitc5600
    
  jpa:
    open-in-view: false
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true
    #show-sql : 실제로 동작하는 sql문을 보고싶을때 true로 해서 사용(콘솔에 찍힘)
    properties:
      hibernate.enable_lazy_load_no_trans: true
      #레이지로드 : 뒤늦은 로딩이 가능하게 함.(하나의 모델에서 오브젝트를 가지고 있을때, 최초에 필요한것만 로드하고 원하는 오브젝트를 나중에 로드할 수 있음)
      hibernate.format_sql: true
  http:
    encoding:
      charset: UTF-8
      enabled: true
      force: true
  
  servlet:
    multipart:
      enabled: true
      max-file-size: 20MB

      
file: 
  path: G:/workspace/springWork/jpa-crud/src/main/resources/upload/
```
  
###pom.xml문
```xml
  <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.1.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.cos</groupId>
	<artifactId>jpa-crud</artifactId>
	<version>0.1</version>
	<name>jpa-crud</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper -->
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jasper</artifactId>
			<version>9.0.22</version>
		</dependency>


		<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>



		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```
