# java-gradle-template
A template java project using gradle and basic dependencies
It basically follows the tutorial described here: https://docs.gradle.org/current/samples/sample_building_java_applications.html
I have added an example dependency that reads a CSV file (many of you look like they want something like that). 
A tutorial is here: https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/
There are different options for reading input from the console: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
Place your assigned file description.pdf in the root folder of the project. 
Add whatever documentation you feel necessary in README.md (also root folder).

------------------------------------------------------------------------------------------------------------

[ Group 21 - Quiz game summary ]

* Quiz questions
programming, machine learning and software engineering in general / a multiple-choice question with a correct answer. 

* Penalty system
• Incorrect answer would cost them some penalty. 
• The penalty is in the form of life (hearts). 
• Every player would start with 3 lives or hearts. 
• The incorrect answer would also give a descriptive text about why the answer is incorrect. 

* Time limitation
• The player would also have a timer running for every question (like 10-30 seconds based on the difficulty of the question). 
• If the timer runs out, they will lose a heart. 

* Point system (for unlocking the next quiz)
• player earns points for giving a correct answer. 
• These points can later be spent on unlocking the next quiz. 

* The next quiz
• would be of a different field/subject than the first one. 
• Once a new quiz is unlocked by paying the points
• The points will be deducted, and the remaining balance is shown. 
• If a player answers all the questions in a quiz without losing all their lives, they will get extra points.

* Features:
• Timer 
• Heart/lives system
• Point based system for the next quiz (Basic quiz)
• Rewards for completing a quiz without losing all hearts

*  Requirements:
• Dataset in the form of a csv file that would contain a set of questions, options, answers and difficulty.
• Simple GUI for this quiz that would display the question and options, the timer, lives and points earned.
• We want the app to be operated with mouse clicks and mouse movements.
• We also want to save the progress of points and unlocked quizzes for the user.

* References:
https://gameoftheyear.withgoogle.com/


>> Our Tasks
Create github 
Define functions, variables, classes 
Function to extract info from csv 
Manager of the UI -> controls intro UI and question UI 
Function to select a question from the csv and display it in the UI 
Function check if the answer is correct or not and increase the score
Function to go to the next question and count the number of questions
Code simple quiz UI intro 
Code simple quiz UI questions
