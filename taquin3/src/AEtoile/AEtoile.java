/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEtoile;

import java.util.Vector;

/**
 *
 * @author wassim-rim
 */
public class AEtoile {

    private Vector<Noeud> listNoeudOuvert = new Vector<Noeud>();
    private Vector<Noeud> listNoeudFerme = new Vector<Noeud>();
    private Vector<Noeud> listNoeudFils = new Vector<Noeud>();
    private Noeud noeudinitial;
    private Noeud noeudfinal;

    public AEtoile(Noeud noeudinitial, Noeud noeudfinal) {
        this.noeudinitial = noeudinitial;
        this.noeudfinal = noeudfinal;
    }

    public Vector<Noeud> getListNoeudOuvert() {
        return listNoeudOuvert;
    }

    public void setListNoeudOuvert(Vector<Noeud> listNoeudOuvert) {
        this.listNoeudOuvert = listNoeudOuvert;
    }

    public Vector<Noeud> getListNoeudFerme() {
        return listNoeudFerme;
    }

    public void setListNoeudFerme(Vector<Noeud> listNoeudFerme) {
        this.listNoeudFerme = listNoeudFerme;
    }

    public Vector<Noeud> getListNoeudFils() {
        return listNoeudFils;
    }

    public void setListNoeudFils(Vector<Noeud> listNoeudFils) {
        this.listNoeudFils = listNoeudFils;
    }

    public Noeud getNoeudinitial() {
        return noeudinitial;
    }

    public void setNoeudinitial(Noeud noeudinitial) {
        this.noeudinitial = noeudinitial;
    }

    public Noeud getNoeudfinal() {
        return noeudfinal;
    }

    public void setNoeudfinal(Noeud noeudfinal) {
        this.noeudfinal = noeudfinal;
    }

    public void initialisation() {
        this.listNoeudOuvert.addElement(noeudinitial);
    }

    public void traitementBAB() {

        int x = 0, y = 0;
        Noeud noeud1 = this.listNoeudOuvert.elementAt(0);

        if ((noeud1.getHeuristique() == 0) || this.listNoeudOuvert.isEmpty()) {
            toStringOuvert();//affichage liste ouvert
            this.listNoeudOuvert.remove(0);
            toStringFerme();//affichage liste fermé
            this.listNoeudFerme.add(noeud1);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (noeud1.getTab()[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }
            int localtab[][] = remplissageTableau(noeud1.getTab());
            int localtab1[][] = remplissageTableau(noeud1.getTab());
            int localtab2[][] = remplissageTableau(noeud1.getTab());
            int localtab3[][] = remplissageTableau(noeud1.getTab());

            if (x - 1 >= 0) {

                int tabb1[][] = permuteHaut(localtab, x, y);
                Noeud nouedh1 = new Noeud(tabb1);
                nouedh1.setHeuristique2(noeudfinal.getTab());

                nouedh1.setCoutSomme(noeud1);// new line
                
                nouedh1.setHplusCSomme();

                if ((notCycleOuvert(nouedh1)) && (notCycleFermee(nouedh1))) {
                    insertionListOuvert(nouedh1);
                } else if (!(notCycleOuvert(nouedh1))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh1))) {
                    swapNoeudFerme(noeud1);
                }

            }

            if (x + 1 <= 2) {

                int tabb2[][] = permuteBas(localtab1, x, y);

                Noeud nouedh2 = new Noeud(tabb2);
                nouedh2.setHeuristique2(noeudfinal.getTab());

                nouedh2.setCoutSomme(noeud1);// new line
                nouedh2.setHplusCSomme();

                if ((notCycleOuvert(nouedh2)) && (notCycleFermee(nouedh2))) {
                    insertionListOuvert(nouedh2);
                } else if (!(notCycleOuvert(nouedh2))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh2))) {
                    swapNoeudFerme(noeud1);
                }

            }
            if (y - 1 >= 0) {
                int tabb3[][] = permuteGauche(localtab2, x, y);
                Noeud nouedh3 = new Noeud(tabb3);
                nouedh3.setHeuristique2(noeudfinal.getTab());

                nouedh3.setCoutSomme(noeud1);// new line
                nouedh3.setHplusCSomme();

                if ((notCycleOuvert(nouedh3)) && (notCycleFermee(nouedh3))) {
                    insertionListOuvert(nouedh3);
                } else if (!(notCycleOuvert(nouedh3))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh3))) {
                    swapNoeudFerme(noeud1);
                }
            }
            if (y + 1 <= 2) {
                int tabb4[][] = permuteDroit(localtab3, x, y);
                Noeud nouedh4 = new Noeud(tabb4);
                nouedh4.setHeuristique2(noeudfinal.getTab());

                nouedh4.setCoutSomme(noeud1);// new line
                nouedh4.setHplusCSomme();

                if ((notCycleOuvert(nouedh4)) && (notCycleFermee(nouedh4))) {
                    insertionListOuvert(nouedh4);
                } else if (!(notCycleOuvert(nouedh4))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh4))) {
                    swapNoeudFerme(noeud1);
                }
            }

        } else {
            toStringOuvert();//affichage liste ouvert
            this.listNoeudOuvert.remove(0);
            toStringFerme();//affichage liste ouvert
            this.listNoeudFerme.add(noeud1);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (noeud1.getTab()[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }
            int localtab[][] = remplissageTableau(noeud1.getTab());
            int localtab1[][] = remplissageTableau(noeud1.getTab());
            int localtab2[][] = remplissageTableau(noeud1.getTab());
            int localtab3[][] = remplissageTableau(noeud1.getTab());

            if (x - 1 >= 0) {
                int tabb1[][] = permuteHaut(localtab, x, y);
                Noeud nouedh1 = new Noeud(tabb1);
                nouedh1.setHeuristique2(noeudfinal.getTab());

                nouedh1.setCoutSomme(noeud1);// new line
                nouedh1.setHplusCSomme();

                if ((notCycleOuvert(nouedh1)) && (notCycleFermee(nouedh1))) {
                    insertionListOuvert(nouedh1);
                } else if (!(notCycleOuvert(nouedh1))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh1))) {
                    swapNoeudFerme(noeud1);
                }

            }

            if (x + 1 <= 2) {
                int tabb2[][] = permuteBas(localtab1, x, y);
                Noeud nouedh2 = new Noeud(tabb2);
                nouedh2.setHeuristique2(noeudfinal.getTab());
                nouedh2.setCoutSomme(noeud1);// new line
                nouedh2.setHplusCSomme();

                if ((notCycleOuvert(nouedh2)) && (notCycleFermee(nouedh2))) {
                    insertionListOuvert(nouedh2);
                } else if (!(notCycleOuvert(nouedh2))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh2))) {
                    swapNoeudFerme(noeud1);
                }

            }
            if (y - 1 >= 0) {
                int tabb3[][] = permuteGauche(localtab2, x, y);
                Noeud nouedh3 = new Noeud(tabb3);
                nouedh3.setHeuristique2(noeudfinal.getTab());
                nouedh3.setCoutSomme(noeud1);// new line
                nouedh3.setHplusCSomme();
                if ((notCycleOuvert(nouedh3)) && (notCycleFermee(nouedh3))) {
                    insertionListOuvert(nouedh3);
                } else if (!(notCycleOuvert(nouedh3))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh3))) {
                    swapNoeudFerme(noeud1);
                }
            }
            if (y + 1 <= 2) {
                int tabb4[][] = permuteDroit(localtab3, x, y);
                Noeud nouedh4 = new Noeud(tabb4);
                nouedh4.setHeuristique2(noeudfinal.getTab());
                nouedh4.setCoutSomme(noeud1);// new line
                nouedh4.setHplusCSomme();
                if ((notCycleOuvert(nouedh4)) && (notCycleFermee(nouedh4))) {
                    insertionListOuvert(nouedh4);
                } else if (!(notCycleOuvert(nouedh4))) {
                    swapNoeudOuvert(noeud1);
                } else if (!(notCycleFermee(nouedh4))) {
                    swapNoeudFerme(noeud1);
                }
            }
            traitementBAB();
        }

    }

    public void toStringOuvert() {

        System.out.print("Ouvert: { ");
        for (Noeud n : this.getListNoeudOuvert()) {
            System.out.print(n.toString());
        }
        System.out.println(" } ");
        System.out.println("");

    }

    public void toStringFerme() {

        System.out.print("Ferme:  {");
        for (Noeud n : this.getListNoeudFerme()) {
            System.out.print(n.toString());
        }
        System.out.println(" } ");
        System.out.println("*********************");

    }

    public int[][] permuteHaut(int tab[][], int x, int y) {
        int val;
        val = tab[x - 1][y];
        tab[x - 1][y] = tab[x][y];
        tab[x][y] = val;
        return tab;
    }

    public int[][] permuteBas(int tab[][], int x, int y) {
        int val;
        val = tab[x + 1][y];
        tab[x + 1][y] = tab[x][y];
        tab[x][y] = val;
        return tab;
    }

    public int[][] permuteGauche(int tab[][], int x, int y) {
        int val;
        val = tab[x][y - 1];
        tab[x][y - 1] = tab[x][y];
        tab[x][y] = val;
        return tab;
    }

    public int[][] permuteDroit(int tab[][], int x, int y) {
        int val;
        val = tab[x][y + 1];
        tab[x][y + 1] = tab[x][y];
        tab[x][y] = val;
        return tab;
    }

    public void insertionListOuvert(Noeud noeud) {

        int i, size;
        size = this.getListNoeudOuvert().size();
        if (this.getListNoeudOuvert().isEmpty()) {
            this.listNoeudOuvert.add(noeud);
        } else {

            OUTER:
            for (i = 0; i < size; i++) {
                if (noeud.getHpc()< this.getListNoeudOuvert().elementAt(i).getHpc()) {
                    this.listNoeudOuvert.add(i, noeud);
                    break OUTER;
                } else if ((noeud.getHpc()== this.getListNoeudOuvert().elementAt(i).getHpc()) && (noeud.getHeuristique() < this.getListNoeudOuvert().elementAt(i).getHeuristique())) {
                    this.listNoeudOuvert.add(i, noeud);
                    break OUTER;
                } 
                else if ((noeud.getHpc()> this.getListNoeudOuvert().elementAt(i).getHpc()) && (this.getListNoeudOuvert().size() - 1 == i)) {
                    this.listNoeudOuvert.add(noeud);
                    break OUTER;
                } else if ((noeud.getHpc()== this.getListNoeudOuvert().elementAt(i).getHpc()) && (noeud.getHeuristique() >= this.getListNoeudOuvert().elementAt(i).getHeuristique()) && (this.getListNoeudOuvert().size() - 1 == i)) {
                    this.listNoeudOuvert.add(noeud);
                    break OUTER;
                } else if ((noeud.getHpc()>= this.getListNoeudOuvert().elementAt(i).getHpc()) && (this.getListNoeudOuvert().size() - 2 >= i)) {
                    if ((noeud.getHpc()> this.getListNoeudOuvert().elementAt(i).getHpc()) && (noeud.getHpc()< this.getListNoeudOuvert().elementAt(i + 1).getCout())) {
                        this.listNoeudOuvert.add(i + 1, noeud);
                        break OUTER;
                    } else if ((noeud.getHpc()== this.getListNoeudOuvert().elementAt(i).getHpc()) && (noeud.getHeuristique() >= this.getListNoeudOuvert().elementAt(i).getHeuristique()) && (noeud.getHpc()< this.getListNoeudOuvert().elementAt(i + 1).getHpc())) {
                        this.listNoeudOuvert.add(i + 1, noeud);
                        break OUTER;
                    } else if ((noeud.getHpc()== this.getListNoeudOuvert().elementAt(i).getHpc()) && (noeud.getHeuristique() >= this.getListNoeudOuvert().elementAt(i).getHeuristique()) && (noeud.getHpc()== this.getListNoeudOuvert().elementAt(i + 1).getHpc()) && (noeud.getHeuristique() < this.getListNoeudOuvert().elementAt(i + 1).getHeuristique())) {
                        this.listNoeudOuvert.add(i + 1, noeud);
                        break OUTER;
                    }
                }
            }

        }

    }

    public int[][] remplissageTableau(int[][] tab) {
        int tab1[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(tab[i], 0, tab1[i], 0, 3);
        }
        return tab1;
    }

    public boolean notCycleOuvert(Noeud noeud) {

        for (Noeud n : this.getListNoeudOuvert()) {
            if (n.getHeuristique() == noeud.getHeuristique()) {
                if ((java.util.Arrays.deepEquals(n.getTab(), noeud.getTab()))) {
                    //   System.out.println(" O : not inserted in O : " + n.toString());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean notCycleFermee(Noeud noeud) {

        for (Noeud n : this.getListNoeudFerme()) {
            if (n.getHeuristique() == noeud.getHeuristique()) {
                if (java.util.Arrays.deepEquals(n.getTab(), noeud.getTab())) {
                    //  System.out.println(" F : not inserted in O : " + n.toString());
                    return false;

                }
            }

        }
        return true;

    }

    public void swapNoeudOuvert(Noeud noeud) {
        int i = 0;
        OUTER:
        for (Noeud n : this.getListNoeudOuvert()) {
            if (n.getHeuristique() == noeud.getHeuristique()) {
                if ((java.util.Arrays.deepEquals(n.getTab(), noeud.getTab())) && (noeud.getCout() < n.getCout())) {
                    this.listNoeudOuvert.remove(i);
                    insertionListOuvert(noeud);
                    break OUTER;
                }
            }
            ++i;
        }
    }

    public void swapNoeudFerme(Noeud noeud) {
        int i = 0;
        OUTER:
        for (Noeud n : this.getListNoeudFerme()) {
            if (n.getHeuristique() == noeud.getHeuristique()) {
                if ((java.util.Arrays.deepEquals(n.getTab(), noeud.getTab())) && (noeud.getCout() < n.getCout())) {
                    this.listNoeudFerme.remove(i);
                    insertionListOuvert(noeud);
                    break OUTER;
                }
            }
            ++i;
        }
    }

}
