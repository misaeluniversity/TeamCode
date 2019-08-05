# Basic MongoDB commands

## online data

http://stat-computing.org/dataexpo/2009/
http://stat-computing.org/dataexpo/2009/supplemental-data.html


## Import data into collections

```
cd ~/dev/airline
mongoimport --db airline --collection planes --type csv --headerline --file ./plane-data.csv
mongoimport --db airline --collection carriers --type csv --headerline --file ./carriers.csv
mongoimport --db airline --collection airports --type csv --headerline --file ./airports.csv
```


## Run mongoDB client

```
mongo
show databases;
use airline;
show collections;
```

## CRUD operations

```
db.planes.insert({tailnum: 'XYZ1234'});
db.planes.find({tailnum: 'XYZ1234'});
db.planes.update({tailnum:'XYZ1234'},{$set:{'comments':'My comments'}});
db.planes.remove({tailnum: 'XYZ1234'});
```

## Drop collections

```
db.airports.drop();
db.carriers.drop();
db.planes.drop();
```

- When no collection is left, database is removed.

## Build this project:

```
mvn clean package
```

## Run the Spring Boot App:

```
java -jar target/mongodb-0.0.1-SNAPSHOT.jar

```

## Postman test URLs:

```
http://localhost:8080/airports?iata=06N
http://localhost:8080/planes?tailnum=N104UA
```

## Curl

```
curl http://localhost:8080/airports?iata=06N
curl http://localhost:8080/planes?tailnum=N104UA
```

