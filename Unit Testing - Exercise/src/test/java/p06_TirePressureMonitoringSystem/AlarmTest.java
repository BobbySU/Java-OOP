package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    private static final double LOW_PRESSURE=12;
    private static final double HIGH_PRESSURE=25;
    private static final double NORMAL_PRESSURE=20;

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void initialiseObjects(){
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmTurnOnForLowPressure(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmTurnOnForHighPressure(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmTurnOnForNormalPressure(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}