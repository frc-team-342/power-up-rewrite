/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilib2.SubsystemBase;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.LEDChannel;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

import frc.robot.Constants;

public class LightSystem extends SubsystemBase {
  private static final LightSystem INSTANCE = new LightSystem();

  private CANifier rgbController;
  private DriverStation ds;
  
  // Code for initializing subsystem, called when LightSubsystem is created
  public LightSystem() {
    rgbController = new CANifier(Constants.CANIFIER);
    ds = DriverStation.getInstance();
  }

  // Will be called periodically whenever the CommandScheduler runs.
  @Override
  public void periodic() {

  }

  // Methods for controlling the subsystem
  public static LightSystem getInstance() {
    return INSTANCE;
  }

  public void setAllianceColor () {
    if (ds.getAlliance().equals(Alliance.Red)) {
      rgbController.setLEDOutput(1.0, LEDChannel.LEDChannelA);
    } else if (ds.getAlliance().equals(Alliance.Red)) {
      rgbController.setLEDOutput(1.0, LEDChannel.LEDChannelC);
    }
  }
}
