<img src="/01_info/kafka.png" alt=""><br>

<h3>Kafka Connect</h3>
Описание проекта<br>
Сначала установим и запустим Zookeeper и Kafka. Потом создаем проект, <br> 
который одновременно является и Поставщиком и Потребителем сообщений через Kafka. <br>
Все работы осуществляются в Windows 7 x64<br>
Жми ★ если понравилось. <br><br>

**Проводим подготовительные работы** <br>

<a href="/01_info/010_zookeeper/ZOOKEEPER.md">Установка Zookeeper</a> <br>
Проверяем JRE, скачиваем, устанавливаем и настраиваем Zookeeper<br><br>

<a href="/01_info/020_kafka/KAFKA.md">Установка Kafka</a> <br>
устанавливаем Kafka, проверяем совместный запуск<br><br>

После проведения подготовительных работ создаем проект<br>
<a href="/01_info/030_create/CREATE.md">Создаем проект</a> <br>
Задаем параметры проекта Spring Boot и Kafka<br><br>

**Использование Kafka в проектах Spring** <br><br>
<a href="/01_info/040_simple/SIMPLE.md">Простой вариант</a> <br>
Отправляем простое сообщения типа String от Постащика Потребителю<br><br>

<a href="/01_info/050_regular/REGULAR.md">Более сложный вариант</a> <br>
Отправляем Потребителю объект UserDTO<br><br>