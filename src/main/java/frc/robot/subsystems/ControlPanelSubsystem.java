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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ControlPanelSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  
  // Instantiate new motor controller objects
  public WPI_TalonSRX controlPanelMotor = new WPI_TalonSRX(RobotMap.controlPanelPort);

  // Instantiate new Solenoid for pneumatic cylinder
  public DoubleSolenoid controlPanelSolenoid = new DoubleSolenoid(RobotMap.controlPanelDeploySolenoidPort,RobotMap.controlPanelRetractSolenoidPort);

  public void deployPiston() {
  controlPanelSolenoid.set(Value.kForward);
  }

  public void retractPiston() {
    controlPanelSolenoid.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
