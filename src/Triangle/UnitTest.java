package Triangle;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

	@Test
	public void testRtriangleProviderMethod() {

		Rtriangle triangle = RtriangleProvider.getRtriangle();

		//get triangle sides lenth
		Map<Double, String> map = new TreeMap<Double, String>();
		
		int aX31 = (triangle.getApexX3()-triangle.getApexX1());
		int aY31 = (triangle.getApexY3()-triangle.getApexY1());		
		int aX13 = (triangle.getApexX1()-triangle.getApexX3());
		int aY13 = (triangle.getApexY1()-triangle.getApexY3());
		
		int bX21 = (triangle.getApexX2()-triangle.getApexX1());
		int bY21 = (triangle.getApexY2()-triangle.getApexY1());		
		int bX12 = (triangle.getApexX1()-triangle.getApexX2());
		int bY12 = (triangle.getApexY1()-triangle.getApexY2());
		
		int cX32 = (triangle.getApexX3()-triangle.getApexX2());
		int cY32 = (triangle.getApexY3()-triangle.getApexY2());		
		int cX23 = (triangle.getApexX2()-triangle.getApexX3());
		int cY23 = (triangle.getApexY2()-triangle.getApexY3());
		
		map.put(Math.abs(Math.sqrt(Math.pow(aX31,2) + Math.pow(aY31, 2))), TriangleSide.A.getName());
		map.put(Math.abs(Math.sqrt(Math.pow(bX21,2) + Math.pow(bY21, 2))), TriangleSide.B.getName());
		map.put(Math.abs(Math.sqrt(Math.pow(cX32,2) + Math.pow(cY32, 2))), TriangleSide.C.getName());

		//continue with 2 the shortest sides only
		map.remove(((TreeMap<Double, String>) map).lastKey());
		
		List<String> list = new ArrayList<>();
		for (Map.Entry<Double, String> entry : map.entrySet()) {
			list.add(entry.getValue());	
		}
		int vectorsSum = 1;
		if (list.contains(TriangleSide.A.getName()) && list.contains(TriangleSide.B.getName()))			
			vectorsSum = aX31 * bX21 + aY31 * bY21;
		else if (list.contains(TriangleSide.B.getName()) && list.contains(TriangleSide.C.getName()))
			vectorsSum = bX12 * cX32 + bY12 * cY32;
		else // A & C
			vectorsSum = aX13 * cX23 + aY13 * cY23;
				
		assertTrue(vectorsSum==0);
	}
	
	public enum TriangleSide {		
		A ( "a" ),
		B ( "b" ),
		C ( "c" );
	
		private String side;
		
		private TriangleSide(String side) {
			this.side = side;
		}
		
		public String getName(){
			return side;
		}
	}
	
}