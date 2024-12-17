Приложение из двух сервисов - сервис для работы с числами и сервис с фича-тогглами, который использует БД postgres.

## Сборка

Для сборки необходимо выполнить следующую команду:

`./gradlew clean build`

Затем произвести сборку образов

`docker compose build`

## Локальный запуск

Для локального запуска выполнить команду:

`docker compose up`

После выполнения команды создается папка db_data - вольюм для базы данных.

## Развертывание на кластере

Пример развертывания в кластере minikube может выглядеть следующим образом.

1. `kubectl apply -f manifests/configmap.yml`
2. `kubectl apply -f manifests/secret-db.yml`
3. `kubectl apply -f manifests/statefulset-postgres.yml`
4. `kubectl apply -f manifests/service-postgres.yml`
5. `minikube mount ./liquibase/changelog:/mnt/data`
6. `kubectl apply -f manifests/pv-liquibase.yml`
7. `kubectl apply -f manifests/pvc-liquibase.yml`
8. `kubectl apply -f manifests/job-migration.yml`
9. `kubectl apply -f manifests/deployment-feature-service.yml`
10. `kubectl apply -f manifests/deployment-base-app.yml`
11. `kubectl apply -f manifests/service-feature-service.yml`
12. `kubectl apply -f manifests/service-base-app.yml`
13. `kubectl create secret tls tls-secret --cert=tls-examples/tls.crt --key=tls-examples/tls.key`
14. `kubectl apply -f manifests/ingress.yml`
15. `minikube tunnel`