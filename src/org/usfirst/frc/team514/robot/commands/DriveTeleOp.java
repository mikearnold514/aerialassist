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
public class DriveTeleOp extends Command {
    int mode;
    
    public DriveTeleOp(int mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveUtil);
        this.mode = mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        switch (mode){
            case(RobotMap.arcade_Mode):
                Robot.driveUtil.driveArcade(Robot.oi.getRightstick());
                break;
            case(RobotMap.tank_Mode):
                Robot.driveUtil.driveTank(Robot.oi.getLeftstick(), Robot.oi.getRightstick());
                break;
            default:
                Robot.driveUtil.driveTank(Robot.oi.getLeftstick(), Robot.oi.getRightstick());
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
