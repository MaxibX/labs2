package ru.nsu.ccfit.nadezhkin.lab2;

import java.awt.Point;
public class Figures {
    private static int ZERO = 0;
    private static int ONE = 1;
    private static int TWO = 2;
    private static int THREE = 3;
    public static final Point[][][] FiguresArray = {
            //J Figure
            {
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(TWO, TWO)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(ONE, TWO), new Point(ZERO, TWO)},
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(ZERO, ZERO)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(ONE, TWO), new Point(TWO, ZERO)}
            },
            //Z Figure
            {
                    {new Point(ZERO, ZERO), new Point(ONE, ZERO), new Point(ONE, ONE), new Point(TWO, ONE)},
                    {new Point(ONE, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE), new Point(ZERO, TWO)},
                    {new Point(ZERO, ZERO), new Point(ONE, ZERO), new Point(ONE, ONE), new Point(TWO, ONE)},
                    {new Point(ONE, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE), new Point(ZERO, TWO)}
            },
            //L Figure
            {
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(TWO, ZERO)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(ONE, TWO), new Point(TWO, TWO)},
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(ZERO, TWO)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(ONE, TWO), new Point(ZERO, ZERO)}
            },
            //S Figure
            {
                    {new Point(ONE, ZERO), new Point(TWO, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE)},
                    {new Point(ZERO, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE), new Point(ONE, TWO)},
                    {new Point(ONE, ZERO), new Point(TWO, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE)},
                    {new Point(ZERO, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE), new Point(ONE, TWO)}
            },
            //I Figure
            {
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(THREE, ONE)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(ONE, TWO), new Point(ONE, THREE)},
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(THREE, ONE)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(ONE, TWO), new Point(ONE, THREE)}
            },
            //O Figure
            {
                    {new Point(ZERO, ZERO), new Point(ZERO, ONE), new Point(ONE, ZERO), new Point(ONE, ONE)},
                    {new Point(ZERO, ZERO), new Point(ZERO, ONE), new Point(ONE, ZERO), new Point(ONE, ONE)},
                    {new Point(ZERO, ZERO), new Point(ZERO, ONE), new Point(ONE, ZERO), new Point(ONE, ONE)},
                    {new Point(ZERO, ZERO), new Point(ZERO, ONE), new Point(ONE, ZERO), new Point(ONE, ONE)}
            },
            //T Figure
            {
                    {new Point(ONE, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE)},
                    {new Point(ONE, ZERO), new Point(ZERO, ONE), new Point(ONE, ONE), new Point(ONE, TWO)},
                    {new Point(ZERO, ONE), new Point(ONE, ONE), new Point(TWO, ONE), new Point(ONE, TWO)},
                    {new Point(ONE, ZERO), new Point(ONE, ONE), new Point(TWO, ONE), new Point(ONE, TWO)}
            }
    };
}
