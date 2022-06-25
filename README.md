# SA54_KhanSherMostafaSomik_fibonacci
Java REST API built on dropwizard using Maven

Demo:
Send a `POST` request to http://130.162.245.46:8080/fibonacci

with JSON body:
```
{ "elements": 10 }
```
Reply will look like:
```
{"fibonacci":[0,1,1,2,3,5,8,13,21,34],"sorted":[34,8,2,0,21,13,5,3,1,1]}
```

.

## Install

Run local machine (requires Maven & Java JDK 11):
```
mvn clean package
java -jar ./target/sa54somik-1.0-SNAPSHOT.jar
```


Build and run with docker (Requires docker):
```
docker build -t sa54somik .
```

Start the container with:
```
docker run -d -p 8080:8080 --name sa54somik sa54somik
```

.

## Run React JS Client

Run from local machine (requires npm):
```
cd react-js_client
npm install
npm start
```
