package at.struct.wasbugs.wasbug22.services;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SnapshotData
{
  private Long snapshotId = 1234L;
  
  public Long getSnapshotId()
  {
    return this.snapshotId;
  }
  
  public void setSnapshotId(Long snapshotId)
  {
    this.snapshotId = snapshotId;
  }
  
  public boolean isSnapshotRequested()
  {
    return this.snapshotId != null;
  }
}
