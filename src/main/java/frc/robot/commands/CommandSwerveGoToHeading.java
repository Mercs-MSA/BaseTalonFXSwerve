package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.vision.CustomGamePieceVision;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

public class CommandSwerveGoToHeading extends Command {
  private final Swerve m_swerve;
  public CustomGamePieceVision m_GamePieceVision = new CustomGamePieceVision("note_yaw");
  
  public CommandSwerveGoToHeading(Swerve s) {
    // heading = (target);
    m_swerve = s;
    addRequirements(m_swerve);
  }

  @Override
  public void initialize() {

  }
  
  @Override
  public void execute() {
    if (m_GamePieceVision.getGamePieceYaw() != 999.0) {
      m_swerve.drive(new Translation2d(0.2, 0), m_GamePieceVision.getGamePieceYaw()/20 > 2.5 ? 2.5 : m_GamePieceVision.getGamePieceYaw()/20 , false, true);
    }
  }
  
  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
