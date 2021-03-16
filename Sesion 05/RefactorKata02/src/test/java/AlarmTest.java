

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlarmTest {

    private final class MockSensor implements ISensor {

        public double sensorValue = 0.0;

        @Override
        public double popNextPressurePsiValue() {
            return sensorValue;
        }
    }

    private MockSensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
        sensor = new MockSensor();
        alarm = new Alarm(sensor);
    }

    @Test
    public void testCheckAlarmOn() {

        sensor.sensorValue = 15.0;
        alarm.check();

        boolean result = alarm.isAlarmOn();


        assertTrue(result);
    }

    @Test
    public void testCheckAlarmOff() {
        sensor.sensorValue = 20.0;
        alarm.check();

        boolean result = alarm.isAlarmOn();


        assertFalse(result);

    }
}
