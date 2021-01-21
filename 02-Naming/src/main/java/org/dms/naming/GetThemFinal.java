package org.dms.naming;

import java.util.ArrayList;
import java.util.List;

public class GetThemFinal {

    private static List<Cell> getFlaggedCells(List<Cell> gameBoard) {
        List<Cell> flaggedCells = new ArrayList<>();
        for(Cell cell: gameBoard) {
            if(cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}
