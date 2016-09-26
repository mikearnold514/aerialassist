/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.commands;

import org.usfirst.frc.team514.robot.RobotMap;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Team 514
 */
public class AutoCMD extends CommandGroup {
    
    public AutoCMD(boolean side) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        //addSequential(new OperateTension(RobotMap.pass_ready_mode));
        
        addParallel(new OperateTension(RobotMap.fire_ready_mode));
        addSequential(new DriveEncoder(false));
        
        addParallel(new PrimeShot());
        addSequential(new OperateJaw(RobotMap.jawOpen_mode));
        
        addSequential(new TrackTargets(side));
        addSequential(new OperateTimer(RobotMap.timer_Stop));
        addSequential(new WaitCommand(RobotMap.auto_WAIT));
        addSequential(new OperateShot());
        addSequential(new WaitCommand(RobotMap.auto_WAIT));
        addSequential(new OperateTension(RobotMap.pass_ready_mode));
    }
}
