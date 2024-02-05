package com.loop.utilities.utilities;

public class TextExcel {
    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils ("C:/Users/Dina/IdeaProjects/Cucumber-project-b2/src/test/resources/Excel.xlsx","Sheet1");
        System.out.println(excelUtils.getCellData(3,3));
    }
}
