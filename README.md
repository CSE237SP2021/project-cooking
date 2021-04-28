# Cooking Project
We've developed a command line tool in Java to help you come up with new recipe ideas. To accomplish this, we're using the [WebKnox Recipe API](http://webknox.com/api#!/recipes/getRandomPopularRecipes_GET)

## Iteration 3
* User stories completed this iteration:
  * [A user can input ingredients and search for recipes that contain them.](https://github.com/CSE237SP2021/project-cooking/issues/5)
  * [A user can search for recipes by name](https://github.com/CSE237SP2021/project-cooking/issues/4)
  * [Add Number Filtering and a Corresponding Unit Test to InputFilter](https://github.com/CSE237SP2021/project-cooking/issues/28)
  * [A user can select one of recipes (in folder) from command line and print it in the command line.](https://github.com/CSE237SP2021/project-cooking/issues/19)
  * [Move Controller Tests code to API Controller as well as search methods to API Controller](https://github.com/CSE237SP2021/project-cooking/issues/27)
  * [A user's recipes appear in an output folder (rather than just a file)](https://github.com/CSE237SP2021/project-cooking/issues/21)
  * [A user's exported recipe is aesthetically appealing (through CSS).](https://github.com/CSE237SP2021/project-cooking/issues/31)
  * Note: [PC10: Investigate Unit Testing Additions for Controller Class](https://github.com/CSE237SP2021/project-cooking/issues/9) from last iteration was closed, and the necessary changes from it were included in another PR.
* Unfinished features:
  * The search for recipes by ingredient and by name features are implemented, but only return raw JSON (unlike the styled HTML that random searches return). To our surprise, calls to the WebKnox API from the search-by-ingredient and search-by-name endpoints returned JSON objects of vastly different structure than the random-search endpoint. Given more time on the project, we would add logic to the Exporter class to handle these new structures.
* Commands to compile and run code from command line:  
  * Compile using javac on Main.java, APIController.java, Controller.java, Exporter.java, RecipeOutputter.java, and InputFilter.java
  * Run using java on Main.java
  * Alternatively, you could run it on the Eclipse console (if Java on command line is not working)
  * You will also have to download the testNG following the instructions on this website: https://www.toolsqa.com/rest-assured/configure-eclipse-with-rest-assured/

## Iteration 2
* User stories completed this iteration:
  * [PC9: Add And Consolidate More Menu Options](https://github.com/CSE237SP2021/project-cooking/issues/10)
  * [PC11: Create a class to handle json formatting for the method responses](https://github.com/CSE237SP2021/project-cooking/issues/12)
* User stories for next iteration:
  * [PC10: Investigate Unit Testing Additions for Controller Class](https://github.com/CSE237SP2021/project-cooking/issues/9)
  * [A user can input ingredients and search for recipes that contain them.](https://github.com/CSE237SP2021/project-cooking/issues/5)
  * [A user can search for recipes by name](https://github.com/CSE237SP2021/project-cooking/issues/4)
* Commands to compile and run code from command line:
  * Compile using javac on Main.java, APIController.java, Controller.java, and InputFilter.java
  * Run using java on Main.java
  * Alternatively, you could run it on the Eclipse consol (if Java on command line is not working)
  * You will also have to download the testNG following the instructions on this website: https://www.toolsqa.com/rest-assured/configure-eclipse-with-rest-assured/

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

## Features
- By specifying what ingredients you'd like to use, the tool will return a list of recipes that contain those ingredients.
- "I'm feeling lucky"-type feature that gives you a random appetizer/entree/dessert
- A search feature that sorts results by price, etc.
- Exports recipes in a friendly, printable format

### Basic 
1. Running command opens up main menu type environment
2. Search bar that connects to API and returns results
3. Export chosen recipes to a file

### Additional
4. Sorting by price, recipe, etc.
5. "I'm feeling lucky" feature
