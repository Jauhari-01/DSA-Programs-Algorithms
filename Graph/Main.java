import java.util.*;
class Graph{

    //we will use map here
    Map<Integer,ArrayList<Integer>> adj;
    Graph(){
        adj = new HashMap<>();
    }

    //function for adding elements
    public void addEdge(int u,int v,boolean direction){
        //direction == true -> directed graph
        //direction == false -> undirected graph
        
        //if graph is directed create edge from u to v
        if(adj.containsKey(u)){
            ArrayList<Integer> temp = adj.get(u);
            temp.add(v);
            adj.put(u,temp);
        }else{
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            adj.put(u,temp);
        }

        //now if we are having undirected graph means 
        //we need to add edge from v to u also
        if(direction==false){
            if(adj.containsKey(v)){
                ArrayList<Integer> temp = adj.get(v);
                temp.add(u);
                adj.put(v,temp);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(u);
                adj.put(v,temp);
            }
        }
        
    }

    public void printAdj(){
        for(int i : this.adj.keySet()){
            System.out.print(i+"->");
            for(int j : this.adj.get(i)){
                System.out.print(j+" , ");
            }
            System.out.print("\n");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        int n = 4;
        int edge = 5;
        Scanner in = new Scanner(System.in);
        Graph g = new Graph();
        for(int i=0 ; i<edge; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            g.addEdge(u,v,false);
        }

        g.printAdj();
    }
}