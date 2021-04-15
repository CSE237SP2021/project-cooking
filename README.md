# Cooking Project
We're developing a command line tool in Java to help you plan meals. To accomplish this, we're using the [WebKnox Recipe API](http://webknox.com/api#!/recipes/getRandomPopularRecipes_GET)

## Iteration 1
* User stories completed this iteration: 
  * [A user can request a random recipe](https://github.com/CSE237SP2021/project-cooking/issues/2)
  * [Basic prototype: Command line interface, API connection](https://github.com/CSE237SP2021/project-cooking/issues/1)
  * [Fix: get Vi's work in the remote repo](https://github.com/CSE237SP2021/project-cooking/issues/6)
  * [A user can export recipes as HTML files](https://github.com/CSE237SP2021/project-cooking/issues/3)
* User stories for next iteration:
  * [A user can search for recipes by name](https://github.com/CSE237SP2021/project-cooking/issues/4)
  * [A user can input ingredients and search for recipes that contain them](https://github.com/CSE237SP2021/project-cooking/issues/5)
* Implemented that doesn't currently work:
  * SearchRecipesByName branch isn't finished yet, but it has been started
* Commands to compile and run code from command line:
  * Compile using javac on Main.java, APIController.java, Controller.java, and InputFilter.java
  * Run using java on Main.java
  * Alternatively, you could run it on the Eclipse consol (if Java on command line is not working)
  * You will also have to download the testNG following the instructions on this website: https://www.toolsqa.com/rest-assured/configure-eclipse-with-rest-assured/

## Iteration 2
* User stories completed this iteration:
  * [Add menu options for users and consolidate code in Controller class](https://github.com/CSE237SP2021/project-cooking/issues/10)
  * [Investigate unit testing addiitons for Controller Class] (https://github.com/CSE237SP2021/project-cooking/issues/9)
  * [Create a class to handle json formatting for the method responses] (https://github.com/CSE237SP2021/project-cooking/issues/12)
* User stories for next iteration:
  * [A user can search for recipes by name](https://github.com/CSE237SP2021/project-cooking/issues/4)
  * [A user can input ingredients and search for recipes that contain them](https://github.com/CSE237SP2021/project-cooking/issues/5)  
* General goals for next iteration
  * Complete the above two features as well as writing robust unit tests for each class as doable (some difficulties with doing this for Controller class because it takes in user input and prints output)
  * Add comments and javadocs to the code
  * Implement features as doable, with unit tests included as part of the issues 

## Features
- By specifying what ingredients you'd like to use, the tool will return a list of recipes that contain those ingredients.
- "I'm feeling lucky"-type feature that gives you a random appetizer/entree/dessert
- A search feature that sorts results by price, etc.
- Exports recipes in a friendly, printable format

## Next steps

### Basic 
1. Running command opens up main menu type environment
2. Search bar that connects to API and returns results
3. Export chosen recipes to a file

### Additional
4. Sorting by price, recipe, etc.
5. "I'm feeling lucky" feature
