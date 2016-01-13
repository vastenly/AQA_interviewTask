package Triangle;

public class RtriangleProvider implements Rtriangle{

	public static Rtriangle getRtriangle() {
		return new RtriangleProvider();
	}
	
	public int getApexX1() {
		return Constants.ApexX1;
	}

	public int getApexY1() {
		return Constants.ApexY1;
	}

	public int getApexX2() {
		return Constants.ApexX2;
	}

	public int getApexY2() {
		return Constants.ApexY2;
	}

	public int getApexX3() {
		return Constants.ApexX3;
	}

	public int getApexY3() {
		return Constants.ApexY3;
	}
	
}
