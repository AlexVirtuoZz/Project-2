package main;

import controller.Controller;

import java.io.IOException;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Controller controller = new Controller();
        controller.process();

    }
}
