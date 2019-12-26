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

  // Instance of DriveSystem used in getInstance()
  private static final DriveSystem INSTANCE = new DriveSystem();
    
  // Declaring motor controllers and NavX
  private TalonSRX leftLead;
  private TalonSRX leftFollow1;
  private TalonSRX rightLead;
  private TalonSRX rightFollow1;

  private static AHRS NavX;

  private final double SLOW_SPEED = 0.5;
  private Boolean slowmode = false;
  
  // Code for initializing subsystem, called when DriveSystem is created
  public DriveSystem() {
    // Motor IDs are stored in Constants.java to make code more readable 
    leftLead = new TalonSRX(Constants.DRV_LEFTLEAD);
    leftFollow1 = new TalonSRX(Constants.DRV_LEFTFOLLOW1);
    rightLead = new TalonSRX(Constants.DRV_RIGHTLEAD);
    rightFollow1 = new TalonSRX(Constants.DRV_RIGHTFOLLOW1);

    // Setting physically linked motors to follow one lead and setting them all to 0
    leftFollow1.follow(leftLead);
    leftLead.set(ControlMode.PercentOutput, 0);

    rightFollow1.follow(rightLead);
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

  public void driveStop () {
    leftLead.set(ControlMode.PercentOutput, 0);
    rightLead.set(ControlMode.PercentOutput, 0);
  }

  // Methods for using slowmode
  public void setSlow (Boolean slow) {
    // Sets the DriveSystem's slowmode to the boolean parameter
    slow = slowmode;
  }

  public Boolean getSlow () {
    // Returns the current slowmode, as defined by setSlow()
    return slowmode;
  }

  // Static NavX methods that can be used without having to create new instances of DriveSystem
  public static double getPitch () {
    // Pitch is the vertical angle of the robot on an axis from side to side
    return NavX.getPitch();
  }
  
  public static double getYaw () {
    // Yaw is the horizontal angle of the robot on an axis from bottom to top
    return NavX.getYaw();
  }

  public static double getRoll () {
    // Roll is the rotation of the robot on an axis running from the back to the front
    return NavX.getRoll();
  }
}
