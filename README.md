# NewsProjectV2

**NewsProjectV2** — это веб-приложение для агрегации, обработки и отображения новостей из различных источников.  
Проект построен на **Java** с использованием **Spring Boot** и предназначен для демонстрации навыков backend-разработки, работы с API новостных сервисов (например, NewsAPI) и баз данных.  
Во **второй версии** проекта улучшена производительность и структура.  
NewsProjectV2 реализует API для управления новостями: создание, чтение, обновление и удаление (CRUD).  

---

## Архитектура

Приложение реализует классическую 3-слойную структуру:
controller → service → dao → model

- **Controller** — слой взаимодействия с пользователем (`ApplicationController`),  
  управляет навигацией между страницами, обработкой форм и вызовами сервисов.  
- **Service** — бизнес-логика (например, `NewsService`, `UserService`).  
- **DAO / Repository** — работа с источником данных (реализация не показана).  
- **Bean (model)** — классы сущностей: `News`, `User`, `Roles`, `LocaleOptions`.  
- **View** — JSP/Thymeleaf-шаблоны с макетом `baseLayout`.  

---

## Функции

- Использование Spring Boot, Java и CSS  
- Регистрация и авторизация пользователей  
- Добавление, редактирование, просмотр и удаление новостей  
- Ролевая модель доступа (*user*, *admin*, *guest*)  
- Переключение локализации (через `LocaleOptions`)  
- Валидация данных через `@Valid` и `BindingResult`  
- Информирование пользователя через глобальные сообщения в сессии  
- Разделение приложения на Controller, Service и DAO слои  
- Пагинация списка новостей  

---

## Технологии

| Компонент | Технология |
|------------|-------------|
| Язык | Java 17 |
| Фреймворк | Spring Boot (укажи версию) |
| Сборка | Maven |
| Шаблоны | JSP / Thymeleaf |
| Валидация | javax.validation |
| Управление сессиями | HttpSession |
| Dependency Injection | @Autowired |
| Локализация | LocaleOptions |
| AOP | Aspects (для разделения кросс-срезной логики) |

---

## Основные эндпоинты

| Маршрут | Метод | Назначение |
|----------|--------|------------|
| `/controller/goToBasePage` | GET | Главная страница, последние новости |
| `/controller/goToNewsList/` | GET | Список новостей с пагинацией |
| `/controller/goToAddNews` | GET | Страница добавления новости |
| `/controller/doAddNews` | POST | Добавление новости |
| `/controller/goToEditNews/{newsId}` | GET | Редактирование новости |
| `/controller/goToEditNews/doEditNews/{newsId}` | POST | Сохранение изменений |
| `/controller/goToViewNews/{newsId}` | GET | Просмотр новости |
| `/controller/goToViewNews/doDeleteNews` | POST | Удаление новости |
| `/controller/doRegistration` | POST | Регистрация пользователя |
| `/controller/doSignIn` | POST | Вход пользователя |
| `/controller/doSignOut` | POST | Выход из системы |
| `/controller/doLocale` | POST | Изменение языка интерфейса |

---

## Валидация и обработка ошибок

- Поля очищаются через `@InitBinder` и `StringTrimmerEditor`.  
- Ошибки форм обрабатываются с помощью `BindingResult` и аннотации `@Valid`.  
- Исключения сервисного уровня (`ServiceException`) перехватываются в контроллере.  
- Ошибочные переходы перенаправляются на `/controller/goToError`.  

---

## Навигация и представления

Все страницы рендерятся через общий макет:
baseLayout.jsp


В `Model` передаются атрибуты:
- `presentation` — имя отображаемой страницы (`add_news`, `view_news`, `registration`, и т.д.)  
- `news`, `user`, `message` — данные для рендеринга содержимого  

---

## Установка и запуск

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/enhort88/NewsProjectV2.git
   cd NewsProjectV2```
2. Соберите и запустите проект:
  ```mvn clean install
mvn spring-boot:run
```
3. Перейдите в браузере: http://localhost:8080/controller/goToBasePage

**Структура проекта**
/src
  /main
    /java/by/htp/main
      /controller   → контроллеры (ApplicationController)
      /service      → бизнес-логика (NewsService, UserService)
      /bean         → модели данных (News, User, Roles, LocaleOptions)
      /dao          → слой доступа к данным
    /resources
      application.properties

**Автор**
Artem Ponikarov
Java-разработчик
Stack: Java + Spring Boot + Hibernate + Kafka + RabbitMQ + Flyway + MySQL + Jenkins
GitHub: @enhort88
