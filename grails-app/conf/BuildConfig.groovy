grails.project.work.dir = 'target'

grails.project.dependency.resolver = 'maven'

grails.project.dependency.resolution = {
    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        mavenRepo 'http://repo.spring.io/milestone' // TODO remove
        mavenRepo 'https://oss.sonatype.org/content/repositories/snapshots'
    }

    dependencies {
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0", {
            export = false
        }

        compile 'net.spy:spymemcached:2.10.3'
        compile 'com.google.guava:guava-io:r03'
        compile 'org.pac4j:pac4j-oauth:1.5.0-SNAPSHOT'
    }

    plugins {
        compile ':spring-security-core:2.0-RC2'
        runtime(":cors:1.1.4") {
            exclude("spring-security-core")
            exclude("spring-security-web")
        }

        build(":release:3.0.1", ":rest-client-builder:1.0.3") {
            export = false
        }

        test(":spock:0.7") {
            exclude("spock-grails-support")
            export = false
        }
    }
}
