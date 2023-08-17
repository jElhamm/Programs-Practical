# Song Downloader

   This program allows users to download songs by providing the download link and the folder address to save the song.

## Usage

   1. Run the program.
   2. Enter the download link of the song when prompted.
   3. Enter the folder address where you want to save the song file.
   4. The program will validate the song URL and the save path.
   5. If both are valid, the song will be downloaded and saved in the specified folder.
   6. If the song URL is invalid or the folder address is not valid, appropriate error messages will be displayed.

## Example

                _________________________________________________________________________
                |                                                                       |
                |                       ***   Welcome   ***                             |
                |                                                                       |
                |            You can use this program to download your songs.           | 
                |           Enter the download link of a song, then specify an          |
                |          address on your computer to save the song file there.        |
                |        Then you can see your song downloaded at the same address.     |
                |                                                                       |
                |                       (: Hope you enjoy :)                            |
                |_______________________________________________________________________|

                ===> Enter the song download link: https://example.com/songs/song.mp3
                ===> Enter the save path: /path/to/folder

                **************************************************************
                The song has been downloaded and saved successfully!
                **************************************************************

## Notes

   * The program checks the validity of the song URL by sending a GET request to the specified URL. 
   If the response code is 200, it is considered a valid URL.
   * The program also checks if the specified save path is a valid directory.
   * The downloaded song is saved with its original file name.
   * The urllib.parse library is used to handle special characters in the file name and URL.
   * The requests library is used to send HTTP requests to the song URL and retrieve its content.
   * The BeautifulSoup library is used for HTML parsing.

## Remarks

   * Make sure the song download link is valid and accessible.
   * Ensure that the folder address to save the song exists and is accessible.
   * The program checks the validity of the song URL and save path before downloading the song.
   It provides error messages if they are invalid.