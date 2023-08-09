<a href="/README.md">вернуться к оглавлению</a>

<b>Простой вариант использования Kafka</b> <br><br>

Порядок запуска:<br>
~ запускаем связку приложений ZooKeeper и Kafka c помощью start.bat<br>
(см предыдущие части)<br>
~ запускаем приложение<br>
src/main/java/com/example/kafka_connect/KafkaConnectApplication.java<br>
~ запускаем Postman<br><br>

В Postman создаем запрос типа Post:<br>
адрес: `http://localhost:8080/msg` <br>
Body (form-data) <br>
key: `msgId` value: `string_id`<br>
key:`msg` value: `Hello, world`<br>
Запрос прошёл - Status 200 Ok
<details>
<summary>Картинка запроса</summary>
<img src="postman.png" alt="" />
</details> <br>

Описание схемы прохождения запроса (simple). <br>
Запрос проходит следующие этапы: <br>
~ создаем запрос в Postman<br>
~ для этого запроса используется файл конфигурации<br>
src/main/java/com/example/kafka_connect/config/SimpleMsgConfigProducer.java<br>
в котором мы описываем шаблон сообщения (бин)<br>
simpleKafkaTemplate() <br>
который мы внедрим в следующий контроллер. <br>
~ далее запрос и принимается и обрабатывается и отпраляется контроллером <br>
src/main/java/com/example/kafka_connect/controller/SimpleMsgControllerProducer.java <br>
и отправляется в Кафку <br>
~ далее запрос от Кафки принимается сервисом (слушателем, консьюмером, потребителем)<br>
src/main/java/com/example/kafka_connect/service/SimpleMsgListenerConsumer.java<br>
который, для примера, выводит его в консоль
<details>
<summary>Результат работы Consumer</summary>
<img src="console.png" alt="" />
</details> <br><br>

Примечание: <br>
Если вы хотите чтобы тип id был не String а Long вы можете использовать другой<br> 
конфигурационный файл: <br>
src/main/java/com/example/kafka_connect/config/LongMsgConfigProducer.java <br>
взять оттуда соответственно другой бин: <br>
longKafkaTemplate() <br> 
и использовать его в контроллере. <br>