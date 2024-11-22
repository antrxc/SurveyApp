# SurveyApp

SurveyApp is an Android application designed to demonstrate text input and validation using Android Compose.

## Project Structure

The project is structured as follows:

- `app/src/main/java/com/example/surveyapplication/`: Contains the main application code.
  - `AdminActivity.kt`: Handles administrative tasks.
  - `LoginActivity.kt`: Manages user login.
  - `MainActivity.kt`: The main entry point of the application.
  - `RegisterActivity.kt`: Manages user registration.
  - `Survey.kt`: Represents the survey data model.
  - `SurveyDao.kt`: Data Access Object for surveys.
  - `SurveyDatabase.kt`: Database configuration for surveys.
  - `SurveyDatabaseHelper.kt`: Helper class for survey database operations.
  - `User.kt`: Represents the user data model.
  - `UserDao.kt`: Data Access Object for users.
  - `UserDatabase.kt`: Database configuration for users.
  - `UserDatabaseHelper.kt`: Helper class for user database operations.
  - `ui/theme/`: Contains theme-related files for the application.
    - `Theme.kt`
    - `Color.kt`
    - `Type.kt`
    - `Shape.kt`

- `app/src/test/java/com/example/surveyapplication/`: Contains unit tests.
  - `ExampleUnitTest.kt`: Example unit test file.

- `app/build/`: Contains build-related files and directories.

- `.idea/`: Contains project-specific settings for the IDE.

## Configuration Files

- `gradle.properties`: Contains project-wide Gradle settings.
- `app/proguard-rules.pro`: Contains ProGuard rules for the project.
- `.idea/inspectionProfiles/Project_Default.xml`: Contains inspection profiles for the project.
- `.idea/gradle.xml`: Contains Gradle settings for the project.
- `.idea/misc.xml`: Contains miscellaneous project settings.
- `.idea/vcs.xml`: Contains version control settings.

## Build and Run

To build and run the project, use the following commands:

```sh
./gradlew build
./gradlew installDebug
```

# [Demo Video](https://drive.google.com/file/d/1mP4xmj1ADjWwbkkns8rvG0xgohyNCdz0/view?usp=sharing) | [PPT](Naan_Mudhalvan_PPT.pdf)
