import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        IPlayList myPlaylist = SLLFactory.create();
        System.out.println("\n****************************");
        myPlaylist.insertMusic("music 1", "E:\\file1.mp3");
        myPlaylist.insertMusic("music 2", "E:\\file2.mp3");
        myPlaylist.insertMusic("music 3", "E:\\file3.mp3");
        myPlaylist.insertMusic("music 4", "E:\\file4.mp3");
        myPlaylist.insertMusic("music 5", "E:\\file5.mp3");
        myPlaylist.playMusic("music 3");
        myPlaylist.playMusic("music 1");
        myPlaylist.playMusic("music 5");
        myPlaylist.playMusic("music 2");
        myPlaylist.playMusic("music 4");
        myPlaylist.playMusic("music 2");
        myPlaylist.playMusic("music 4");
        myPlaylist.playMusic("music 3");
        myPlaylist.playMusic("music 1");
        myPlaylist.playMusic("music 5");
        myPlaylist.playMusic("music 2");
        myPlaylist.playMusic("music 5");

        Iterator<String> nameSong = myPlaylist.nameIterator();
        while(nameSong.hasNext()){
            String element = nameSong.next();
            System.out.println(element);
        }
        System.out.println("****************************\n");
        Iterator<String> shuffleSong = myPlaylist.shuffleIterator();
        while(shuffleSong.hasNext()){
            String element = shuffleSong.next();
            System.out.println(element);
        }
    }
}