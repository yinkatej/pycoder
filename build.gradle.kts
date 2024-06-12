plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
//    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springAiVersion"] = "0.8.1"
//ext["spring-security.version"]="5.7.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.session:spring-session-core")
    implementation("org.springframework.session:spring-session-core")
    implementation("org.apache.commons:commons-lang3:3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

//    implementation("org.springframework.ai:spring-ai-vertex-ai-gemini-spring-boot-starter")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("com.mysql:mysql-connector-j")
}

//dependencyManagement {
//    imports {
//        mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
//    }
//}

tasks.withType<Test> {
    useJUnitPlatform()
}
