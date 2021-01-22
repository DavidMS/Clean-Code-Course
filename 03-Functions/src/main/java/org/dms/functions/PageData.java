package org.dms.functions;

class PageData {
    private WikiPage wikiPage;
    private String content;
    private String html;

    public WikiPage getWikiPage() {
        return wikiPage;
    }

    public boolean hasAttribute(String name) {
        return true;
    }

    public String getContent() {
        return "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml() {
        return html;
    }
}
