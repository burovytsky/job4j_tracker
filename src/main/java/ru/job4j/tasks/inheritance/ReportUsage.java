package ru.job4j.tasks.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        String text = textReport.generate("Reports name", "Reports body");
        System.out.println(text);
        HtmlReport htmlReport = new HtmlReport();
        String htmlText = htmlReport.generate("HTMLReports name", "HTMLReports body");
        System.out.println(htmlText);
        JSONReport jsonReport = new JSONReport();
        String jsonText = jsonReport.generate("JSONReports name", "JSONReports body");
        System.out.println(jsonText);
    }
}
