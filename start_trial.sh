#!/bin/bash

#total remove images and containers
#docker rm -vf $(docker ps -a -q)
#docker rmi -f $(docker images -a -q)

#./build_java.sh
docker-compose -f docker-compose_full.yml build --parallel && docker-compose -f docker-compose_full.yml up --quiet-pull
