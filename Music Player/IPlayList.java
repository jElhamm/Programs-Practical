import java.util.Iterator;

public interface IPlayList<T>{
    public int size();
    public boolean isEmpty();
    public void insertMusic(String nameSong, String addrSong);
    public String removeMusic(String nameSong);
    public void playMusic(String musicName);
    public Iterator<String> shuffleIterator();
    public Iterator<String> nameIterator();
    public Iterator<Integer> FrequencyIterate();
    public Iterator<String> Iterate();
}