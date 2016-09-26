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
public class TrackTargets extends Command {
    boolean side;
    int timestamp;
    public TrackTargets(boolean side) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.visionUtil);
        requires(Robot.timerUtil);
        this.side = side;
        timestamp = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.timerUtil.calcTime();
        timestamp = Robot.timerUtil.getSeconds();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.timerUtil.calcTime();
        Robot.visionUtil.setSide(side);
        if(Robot.timerUtil.getSeconds() >= RobotMap.start_Vision){
            if(takeALook()){
                Robot.visionUtil.processImages();            
            }
        }
   }
    
    private boolean takeALook(){
        boolean look = false;
        if(Robot.timerUtil.getSeconds() > timestamp){
            timestamp = Robot.timerUtil.getSeconds();
            look = true;
        }
        return look;
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean done;
        done = false;
        if(Robot.timerUtil.getSeconds() >= RobotMap.stop_Vision){
            done = true;
        }
        if(Robot.visionUtil.getHotGoal()){
            done = true;
        }
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
