package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {
    private VictorSPX hopperVictor;
    private VictorSPX pinchRollerVictor;

    public HopperSubsystem() {
        hopperVictor = new VictorSPX(9);
        pinchRollerVictor = new VictorSPX(7);

        hopperVictor.setInverted(true);
    }

    public void hopperIn() {
        hopperVictor.set(ControlMode.PercentOutput, 0.4);
    }

    public void hopperOut() {
        hopperVictor.set(ControlMode.PercentOutput, -0.4);
    }

    public void hopperStop() {
        hopperVictor.set(ControlMode.PercentOutput, 0);
    }

    public void pinchIn() {
        pinchRollerVictor.set(ControlMode.PercentOutput, 0.3);
    }

    public void pinchOut() {
        pinchRollerVictor.set(ControlMode.PercentOutput, -0.3);
    }

    public void pinchStop() {
        pinchRollerVictor.set(ControlMode.PercentOutput, 0);
    }
}

