package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.bodges.EzTalonFX;

public class TankDrivetrain extends DifferentialDrive implements Subsystem {
    private TankDrivetrain(MotorController left, MotorController right) { super(left, right); }
    private static TankDrivetrain instance;
    public static TankDrivetrain getInstance() {
        if (instance == null) {
            MotorControllerGroup left, right;

            left = new MotorControllerGroup(EzTalonFX.createListFromIDs(frc.robot.constants.Ports.can.drivetrain.LEFTS));
            left.setInverted(true);

            right = new MotorControllerGroup(EzTalonFX.createListFromIDs(frc.robot.constants.Ports.can.drivetrain.RIGHTS));
            right.setInverted(false);

            instance = new TankDrivetrain(left, right);
        }
        return instance;
    }

    public void curvatureDrive(double xSpeed, double zRotation) {
        this.curvatureDrive(xSpeed*Math.abs(xSpeed), zRotation, Math.abs(xSpeed) < 0.1);
    }
}
