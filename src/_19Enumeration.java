public class _19Enumeration {

	public static void main(String[] args) {
		System.out.println(GeoLevels.CELL.getTableName());
	}
}

enum BooleanType{
	TRUE(1),
	FALSE(0);

	private int value;
	
	private BooleanType(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}
}


enum GeoLevels{
	
	CELL("PmDailyCellKPIData"),
	BAND("PmDailyBandKPIData"),
	SECTOR("PmDailySectorKPIData"),
	SAPID(""),
	JC("PmDailyJCKPIData"),
	CIRCLE("PmDailyCircleKPIData");
	
	private String tableName;

	private GeoLevels(String tableName) {
		this.tableName = tableName;
	}
	public String getTableName() {
		return tableName;
	}
}