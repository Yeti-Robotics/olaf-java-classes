// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.IntakeForwardCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer{

    public XboxController joystick;

    public final DrivetrainSubsystem drivetrainSubsystem;
    public final IntakeSubsystem intakeSubsystem;


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        drivetrainSubsystem = new DrivetrainSubsystem();
        intakeSubsystem = new IntakeSubsystem();
        joystick = new XboxController(0);

        drivetrainSubsystem.setDefaultCommand(
            new RunCommand(() -> drivetrainSubsystem.tankDrive(joystick.getLeftY(), joystick.getRightY()), drivetrainSubsystem));
        // Configure the button bindings
        configureButtonBindings();
    }
    
    
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        setButtonWhileHeld(joystick, XboxController.Button.kRightBumper.value, new IntakeBallCommand(intakeSubsystem));
        setButtonWhenPressed(joystick, XboxController.Button.kA.value, new IntakeForwardCommand(intakeSubsystem));
    }

    private void setButtonWhenPressed(GenericHID controller, int buttonNumber, Command command) {
        new JoystickButton(controller, buttonNumber).whenPressed(command);
    }

    private void setButtonWhileHeld(GenericHID controller, int buttonNumber, Command command) {
        new JoystickButton(controller, buttonNumber).whileHeld(command);
    }
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
