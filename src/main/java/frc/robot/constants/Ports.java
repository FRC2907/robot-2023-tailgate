package frc.robot.constants;

import java.util.Arrays;
import java.util.List;

public class Ports {
    public static class can {
        public static class drivetrain {
            public static final List<Integer> LEFTS = Arrays.asList(1, 2);
            public static final List<Integer> RIGHTS = Arrays.asList(3, 4);
        }
    }
    public static class driver_inputs {
        public static final int DRIVER = 0;
        public static final int CODRIVER = 1;
    }
}
