package factory;

import commands.Strategy;
import exceptions.*;
import model.Model;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Factory {
    private Model model;
    private Properties config;
    public Factory(Model model) {
        this.model = model;
        InputStream in = Factory.class.getResourceAsStream("/config.properties");
        config = new Properties();
        try {
            config.load(in);
        } catch (IOException e) {
            throw new IOExc();
        }
    }

    public Strategy createCommand(String str) {
        String[] command_parts = str.split(" ");
        if (command_parts.length == 0) {
            throw new BadCommand();
        }
        String classname = config.getProperty(command_parts[0]);
        if (classname == null) {
            throw new BadCommand();
        }
        Class<? extends Strategy> command_class;
        try {
            command_class = (Class<? extends Strategy>) Class.forName(classname);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFound();
        }
        Constructor<Strategy> constructor;
        try {
            constructor = (Constructor<Strategy>) command_class.getConstructor(Object[].class);
        } catch (NoSuchMethodException e) {
            throw new ConstructorNotFound();
        }
        Object[] objects = new Object[command_parts.length];
        objects[0] = model;
        for (int i = 1; i < command_parts.length; ++i) {
            objects[i] = command_parts[i];
        }
        try {
            return constructor.newInstance((Object) objects);
        } catch (InstantiationException e) {
            throw new Instantiation();
        } catch (IllegalAccessException e) {
            throw new IllegalAccess();
        } catch (InvocationTargetException e) {
            throw new InvocationTarget();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
