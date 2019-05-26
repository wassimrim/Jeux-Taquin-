/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin;


import bestfirstsearch.BFS;
import bestfirstsearch.Noeud;
import java.util.Vector;

/**
 *
 * @author wassim-rim
 */
public class Taquin {
    

   
   
   
   

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //int tab1[][] ={{2,8,3},{1,6,4},{7,5,0}};
        int tab1[][] ={{2,8,3},{1,6,4},{7,0,5}};
      //  int tab1[][] ={{4,8,3},{1,6,1},{7,0,5}}; /*boucle infinie*/
        
        
        int tab2[][] ={{1,2,3},{8,0,4},{7,6,5}};
       Noeud n1 = new Noeud(tab1);
       n1.setHeuristique2(tab2);
       
       Noeud n2 = new Noeud(tab2);
       n2.setHeuristique2(tab2);
        
      BFS bfs = new BFS(n1,n2);
        bfs.initialisation();
        bfs.traitementBfs();
          
}
    
}
