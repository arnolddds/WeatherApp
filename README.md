# 🌦️ WeatherApp

[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.10-blue.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-1.5.0-brightgreen)](https://developer.android.com/jetpack/compose)
[![API](https://img.shields.io/badge/API-24%2B-orange)](https://android-arsenal.com/api?level=24)

Приложение прогноза погоды, созданное с использованием Clean Architecture, MVI и Decompose. Позволяет находить города, получать текущую погоду и 3-дневный прогноз, а также добавлять локации в избранное.

---

## 📱 Демонстрация

<div align="center">
  <img src="screen/main.png" width="32%" alt="Избранные города">
  <img src="screen/detail.png" width="32%" alt="Детальный экран погоды">
  <img src="screen/search.png" width="32%" alt="Экран поиска">
</div>

---

## 🚀 Ключевые возможности

### 🔍 Поиск и избранное
- Поиск погоды по названию города
- Добавление и удаление из избранного
- Поддержка нескольких избранных локаций

### 🌤 Детальный прогноз
- Актуальная погода: температура, ощущается как, облачность, ветер и т.д.
- Прогноз на ближайшие **3 дня**
- Интуитивный UI с анимациями

### 💾 Локальное хранение
- Данные избранных городов сохраняются локально
- Room + Kotlin Coroutines

---

## ⚙️ Технологический стек

### Ядро
- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**

### Архитектура
- **Clean Architecture**
- **MVI (Mvikotlin)**
- **Decompose** — навигация

### DI & Data
- **Dagger 2** — внедрение зависимостей
- **Retrofit + Gson** — API OpenWeather
- **Room** — локальная база данных
- **Glide Compose** — загрузка и отображение иконок погоды


## 🧠 Архитектурные особенности

- **Clean Architecture** — разделение приложения на слои: `data`, `domain`, `presentation`, обеспечивающее тестируемость и масштабируемость.
- **MVI (Mvikotlin)** — однонаправленный поток данных, с четким управлением состоянием и побочными эффектами.
- **Decompose** — компонентно-ориентированная навигация с сохранением состояния и поддержки deep-link'ов.
- **Dependency Injection через Dagger 2** — гибкая настройка зависимостей и область видимости компонентов.



## 🔧 Инструкция по сборке проекта

1. В файл gradle.properties необходимо добавить ваш apikey в следующем формате
   
```bash
apikey=YOUR_API_KEY 

