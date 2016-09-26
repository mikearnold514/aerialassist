/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Team 514
 */
public class ShotUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
        DoubleSolenoid ShotReturn;    
        Solenoid Latch;
        DigitalInput BallReady, ShotReady;
        
        boolean primer;

    public ShotUtil(){
        ShotReturn = new DoubleSolenoid(RobotMap.shot_Out_Channel, RobotMap.shot_Back_Channel);
        Latch = new Solenoid(RobotMap.latchChannel);
        BallReady = new DigitalInput(RobotMap.ballReady);
        ShotReady = new DigitalInput(RobotMap.shotReady);
        this.primer = false;
        
    }
    
    public void Fire(){
        Latch.set(true);
    }
    
    public void ReturnLatch(){
        Latch.set(false);
    }
    
    public void PrimeShooter(){
        ShotReturn.set(DoubleSolenoid.Value.kReverse);
        primer = true;
    }
    
    public void ReturnShooter(){
        ShotReturn.set(DoubleSolenoid.Value.kForward);
        primer = false;
    }
    
    public void ShooterOff(){
        ShotReturn.set(DoubleSolenoid.Value.kOff);
    }
    
    /*
    public boolean GetBallStatus(){
        //return true;
        return BallReady.get();
    }
    */
    
    public boolean getPrimerStatus(){
        return this.primer;
    }
    
    public boolean GetShooterStatus(){
        return !ShotReady.get();
    }
    
    public void updateStatus(){
        //SmartDashboard.putBoolean("Ball Ready = ", GetBallStatus());
        SmartDashboard.putBoolean("Primer Status = ", primer);
        SmartDashboard.putBoolean("Shot Ready = ", GetShooterStatus());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new OperateLatch(RobotMap.fire_ready_mode));
    }
}
