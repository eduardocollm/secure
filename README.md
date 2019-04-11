# micronaut secure example

## build
```
./gradlew clean build
```

## run
```
java -jar ./build/libs/secure-0.1-all.jar
```

## test
See API spec for full endpoint documentation
````
curl -i --user sherlock:password -X POST -H 'Content-Type: application/json' -d '{ "uno": "something", "dos": "something else" }' http://localhost:8080/numbers
````

## API Spec
Run build and api spec will be in `./build/classes/java/main/META-INF/swagger/`
