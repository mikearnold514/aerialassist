/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.commands;

import org.usfirst.frc.team514.robot.Robot;
import org.usfirst.frc.team514.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Team 514
 */
public class OperateBallMag extends Command {
    int mode;
    
    public OperateBallMag(int mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.ballmagUtil);
        this.mode = mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        switch (mode){
            case RobotMap.mag_Capture_mode:
                Robot.ballmagUtil.Capture();
                break;
            case RobotMap.mag_Release_mode:
                Robot.ballmagUtil.Release();
                break;
            case RobotMap.mag_Off_mode:
                Robot.ballmagUtil.Off();
                break;
            default:
                Robot.ballmagUtil.Off();
                break;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
