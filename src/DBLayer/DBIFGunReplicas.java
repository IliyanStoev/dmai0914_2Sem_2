package DBLayer;

import modelLayer.GunReplicas;

public interface DBIFGunReplicas {

	public int insertGunReplicas(GunReplicas gr);
	public GunReplicas findGunReplicas(int pid) ;
	public int updateGunReplicas(GunReplicas gr);
	public int removeGunReplicas (GunReplicas gr);
}
