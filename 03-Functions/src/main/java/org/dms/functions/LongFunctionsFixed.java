package org.dms.functions;

public class LongFunctionsFixed {

    public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) throws Exception {
        boolean isTestPage = pageData.hasAttribute("Test");
        if(isTestPage) {
            WikiPage testPage = pageData.getWikiPage();
            StringBuffer newPageContent = new StringBuffer();
            // TODO: Implement this function
            includeSetupPages(testPage, newPageContent, isSuite);
            newPageContent.append(pageData.getContent());
            // TODO: Implement this function
            includeTeardownPages(testPage, newPageContent, isSuite);
            pageData.setContent(newPageContent.toString());
        }
        return pageData.getHtml();
    }

    private static void includeSetupPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {
        // TODO: Implement this!
    }

    private static void includeTeardownPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {
        // TODO: Implement this!
    }

    // TODO: Mover esto a otro sitio
    public static String renderPageWithSetupsAndTeardownsCompact(PageData pageData, boolean isSuite) throws Exception {
        // TODO: Implement this function
        if(isTestPage(pageData)) {
            // TODO: Implement this function
            // TODO: Question: Difference between method and function
            includeSetupAndTeardownPages(pageData, isSuite);
        }
        return pageData.getHtml();
    }

    public static boolean isTestPage(PageData pageData) {
        return true;
    }

    private static void includeSetupAndTeardownPages(PageData pageData, boolean isSuite) {
        // TODO: Implement this!!
    }
}
