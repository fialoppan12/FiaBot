package fiaBot;
import java.util.Random;

/**
 * Work in progress. 
 * @author Fialoppan12
 *
 */

public class Edge implements Comparable<Edge> {
        protected Vertex to;
        private int count;
        static Random r = new Random();
       
        protected Edge(Vertex v) {
            to=v;
            count=r.nextInt(50);
        }
       
        @Override
        public int compareTo(Edge other) {
                if (this.getCount()<other.getCount())
                        return -1;
                        else if (this.getCount()>other.getCount())
                                return 1;
                                else if (this.getCount()==other.getCount()) {
                                        //kommer inte hända eftersom check for duplicates
                                        if (this.to.equals(other.to))
                                                return 0;
                                }
                boolean b = r.nextBoolean();
                if (b)
                        return 1;
                return -1;     
                }
 
       
        @Override
        public boolean equals(Object other) {
            Edge e = (Edge)other;
            if (this.to.equals(e.to))
                    return true;
            return false;
        }
       
        @Override
        public int hashCode() {
            return to.hashCode();
        }
       
        public void increase() {
                count=count+r.nextInt(50);
        }
       
        public void decrease() {
                count= count-r.nextInt(50);
        }
       
        public int getCount() {
                return count;
        }
       
        @Override
        public String toString() {
            return to.toString();
        }
}
