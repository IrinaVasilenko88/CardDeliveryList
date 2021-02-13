[![Build status](https://ci.appveyor.com/api/projects/status/2a5he7sm8hwdjffc?svg=true)](https://ci.appveyor.com/project/IrinaVasilenko88/carddeliverylist)

# Обучение в Нетологии.

## Домашнее задание по курсу Автоматизированное тестирование

## Тема: Selenide

Автоматизирование тестирования формы заказа доставки карты(приложение ```app-card-delivery.jar```) с условиями: 

- Ввод 2 букв в поле город, после чего выбор нужного города из выпадающего списка

![](https://github.com/netology-code/aqa-homeworks/blob/aqa4/selenide/pic/dropdown.png)

- Выбор даты на неделю вперёд (начиная от текущей даты) через инструмент календаря

![](https://github.com/netology-code/aqa-homeworks/blob/aqa4/selenide/pic/calendar.png)

**Для запуска проекта:**
1. Склонировать проект из репозитория командой 

```
git clone https://github.com/IrinaVasilenko88/CardDeliveryList.git
``` 
2. Открыть склонированный проект в Intellij IDEA
3. Открыть в терминале каталог ```artifacts```
3. Для запуска приложения ввести команду ```java -jar app-card-delivery.jar```
4. Запустить команду ```gradlew test```
