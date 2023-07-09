package com.company.reflectionAndAnnotation.barakWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Runnable {
    void run() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ExecutionControl.NotImplementedException;
}

