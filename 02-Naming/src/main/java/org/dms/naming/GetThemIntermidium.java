package org.dms.naming;

import java.util.ArrayList;
import java.util.List;

public class GetThemIntermidium {

    private static final int STATUS_VALUE = 0;
    private static final int FLAGGED = 4;

    private static List<int[]> getFlaggedCells(List<int[]> gameBoard) {
        List<int[]> flaggedCells = new ArrayList<>();
        for(int[] cell: gameBoard) {
            if(cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }


}
