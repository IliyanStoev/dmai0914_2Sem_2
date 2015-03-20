package DBLayer;

import modelLayer.Equipment;

public interface DBIFEquipment {

	public int insertEquipment(Equipment eq);
	public Equipment findEquipment(int pid) ;
	public int updateEquipment(Equipment eq);
	public int removeEquipment (Equipment eq);
}
