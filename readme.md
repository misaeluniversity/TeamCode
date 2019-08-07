# Notes on Hadoop
I used this website to set up stand-alone hadoop: 
`https://hadoop.apache.org/docs/r3.2.0/hadoop-project-dist/hadoop-common/SingleCluster.html`

After setting up and startup the local dfs, visit this url:
`http://localhost:45003` and this url for namenode: 
`localhost:9870` and this url for yarn: 
`http://localhost:8088` 

*** Note: If you run in to 'lock' problem, may want to delete temporary file in /tmp folder

I used the following information to create user for mapreduce WordCount:

## Start Hadoop

```
hdfs namenode –format
cd /usr/local/hadoop/sbin
./start-all.sh

jpsOutput:
XXXX SecondaryNameNode
XXXX DataNode
XXXX NodeManager
XXXX NameNode
XXXX ResourceManager
XXXX Jps
```



### Preparation directory structure:
```
hdfs dfs -mkdir /user
hdfs dfs -mkdir /user/student
hdfs dfs -mkdir /user/student/airline
hdfs dfs -mkdir /user/student/airline/output
hdfs dfs -mkdir /user/student/airline/output/1996
hdfs dfs -mkdir /user/student/airline/output/1997
hdfs dfs -mkdir /user/student/airline/output/1998
hdfs dfs -mkdir /user/student/airline/output/1999
hdfs dfs -mkdir /user/student/airline/output/2000
hdfs dfs -mkdir /user/student/airline/output/2001
hdfs dfs -mkdir /user/student/airline/output/2002
hdfs dfs -mkdir /user/student/airline/output/2003
hdfs dfs -mkdir /user/student/airline/output/2004
hdfs dfs -mkdir /user/student/airline/output/2005
hdfs dfs -mkdir /user/student/airline/output/2006

```



### Clone & Build:cd ~/dev
```bash
git clone https://github.com/drkiettran/mapreduce
cd mapreduce
mvn clean package
```

### Prepare Input & Run:
```
hdfs dfs -copyFromLocal ~/dev/airline/1996.csv /user/student/airline

hadoop jar target/cisc-525-mapreduce-jar-with-dependencies.jar com.drkiettran.mapreduce.AirportsByArrivalDelay /user/student/airline/1996.csv /user/student/airline/output/1996/result 1996

```

### Clear output:
```
hdfs dfs -rm -R /user/student/airline/output
```

### Result:
```
hdfs dfs -cat /user/student/shakespeare/output/part-r-00000 

```

## Hive Getting started:

https://cwiki.apache.org/confluence/display/Hive/GettingStarted

## Mysql JDBC Driver download

- Go here: https://dev.mysql.com/downloads/connector/j/
- Choose Looking for previous GA version (i.e., MYSQL 5.1.47)
- Choose platform independent
- Download Zip.
- Unpack the zip
- copy the mysql-connector-java-5.1.47.jar into ~/hive/lib folder.

## hive/lib
Need to have mysql-connector-java-5.1.47.jar stored in ~/hive/lib folder








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

