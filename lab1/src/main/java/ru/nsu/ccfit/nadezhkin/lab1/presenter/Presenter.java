package ru.nsu.ccfit.nadezhkin.lab1.presenter;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.*;
import ru.nsu.ccfit.nadezhkin.lab1.factory.Factory;
import ru.nsu.ccfit.nadezhkin.lab1.model.Model;
import ru.nsu.ccfit.nadezhkin.lab1.view.View;

public class Presenter implements IViewListener {
    private final String command_not_found = "Command not found\n";
    private final String constructor_not_found = "Constructor not found\n";
    private final String instantiation_error = "Instantiation error\n";
    private final String illegal_access_to_data = "Illegal access to data\n";
    private final String bad_command_args = "Bad command. Wrong number of arguments. Try again\n";
    private final String bad_command = "Bad command. Try again\n";
    private final String required_number = "Command can't find required number of elements in stack\n";
    private final String parameter = "Parameter isn't defined\n";
    private final String sqrt_of_negative = "Sqrt of negative number isn't allowed\n";
    private final String another_exception = "Another exception\n";

    private Model model;
    private View view;
    private Factory factory;
    public Presenter() {
        model = new Model();
        view = new View(this);
        factory = new Factory(model);
    }
    public void run() {
        while (true)
            view.ask_str();
    }
    @Override
    public void get_str(String str) {

        try {
            factory.createCommand(str).exec();
        }
        catch (ClassNotFound e) {
            System.out.println(command_not_found);
        }
        catch (ConstructorNotFound e) {
            System.out.println(constructor_not_found);
        }
        catch (Instantiation e) {
            System.out.println(instantiation_error);
        }
        catch (IllegalAccess e) {
            System.out.println(illegal_access_to_data);
        }
        catch (InvocationTarget e) {
            System.out.println(bad_command_args);
        }
        catch (BadCommand e) {
            System.out.println(bad_command);
        }
        catch (NoStackElement e) {
            System.out.println(required_number);
        }
        catch (NoMapKey e) {
            System.out.println(parameter);
        }
        catch (SqrtNegativeNumber e) {
            System.out.println(sqrt_of_negative);
        }
        catch (Exception e) {
            System.out.println(another_exception);
        }
    }
}
