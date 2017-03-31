public class Point3D
{
	public double x;
	public double y;
	public double z;

	public Point3D(double a, double b, double c)
	{
		x=a;
		y=b;
		z=c;
	}

	public boolean isSameAs(Point3D p)
	{
		return p.x==x&&p.y==y&&p.z==z;
	}

	public String toString()
	{
		return "("+x+","+y+","+z+")";
	}
}