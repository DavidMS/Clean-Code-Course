public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;



    ISensor sensor;

    public Alarm(ISensor sensor) {
        this.sensor = sensor;
    }

    public Alarm() {
        new Alarm(new Sensor());
    }

    boolean alarmOn = false;

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
