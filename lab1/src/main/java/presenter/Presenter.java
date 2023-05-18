package presenter;

import exceptions.*;
import factory.Factory;
import model.Model;
import view.View;

public class Presenter implements IViewListener {
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
            System.out.println("Command not found\n");
        }
        catch (ConstructorNotFound e) {
            System.out.println("Constructor not found\n");
        }
        catch (Instantiation e) {
            System.out.println("Instantiation error\n");
        }
        catch (IllegalAccess e) {
            System.out.println("Illegal access to data\n");
        }
        catch (InvocationTarget e) {
            System.out.println("Bad command. Wrong number of arguments. Try again\n");
        }
        catch (BadCommand e) {
            System.out.println("Bad command. Try again\n");
        }
        catch (NoStackElement e) {
            System.out.println("Command can't find required number of elements in stack\n");
        }
        catch (NoMapKey e) {
            System.out.println("Parameter isn't defined\n");
        }
        catch (SqrtNegativeNumber e) {
            System.out.println("Sqrt of negative number isn't allowed\n");
        }
        catch (Exception e) {
            System.out.println("Another exception\n");
        }
    }
}
