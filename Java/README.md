========
=[Pigdice](http://rosettacode.org/wiki/Pig_the_dice_game/Player#Java)=
========
**What I did was completely reimplement the game from scratch. I included 4 basic bots with varying strategies. The game not only supports human play and bot simulations, but multiplayer with bots and humans.**


#Task
"The task is to create a dice simulator and scorer of Pig the dice game and add to it the ability to play the game to at least one strategy.

>    State here the play strategies involved.
>    Show play during a game here. 

As a stretch goal:

>    Simulate playing the game a number of times with two players of given strategies and report here summary statistics such as, but not restricted to, the influence of going first or which strategy seems stronger. 

#Game Rules

The game of Pig is a multiplayer game played with a single six-sided die. The object of the game is to reach 100 points or more. Play is taken in turns. On each person's turn that person has the option of either

>    Rolling the dice: where a roll of two to six is added to their score for that turn and the player's turn continues as the player is given the same choice again; or a roll of 1 loses the player's total points for that turn and their turn finishes with play passing to the next player.
>    Holding: The player's score for that round is added to their total and becomes safe from the effects of throwing a one. The player's turn finishes with play passing to the next player. "

Lessened sample output of a simulation:
<pre>
Hello, welcome to Pig Dice the game! How many players? 
4
Alright, starting with 4 players. 

Player 0  is alive! 
Player 1  is alive! 
Player 2  is alive! 
Player 3  is alive! 
Each strategy is numbered 0 - 4. They are as follows: 
`>> Enter '0' for a human player. `
`>> Strategy 1 is a basic strategy where the AI rolls until 20+ points and holds unless the current max is 75+.`
`>> Strategy 2 is a basic strategy where the AI, after 3 successful rolls, will randomly decide to roll or hold.` 
`>> Strategy 3 is similar to strategy 2, except it's a little gutsier and will attempt 5 successful rolls. `
`>> Strategy 4 is like a mix between strategies 1 and 3. After turn points are >= 20 and while max points are still less than 75, it will randomly hold or roll. `

What strategy would you like player 0 to use? 
1
What strategy would you like player 1 to use? 
2
What strategy would you like player 2 to use? 
3
What strategy would you like player 3 to use? 
4
`>> Beginning Player 0's turn. `
   Player 0's turn points are 0. Their total is 0. 
   The max points any player currently has is 0. 
   A 4 was rolled. 
   Player 0's turn points are 4. Their total is 0. 
   The max points any player currently has is 0. 
   A 4 was rolled. 
   Player 0's turn points are 8. Their total is 0. 
   The max points any player currently has is 0. 
   A 1 was rolled. 
   Player 0's turn is now over. Their total is 0. 

`>> Beginning Player 1's turn.` 
...
...
*SNIP*
...
...
Player 3 wins with 102 points! End scores: 
Player 0 had 20 points. 
Player 1 had 73 points. 
Player 2 had 66 points. 
Player 3 had 102 points. 
</pre>
