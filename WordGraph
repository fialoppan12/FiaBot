package fiaBot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
 
/**
 *
 * @author fialoppan
 *
 */
 
public class WordGraph implements FiaBot {
        private HashMap<Vertex, ArrayList<Edge>> graph = new HashMap<Vertex, ArrayList<Edge>>(); 
        private static Vertex start = new Vertex("START");
        private static Vertex stop = new Vertex("STOP");
        private static Edge stopEdge = new Edge(stop);
        private static Random r = new Random();
       
        public WordGraph() {
            graph.put(start, new ArrayList<Edge>());
        }
       
        /**
         * Method for adding input to the graph.
         * Separates a String into an array containing wordes separated by the space-button parametrized into private add(String s)
         *
         * @param s input String to be converted in to vertices and added to the graph
         */
       
        public void readInput(String s) {
            String regex = " ";
            String[] words = s.split(regex);
            this.add(words);
            return;
        }
        
        public String getAnswer() {
            return this.calcOutput4();
        }
     
        /**
         * Internal method to add vertices and their proper edges to the graph.
         * A new vertex is created for every String in sentence[] (which will always be a single word since readInput()) 
         * <p>
         * initializing Vertex is start.
         * <p>
         * Create a new Edge e with destination v in list of all new vertices.
         * if prev (witch is start at first) is in the graph check whether its list contains e. 
         * if so increase value of e, other add e to v's list.
         * <p>
         * if graph does not contain prev. add it to the graph with a new empty list. 
         * add Edge e to same list. 
         * <p>
         * set prev to next vertex in list. 
         *<p>
         * add stopEdge to last vertices List of edges. 
         * <p>
         * (just nu är det meningslöst att check if list contains en viss edge eftersom jag inte har implementerat value hos Edge.
         * men det hindrar att vertex's list inte innehåller duplicates.) 
         *
         * @param sentence array containing words to be transformed into vertices
         */
        private void add(String[] sentence) {
            LinkedList<Vertex> list = new LinkedList<Vertex>();
           
            for (int i = 0; i< sentence.length; i++) {
                list.add(new Vertex(sentence[i]));
            }
           
            Vertex prev=start;             
            for (Vertex v : list) {
                Edge e = new Edge(v);
                if (graph.containsKey(prev)) {
                    if (graph.get(prev).contains(e)) {
                        for (Edge ed : graph.get(prev)) 
                            if (ed.equals(e)) 
                                ed.increase();
                    } else 
                      graph.get(prev).add(e);
                } else {
                        graph.put(prev, new ArrayList<Edge>());
                        graph.get(prev).add(e);
                }               
                prev=v;
            }
            if (graph.containsKey(prev)) {
                if (graph.get(prev).contains(stopEdge))
                    stopEdge.increase();
            } else {
		        graph.put(prev, new ArrayList<Edge>());
		        graph.get(prev).add(stopEdge);
            }
           
            this.printMap();
        }
        
        /*     
        public String calcOutput2() {
                StringBuilder sb = new StringBuilder();
 
 
                Iterator<Edge> alts = graph.get(start).iterator();
                ArrayList<Edge> alter = graph.get(start);
                Edge next;
                Vertex n=start;
                for (Edge e : alter)
                        for (Edge e2 : alter) {
                                if (e.compareTo(e2)>0)
                                        n=e.to;
                        }
                sb.append(n+" ");
               
                String s = rawler(start, sb);
                return s;
        }
        */
       
/*      public String calcOutput3() {
                StringBuilder sb = new StringBuilder();
                Vertex v = start;
               
                Edge e = chooseEdge(start);
                while (e==null || e.equals(stopEdge)==false) {
                        sb.append(e.to.toString()+" ");
        //              System.out.println("\t"+e.to.toString());
                        e=chooseEdge(e.to);
                }
                return sb.toString();
        }
       
        */
        
        
        /**
         * 
         * 
         * @return String made up by vertices space-separated.
         */
       
        private String calcOutput4() {
            StringBuilder sb = new StringBuilder();
            Edge e = randomPop(start);
                while (e.equals(stopEdge)==false) {
                    sb.append(e.to.toString()+" ");
                    e=randomPop(e.to);
                }
            return sb.toString();
        }
       
        /*private Edge chooseEdge2(ArrayList<Edge> s) {
                if (!currentEdges.get(s).isEmpty())
                        return currentEdges.get(s).pop();
                LinkedList<Edge> e = new LinkedList<Edge>(s);
                currentEdges.put(s, e);
                return currentEdges.get(s).pop();
                int rand = r.nextInt(s.size()-1);
                ArrayList<Edge> a = s;
                Vertex v = a.get(rand).to;
                return v;
        }
       
*/
        
        /**
         * pick an random Edge from the hashMap 
         * 
         * @param s the Vertex in the graph from witch a edge shall be choosen
         * @return
         */
        private Edge randomPop(Vertex s) {
            int rand = r.nextInt(graph.get(s).size())-1;
            if (rand<0)
                rand=0;
            return graph.get(s).get(rand);
        }
/*     
        private Edge chooseEdge3(Vertex s) {
                r.nextInt();
                if (currentEdges.get(s)!=null) {
                        if (currentEdges.get(s).peek()!=null)
                                return currentEdges.get(s).pop();
                }
                LinkedList<Edge> e = new LinkedList<Edge>(graph.get(s));
                currentEdges.put(s, e);
                return currentEdges.get(s).pop();
        }
       
        private String rawler2(Vertex n, StringBuilder sb) {
               
                return sb.toString();
        }
 
        private String rawler(Vertex n, StringBuilder sb) {
                if (graph.get(n).contains(stopEdge))
                        return sb.toString();
                Collections.sort(graph.get(n));
                Vertex next = graph.get(n).get(graph.get(n).size()/2).to;
                graph.get(n).get(graph.get(n).size()/2).decrease();
                sb.append(next.toString()+" ");
                return rawler(next, sb);       
        }
       
        public String calcOutput() {
                String s = "";
                int bestStart = Integer.MIN_VALUE;
                Vertex next=start;
                for (int i = 0; i< graph.get(start).size() ; i++) {
                        if (bestStart < graph.get(start).get(i).getCount()) {
                                bestStart = graph.get(start).get(i).getCount();
                                graph.get(start).get(i).decrease();
                                next=graph.get(start).get(i).to;
                        }
 
                }
                s = s+" "+next.toString();
 
                bestStart = Integer.MIN_VALUE;
                // med logiken att ju kortare FiaBot är ju mindre stupid kommer han låta...
                        for (int i = 0; i< graph.get(next).size(); i++) {
                                if (bestStart<graph.get(next).get(i).getCount()) {
                                        bestStart = graph.get(next).get(i).getCount();
                                        graph.get(next).get(i).decrease();
                                        next=graph.get(next).get(i).to;
                                }
                        if (graph.get(next).contains(stopEdge)|| graph.get(next).isEmpty())
                                        break;
                        }
                System.out.println("hej");
                s = s+" "+next.toString();
 
               
                return s;
               
        }
        */

        
        /**
         * internal method for overwiew and de-bug. prints all vertecies and their list of edges
         *
         */
        private void printMap() {
            Iterator<Map.Entry<Vertex, ArrayList<Edge>>> it = graph.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Vertex, ArrayList<Edge>> pair = (Map.Entry<Vertex, ArrayList<Edge>>)it.next();
                System.out.println(pair.getKey()+" "+pair.getValue().toString());
            }
            System.out.println("\n");
        }
        
        /**
         * Method for setting up the bot with vertecis and edges
         * Uses Setup.class
         * @param s
         */
        protected void setup(ArrayList<String> s) {
            for (String sent : s) 
	            readInput(sent);
        }
 
}
