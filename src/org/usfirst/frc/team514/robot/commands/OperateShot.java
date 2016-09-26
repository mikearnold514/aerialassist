/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.commands;

import org.usfirst.frc.team514.robot.Robot;
import org.usfirst.frc.team514.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Team 514
 */
public class OperateShot extends Command {
    boolean done;
    public OperateShot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shotUtil);
        requires(Robot.tensionUtil);
        requires(Robot.gatorUtil);
        requires(Robot.jawUtil);
        done = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(GetShotStatus()){
            Robot.shotUtil.Fire();
            Timer.delay(RobotMap.latch_WAIT);  //Could be longer if pneumatics have to charge!
            Robot.shotUtil.ReturnLatch();
            Timer.delay(RobotMap.return_WAIT);
            done = true;
        }
    }
    
    private boolean GetShotStatus(){
        boolean Status = true;
        //Status &= shotUtil.GetBallStatus();
        Status &= Robot.shotUtil.getPrimerStatus();
        Status &= Robot.shotUtil.GetShooterStatus();
        Status &= Robot.tensionUtil.getTensionStatus();
        Status &= Robot.gatorUtil.getGatorStatus();
        Status &= Robot.jawUtil.getJawStatus();
        
        return Status;
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
