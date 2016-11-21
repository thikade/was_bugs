package at.struct.wasbugs.wasbug22.specialize;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.inject.Named;
import at.struct.wasbugs.wasbug22.services.SnapshotData;


@RequestScoped
@Specializes
public class UiSnapshotData extends SnapshotData
{
//  @Inject
//  private UiSnapshotIdStorage uiSnapshotIdStorage;

  public Long getSnapshotId()
  {
	  return super.getSnapshotId() + 100000L;
  }
  
  public void setSnapshotId(Long snapshotId)
  {
    super.setSnapshotId(snapshotId);
  }
}
