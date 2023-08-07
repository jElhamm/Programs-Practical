/**
 * You can use this program to generate random passwords.
**/

#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
using namespace std;

int main() {
    cout << "\n---------------------------------------------------------------" << endl;
    cout << "   Hello, please enter the length of the password: ";
    int passwordLength;
    cin >> passwordLength;

    string numeric   = "0123456789";
    string uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string lowercase = "abcdefghijklmnopqrstuvwxyz";
    string special   = "()<>[]{}/!?*@#&$^%_-+=";  
    string password  = "";
    srand(time(0));
    string select = "";

    cout << "---------------------------------------------------------------" << endl;
    cout << "|  Choose the types of characters for the password:           |" << endl;
    cout << "|  1- Lowercase letters                                       |" << endl;
    cout << "|  2- Uppercase letters                                       |" << endl;
    cout << "|  3- Numeric digits                                          |" << endl;
    cout << "|  4- Special characters                                      |" << endl;
    cout << "---------------------------------------------------------------" << endl;
    cout << "   Enter your choices: ";
    string choices;
    cin >> choices;

    if (choices.find("1") != string::npos) {
        select += lowercase;
    }
    if (choices.find("2") != string::npos) {
        select += uppercase;       
    }
    if (choices.find("3") != string::npos) {
        select += numeric;
    }
    if (choices.find("4") != string::npos) {
        select += special;
    }

    for (int i = 0; i < passwordLength; i++) {
        int random = rand() % select.length();
        password += select[random];
    }
    cout << "---------------------------------------------------------------" << endl;
    cout << "*** Generated Password: " << password << endl;
    cout << "---------------------------------------------------------------" << endl;
    return 0;
}  