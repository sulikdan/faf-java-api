package com.faforever.api.data.domain;

import com.yahoo.elide.annotation.Include;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "player_achievements")
@Include(rootLevel = true, type = "playerAchievement")
@Setter
public class PlayerAchievement {

  private int id;
  private Integer currentSteps;
  private AchievementState state;
  private Timestamp createTime;
  private Timestamp updateTime;
  private Player player;
  private AchievementDefinition achievement;

  @Id
  @Column(name = "id")
  @GeneratedValue
  public int getId() {
    return id;
  }

  @Column(name = "current_steps")
  public Integer getCurrentSteps() {
    return currentSteps;
  }

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  public AchievementState getState() {
    return state;
  }

  @Column(name = "create_time")
  public Timestamp getCreateTime() {
    return createTime;
  }

  @Column(name = "update_time")
  public Timestamp getUpdateTime() {
    return updateTime;
  }

  @ManyToOne
  @JoinColumn(name = "player_id")
  public Player getPlayer() {
    return player;
  }

  @OneToOne
  @JoinColumn(name = "achievement_id")
  public AchievementDefinition getAchievement() {
    return achievement;
  }
}
