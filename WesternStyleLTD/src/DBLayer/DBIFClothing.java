package DBLayer;

import modelLayer.Clothing;

public interface DBIFClothing {

	public int insertClothing(Clothing clo);
	public Clothing findClothing(int pid) ;
	public int updateClothing(Clothing clo);
	public int removeClothing (Clothing clo);
}
