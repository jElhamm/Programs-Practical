import random

def drawBoard(board):
    print("************************************")
    print("Game Status:")
    print("-------------")
    for i in range(3):
        print("|", end=" ")
        for j in range(3):
            print(board[i][j], "|", end=" ")
        print("\n-------------")

def checkWin(board, player):
    # Review rows
    for i in range(3):
        if board[i][0] == board[i][1] == board[i][2] == player:
            return True
        
    # Check the columns
    for j in range(3):
        if board[0][j] == board[1][j] == board[2][j] == player:
            return True
        
    # Check the main diameter
    if board[0][0] == board[1][1] == board[2][2] == player:
        return True
    
    # Check the sub diameter
    if board[0][2] == board[1][1] == board[2][0] == player:
        return True
    return False

def playGame():
    board = [[" " for _ in range(3)] for _ in range(3)]
    currentPlayer = "X"
    gameOver = False
    winner = None
    print("\n-----------------------------------------------------------------------")
    print("|  Game Information: # You are going to play with the computer.        |")
    print("|                    ## You are player X and the computer is player C. |")
    print("|                    ### Do your best to win :)                        |")
    print("-----------------------------------------------------------------------\n" + "let's GO")
    while not gameOver:
        drawBoard(board)
        if currentPlayer == "X":                                                 # Get selected position from current player
            row = int(input("Row selection     (0-2): "))
            column = int(input("Column selection  (0-2): "))
        else:                                                                    # Computer Movement
            print("computer turn...")
            row    = random.randint(0, 2)
            column = random.randint(0, 2)
        if board[row][column] == " ":
            board[row][column] = currentPlayer                                   # Registration of the player's sign in the selected position
            if checkWin(board, currentPlayer):                                   # Checking the current player's win
                gameOver = True
                winner   = currentPlayer
            else:                                                                # Change the player's turn
                if currentPlayer == "X":
                    currentPlayer = "O"
                else:
                    currentPlayer = "X"
            if all(board[i][j] != " " for i in range(3) for j in range(3)):      # Check for a tie
                gameOver = True
                if not winner:
                    winner = None                                                # Indicate a tie
        else:
            print("! This position is already selected !")

    drawBoard(board)
    if winner is not None:                                                       # Display the result of the Game
        print("\n************************************")
        print("|    (:  Player", winner, "won!  :)          |")
        print("************************************\n")
    else:
        print("\n**************************************")
        print("|   ):  The Game ended in a tie!  :(  |")
        print("**************************************\n")

playGame()