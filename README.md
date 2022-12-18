## Install Kafka with Zookeeper on Mac OS

### Step 1 Check Install Java JDK version 17 (or other)
```java -version```
![java-version.png](screenshots%2Fjava-version.png)

### Step 2 Download Apache Kafka from https://kafka.apache.org/downloads under 'Binary Downloads'
![download-kafka.png](screenshots%2Fdownload-kafka.png)

### Step 3 Extract the contents on your Mac
Extract the contents (double click in the Finder) to a directory of your choice, 
for example ```/opt/homebrew/Cellar/kafka_2.13-3.3.1```
![extract-contents.png](screenshots%2Fextract-contents.png)

### Step 4 Create in the folder kafka_2.13-3.3.1/data two folders: kafka and zookeper.
- ```cd kafka_2.13-3.3.1```
- ```mkdir data```
- ```mkdir data/zookeper```
- ```mkdir data/kafka```
![kafka-zookeeper.png](screenshots%2Fkafka-zookeeper.png)

### Step 5 Editing files zookeeper.properties and server.properties
![config-properties.png](screenshots%2Fconfig-properties.png)
- ```~/kafka_2.13-3.3.1/config/server.properties```
- Find log.dirs and paste our temporary path instead
- ```log.dirs=/opt/homebrew/Cellar/kafka_2.13-3.3.1/data/kafka```
![server-properties.png](screenshots%2Fserver-properties.png)
- ```~/kafka_2.13-3.3.1/config/zookeeper.properties```
- Find dataDir and paste our temporary path instead
- ```dataDir=/opt/homebrew/Cellar/kafka_2.13-3.3.1/data/zookeper```
![zookeeper-properties.png](screenshots%2Fzookeeper-properties.png)

### Step 6 Start Zookeeper using the binaries
From the root folder of Apache Kafka, 
you can run ZooKeeper by executing the following command:
- ```bin/zookeeper-server-start.sh config/zookeeper.properties```
![zookeeper-start1.png](screenshots%2Fzookeeper-start1.png)
- Zookeeper running
![zookeeper-start2.png](screenshots%2Fzookeeper-start2.png)

### Step 7 Start Kafka using the binaries in another process
Now, open a new terminal window & run the following command from the root of Apache Kafka to start the Kafka environment:
-```bin/kafka-server-start.sh config/server.properties```
![server-star1.png](screenshots%2Fserver-star1.png)
Kafka running
![server-Start2.png](screenshots%2Fserver-Start2.png)