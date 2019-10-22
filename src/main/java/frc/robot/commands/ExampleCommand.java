/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


// An example command that uses an example subsystem.
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem;

  
  // Creates a new Command.
  public ExampleCommand(ExampleSubsystem subsystem) {
    // Adds ExampleSubsystem as a requirement subsystem, allowing methods from the subsystem to be called
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  // This method is called before execute() and should contain any initialization needed by the command
  public void initialize () {

  }

  // This method is called repeatedly when the command is scheduled until isFinished() returns true and should contain any actions to be performed by the command
  public void execute () {

  }

  // This method is called when isFinished() returns true and should stop any actions being run by the command
  public void end () {

  }

  // This method is called repeatedly when the command is scheduled and calls the end() method when it returns true
  public boolean isFinished () {
    return false;
  }
}
