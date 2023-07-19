package com.company.UnitTesting.exercise.p06_TirePressureMonitoringSystem;

public class AlarmTest {

    private static final Double LOWER_PRESSURE=12.0;
    private static final Double HIGHER_PRESSURE=22.0;
    private static final Double NORMAL_PRESSURE=18.0;

    @Test
    public void testIfTheAlarmTurnsOnWithLowerPressure(){
        Sensor fakeSensor= Mockito.mock(Sensor.class);
        when(fakeSensor.popNextPressurePsiValue()).thenReturn(LOWER_PRESSURE);
        Alarm alarm=new Alarm(fakeSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testIfTheAlarmTurnsOnWithHigherPressure(){
        Sensor fakeSensor= Mockito.mock(Sensor.class);
        when(fakeSensor.popNextPressurePsiValue()).thenReturn(HIGHER_PRESSURE);
        Alarm alarm=new Alarm(fakeSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testIfTheAlarmTurnsOffWithPressureBetweenTheBorders(){
        Sensor fakeSensor= Mockito.mock(Sensor.class);
        when(fakeSensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        Alarm alarm=new Alarm(fakeSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}