package org.dms.naming;

import java.util.ArrayList;
import java.util.List;

public class GetThemInitial {

    int d;

    /**
     * PREGUNTAS:
     * 1. ¿Qué contiene theList?
     * 2. ¿Qué significado tiene el subíndice 0 de un elemento theList?
     * 3. ¿Qué importancia tiene el valor 4?
     * 4. ¿Cómo se usa la lista devuelta?
     */
    private static List<int[]> getThem(List<int[]> theList) {
        List<int[]> list1 = new ArrayList<int[]>();
        for(int[] x : theList)
            if(x[0] == 4)
                list1.add(x);
            return list1;
    }

    private static final int STATUS_VALUE = 0;
    private static final int FLAGGED = 4;

    private static List<int[]> getFlaggedCells(List<int[]> gameBoard) {
        List<Cell> flaggedCells = new ArrayList<>();
        for(int[] cell: gameBoard) {
            if(cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}