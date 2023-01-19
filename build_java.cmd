cd academic-performance
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v %CD%:/usr/src/academic-performance -w /usr/src/academic-performance maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd period-planning
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v %CD%:/usr/src/period-planning -w /usr/src/period-planning maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd personal-information
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v %CD%:/usr/src/personal-information -w /usr/src/personal-information maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd schedule-calendar
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v %CD%:/usr/src/schedule-calendar -w /usr/src/schedule-calendar maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..

cd results-control-api-gateway
docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v %CD%:/usr/src/results-control-api-gateway -w /usr/src/results-control-api-gateway maven:3-openjdk-11-slim bash -c "mvn -DskipTests=true clean install && chown $USER:$GROUP -R /usr/src/"
cd ..
