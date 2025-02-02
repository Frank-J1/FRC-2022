/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package ca.warp7.frc2022;

import ca.warp7.frc2022.lib.NetworkUtil;
import ca.warp7.frc2022.lib.control.PID;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Configuration

    public static final boolean kEnableSolenoids = true;
    public static final boolean kEnableDriveTrain = true;

    public static final boolean kDebugCommandScheduler = false;
    public static final boolean kUseKinematicsDrive = false;
    public static final boolean kUseNotifierForMainLoop = false;

    // CAN IDs

    public static final int kDriveLeftMasterID = 31;
    public static final int kDriveLeftFollowerID = 32;

    public static final int kDriveRightMasterID = 34;
    public static final int kDriveRightFollowerID = 33;

    public static final int kClimbMasterID = 41;
    public static final int kClimbFollowerID = 42;
    //public static final int kControlPanelManipulatorID = -1;


    // PCM IDs
    public static final int kDriveShifterID = 0;

    // DIO IDs

    //public static final int kBeamBreakID = 1;

    // Launcher Tuning
    public static final boolean kIsLauncherLobber = true;

    public static final double kLobberRPS = 10.0;
    public static final double kShooterRPS = 20.0;

    // TODO: Figure out what these variables actually mean (I ported them from 2020 code)
    public static final double kLauncherKp = 1.94;
    public static final double kLauncherKs = 0.0911;
    public static final double kLauncherKv = (0.0644 + 0.063) / 2;
    public static final double kLauncherKa = (0.0401 + 0.0483) / 2;

    // Drive Train Tuning

    public static final double kLowGearRampRate = 0.15;
    public static final double kHighGearRampRate = 0.3;

    public static final PID kAutonLowGearVelocityPID =
            new PID(0.2, 0.0, 0.0, 0.0);
    public static final PID kTeleopLowGearVelocityPID =
            new PID(0.0, 0.0, 0.0, 0.0);
    public static final PID kTeleopHighGearVelocityPID =
            new PID(0.0, 0.0, 0.0, 0.0);
    public static final PID kVisionAlignmentYawPID =
            new PID(0.025, 0.0, 0.002, 0.0);
    // units: degrees => percent
    public static final PID kQuickTurnPID =
            new PID(0.04, 0.0, 0.0, 0.0);


    // Drive Train Constants

    public static final double kWheelBaseRadius = 0.375; // metres
    public static final double kWheelRadius = 0.0760858711932102; // metres
    public static final double kMaxVoltage = 12.0; // volts

    public static class LowGear {
        public static final double kGearRatio = 42.0 / 10.0 * 60.0 / 14.0; // 18.0

        public static final double kMetresPerRotation =
                (2 * Math.PI * kWheelRadius) / kGearRatio; // ticks/m

        public static final SimpleMotorFeedforward kTransmission =
                new SimpleMotorFeedforward(0.0353, 4.140, 0.401);

    }

    public static class HighGear {
        public static final double kGearRatio = 42.0 / 10.0 * 50.0 / 24.0; // 8.75

        public static final double kMetresPerRotation =
                (2 * Math.PI * kWheelRadius) / kGearRatio; // m/rotation

        public static final SimpleMotorFeedforward kTransmission =
                new SimpleMotorFeedforward(0.218, 2.01, 0.307);
    }

    @SuppressWarnings("unused")
    private static class PracticeRobotDetector {
        private static final String kPracticeRobotAddress = "00-80-2F-27-06-8E";
        private static final boolean kIsPracticeRobot =
                NetworkUtil.getMACAddress().equals(kPracticeRobotAddress);
    }

    public static boolean isPracticeRobot() {
        return true;
    }
}