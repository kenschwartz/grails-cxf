grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.repos.default = "kmsRepo"
grails.project.repos.kmsRepo.url = "https://wiki.wikigood.com/artifactory/plugins-snapshot-local"
grails.project.repos.kmsRepo.type = "maven"
grails.project.repos.kmsRepo.username = "admin"
grails.project.repos.kmsRepo.password = ''

grails.project.dependency.resolution = {

    String cxfVersion = '3.0.2'
    String jaxbVersion = '2.2.7'
    String springVersion = '4.0.8.RELEASE'

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        compile('commons-cli:commons-cli:1.2')

        compile("org.apache.cxf:cxf-tools-wsdlto-core:${cxfVersion}") {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis', 'jaxb-impl', 'jaxb-xjc',
                    'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("org.apache.cxf:cxf-tools-wsdlto-frontend-jaxws:${cxfVersion}") {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis', 'jaxb-impl', 'jaxb-xjc',
                    'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("org.apache.cxf:cxf-tools-wsdlto-databinding-jaxb:${cxfVersion}") {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis', 'jaxb-impl', 'jaxb-xjc',
                    'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("org.apache.cxf:cxf-rt-frontend-jaxws:${cxfVersion}") {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis', 'jaxb-impl', 'jaxb-xjc',
                    'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("org.apache.cxf:cxf-rt-frontend-jaxrs:${cxfVersion}") {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis', 'jaxb-impl', 'jaxb-xjc',
                    'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("com.sun.xml.bind:jaxb-impl:${jaxbVersion}"){
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis', 'jaxb-impl', 'jaxb-xjc',
                    'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("com.sun.xml.bind:jaxb-xjc:${jaxbVersion}"){
            excludes 'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'spring-beans', 'spring-context', 'slf4j'
        }

        compile("org.springframework:spring-expression:${springVersion}"){
            excludes 'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'spring-aop', 'slf4j'
        }

        compile("org.springframework:spring-aop:${springVersion}"){
            excludes 'junit', 'log4j', 'slf4j-api', 'slf4j-jdk14', 'slf4j'
        }

        /* Some Testing Help **************************************************/
        test('org.apache.ws.security:wss4j:1.6.7') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis',
                    'junit', 'log4j', 'slf4j', 'slf4j-log4j12', 'slf4j-api', 'slf4j-jdk14',
                    'spring-aop', 'spring-beans', 'spring-context'
            export = false
        }

        test("org.apache.cxf:cxf-rt-ws-security:${cxfVersion}"){
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis',
                    'ehcache', 'easymock', 'ehcache-core',
                    'log4j', 'slf4j', 'slf4j-log4j12','slf4j-api', 'slf4j-jdk14',
                    'junit', 'spring-aop', 'spring-beans', 'spring-context'
            export = false
        }


        test("org.gebish:geb-spock:0.9.2") {
            export = false
        }

//        test("com.github.groovy-wslite:groovy-wslite:0.7.2.0") {
//            export = false
//        }

//        test("org.codehaus.geb:geb-spock:${gebVersion}") {
//            export = false
//        }

        test('org.seleniumhq.selenium:selenium-htmlunit-driver:2.25.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis'
            export = false
        }

        test('org.seleniumhq.selenium:selenium-chrome-driver:2.25.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis'
            export = false
        }

        test('org.seleniumhq.selenium:selenium-firefox-driver:2.25.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis'
            export = false
        }
    }

    plugins {
        //remove this before committing.  Only used to release...not test.
        // This still an issue?!?
        // http://grails.1312388.n4.nabble.com/Geb-and-Release-plugin-httpclient-conflicts-td4295238.html
       // build(':release:3.0.1', ':rest-client-builder:2.0.1') {
//            export = false
        //}

        runtime(":hibernate4:4.3.6.1") {
            export = false
        }

        runtime(":tomcat:7.0.55") {
            export = false
        }

        test(":wslite:0.7.2.0") {
            export = false
        }

        test(":geb:0.9.2") {
            export = false
        }

        test(":code-coverage:1.2.5") {
            export = false
        }

        test(":codenarc:0.21") {
            export = false
        }
    }
}

coverage {
    xml = true
    exclusions = ['**/*Tests*']
}

codenarc {
    processTestUnit = false
    processTestIntegration = false
    processServices = false
    processDomain = false
    propertiesFile = 'codenarc.properties'
    ruleSetFiles = 'file:grails-app/conf/codenarc.groovy'
    reports = {
        CxfClientReport('xml') {                    // The report name 'MyXmlReport' is user-defined; Report type is 'xml'
            outputFile = 'target/codenarc.xml'      // Set the 'outputFile' property of the (XML) Report
            title = 'Grails CXF Plugin'             // Set the 'title' property of the (XML) Report
        }
    }
}
