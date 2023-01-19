#!/bin/bash

printf "\033c"

echo checking ping 
./check_url.sh http://localhost:8080/ping
./check_url.sh http://localhost:8083/ping
./check_url.sh http://localhost:8084/ping
./check_url.sh http://localhost:8085/ping
./check_url.sh http://localhost:8086/ping

echo checking personal information...
./check_url.sh http://localhost:8083/list
./check_url.sh http://localhost:8083/find/initialPersonData_1

echo checking academic performance
./check_url.sh http://localhost:8084/list
./check_url.sh http://localhost:8084/findByPerson/initialPersonData_1
./check_url.sh http://localhost:8084/findByLesson/initialLesson_1

echo checking Period planning

./check_url.sh http://localhost:8085/listLessons
./check_url.sh http://localhost:8085/findLesson/initialLesson_1


./check_url.sh http://localhost:8085/listParticipants
./check_url.sh http://localhost:8085/findLessonByLesson/initialLesson_1
./check_url.sh http://localhost:8085/findLessonByPerson/initialPersonData_1



echo checking schedule calendar checking
./check_url.sh http://localhost:8086/list
./check_url.sh http://localhost:8086/all-event-attendances
./check_url.sh http://localhost:8086/auto-attendance PUT BODY


