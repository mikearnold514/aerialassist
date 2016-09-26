/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.commands;

import org.usfirst.frc.team514.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Team 514
 */
public class TestTarget extends Command {
    
    boolean active, done;
    
    public TestTarget(boolean active) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.visionUtil);
        this.active = active;
        done = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            done = false;
            Robot.visionUtil.testSetHotGoal(active);
            done = true;
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
