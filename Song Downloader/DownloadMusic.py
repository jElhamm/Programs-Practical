# This program can download songs by receiving download links from the user.

# Inputs include:           1. Song download link
#                           2. Folder address to save the song


import os
import requests
import urllib.parse
import urllib.request

class SongDownloader:
    def __init__(self, song_url, save_path):
        self.song_url = song_url
        self.save_path = save_path

    # Check if the song URL is valid
    def check_song_url(self):
        response = requests.get(self.song_url)                # Send a GET request to the song URL
        if response.status_code == 200:
            return True
        else:
            return False
        
    # Check if the address to save the file is valid 
    def check_save_path(self):
        if os.path.isdir(self.save_path):
            return True
        else:
            return False
        
    # Download and save the song
    def download_song(self):
        if self.check_song_url() and self.check_save_path():
            response = requests.get(self.song_url)
            file_name = self.song_url.split("/")[-1]             # Extract the file name from the song URL.
            with open(file_name, "wb") as file:                  # Save the song content to a file.
                file.write(response.content)

            file_name = urllib.parse.unquote(file_name)
            urllib.request.urlretrieve(self.song_url, self.save_path + '/' + urllib.parse.quote(file_name))
            print('     The song has been downloaded and saved successfully!    ')
        elif not self.check_song_url():
            print(' ( ! Invalid song URL or the song does not exist at the specified URL. ! ) ')
        elif not self.check_save_path():
            print(' ( ! Invalid save path. ! ) ')


# # This part of the code is written as an example to show the output of the code.
# According to your needs, you can change or delete this part.
def  banner():
    print("""
        
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
    """) 

def main():
    banner()
    song_url = input("===> Enter the song download link: ")
    save_path = input("===> Enter the save path: ")
    song_downloader = SongDownloader(song_url, save_path)
    print("**************************************************************")
    song_downloader.download_song()
    print("**************************************************************\n")

if __name__ == '__main__':
    main()