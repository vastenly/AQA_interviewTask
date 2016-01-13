package Triangle;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class UnitTest_updated {

	@Test
	public void testRtriangleProviderMethod() {

		Rtriangle tr = RtriangleProvider.getRtriangle();

		Map<Apex,Integer> pMap = new HashMap<Apex,Integer>();
		pMap.put(Apex.AX, tr.getApexX3()-tr.getApexX1());
		pMap.put(Apex.AY, tr.getApexY3()-tr.getApexY1());
		pMap.put(Apex.BX, tr.getApexX2()-tr.getApexX1());
		pMap.put(Apex.BY, tr.getApexY2()-tr.getApexY1());
		pMap.put(Apex.CX, tr.getApexX3()-tr.getApexX2());
		pMap.put(Apex.CY, tr.getApexY3()-tr.getApexY2());
		
		Map<Side,Double> lMap = new HashMap<Side,Double>();
		lMap.put(Side.A, getTriangleSideLength(pMap.get(Apex.AX),pMap.get(Apex.AY)));
		lMap.put(Side.B, getTriangleSideLength(pMap.get(Apex.BX),pMap.get(Apex.BY)));
		lMap.put(Side.C, getTriangleSideLength(pMap.get(Apex.CX),pMap.get(Apex.CY)));
		
		assertTrue("Validate is triangle", validateIsTriangle(lMap));	
		assertTrue("Validate is right triangle", validateIsRightTriangle(lMap, pMap));
	}

	public double getTriangleSideLength(Integer lx, Integer ly) {
		return Math.abs(Math.sqrt(Math.pow(lx,2) + Math.pow(ly,2)));
	}
	
	public boolean validateIsTriangle(Map<Side,Double> lMap) {
		return (lMap.get(Side.A)<(lMap.get(Side.B)+lMap.get(Side.C)) && lMap.get(Side.B)<(lMap.get(Side.A)+lMap.get(Side.C)) 
				&& lMap.get(Side.C)<(lMap.get(Side.A)+lMap.get(Side.B))) ? true : false;
	}
	
	public boolean validateIsRightTriangle(Map<Side,Double> lMap, Map<Apex,Integer> pMap) {
		int vectorScalarProduct = 1;
		if (lMap.get(Side.A)>lMap.get(Side.B) && lMap.get(Side.A)>lMap.get(Side.C))			
			vectorScalarProduct = pMap.get(Apex.BX) * pMap.get(Apex.CX) + pMap.get(Apex.BY) * pMap.get(Apex.CY);
		else if (lMap.get(Side.B)>lMap.get(Side.C) && lMap.get(Side.B)>lMap.get(Side.A))
			vectorScalarProduct = pMap.get(Apex.AX) * pMap.get(Apex.CX) + pMap.get(Apex.AY) * pMap.get(Apex.CY);
		else // C>A,B
			vectorScalarProduct = pMap.get(Apex.AX) * pMap.get(Apex.BX) + pMap.get(Apex.AY) * pMap.get(Apex.BY);
		
		System.out.println("vectorScalarProduct "+vectorScalarProduct);
		return (vectorScalarProduct==0) ? true : false;		
	}
	
	 enum Apex {
		AX,
		AY,
		BX,
		BY,
		CX,
		CY;
	}
	 
	 enum Side {
		A,
		B,
		C;
	 }
}