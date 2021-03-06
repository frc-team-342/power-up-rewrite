/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSystem;


// An drive command that uses the DriveSystem
public class DriveWithJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSystem drive;

  // Declaration of RobotContainer instance used for joystick input
  private RobotContainer robotcontainer;

  // Variables used for drive speed set from joystick input
  private double leftSpeed;
  private double rightSpeed;

  // Creates a new Command.
  public DriveWithJoystick(DriveSystem subsystem) {
    // Adds DriveSystem as a requirement subsystem, allowing methods from the subsystem to be called
    drive = subsystem;
    addRequirements(subsystem);

    // Instantiation of RobotContainer instance used for joystick input
    robotcontainer = RobotContainer.getInstance();

  }

  // This method is called before execute() and should contain any initialization needed by the command
  public void initialize () {

  }

  // This method is called repeatedly when the command is scheduled until isFinished() returns true and should contain any actions to be performed by the command
  public void execute () {
    // Gets values of Xbox joysticks from RobotContainer
    leftSpeed = robotcontainer.getXboxAxis(Constants.XBOX_LEFT_Y);
    rightSpeed = robotcontainer.getXboxAxis(Constants.XBOX_RIGHT_Y);

    if (Math.abs(leftSpeed) > Constants.DRV_DEADZONE || Math.abs(rightSpeed) > Constants.DRV_DEADZONE) {
      drive.drivePercentOutput(leftSpeed, rightSpeed);
    } 

  }

  // This method is called when isFinished() returns true and should stop any actions being run by the command
  public void end () {
    drive.driveStop();
  }

  // This method is called repeatedly when the command is scheduled and calls the end() method when it returns true
  public boolean isFinished () {
    return false;
  }
}
