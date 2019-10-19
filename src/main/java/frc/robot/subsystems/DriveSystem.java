/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSystem extends SubsystemBase {
  
  private static final DriveSystem INSTANCE = new DriveSystem();
  
  // Declaring motor controllers and NavX
  private TalonSRX leftLead;
  private TalonSRX leftFollow1;
  private TalonSRX leftFollow2;
  private TalonSRX rightLead;
  private TalonSRX rightFollow1;
  private TalonSRX rightFollow2;

  private AHRS NavX;

  private final double SLOW_SPEED = 0.5;
  private boolean slowmode = false;
  
  // Code for initializing subsystem, called when DriveSystem is created
  public DriveSystem() {
    // Motor IDs are stored in Constants.java to make code more readable 
    leftLead = new TalonSRX(Constants.DRV_LEFTLEAD);
    leftFollow1 = new TalonSRX(Constants.DRV_LEFTFOLLOW1);
    leftFollow2 = new TalonSRX(Constants.DRV_LEFTFOLLOW2);
    rightLead = new TalonSRX(Constants.DRV_RIGHTLEAD);
    rightFollow1 = new TalonSRX(Constants.DRV_RIGHTFOLLOW1);
    rightFollow2 = new TalonSRX(Constants.DRV_RIGHTFOLLOW2);

    // Setting physically linked motors to follow one lead and setting them all to 0
    leftFollow1.follow(leftLead);
    leftFollow2.follow(leftLead);
    leftLead.set(ControlMode.PercentOutput, 0);

    rightFollow1.follow(rightLead);
    rightFollow2.follow(rightLead);
    rightLead.set(ControlMode.PercentOutput, 0);

    // NavX is a gyro used to detect the robot's pitch, yaw, and roll
    NavX = new AHRS(SPI.Port.kMXP);

  }

  // Will be called periodically whenever the CommandScheduler runs.
  @Override
  public void periodic() {

  }

  // Methods for controlling the subsystem
  public void drivePercentOutput (double rightSpeed, double leftSpeed) {
    if (slowmode) {
      leftSpeed *= SLOW_SPEED;
      rightSpeed *= SLOW_SPEED;
    } else {
      leftSpeed *= 0.8;
      rightSpeed *= 0.8;
    }

    leftLead.set(ControlMode.PercentOutput, leftSpeed);
    rightLead.set(ControlMode.PercentOutput, rightSpeed);
  }

  public void driveVelocity (double rightSpeed, double leftSpeed) {
    if (slowmode) {
      leftSpeed *= SLOW_SPEED;
      rightSpeed *= SLOW_SPEED;
    } else {
      leftSpeed *= 0.8;
      rightSpeed *= 0.8;
    }

    leftLead.set(ControlMode.Velocity, leftSpeed);
    rightLead.set(ControlMode.Velocity, rightSpeed);
  }

  // Used to access DriveSystem without having to create a new instance every time it's referenced
  public static DriveSystem getInstance () {
    return INSTANCE;
  }
}
