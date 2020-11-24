package com.tw;

public class MultiplicationTable {
    //P: 1 min D: 5 min C: Forget if isValid return false should directly return null A: Need to check return null once isValid is ensure to be false, or else will have have error
    public String create(int startNumber, int endNumber) {
        boolean isValid = isValid(startNumber, endNumber);
        if (isValid) {
            String multiplicationTable = generateMultiplicationTable(startNumber, endNumber);
            return multiplicationTable;
        }
        return null;
    }

    //P: 1 min D: 5 min C: \n is not suitable A: Change to \r\n
    private String generateMultiplicationTable(int startNumber, int endNumber) {
        //logic
        String multiplicationLine = "";
        for (int row = startNumber; row <= endNumber; row++) {
            multiplicationLine += generateMultiplicationLine(startNumber, row);
            if (row < endNumber) {
                multiplicationLine = multiplicationLine.concat("\r\n");
            }
        }
        return multiplicationLine;
    }

    //P: 1 min D: 5 min C: The space between each expression is two spaces A: Change one space to two spaces to separate the expression
    private String generateMultiplicationLine(int startNumber, int row) {
        String multiplicationExpression = "";
        for (int multiplier = startNumber; multiplier <= row; multiplier++) {
            multiplicationExpression += generateMultiplicationExpression(multiplier, row);
            if (multiplier < row) {
                multiplicationExpression = multiplicationExpression.concat("  ");
            }
        }
        return multiplicationExpression;
    }

    private String generateMultiplicationExpression(int multiplier, int row) {
        String multiplicationExpression = "";
        multiplicationExpression = multiplicationExpression + multiplier + "*" + row + "=" + (multiplier * row);
        return multiplicationExpression;
    }

    //P: 1 min D: 1 min C: Check if all the input parameter is correct A: Update the wrong input parameter
    private boolean isValid(int startNumber, int endNumber) {
        boolean isStartNumberInRange = isNumberInRange(startNumber);
        boolean isEndNumberInRange = isNumberInRange(endNumber);
        boolean isEndBiggerThanStart = isEndBiggerThanStart(startNumber, endNumber);
        return isStartNumberInRange && isEndNumberInRange && isEndBiggerThanStart;
    }

    //P: 1 min D: 1 min C: Not familiar with simplifying the if else logic A: try to use suggested method by IntelliJ
    private boolean isEndBiggerThanStart(int startNumber, int endNumber) {
        return startNumber <= endNumber;
    }

    //P: 1 min D: 1 min C: More familiar with the logic now
    private boolean isNumberInRange(int number) {
        return number < 1000 && number > 1;
    }
}
