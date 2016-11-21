package at.struct.wasbugs.wasbug22.vorgang.be;

import at.struct.wasbugs.wasbug22.services.SnapshotData;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class KinderzuschussKinderServiceImpl
{

  @Inject
  private SnapshotData snapshotData;
  
  
  public Long getSnapshotId()
  {
    Long snapshotID = this.snapshotData.getSnapshotId();
    return  snapshotID;
  }
  
}
