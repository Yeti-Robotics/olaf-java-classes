package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    private WPI_TalonFX leftFalcon1, leftFalcon2, rightFalcon1, rightFalcon2;

    public final DifferentialDrive differentialDrive;

    public DrivetrainSubsystem() {
        leftFalcon1 = new WPI_TalonFX(1);
        leftFalcon2 = new WPI_TalonFX(4);
        rightFalcon1 = new WPI_TalonFX(3);
        rightFalcon2 = new WPI_TalonFX(2);

        differentialDrive = new DifferentialDrive(leftFalcon1, rightFalcon1);
        differentialDrive.setDeadband(0.05);

        leftFalcon1.setInverted(true);
        rightFalcon1.setInverted(false);

        leftFalcon1.setNeutralMode(NeutralMode.Brake);
        rightFalcon1.setNeutralMode(NeutralMode.Brake);

        leftFalcon2.follow(leftFalcon1);
        rightFalcon2.follow(rightFalcon1);

        leftFalcon2.setInverted(InvertType.FollowMaster);
        rightFalcon2.setInverted(InvertType.FollowMaster);
    }

    @Override
    public void periodic() {

    }

    public void tankDrive(double leftPower, double rightPower){
        differentialDrive.tankDrive(leftPower, rightPower);
    }

    public void stopDrive(){
        leftFalcon1.set(ControlMode.PercentOutput, 0);
        rightFalcon1.set(ControlMode.PercentOutput, 0);
    }
}

