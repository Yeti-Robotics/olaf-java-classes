package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AllInCommandGroup extends ParallelCommandGroup {
    public AllInCommandGroup(IntakeSubsystem intakeSubsystem, HopperSubsystem hopperSubsystem) {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(
                new IntakeBallCommand(intakeSubsystem),
                new StartEndCommand(
                        () -> {
                            hopperSubsystem.hopperIn();
                            hopperSubsystem.pinchIn();
                        },
                        () -> {
                            hopperSubsystem.hopperStop();
                            hopperSubsystem.pinchStop();
                        },
                        hopperSubsystem
                )
        );
    }
}