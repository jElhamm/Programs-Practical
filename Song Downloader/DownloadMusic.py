# This program can download songs by receiving download links from the user.

# Inputs include:           1. Song download link
#                           2. Folder address to save the song


import os
import requests
import urllib.parse
import urllib.request
from bs4 import BeautifulSoup

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