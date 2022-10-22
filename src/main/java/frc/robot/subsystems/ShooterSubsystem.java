package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    private WPI_TalonFX rightFlywheel;
    private WPI_TalonFX leftFlywheel;

    public ShooterSubsystem() {
        rightFlywheel = new WPI_TalonFX(5);
        leftFlywheel = new WPI_TalonFX(6);

        rightFlywheel.follow(leftFlywheel);
        rightFlywheel.setInverted(InvertType.OpposeMaster);

        rightFlywheel.setNeutralMode(NeutralMode.Coast);
        leftFlywheel.setNeutralMode(NeutralMode.Coast);
    }

    public void shootFlywheel() {
        leftFlywheel.set(ControlMode.PercentOutput, 0.6);
    }

    public void stopFlywheel() {
        leftFlywheel.set(ControlMode.PercentOutput, 0);
    }
}

