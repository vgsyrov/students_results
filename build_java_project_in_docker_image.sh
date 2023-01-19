if [ -n "$1" ]
then
    docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim mvn clean install && chown
else
    docker run -it --rm --name cust-trial-subproject -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/"$(pwd)" -w /usr/src/"$(pwd)" maven:3-openjdk-11-slim mvn -DskipTests=true clean install
fi