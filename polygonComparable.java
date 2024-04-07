import java.awt.Dimension;
import java.awt.Polygon;
import java.util.Arrays;

public class polygonComparable<T extends Comparable<T>> extends Polygon implements Comparable {
	Polygon p1;
	double area;

	public polygonComparable() {

	}

	public int compareTo(Object o) {
		double nThisArea = this.getArea();
		polygonComparable oo = (polygonComparable) o;
		double nThisArea2 = oo.getArea();
		if (nThisArea > nThisArea2) {
			return 1;
		} else if (nThisArea < nThisArea2) {
			return -1;
		} else {
			if (sameCoordinates(this, oo))
				return 0;

			else
				return -2;
			// -2 when the areas are equal but diff coordinates
		}
	}
	
	public int compareToArea(Object o) {
		double nThisArea = this.getArea();
		polygonComparable oo = (polygonComparable) o;
		double nThisArea2 = oo.getArea();
		if (nThisArea > nThisArea2) {
			return 1;
		} else if (nThisArea < nThisArea2) {
			return -1;
		} else {
			return 0;
			// -2 when the areas are equal but diff coordinates
		}
	}

	public void setPoly(Polygon p) {
		this.p1 = p;

		area = this.calculatePolygonArea(p);
	}

	public double getArea() {
		return area;
	}

	public Polygon getPoly(polygonComparable e) {
		return e.p1;
	}

	public boolean sameCoordinates(polygonComparable pc1, polygonComparable pc2) {

		Polygon p1 = pc1.getPoly(pc1);
		Polygon p2 = pc2.getPoly(pc2);
		
		Arrays.sort(p1.xpoints); 
		Arrays.sort(p1.ypoints); 
		Arrays.sort(p2.xpoints); 
		Arrays.sort(p2.ypoints); 


		if (p1.npoints != p2.npoints) {
			return false;
		}
		if (!Arrays.equals(p1.xpoints, p2.xpoints)) {
			return false;
		}
		if (!Arrays.equals(p1.ypoints, p2.ypoints)) {
			return false;
		}
		return true;
	}

	public double calculatePolygonArea(Polygon p1) {
		Dimension dim1 = p1.getBounds().getSize();
		return dim1.width * dim1.height;
	}

	public String toString() {// overriding the toString() method

		return "Area = " + area + " ";

	}

	public static void main(String[] args) {
		Polygon a = new Polygon();
		a.addPoint(1, 2);
		a.addPoint(2, 3);
		a.addPoint(4, 5);

		Polygon b = new Polygon();
		b.addPoint(0, 0);
		b.addPoint(3, 3);
		b.addPoint(33, 5);
		Polygon c = new Polygon();
		c.addPoint(3, 3);
		c.addPoint(33, 5);
		c.addPoint(0, 0);
		polygonComparable a1 = new polygonComparable();
		a1.setPoly(a);

		
		
//		a1.setPoly(a);
		polygonComparable b1 = new polygonComparable();
		b1.setPoly(b);
//		b1.setPoly(b);
		polygonComparable c1 = new polygonComparable();
		c1.setPoly(c);
//		System.out.println(a1.compareTo(b1));
//		System.out.println(a1.compareTo(c1));
//		System.out.println(b1.compareTo(c1));
		System.out.println(b1.sameCoordinates(b1,a1));

	}

}
