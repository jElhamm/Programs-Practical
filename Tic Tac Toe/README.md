# Tic Tac Toe Game

   This is a Python implementation of the classic game Tic Tac Toe. Allows you to test against your computer. 
   You are player X and the computer is player C.

## How to Play

   1. The game board is a 3x3 grid. 
    You will be prompted to enter the row and column of the position where you want to place your X.
   2. The computer will randomly select a position to place its O.
   3. The game continues until one player wins or there is a tie.
   4. To win, you need to have three consecutive X's (horizontally, vertically, or diagonally).
   5. If all positions on the board are filled and no player has won, the game ends in a tie.

## Getting Started

   To run the game, you need to have Python installed on your computer.
   Simply execute the playGame() function.

## Example Game
                    Game Status:
                    -------------
                    |   |   |   | 
                    -------------
                    |   |   |   | 
                    -------------
                    |   |   |   | 
                    -------------
                    Row selection     (0-2): 1
                    Column selection  (0-2): 1
    **********************************************************
                    Game Status:
                    -------------
                    |   |   |   | 
                    -------------
                    |   | X |   | 
                    -------------
                    |   |   |   | 
                    -------------
                    computer turn...
    **********************************************************
                    Game Status:
                    -------------
                    |   |   |   | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O |   |   | 
                    -------------
                    Row selection     (0-2): 2
                    Column selection  (0-2): 0
    **********************************************************
                    Game Status:
                    -------------
                    |   |   |   | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O |   | X | 
                    -------------
                    computer turn...
    **********************************************************
                    Game Status:
                    -------------
                    |   |   |   | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O | O | X | 
                    -------------
                    Row selection     (0-2): 0
                    Column selection  (0-2): 0
    **********************************************************
                    Game Status:
                    -------------
                    | X |   |   | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O | O | X | 
                    -------------
                    computer turn...
    **********************************************************
                    Game Status:
                    -------------
                    | X |   |   | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O | O | X | 
                    -------------
                    Row selection     (0-2): 0
                    Column selection  (0-2): 2
    **********************************************************
                    Game Status:
                    -------------
                    | X |   | X | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O | O | X | 
                    -------------
                    computer turn...
    **********************************************************
                    Game Status:
                    -------------
                    | X |   | X | 
                    -------------
                    |   | X |   | 
                    -------------
                    | O | O | X | 
                    -------------
                    (:  Player X won!  :)

    
   (: I hope you enjoy the game! :)