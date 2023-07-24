import imaplib

def connectServer():
    email = input("## Please enter your Email: ")
    password = input("### Please enter your Password: ")
    imapServer = imaplib.IMAP4_SSL('imap.gmail.com')                  # Connection to the server
    try:
        imapServer.login(email, password)                             # Log in to your Email account
    except imaplib.IMAP4.error:
        print("Invalid Email or Password!. Program terminated.\n")
        return None
    return imapServer

def read_readEmails(imapServer):
    imapServer.select('INBOX')                                        # Choosing an Email box
    result, data = imapServer.search(None, 'SEEN')                    # Search in read Emails
    readEmails = data[0].split()

    print("Your read Emails:\n")
    for num in readEmails:
        result, data = imapServer.fetch(num, '(RFC822)')
        print(data[0][1])

def read_unreadEmails(imapServer):
    imapServer.select('INBOX')
    result, data = imapServer.search(None, 'UNSEEN')
    unread_emails = data[0].split()

    print("Your unread Emails:\n")
    for num in unread_emails:
        result, data = imapServer.fetch(num, '(RFC822)')
        print(data[0][1])

def main():
    print("\n-------------------------------------------------")
    imapServer = connectServer()
    if not imapServer:
        return
    print("\n-----------------------------------------")
    print("| Please select the desired option:      |")
    print("| 1. View read Emails                    |")
    print("| 2. View unread Emails                  |")
    print("-----------------------------------------")
    userChoice = input("Your Choice: ")
    if userChoice == "1":
        read_readEmails(imapServer)
    elif userChoice == "2":
        read_unreadEmails(imapServer)
    else:
        print("Invalid Selection!")

    imapServer.logout()                                                 # disconnection

if __name__ == "__main__":
    main()