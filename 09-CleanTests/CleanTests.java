public class CleanTests {

    // CLEAN TESTS

    public void testGetPageHieratchyAsXml() throws Exception
    {
        crawler.addPage(root, PathParser.parse("PageOne"));
        crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
        crawler.addPage(root, PathParser.parse("PageTwo"));
        request.setResource("root");
        request.addInput("type", "pages");
        Responder responder = new SerializedPageResponder();
        SimpleResponse response =
                (SimpleResponse) responder.makeResponse(
                        new FitNesseContext(root), request);
        String xml = response.getContent();
        assertEquals("text/xml", response.getContentType());
        assertSubString("<name>PageOne</name>", xml);
        assertSubString("<name>PageTwo</name>", xml);
        assertSubString("<name>ChildOne</name>", xml);
    }
    public void testGetPageHieratchyAsXmlDoesntContainSymbolicLinks()
            throws Exception
    {
        WikiPage pageOne = crawler.addPage(root, PathParser.parse("PageOne"));
        crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
        crawler.addPage(root, PathParser.parse("PageTwo"));
        PageData data = pageOne.getData();
        WikiPageProperties properties = data.getProperties();
        WikiPageProperty symLinks = properties.set(SymbolicPage.PROPERTY_NAME);
        symLinks.set("SymPage", "PageTwo");
        pageOne.commit(data);
        request.setResource("root");
        request.addInput("type", "pages");
        Responder responder = new SerializedPageResponder();
        SimpleResponse response =
                (SimpleResponse) responder.makeResponse(
                        new FitNesseContext(root), request);
        String xml = response.getContent();
        assertEquals("text/xml", response.getContentType());
        assertSubString("<name>PageOne</name>", xml);
        assertSubString("<name>PageTwo</name>", xml);
        assertSubString("<name>ChildOne</name>", xml);
        assertNotSubString("SymPage", xml);
    }
    public void testGetDataAsHtml() throws Exception
    {
        crawler.addPage(root, PathParser.parse("TestPageOne"), "test page");
        request.setResource("TestPageOne");
        request.addInput("type", "data");
        Responder responder = new SerializedPageResponder();
        SimpleResponse response =
                (SimpleResponse) responder.makeResponse(
                        new FitNesseContext(root), request);
        String xml = response.getContent();
        assertEquals("text/xml", response.getContentType());
        assertSubString("test page", xml);
        assertSubString("<Test", xml);
    }





    public void testGetPageHierarchyAsXml() throws Exception {
        makePages("PageOne", "PageOne.ChildOne", "PageTwo");
        submitRequest("root", "type:pages");
        assertResponseIsXML();
        assertResponseContains(
                "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
        );
    }
    public void testSymbolicLinksAreNotInXmlPageHierarchy() throws Exception {
        WikiPage page = makePage("PageOne");
        makePages("PageOne.ChildOne", "PageTwo");
        addLinkTo(page, "PageTwo", "SymPage");
        submitRequest("root", "type:pages");
        assertResponseIsXML();
        assertResponseContains(
                "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
        );
        assertResponseDoesNotContain("SymPage");
    }

    public void testGetDataAsXml() throws Exception {
        makePageWithContent("TestPageOne", "test page");
        submitRequest("TestPageOne", "type:data");
        assertResponseIsXML();
        assertResponseContains("test page", "<Test");
    }


    // DOMAIN SPECIFIC TESTING LANGUAGE.
    // A DOUBLE STANDARD.

    @Test
    public void turnOnLoTempAlarmAtThreashold() throws Exception {
        hw.setTemp(WAY_TOO_COLD);
        controller.tic();
        assertTrue(hw.heaterState());
        assertTrue(hw.blowerState());
        assertFalse(hw.coolerState());
        assertFalse(hw.hiTempAlarm());
        assertTrue(hw.loTempAlarm());
    }

    @Test
    public void turnOnLoTempAlarmAtThreshold() throws Exception {
        wayTooCold();
        assertEquals("HBchL", hw.getState());
    }

    @Test
    public void turnOnCoolerAndBlowerIfTooHot() throws Exception {
        tooHot();
        assertEquals("hBChl", hw.getState());
    }
    @Test
    public void turnOnHeaterAndBlowerIfTooCold() throws Exception {
        tooCold();
        assertEquals("HBchl", hw.getState());
    }
    @Test
    public void turnOnHiTempAlarmAtThreshold() throws Exception {
        wayTooHot();
        assertEquals("hBCHl", hw.getState());
    }
    @Test
    public void turnOnLoTempAlarmAtThreshold() throws Exception {
        wayTooCold();
        assertEquals("HBchL", hw.getState());
    }

    public String getState() {
        String state = "";
        state += heater ? "H" : "h";
        state += blower ? "B" : "b";
        state += cooler ? "C" : "c";
        state += hiTempAlarm ? "H" : "h";
        state += loTempAlarm ? "L" : "l";
        return state;
    }


    // ONE ASSERT PER TEST
    public void testGetPageHierarchyAsXml() throws Exception {
        givenPages("PageOne", "PageOne.ChildOne", "PageTwo");
        whenRequestIsIssued("root", "type:pages");
        thenResponseShouldBeXML();
    }
    public void testGetPageHierarchyHasRightTags() throws Exception {
        givenPages("PageOne", "PageOne.ChildOne", "PageTwo");
        whenRequestIsIssued("root", "type:pages");
        thenResponseShouldContain(
                "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
        );
    }

    // SINGLE CONCEPT PER TEST
    /**
     * Miscellaneous tests for the addMonths() method.
     */
    public void testAddMonths() {
        SerialDate d1 = SerialDate.createInstance(31, 5, 2004);
        SerialDate d2 = SerialDate.addMonths(1, d1);
        assertEquals(30, d2.getDayOfMonth());
        assertEquals(6, d2.getMonth());
        assertEquals(2004, d2.getYYYY());
        SerialDate d3 = SerialDate.addMonths(2, d1);
        assertEquals(31, d3.getDayOfMonth());
        assertEquals(7, d3.getMonth());
        assertEquals(2004, d3.getYYYY());
        SerialDate d4 = SerialDate.addMonths(1, SerialDate.addMonths(1, d1));
        assertEquals(30, d4.getDayOfMonth());
        assertEquals(7, d4.getMonth());
        assertEquals(2004, d4.getYYYY());
    }
}