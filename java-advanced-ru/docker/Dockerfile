# Указываем образ, от которого наследуемся
FROM eclipse-temurin:20-jdk

ARG GRADLE_VERSION=8.2

RUN apt-get update && apt-get install -yq make unzip

RUN wget -q https://services.gradle.org/distributions/gradle-${8.2}-bin.zip \
    && unzip gradle-${8.2}-bin.zip \
    && rm gradle-${8.2}-bin.zip

ENV GRADLE_HOME=/opt/gradle

RUN mv gradle-${8.2} ${GRADLE_HOME}

ENV PATH=$PATH:$GRADLE_HOME/bin

# Устанавливаем рабочую директорию
WORKDIR /docker

# Копируем директорию из основной файловой системы внутрь образа
COPY ${JAR-FILE} docker.jar

# Определяет действие, которое будет выполнено при старте контейнера (docker run)
# Используется только в случае, если контейнер был запущен без указания команды
# [команда, аргумент]
ENTRYPOINT ["java", "-jar", "docker.jar"]

# Сообщаем, что контейнер использует 8000 порт
EXPOSE 8000