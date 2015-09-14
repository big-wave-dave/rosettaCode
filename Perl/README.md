These are the Rosetta Code's descriptions of the tasks.

===================
===Penney's Game===
===================
Link: http://rosettacode.org/wiki/Penney%27s_game#Perl
"Penneys game is a game where two players bet on being the first to see a particular sequence of Heads and Tails in consecutive tosses of a fair coin.

It is common to agree on a sequence length of three then one player will openly choose a sequence, for example Heads, Tails, Heads, or HTH for short; then the other player on seeing the first players choice will choose his sequence. The coin is tossed and the first player to see his sequence in the sequence of coin tosses wins.

For example: One player might choose the sequence HHT and the other THT. Successive coin tosses of HTTHT gives the win to the second player as the last three coin tosses are his sequence.

The Task:
Create a program that tosses the coin, keeps score and plays Penney's game against a human opponent.
Who chooses and shows their sequence of three should be chosen randomly.
If going first, the computer should choose its sequence of three randomly.
If going second, the computer should automatically play the optimum sequence.
Successive coin tosses should be shown. "

====================
==General FizzBuzz==
====================
Link: http://rosettacode.org/wiki/General_FizzBuzz#Perl
"Write a generalized version of FizzBuzz that works for any list of factors, along with their words. This is basically a "fizzbuzz" implementation where the user supplies the parameters. The user will enter the max number, then they will enter the factors to be calculated along with the corresponding word to be printed. For simplicity's sake, assume the user will be inputing an integer as the max number and 3 factors, each with a word associated with them.

For example, given:

>20      #This is the maximum number, supplied by the user
>3 Fizz  #The user now enters the starting factor (3) and the word they want associated with it (Fizz)
>5 Buzz  #The user now enters the next factor (5) and the word they want associated with it (Buzz)
>7 Baxx  #The user now enters the next factor (7) and the word they want associated with it (Baxx)

In other words: For this example, print the numbers 1 through 20, replacing every multiple of 3 with "Fizz", every multiple of 5 with "Buzz", and every multiple of 7 with "Baxx". In the case where a number is a multiple of at least two factors, print each of the words associated with those factors in the order of least to greatest factor. For instance, the number 15 is a multiple of both 3 and 5; print "FizzBuzz". If the max number was 105 instead of 20, you would print "FizzBuzzBaxx" because it's a multiple of 3, 5, and 7."