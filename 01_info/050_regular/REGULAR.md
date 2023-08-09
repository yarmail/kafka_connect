<a href="/README.md">вернуться к оглавлению</a>

<b>Более сложный вариант использования Kafka</b> <br><br>

Немного усложним наш проект и представим, что нам нужно <br>
отправить Потребителю объект (передать модель) UserDTO<br>

Порядок запуска (как и в простом случае):<br>
~ запускаем связку приложений ZooKeeper и Kafka c помощью start.bat<br>
~ запускаем приложение<br>
src/main/java/com/example/kafka_connect/KafkaConnectApplication.java<br>
~ запускаем Postman<br><br>

В Postman создаем запрос типа Post для передачи юзера :<br>
адрес: `http://localhost:8080/user` <br>
Body (form-data) <br>
key: `msgId` value: `12345`<br>
key:`name` value: `Vasya`<br>
key:`age` value: `15`<br>
Запрос прошёл - Status 200 Ok
<details>
<summary>Картинка запроса</summary>
<img src="postman.png" alt="" />
</details> <br>

Описание схемы прохождения запроса (user). <br>
Запрос проходит следующие этапы: <br>
~ создаем запрос в Postman<br>
~ для этого запроса используется файл конфигурации специально для User<br>
src/main/java/com/example/kafka_connect/config/UserMsgConfigProducer.java<br>
в котором мы описываем шаблон сообщения (бин)<br>
userKafkaTemplate() <br>
который мы внедрим в следующий контроллер. <br>
~ далее запрос и принимается и обрабатывается и отпраляется контроллером <br>
src/main/java/com/example/kafka_connect/controller/UserMsgControllerProducer.java <br>
и отправляется в Кафку <br>
~ далее запрос от Кафки принимается сервисом (слушателем, консьюмером, потребителем)<br>
src/main/java/com/example/kafka_connect/service/UserMsgListenerConsumer.java<br>
который, выводит его в консоль
<details>
<summary>Результат работы Поставщика и Потребителя в консоли</summary>
<img src="console.png" alt=""/>
</details> <br><br>

Примечание<br> 
Так как усложнился конфиг Продюсера, нужно усложнить и конфиг Потребителя <br>
src/main/java/com/example/kafka_connect/config/UserMsgConfigConsumer.java<br>