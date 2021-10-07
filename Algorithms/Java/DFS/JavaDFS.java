import java.util.ArrayList;
import java.util.List;
 
class Vertex{
  char value;
  List<Vertex> adVertex;
  boolean visited;
 
  Vertex(char value){
    this.value =value;
    adVertex = new ArrayList<>();
    visited = false;
  }
 
  public void addAdVertex(Vertex v){
    //Bidirectional edge (this <---> v)
    this.adVertex.add(v);
    v.adVertex.add(this);
  }
 
  public void display(){
    System.out.print(this.value+" ");
  }
}
 
class DFS{
  public void solve(Vertex root){
    
    root.visited = true;
    root.display();
 
    for(Vertex v: root.adVertex){
      //If unvisited go depth recursively
      //otherwise move to next adjacent vertex
      if(!v.visited){
        solve(v);
      }   
    }
  }
}
 
class JavaDFS{
  public static void main(String[] args) {
    DFS dfs = new DFS();

    Vertex vertexA = new Vertex('A');
    Vertex vertexB = new Vertex('B');
    Vertex vertexC = new Vertex('C');
    Vertex vertexD = new Vertex('D');
    Vertex vertexE = new Vertex('E');

    vertexA.addAdVertex(vertexB);
    vertexA.addAdVertex(vertexD);
    vertexB.addAdVertex(vertexC);
    vertexD.addAdVertex(vertexE);

    dfs.solve(vertexA);
  }
}