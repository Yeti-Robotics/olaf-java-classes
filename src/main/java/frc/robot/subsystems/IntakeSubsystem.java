package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final VictorSPX intakeMotor;
    private final DoubleSolenoid intakePiston;

    public IntakeSubsystem() {
        intakeMotor = new VictorSPX(8);
        intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 7, 0);
    }

    public void intakeIn() {
        intakeMotor.set(ControlMode.PercentOutput, 1.0);
    }

    public void intakeOut() {
        intakeMotor.set(ControlMode.PercentOutput, -1.0);
    }

    public void intakeStop() {
        intakeMotor.set(ControlMode.PercentOutput, 0.0);
    }

    public void intakeForward() {
        intakePiston.set(DoubleSolenoid.Value.kForward);
    }

    public void intakeBackward() {
        intakePiston.set(DoubleSolenoid.Value.kReverse);
    }
}

