/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Motor CAN IDs
    public static final int DRV_LEFTLEAD = 1;
    public static final int DRV_LEFTFOLLOW1 = 2;
    public static final int DRV_LEFTFOLLOW2 = 3;
    public static final int DRV_RIGHTLEAD = 4;
    public static final int DRV_RIGHTFOLLOW1 = 5;
    public static final int DRV_RIGHTFOLLOW2 = 6;

    // Values used in commands
    public static final double DRV_DEADZONE = 0.2;
}