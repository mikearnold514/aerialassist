/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team514.robot;


import org.usfirst.frc.team514.robot.subsystems.BallMagUtil;
//import org.usfirst.frc.team514.robot.commands.CommandBase;
import org.usfirst.frc.team514.robot.subsystems.CompressorUtil;
import org.usfirst.frc.team514.robot.subsystems.DriveUtil;
import org.usfirst.frc.team514.robot.subsystems.EncoderUtil;
import org.usfirst.frc.team514.robot.subsystems.GatorUtil;
import org.usfirst.frc.team514.robot.subsystems.JawUtil;
import org.usfirst.frc.team514.robot.OI;
import org.usfirst.frc.team514.robot.subsystems.ShotUtil;
import org.usfirst.frc.team514.robot.subsystems.TensionUtil;
import org.usfirst.frc.team514.robot.subsystems.TimerUtil;
import org.usfirst.frc.team514.robot.subsystems.VisionUtil;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static final DriveUtil driveUtil = new DriveUtil();
    public static final EncoderUtil encoderUtil = new EncoderUtil();
    public static final VisionUtil visionUtil = new VisionUtil();
    public static final CompressorUtil compUtil = new CompressorUtil();
    public static final BallMagUtil ballmagUtil = new BallMagUtil(); 
    public static final GatorUtil gatorUtil = new GatorUtil();
    public static final JawUtil jawUtil = new JawUtil();
    public static final ShotUtil shotUtil = new ShotUtil();
    public static final TensionUtil tensionUtil = new TensionUtil();
    public static final TimerUtil timerUtil = new TimerUtil();

    //Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	oi = new OI();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
 //       CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Timer.delay(0.01);
        updateStatus();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Timer.delay(0.01);
        updateStatus();
    }
    
    private void updateStatus(){
        Robot.driveUtil.updateStatus();
        Robot.encoderUtil.updateStatus();
        Robot.visionUtil.updateStatus();
        Robot.gatorUtil.updateStatus();
        Robot.jawUtil.updateStatus();
        Robot.shotUtil.updateStatus();
        Robot.tensionUtil.updateStatus();
        Robot.timerUtil.updateStatus();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
