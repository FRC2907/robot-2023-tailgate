package frc.robot.bodges;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class EzTalonFX extends TalonFX implements MotorController {

    public EzTalonFX(Integer deviceNumber) { super(deviceNumber); }
    public EzTalonFX(int     deviceNumber) { super(deviceNumber); }

    @Override
    public void set(double speed) {
        this.set(TalonFXControlMode.PercentOutput, speed);
    }

    @Override
    public double get() {
        return this.getMotorOutputPercent();
    }

    @Override
    public void disable() {
        this.set(TalonFXControlMode.Disabled, 0);
    }

    @Override
    public void stopMotor() {
        this.set(TalonFXControlMode.PercentOutput, 0);
    }

    public static MotorController[] createListFromIDs(int[] ids) {
        MotorController[] out = new MotorController[ids.length];
        for (int i = 0; i < ids.length; i++)
        out[i] = new EzTalonFX(ids[i]);
        return out;
    }
}
