import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PlayList<T> implements IPlayList<T> {
    private class Node{
        private Node next;
        private String nameMusic;
        private File fileMusic;
        private int frequencyMusic;
        public Node(String nameMusic, File fileMusic, Node next){
            nameMusic = nameMusic;
            next = next;
            fileMusic = fileMusic;
            frequencyMusic = 0;
        }
        public String getName(){
            return nameMusic;
        }
        public File getfileMusic(){
            return fileMusic;
        }
        public void increaseRepetition() {
        	this.frequencyMusic = this.frequencyMusic + 1;
        }
        public int getfrequencyMusic(){
            return frequencyMusic;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public PlayList() {
        head = new Node(null, null, null);
        tail = null;
        size = 0;
    }

    private class shuffleIterator implements Iterator<String>{ 
        ArrayList<String> newArray = new ArrayList<String>();
        Node current;
        int n = 0;
        public shuffleIterator(){
            current = head.getNext();
            for(int i=0; i<size; i++){
                newArray.add(current.getName());
                current = current.getNext();
            }
            while(current != null){
                int random = (int) Math.random() * size;
                for(int i=0; i<random; i++){
                    current = current.getNext();
                }
            } 
        }
        @Override
        public boolean hasNext() {
            return current != null && current.getNext() != tail;
        }
        @Override
        public String next() {
            String m = newArray.get(0);
            newArray.remove(0);
            if(n == newArray.size()){
                throw new IndexOutOfBoundsException("");
            }
            return m;
        }
    } 

    private class nameIterator implements Iterator<String>{
        ArrayList<String> newArray = new ArrayList<String>();
        Node current;
        int n = 0;
        public nameIterator(){
            current = head.getNext();
            for(int i=0; i<size; i++){
                newArray.add(current.getName());
                current = current.getNext();
            }
            String temp; 
            for(int i=0; i<newArray.size(); i++){
                for(int j= i+1; j<newArray.size(); j++){
                    if(newArray.get(i).compareTo(newArray.get(j)) > 0){
                        temp = newArray.get(i);
                        newArray.set(i, newArray.get(j));
                        newArray.set(i, temp);
                    }
                }
            }
        }
        @Override
        public boolean hasNext() {
            return current != null && current.getNext() != tail;
        }
        @Override
        public String next() {
            if (newArray == null || newArray.isEmpty()) {
                return null; // or handle it based on your requirements
            }
            String m = newArray.get(0);
            newArray.remove(0);
            return m;
        }
    } 

    private class musicIterator implements Iterator<String>{
        Node current;
        public musicIterator(){
            current = head;
        }
        @Override
        public boolean hasNext() {
            return current.getNext() != m_tail;
        }
        @Override
        public String next() {
            current = current.getNext();
            if(current == tail){
                throw new IndexOutOfBoundsException("");
            }
            return m_current.getName();
        }
    }

    @Override
    public void insertMusic(String nameSong, String addrSong) {
        if (findMusic(nameSong) != null) {
            System.out.println("This music is available in the playlist!!");
        } else {
            Node newNode = new Node(nameSong, Paths.get(addrSong).toFile(), null);
            if (size == 0) {
                head.setNext(newNode);
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
        }
    }
    private Node findMusic(String nameSong) {
        if (size == 0 || head.getNext() == null) {
            return null;
        }
        Node current = head.getNext();
        for (int i=0; i < size; i++) {
            if (current.getName().equals(nameSong)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    @Override
    public String removeMusic(String nameSong){
        if(isEmpty()){
            return null;
        }
        Node current = head.getNext();
        for(int i=0; i < size; i++){
            if(current.getName().equals(nameSong)){
                if(current.getNext() == null){
                    m_tail.setNext(current.getNext());
                } else {
                    current.getNext().setNext(current.getNext());
                }
                size--;
                current.getName();
            }
            current = current.getNext();
        }
        return null;
    }
    @Override
    public String toString() {
        String str = "[";
        System.out.println();
        Node current = head.getNext();
        for (int i = 0; i < size; i++) {
            str += " " + current.getName();
            System.out.println();
            current = current.getNext();
        }
        System.out.println(str += "]");
        return str;
    }
    @Override
	public void playMusic(String musicName) {
		Node musicnode = findMusic(musicName);
		if(musicnode == null) {
			System.out.println("  (  ! Music not found !  )  ");
		}else {
			System.out.println("|   " + musicnode.getName()+" is Playing" + "   |");
			musicnode.increaseRepetition();
		}
	}
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0; 
    }
    @Override
    public Iterator<String> shuffleIterator() {
        return new shuffleIterator();
    }
    @Override
    public Iterator<String> nameIterator() {
        return new nameIterator();
    }
    @Override
    public Iterator<Integer> FrequencyIterate() {
        return new frequencyIterator();
    }
    @Override
    public Iterator<String> Iterate(){
        return new musicIterator();
    } 
}