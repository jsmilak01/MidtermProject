# MidtermProject
A guessing game that keeps track of high scores
## Functionality 

The following **required** functionality is completed:

user opens add and sees a text view prompting them to play, a button to play the game, and a button to view high scores
clicking play game switches the view to two fragments, one with the interface to play the game, the other with a counter for the players score
when in play game you can enter your name, enter a number as a guess, click a plus or minus button to increment/decrement your guess and click ok to guess that number
if the number guessed is incorrect a buzzer sound plays and dialogue pops up on the bottom of the screen to tell you if your guess is higher or lower than the number, fragment in the bottom is supposed to update with the number of guesses
if the number guessed is correct it takes you back to the title screen and the text changes to <username> score: <previous score>


The following **extensions** are implemented:

* 
* ...

## Video Walkthrough

Here's a walkthrough of implemented user stories:
![c323midtermproject](https://github.com/jsmilak01/MidtermProject/assets/111994388/9e8d312b-ec52-45fe-8ff9-786f6ae85b87)


GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

I was still struggling to figure out how to get room library working and did not have the time to implement it
I tried implementing a shared viewmodel for the game fragments but I am unable to get the counter to update
I am also struggling implementing recycler view fully, mostly with the adapter
