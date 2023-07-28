public class SLLFactory {
    public static <T> IPlayList<T> create(){
        return new PlayList<T>();
    }
}