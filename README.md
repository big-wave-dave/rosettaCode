# rosettaCode
Open Source contributions I've made to rosettacode.org

I'll always post a link to the code I've put up as well as include the source code here and Rosetta Code's description of the program.

===================
===Penney's Game===
===================
Link: http://rosettacode.org/wiki/Penney%27s_game#Perl
"Penneys game is a game where two players bet on being the first to see a particular sequence of Heads and Tails in consecutive tosses of a fair coin.

It is common to agree on a sequence length of three then one player will openly choose a sequence, for example Heads, Tails, Heads, or HTH for short; then the other player on seeing the first players choice will choose his sequence. The coin is tossed and the first player to see his sequence in the sequence of coin tosses wins.

For example: One player might choose the sequence HHT and the other THT. Successive coin tosses of HTTHT gives the win to the second player as the last three coin tosses are his sequence.

The Task

Create a program that tosses the coin, keeps score and plays Penney's game against a human opponent.

    Who chooses and shows their sequence of three should be chosen randomly.
    If going first, the computer should choose its sequence of three randomly.
    If going second, the computer should automatically play the optimum sequence.
    Successive coin tosses should be shown. "