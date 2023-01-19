#!/bin/bash

#printf "\033c"


#sh -c '[ $(curl -o -I -L -s -w "%{http_code}" $1) -eq 200 ]'

mode=GET
http_response=0
if [ -z $2 ]
then
    mode=GET
else
    mode=PUT
fi

if [ -z "$3" ]
then
    http_response=$(curl -X $mode -s -o response.txt -w "%{http_code}" $1)
else
    #echo "parameter 3 = " $3
    #-H "Content-Type: application/json" -d '{"eventId":"7", "personId":"8", "attendanceFact":"П"}'
    http_response=$(curl -X PUT -s -o response.txt -w "%{http_code}" -H "Content-Type: application/json" -d '{"eventId":"initialEvent_2", "personId":"initialPersonData_2", "attendanceFact":""}'  $1)
fi





if [ "200" != "$http_response" ]; then
    echo "    " + $1 + "ERROR"
else
    echo "    " + $1 + " returned: OK"
fi

