// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetArmPosition extends CommandBase {
  /** Creates a new SetArmPosition. */
  private double position;
  private double tolerance = 0.030;
  public SetArmPosition(double position) {
    this.position = position;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.arm);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.arm.setPosition(position);
    System.out.println("Beginning SetArmPosition");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //RobotContainer.arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(RobotContainer.arm.getAbsoluteEncoderPosition() - position) <= tolerance) {
      System.out.println("SetArmPosition Complete");
      return true;
    }
    else {
      return false;
    }
  }
}
