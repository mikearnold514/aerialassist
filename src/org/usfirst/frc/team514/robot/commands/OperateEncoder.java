/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.commands;

import org.usfirst.frc.team514.robot.Robot;
import org.usfirst.frc.team514.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author marnold
 */
public class OperateEncoder extends Command {
    int cmd;
    boolean done;
    public OperateEncoder(int cmd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.encoderUtil);
        this.cmd = cmd;
        this.done = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        done = false;
        switch (cmd){
            case RobotMap.reset_Encoder:
                Robot.encoderUtil.resetEncoder();
                break;
            /*    
            case RobotMap.stop_Encoder:
                encoderUtil.stopEncoder();
                break;
            case RobotMap.start_Encoder:
                encoderUtil.startEncoder();
                break;
            */
            default:
            	//encoderUtil.stopEncoder();
                Robot.encoderUtil.resetEncoder();
                break;
        }
        done = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
