# Cook It

**Cook it** is an app that shows food categories and their meals.


## Features

- Shows multiple food categories in a horizontal scroll. 
- When selecting a food category, its meals will appear in a vertical grid under it.


## Tech stack

- Kotlin
- Android Compose
- Material Components


## Project structure

```text
app/
├── src/main/java/com/example/cookit/
│   ├── models/
        ├── CategoriesResponse # categories response from categories endpoint
        ├── MealsResponse # meals response from filter endpoint with
        ├── Category # category model
        ├── Meal # meal model
    └── network/MealsCallable.kt
    └── ui/
        ├── CategoryItem
        ├── HomeScreen
        ├── MealItem
        MainActivity.kt # entry point of the app that calls the HomeScreen
```


## Recording

https://github.com/user-attachments/assets/868d14e5-295f-4893-8177-3791eedfa413

