/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Team 514
 */
public class TimerUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    double starttime, lapsetime;
    int seconds;
    boolean enabled;
    
    public TimerUtil(){
        starttime = lapsetime = 0.0;
        seconds = 0;
        enabled = false;
        start();
    }
    
    public void startTimer(){
        start();
    }
    
    private void start(){
        if(!enabled){
            resetTimer();            
        }
        enabled = true;        
    }
    
    public void resetTimer(){
        starttime = Timer.getFPGATimestamp();
        lapsetime = 0.0;
        seconds = 0;        
    }
    
    public void stopTimer(){
        enabled = false;
        //resetTimer();
    }
    
    public void calcTime(){
        if(enabled){
            lapsetime = Math.abs(Timer.getFPGATimestamp() - starttime);
            seconds++;
            }
    }
    
    public double getLapseTime(){
        return lapsetime;
    }
    
    public int getSeconds(){
        int secs;
        secs = this.seconds/50;
        return secs;
    }
    
    public void updateStatus(){
        SmartDashboard.putNumber("Start Time = ", starttime);
        SmartDashboard.putNumber("Lapse Time = ", getLapseTime());
        SmartDashboard.putNumber("Seconds    = ", getSeconds());
        SmartDashboard.putNumber("FPGA Time  = ", Timer.getFPGATimestamp());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new OperateTimer(RobotMap.timer_Run));
    }
}
