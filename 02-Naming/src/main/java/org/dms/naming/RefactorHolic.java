package org.dms.naming;

public class RefactorHolic {

    // Crear clase para agrupar los 3 valores
    private String calculateVerb(int count) {
        if(count == 1) {
            return "is";
        } else {
            return "are";
        }
    }

    private String calculatePluralModifier(int count) {
        return count == 1 ? "" : "s";
    }

    private String parseGuessNumber(int count) {
        return count == 0 ? "no" : Integer.toString(count);
    }

    public void make(char candidate, int count) {
        String guessMessage = String.format("There %s %s %s%s", calculateVerb(count), calculateNumber(count), candidate, calculatePluralModifier(count));
        System.out.println(guessMessage);
    }

}
