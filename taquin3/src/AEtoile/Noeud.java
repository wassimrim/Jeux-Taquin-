/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEtoile;

/**
 *
 * @author wassim-rim
 */
public class Noeud {

    private int[][] tab = new int[3][3];
    private int heuristique;
    private int cout;
    private int hpc;

    public int getHpc() {
        return hpc;
    }

    public void setHpc(int hpc) {
        this.hpc = hpc;
    }

    public Noeud(int[][] tab) {
        this.tab = tab;
    }

    public Noeud() {
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getHeuristique() {
        return heuristique;
    }

    // set utilisé implicitement
    public void setHeuristique1(int heuristique) {
        this.heuristique = heuristique;
    }

    public void setHeuristique2(int[][] noeudfinal) {
        int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.getTab()[i][j] != noeudfinal[i][j]) {
                    h += 1;
                }
            }
        }
        this.setHeuristique1(h);
    }

    public void setCoutSomme(Noeud noeudparent) {

        this.setCout(noeudparent.getCout()+ 1);

    }
    
     public void setHplusCSomme() {

        this.setHpc(this.getCout()+this.getHeuristique());

    }


    @Override
    public String toString() {
        return "Noeud{" + "tab=" + java.util.Arrays.deepToString(tab) + ", heuristique = " + heuristique + " cout = " + cout + " H+G = " + hpc + '}';
    }

}
