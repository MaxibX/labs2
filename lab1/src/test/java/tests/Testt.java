package tests;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.*;
import ru.nsu.ccfit.nadezhkin.lab1.factory.Factory;
import ru.nsu.ccfit.nadezhkin.lab1.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Testt {
    @Test
    void push_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), 1);
    }

    @Test
    void pop_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
            factory.createCommand("POP").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        NoStackElement e = Assertions.assertThrows(NoStackElement.class, model::peekStack);
        Assertions.assertNotNull(e);
    }

    @Test
    void add_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
            factory.createCommand("PUSH -2").exec();
            factory.createCommand("+").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), -1);
    }

    @Test
    void sub_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
            factory.createCommand("PUSH -2").exec();
            factory.createCommand("-").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), 3);
    }

    @Test
    void mul_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
            factory.createCommand("PUSH -2").exec();
            factory.createCommand("*").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), -2);
    }

    @Test
    void div_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
            factory.createCommand("PUSH -2").exec();
            factory.createCommand("/").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals((float) model.peekStack(), -0.5);
    }

    @Test
    void div_by_zero_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        factory.createCommand("PUSH 1").exec();
        factory.createCommand("PUSH 0").exec();
        DivByZero e = Assertions.assertThrows(DivByZero.class, factory.createCommand("/")::exec);
        Assertions.assertNotNull(e);
    }

    @Test
    void define_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("DEFINE a 1").exec();
            factory.createCommand("PUSH a").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), 1);
    }

    @Test
    void sqrt_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 9").exec();
            factory.createCommand("SQRT").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), 3);
    }

    @Test
    void print_simple() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1").exec();
            factory.createCommand("PRINT").exec();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(model.peekStack(), 1);
    }

    @Test
    void bad_command() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("command").exec();
        } catch (BadCommand e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void less_of_args() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH").exec();
        } catch (InvocationTarget e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void div_by_zero() {
        Model model = new Model();
        Factory factory = new Factory(model);
        factory.createCommand("PUSH 5").exec();
        factory.createCommand("PUSH 0").exec();
        DivByZero e = Assertions.assertThrows(DivByZero.class, factory.createCommand("/")::exec);
        Assertions.assertNotNull(e);
    }

    @Test
    void no_map_key() {
        Model model = new Model();
        Factory factory = new Factory(model);
        NoMapKey e = Assertions.assertThrows(NoMapKey.class, factory.createCommand("PUSH A")::exec);
        Assertions.assertNotNull(e);
    }

    @Test
    void no_stack_element() {
        Model model = new Model();
        Factory factory = new Factory(model);
        NoStackElement e = Assertions.assertThrows(NoStackElement.class, factory.createCommand("POP")::exec);
        Assertions.assertNotNull(e);
    }

    @Test
    void a_lot_of_args() {
        Model model = new Model();
        Factory factory = new Factory(model);
        try {
            factory.createCommand("PUSH 1 1").exec();
        } catch (InvocationTarget e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void sqrt_neg_num() {
        Model model = new Model();
        Factory factory = new Factory(model);
        factory.createCommand("PUSH -1").exec();
        SqrtNegativeNumber e = Assertions.assertThrows(SqrtNegativeNumber.class, factory.createCommand("SQRT")::exec);
        Assertions.assertNotNull(e);
    }
}
