<a href="/README.md">вернуться к оглавлению</a>

<b>Установка ZooKeeper</b> <br><br>
Первое, что надо знать для начала работы — это то, что Apache Kafka работает <br>
поверх сервиса ZooKeeper. ZooKeeper — это распределенный сервис конфигурирования <br>
и синхронизации, и это всё, что нам нужно знать о нём в данном контексте. <br>
Мы должны скачать, настроить и запустить его перед тем, как начать работу с Kafka. <br>
Прежде чем начать работу с ZooKeeper, убедитесь, что у вас установлен JRE. <br><br>

<b>Проверяем наличие и версию JRE</b> <br><br>
Запускаем CMD и запрашиваем версию java<br>
<pre>
C:\Users\01-2017>java -version
java version "17.0.2" 2022-01-18 LTS
Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
</pre>
Так как в системе уже есть JDK, в нем уже есть JRE<br><br>

Примечание: для всех нижеследующих архивов рекомендуется для распаковки<br> 
использовать 7-zip. Архив можно скачать отсюда:<br>
<pre>http://www.7-zip.org/download.html</pre>

Скачать свежую версию ZooKeeper можно с официального сайта.
<pre>https://zookeeper.apache.org/releases.html</pre>
По состоянию на август 2023<br>
Apache ZooKeeper 3.8.2 is our current release, and 3.7.1 our latest stable release<br><br>

Извлекаем из скаченного архива ZooKeeper файлы. В папке zookeeper с номером версии,<br> 
находим папку conf и в ней файл "zoo_sample.cfg" Копируем его и меняем название копии на "zoo.cfg".<br> 
Открываем файл-копию и находим в нём строчку<br>
`dataDir=/tmp/zookeeper` <br>
Прописываем в данной строчке полный путь к нашей папке zookeeper-х.х.х.<br>
У меня это выглядит примерно так (с 2 левыми слешами в пути):<br>
`dataDir=C:\\apache-zookeeper-3.7.1-bin`<br><br>

На следующем этапе открываем Переменные среды и добавляем туда переменную<br>
`ZOOKEEPER_HOME = C:\apache-zookeeper-3.7.1-bin`<br>
а в конце системной переменной Path добавляем запись:<br>
`;%ZOOKEEPER_HOME%\bin;`<br><br>

**Проверяем правильность установки**<br>
Открываем CMD и запускаем команду "zkserver" Если все сделано правильно<br>
мы должны увидеть нечто такое:<br>
<pre>
C:\Windows\System32>zkserver

C:\Windows\System32>call "C:\Program Files\Java\jdk-17.0.2"\bin\java
"-Dzookeeper.log.dir=C:\apache-zookeeper-3.7.1-bin\bin\..\logs"
"-Dzookeeper.root.logger=INFO,CONSOLE"
"-Dzookeeper.log.file=zookeeper-01-2017-server-01-2017.log"
"-XX:+HeapDumpOnOutOfMemoryError"
"-XX:OnOutOfMemoryError=cmd /c taskkill /pid %%p /t /f" -cp
"C:\apache-zookeeper-3.7.1-bin\bin\..\build\classes;
C:\apache-zookeeper-3.7.1-bin\bin\..\build\lib\*;
C:\apache-zookeeper-3.7.1-bin\bin\..\*;
C:\apache-zookeeper-3.7.1-bin\bin\..\lib\*;
C:\apache-zookeeper-3.7.1-bin\bin\..\conf"
org.apache.zookeeper.server.quorum.QuorumPeerMain
"C:\apache-zookeeper-3.7.1-bin\bin\..\conf\zoo.cfg"
...
</pre>
Далее много строк с меткой INFO и логотип ZooKeeper в виде разных черточек.<br>
Далее нажимаем "CTRL + C" для выхода. Проверка прошла успешно.