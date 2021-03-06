/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Arcade_ShiftCommand;

/**
 * Add your docs here.
 */
public class ArcadeDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Instantiate new motor controller objects
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave1 = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave1 = new WPI_TalonSRX(RobotMap.righSlavePort);

  // Instantiate new gearbox Solenoid
  private final DoubleSolenoid shiftSolenoid = new DoubleSolenoid(RobotMap.GBSlowSolenoidPort, RobotMap.GBFastSolenoidPort);

  // Instantiate a new DifferentialDrive objects
  // Assign motor controllers to differential drive
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Arcade_ShiftCommand(Value.kForward));
  }


  // Create constructor Function
  public ArcadeDriveSubsystem() {
      // Point slaves to masters
      leftSlave1.follow(leftMaster);
      rightSlave1.follow(rightMaster);

  }

  // Add manualArcadeDrive() method
  public void manualArcadeDrive(double move, double turn) {

    // Max speed for testing mode
    if(move > 0.5) move = .5;
    if(move < -0.5) move = -.5;


    drive.arcadeDrive(move, turn);

  }

  public void shift(Value value){
	shiftSolenoid.set(value);
  }
  
  public void stop(){
    drive.arcadeDrive(0, 0);
  }

}
