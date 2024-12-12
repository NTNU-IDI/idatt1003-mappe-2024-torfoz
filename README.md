# Portfolio project IDATT1003

[//]: # (TODO: Fill inn your name and student ID)

STUDENT NAME = Tord Johannesen Fosse  
STUDENT ID = 129316

## Project description

[//]: # (TODO: Write a short description of your project/product here.)
Prosjektet er et program utviklet i Java som tar for seg matsvinn ved å hjelpe brukere med å holde oversikt over matvarer og oppskrifter. 
Brukeren kan registrere matvarer i et kjøleskapet, søke etter varer, opprette og se oppskrifter, og lagre disse i en kokebok. 
Programmet har et tekstbasert brukergrensesnitt og er bygget med fokus på brukervennlighet, og vedlikeholdbarhet ved hjelp av strukturer som høy cohesion og lav coupling.

## Project structure

[//]: # (TODO: Describe the structure of your project here. How have you used packages in your structure. Where are all sourcefiles stored. Where are all JUnit-src.test.java.test classes stored. etc.)
- `src/main/java/edu/ntnu/iir/bidata/enums/`: Contains enumeration classes like `RecipeType` and `Unit`.
- `src/main/java/edu/ntnu/iir/bidata/models/`: Contains model classes like `CookBook`, `Fridge`, `Grocery`, and `Recipe`.
- `src/main/java/edu/ntnu/iir/bidata/ui/`: Contains the user interface class `UserInterface`.
- `src/main/java/edu/ntnu/iir/bidata/utils/`: Contains utility classes like `InputUtil`.
- `src/test/java/edu/ntnu/iir/bidata/`: Contains test classes like `FridgeTest` and `RecipeTest`.

## Link to repository

[//]: # (TODO: Include a link to your GitHub repository here.)
[GitHub repository](https://github.com/NTNU-IDI/idatt1003-mappe-2024-torfoz)

## How to run the project

[//]: # (TODO: Describe how to run your project here. What is the main class? What is the main method?
What is the input and output of the program? What is the expected behaviour of the program?)
Download the project from the GitHub repository and open it in IntelliJ IDEA. Navigate to the `UserInterface` class in the `edu.ntnu.iir.bidata.ui` package and run the `main` method.

## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)
To run the tests. Open the project in IntelliJ IDEA and navigate to the `src/test/java/edu/ntnu/iir/bidata/` package. Right-click on the test class you want to run and select `Run 'ClassName'`.