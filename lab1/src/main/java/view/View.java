package view;

import presenter.IViewListener;

import java.util.Scanner;

public class View {
    private Scanner scanner;
    private IViewListener listener;
    public View(IViewListener listener) {
        this.listener = listener;
        scanner = new Scanner(System.in);
    }
    public void ask_str() {
        String str;
        str = scanner.nextLine();
        listener.get_str(str);
    }
}
