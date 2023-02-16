import java.util.ArrayList;
import java.util.List;

public class DisjointSet{
    List<Integer> rank;
    List<Integer> parent;
    List<Integer> size;
    public DisjointSet(int n){
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i=0 ; i<=n ; i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    //now getParent function 
    //with path compression
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        //for compressing the path
        int ulP = findUPar(parent.get(node));
        parent.set(node,ulP);

        return parent.get(node);
    }

    //union by rank
    public void unionByRank(int u,int v){
        int ulP_u = findUPar(u);
        int ulP_v = findUPar(v);
        if(ulP_u == ulP_v){
            return;
        }

        //if note we will add according to the rank
        if(rank.get(ulP_u) < rank.get(ulP_v)){
            parent.set(ulP_u,ulP_v);
        }else if(rank.get(ulP_v) < rank.get(ulP_u)){
            parent.set(ulP_v,ulP_u);
        }else{
            parent.set(ulP_v,ulP_u);
            int rankU = rank.get(ulP_u);
            rank.set(ulP_u,rankU+1);
        } 
    }

    //union by size
    public void unionBySize(int u,int v){
        int ulP_u = findUPar(u);
        int ulP_v = findUPar(v);
        if(ulP_u == ulP_v){
            return;
        }

        //if note we will add according to the rank
        if(size.get(ulP_u) < size.get(ulP_v)){
            parent.set(ulP_u,ulP_v);
            size.set(ulP_v,size.get(ulP_u)+size.get(ulP_v));
        }else{
            parent.set(ulP_v,ulP_u);
            size.set(ulP_u,size.get(ulP_u)+size.get(ulP_v));
        } 
    }
}