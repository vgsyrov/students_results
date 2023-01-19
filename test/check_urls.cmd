

echo checking ping 
./check_url.cmd http://localhost:8080/ping
./check_url.cmd http://localhost:8083/ping
./check_url.cmd http://localhost:8084/ping
./check_url.cmd http://localhost:8085/ping
./check_url.cmd http://localhost:8086/ping

echo checking personal information...
./check_url.cmd http://localhost:8083/list
./check_url.cmd http://localhost:8083/find/initialPersonData_1

echo checking academic performance
./check_url.cmd http://localhost:8084/list
./check_url.cmd http://localhost:8084/findByPerson/initialPersonData_1
./check_url.cmd http://localhost:8084/findByLession/initialLesson_1

echo checking Period planning

./check_url.cmd http://localhost:8085/listLessions
./check_url.cmd http://localhost:8085//findLessionL/initialLesson_1


./check_url.cmd http://localhost:8085/listPartisipans
./check_url.cmd http://localhost:8085//findLessionByLession/initialLesson_1
./check_url.cmd http://localhost:8085//findLessionByPerson/initialPersonData_1



echo checking schedule calendar checking
./check_url.cmd http://localhost:8086/list
./check_url.cmd http://localhost:8086/list_ea
./check_url.cmd http://localhost:8086/auto-attendance PUT BODY


