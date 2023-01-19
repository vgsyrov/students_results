#!/bin/bash

#total remove images and containers
#docker rm -vf $(docker ps -a -q)
#docker rmi -f $(docker images -a -q)

export USER=$(id -u ${USER})
export GROUP=$(id -g ${USER})

docker volume create --name maven-repo

./build_java.sh
docker-compose -f docker-compose_fast.yml up --quiet-pull --build #--no-color > docker.log
