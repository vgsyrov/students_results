#!/bin/bash

#docker volume create --name maven-repo
# docker run -it -v maven-repo:/root/.m2 maven mvn archetype:generate # will download artifacts
#$ docker run -it -v maven-repo:/root/.m2 maven mvn archetype:generate # will reuse downloaded artifacts

cd academic-performance
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd period-planning
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd personal-information
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd schedule-calendar
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd results-control-api-gateway
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..
