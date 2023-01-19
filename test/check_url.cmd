@echo off
SET mode=GET
SET http_response=0


if "%~2"=="" SET mode=PUT


if "%~3"=="" goto simplecheck



if NOT "%~3"=="" goto bodycheck


:simplecheck
for /f USEBACKQ %%i in (`curl -X %mode% -s -o response.txt -w "%{http_code}" %%1`) do set RESULT=%%i
echo response simple check: %RESULT%
goto done


:bodycheck
for /f %%i in ('curl -X PUT -s -o response.txt -w "%{http_code}" -H "Content-Type: application/json" -d '{"eventId":"initialEvent_2", "personId":"initialPersonData_2", "attendanceFact":"П"}'  %1') do set RESULT=%%i
echo response body check: %RESULT%
goto done

:done


rem if [ "200" != "$http_response" ]; then
rem     echo "    " + $1 + "ERROR"
rem else
rem    echo "    " + $1 + " returned: OK"
rem fi

