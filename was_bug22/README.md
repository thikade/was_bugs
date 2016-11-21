### Problem description: @Specializes annotation works in WAS 8.5.5.x but not in WAS 9.0.0.1

* SnapshotData bean is contained in EAR/lib/snapshot.jar
* class KinderzuschussKinderServiceImpl gets field of type SnapshotData injected. Contained in EAR/lib/backend.jar
* WAR: index.xhtml uses KinderzuschussKinderServiceImpl to display SnapshotData
* bean UISnapShotData _@Specializes_ SnapshotData. Contained in WAR/WEB-INF/lib/specializes.jar

