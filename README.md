
mvn clean install 

cp [MAVEN REPO]/com/redhat/reproducer/custom-log4J2-addon/1.0-SNAPSHOT/custom-log4J2-addon-1.0-SNAPSHOT.jar [FUSE FOLDER]/system/com/redhat/reproducer/custom-log4J2-addon/1.0-SNAPSHOT/custom-log4J2-addon-1.0-SNAPSHOT.jar


## startup.properties
```
.....
mvn\:com.redhat.reproducer/custom-log4J2-addon/1.0-SNAPSHOT = 8
mvn\:org.ops4j.pax.logging/pax-logging-api/1.11.9 = 8
mvn\:org.ops4j.pax.logging/pax-logging-log4j2/1.11.9 = 8
.....
```

## org.ops4j.pax.logging.cfg
```
log4j2.appender.rolling.layout.type = CustomLayout
log4j2.appender.rolling.layout.prefix = MyPrefix
```

## sample output
```
yPrefix:Sending Event Admin notification (configuration successful) to org/ops4j/pax/logging/Configuration
MyPrefix:Adding features: wrap/[2.6.7,2.6.7]
MyPrefix:Changes to perform:
MyPrefix:  Region: root
MyPrefix:    Bundles to install:
MyPrefix:      mvn:org.ops4j.pax.url/pax-url-wrap/2.6.7/jar/uber
MyPrefix:Installing bundles:
MyPrefix:  mvn:org.ops4j.pax.url/pax-url-wrap/2.6.7/jar/uber
MyPrefix:Starting bundles:
MyPrefix:  org.ops4j.pax.url.wrap/2.6.7
MyPrefix:Done.
```