package fiaBot;

public class Vertex {
    private String word;
   
    protected Vertex(String s) {
        word=s;
    }
   
    @Override
    public boolean equals(Object o) {
        Vertex other = (Vertex)o;
        if (this.word.equalsIgnoreCase(other.word))
            return true;
        return false;
    }
   
    @Override
    public int hashCode() {
      String s = word.toUpperCase();
        return s.hashCode();
    }
   
    @Override
    public String toString() {
        return word;
    }              
}
