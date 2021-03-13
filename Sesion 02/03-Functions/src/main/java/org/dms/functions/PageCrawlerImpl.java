package org.dms.functions;

class PageCrawlerImpl implements PageCrawler {

    @Override
    public WikiPagePath getFullPath(WikiPage wikiPage) {
        return new WikiPagePath();
    }

    public static WikiPage getInheritedPage(SuiteResponder name, WikiPage wikiPage) {
        return new WikiPage();
    }
}