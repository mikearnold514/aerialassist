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
public class DriveEncoder extends Command {
    double leftValue, rightValue;
    boolean test;
    public DriveEncoder(boolean test) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveUtil);
        requires(Robot.encoderUtil);
        requires(Robot.timerUtil);
        this.test = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.encoderUtil.resetEncoder();
        //encoderUtil.startEncoder();
        Robot.timerUtil.resetTimer();
        Robot.timerUtil.startTimer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.timerUtil.calcTime();
        if(test){
            Robot.driveUtil.drive(0.0, 0.0);
        }else{
            if(Robot.encoderUtil.getLeftEncoderDistance() >= RobotMap.ENCODER_DISTANCE){
                Robot.driveUtil.drive(0.0, 0.0);
                Robot.encoderUtil.setShotRange(true);
                //encoderUtil.stopEncoder();
                Robot.encoderUtil.resetEncoder();
            }else{
                Robot.encoderUtil.setShotRange(false);            
                getMotorSpeed();
                Robot.driveUtil.drive(leftValue, rightValue);
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.encoderUtil.getShotRange();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public void getMotorSpeed(){
        double delta, adjust;
        leftValue = RobotMap.auto_LeftMotor;
        rightValue = RobotMap.auto_RightMotor;
        
        delta = Robot.encoderUtil.getLeftEncoderDistance() - Robot.encoderUtil.getRightEncoderDistance();
    
        adjust = Robot.encoderUtil.coerce2Range(delta);
        
        rightValue = rightValue + adjust;
        leftValue = leftValue + -adjust;
        
    }
    
}
