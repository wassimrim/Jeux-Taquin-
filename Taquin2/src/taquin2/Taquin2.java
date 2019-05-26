/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin2;

import BranchAndBound.*;

/**
 *
 * @author wassim-rim
 */
public class Taquin2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //int tab1[][] ={{2,8,3},{1,6,4},{7,5,0}};
        int tab1[][] ={{2,8,3},{1,6,4},{7,0,5}};
            //  int tab1[][] ={{4,8,3},{1,6,1},{7,0,5}}; this also don't work
        
        
        int tab2[][] ={{1,2,3},{8,0,4},{7,6,5}};
       Noeud n1 = new Noeud(tab1);
       n1.setHeuristique2(tab2);
       n1.setCout(0);
       Noeud n2 = new Noeud(tab2);
       n2.setHeuristique2(tab2);
        
      BAB bfs = new BAB(n1,n2);
        bfs.initialisation();
        bfs.traitementBAB();
    }
    
}
