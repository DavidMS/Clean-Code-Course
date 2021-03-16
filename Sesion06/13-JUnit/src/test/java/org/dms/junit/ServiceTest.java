package org.dms.junit;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    Database databaseMock;

    @Mock
    Iterator<String> i;

    Comparable<String> c;

    @Test
    public void testQuery() {
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);
        Service t = new Service(databaseMock);
        boolean check = t.query("* from t");
        assertTrue(check);
    }

    @Test
    public void ensureMockitoReturnsTheConfiguredValue() {

        // Prepare
        when(databaseMock.getUniqueId()).thenReturn(42);
        Service service = new Service(databaseMock);

        // Act
        var result = service.toString();

        // Assert
        assertEquals(result, "Using database with id: 42");
    }

    @Test
    public void testMoreThanOneReturnValue() {
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        assertEquals("Mockito rocks", result);
    }

    @Test
    public void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> c)  {
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }


    @Test
    public void testReturnValueInDependentOnMethodParameter2(@Mock Comparable<Integer> c )  {
        when(c.compareTo(isA(Integer.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(Integer.valueOf(4)));
    }

    @Test
    public void testMockitoThrowsOne() {
        Properties properties = mock(Properties.class);

        when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("Stuff"));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> properties.get("A"));

        assertEquals("Stuff", exception.getMessage());
    }

    // demonstrates of the spy function
    @Test
    public void testMockitoThrowsTwo() {
        Properties properties = new Properties();

        Properties spyProperties = spy(properties);

        doReturn("42").when(spyProperties).get("shoeSize");

        String value = (String) spyProperties.get("shoeSize");

        assertEquals("42", value);
    }

    @Test
    public void testForIOException() throws IOException {
        // create an configure mock
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();

        // use mock
        OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);

        assertThrows(IOException.class, () -> streamWriter.close());
    }

    @Test
    public void testLinkedListSpyCorrect() {
        // Lets mock a LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);

        // this would not work as delegate it called so spy.get(0)
        // throws IndexOutOfBoundsException (list is still empty)
        // when(spy.get(0)).thenReturn("foo");

        // you have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        assertEquals("foo", spy.get(0));
    }

    @Test
    public void testVerify(@Mock Database database)  {
        // create and configure mock
        when(database.getUniqueId()).thenReturn(43);


        // call method testing on the mock with parameter 12
        database.setUniqueId(12);
        database.getUniqueId();
        database.getUniqueId();


        // now check if method testing was called with the parameter 12
        verify(database).setUniqueId(ArgumentMatchers.eq(12));

        // was the method called twice?
        verify(database, times(2)).getUniqueId();

        // other alternatives for verifiying the number of method calls for a method
        verify(database, never()).isAvailable();
        verify(database, never()).setUniqueId(13);
        verify(database, atLeastOnce()).setUniqueId(12);
        verify(database, atLeast(2)).getUniqueId();

        // more options are
        // times(numberOfTimes)
        // atMost(numberOfTimes)
        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        verifyNoMoreInteractions(database);
    }
}
