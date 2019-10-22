/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.drive.SlowMode;
import frc.robot.commands.drive.DriveWithJoystick;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems are defined here
  private final ExampleSubsystem m_ExampleSubsystem = new ExampleSubsystem();
  private final DriveSystem m_DriveSystem = new DriveSystem();

  // The robot's commands are defined here
  private final ExampleCommand m_ExampleCommand = new ExampleCommand(m_ExampleSubsystem);
  private final SlowMode m_SlowMode = new SlowMode(m_DriveSystem);
  private final DriveWithJoystick m_JoystickDrive = new DriveWithJoystick(m_DriveSystem);

  // Joysticks and buttons are declared here
  private Joystick xboxDrive;
  private Joystick logiManipulator;
  private JoystickButton leftBumper;

  // Creating instance of RobotContainer to be referened with getInstance so new
  // instances don't have to be created
  private static final RobotContainer INSTANCE = new RobotContainer();

  // The container for the robot. Contains subsystems, OI devices, and commands.
  public RobotContainer() {
    // Instantiate joysticks and buttons
    xboxDrive = new Joystick(0);
    logiManipulator = new Joystick(1);

    leftBumper = new JoystickButton(xboxDrive, 6);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * calling passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    leftBumper.whenPressed(m_SlowMode);
  }

  // Use this to pass the autonomous command to the main {@link Robot} class.
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_ExampleCommand;
  }

  // This method is used so that a new instance of RobotContainer does not have to be created for every command
  public static RobotContainer getInstance() {
    return INSTANCE;
  }

  public double getXboxAxis(int axis) {
    return xboxDrive.getRawAxis(axis);
  }

  public double getManipulatorAxis(int axis) {
    return logiManipulator.getRawAxis(axis);
  }
}