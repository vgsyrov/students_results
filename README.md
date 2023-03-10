# Демонстрационный проект: "Backend REST API"


## Запуск проекта:
Linux: `start_trial.sh`
Windows: `start_trial.cmd`

Для запуска необходим установленный *Docker* и подключение к интернету. Первый запуск длится около 5-10 минут (сборка проекта, загрузка библиотек и запуск сервисов).

## Описание REST API (шлюз)   
Swagger doc UI:  http://localhost:8080/swagger-ui/

## Описание решения

Целью данного проекта является написание сервисов предоставляющих информацию об учениках, отображения 
их результатов (оценок) и автоматическое проставление оценки за факт посещения мероприятия (урока). 

### Просмотр результатов
Сервис выборки списка оценок и посещения: http://localhost:8080/lessonResults/{id}

, где id - это требуемое событие.

В тестовых данных возможные значения:
- initialLesson_1
- initialLesson_2


### Простановка автобалла
Сервис простановки автобалла: http://localhost:8080/auto-attendance
Параметры передаются в теле запроса в виде:
{
  "attendanceFact": "string" - значение П/Н - присутствовал/отсутствовал
  "eventId": "string",       - ID мероприятия http://localhost:8086/list
  "personId": "string"       - ID физического лица http://localhost:8083/list
}

Пример: если отправить PUT запрос с этими данными 

   {"eventId":"initialEvent_2", "personId":"initialPersonData_2", "attendanceFact":"П"}

, то на уроке initialLesson_2 (Алгебра и начала анализа) появится ученик (Толстой Лев Николаевич)


## Тесты
Тесты написаны для проверки заполнения БД тестовыми данными и для возможности их выборки через API.

## Другие сервисы
Сервис успеваемости (**academic-performance**): отвечает за хранение и работу с оценками студенту за занятие.

Сервис планирования учебного периода (**period-planning**): отвечает за работу с перечнем учебных занятий и списками участников занятий.

Сервис расписания (**schedule-calendar**), который отвечает за работу с мероприятиями, проводящимися по занятиям и фактами посещения мероприятий.

Сервис персональных данных (**personal-information**), в котором хранятся ФИО и другая персональная информация студентов.

Координационный сервис (шлюз) **results-control-api-gateway**, который будет предоставлять единый API для управления оценками и посещаемостью. У него нет своей БД, его работа – выполнить оркестрацию вызовов сервисов и предоставить API для frontend.

