import java.io.*;
import java.util.*;

public class DataSet
{
	public ArrayList<Point> data = new ArrayList<Point>();
	public ArrayList<Point3D> data3 = new ArrayList<Point3D>();

	public DataSet(ArrayList<Point> a)
	{
		data =a;
	}

	public DataSet(ArrayList<Point> a,int p1, int p2)
	{
		this();
		for(int i=p1;i<=p2;i++)
			if(i>=0&&i<a.size())
				data.add(a.get(i));

	}

	public DataSet()
	{
		data= new ArrayList<Point>();
		data3= new ArrayList<Point3D>();
	}

	public ArrayList<Point> getData()
	{
		return data;
	}

	public void setData(ArrayList<Point> a)
	{
		data=a;
	}

	public double minY()
	{
		double temp=data.get(0).getY();
		for(int i=0;i<data.size();i++)
			if(temp>data.get(i).getY()&&data.get(i).getY()!=Double.NaN&&data.get(i).getY()!=Double.POSITIVE_INFINITY&&data.get(i).getY()!=Double.NEGATIVE_INFINITY)
				temp=data.get(i).getY();

		return temp;
	}

	public double maxY()
	{
		double temp=data.get(0).getY();
		for(int i=0;i<data.size();i++)
			if(temp<data.get(i).getY()&&data.get(i).getY()!=Double.NaN&&data.get(i).getY()!=Double.POSITIVE_INFINITY&&data.get(i).getY()!=Double.NEGATIVE_INFINITY)
				temp=data.get(i).getY();

		return temp;
	}

	public int minYI()
	{
		int index=0;
		double temp=data.get(0).getY();
		for(int i=0;i<data.size();i++)
			if(temp>data.get(i).getY()&&data.get(i).getY()!=Double.NaN&&data.get(i).getY()!=Double.POSITIVE_INFINITY&&data.get(i).getY()!=Double.NEGATIVE_INFINITY)
			{
				temp=data.get(i).getY();
				index=i;
			}


		return index;
	}

	public int maxYI()
	{
		int index=0;
		double temp=data.get(0).getY();
		for(int i=0;i<data.size();i++)
			if(temp<data.get(i).getY()&&data.get(i).getY()!=Double.NaN&&data.get(i).getY()!=Double.POSITIVE_INFINITY&&data.get(i).getY()!=Double.NEGATIVE_INFINITY)
			{
				temp=data.get(i).getY();
				index=i;
			}


		return index;
	}




	public double minX()
	{
		double temp=data.get(0).getX();
		for(int i=0;i<data.size();i++)
			if(temp>data.get(i).getX()&&data.get(i).getX()!=Double.NaN&&data.get(i).getX()!=Double.POSITIVE_INFINITY&&data.get(i).getX()!=Double.NEGATIVE_INFINITY)
				temp=data.get(i).getX();

		return temp;
	}

	public double maxX()
	{
		double temp=data.get(0).getX();
		for(int i=0;i<data.size();i++)
			if(temp<data.get(i).getX()&&data.get(i).getX()!=Double.NaN&&data.get(i).getX()!=Double.POSITIVE_INFINITY&&data.get(i).getX()!=Double.NEGATIVE_INFINITY)
				temp=data.get(i).getX();

		return temp;
	}

	public int minXI()
	{
		int index=0;
		double temp=data.get(0).getX();
		for(int i=0;i<data.size();i++)
			if(temp>data.get(i).getX()&&data.get(i).getX()!=Double.NaN&&data.get(i).getX()!=Double.POSITIVE_INFINITY&&data.get(i).getX()!=Double.NEGATIVE_INFINITY)
			{
				temp=data.get(i).getX();
				index=i;
			}


		return index;
	}

	public int maxXI()
	{
		int index=0;
		double temp=data.get(0).getX();
		for(int i=0;i<data.size();i++)
			if(temp<data.get(i).getX()&&data.get(i).getX()!=Double.NaN&&data.get(i).getX()!=Double.POSITIVE_INFINITY&&data.get(i).getX()!=Double.NEGATIVE_INFINITY)
			{
				temp=data.get(i).getX();
				index=i;
			}


		return index;
	}

	public double avgY()
	{
		int num=data.size();
		double out=0;
		for(int i=0;i<data.size();i++)
			if(!(data.get(i).getY()!=Double.NaN&&data.get(i).getY()!=Double.POSITIVE_INFINITY&&data.get(i).getY()!=Double.NEGATIVE_INFINITY))
				num--;
		for(int i=0;i<data.size();i++)
			if(data.get(i).getY()!=Double.NaN&&data.get(i).getY()!=Double.POSITIVE_INFINITY&&data.get(i).getY()!=Double.NEGATIVE_INFINITY)
				out+=data.get(i).y/num;
		return out;

	}

	public double avgYInRange(int p1, int p2)
	{
		int count=0;
		double avg=0;
		for(int i=p1;i<=p2;i++)
			if(i>=0&&i<data.size())
			{
				count++;
				avg+=data.get(i).y;
			}
		return avg/count;
	}
	public double avgYInRangeExcluding(int p1, int p2, int exclude)
	{
		int count=0;
		double avg=0;
		for(int i=p1;i<=p2;i++)
			if(i>=0&&i<data.size()&&i!=exclude)
			{
				count++;
				avg+=data.get(i).y;
			}
		return avg/count;
	}

	public int maxPointInRange(int p1, int p2)
	{
		double max=Double.MIN_VALUE;
		int maxIndex=0;
		for(int i=p1;i<=p2;i++)
		{
			if(i>=0&&i<data.size()&&data.get(i).y>max)
			{
				max=data.get(i).y;
				maxIndex=i;
			}
		}
		return maxIndex;
	}

	public double minYInRange(int p1, int p2)
	{
		double min=Double.MIN_VALUE;
		for(int i=p1;i<=p2;i++)
			if(i>=0&&i<data.size())
				min=Math.min(min,data.get(i).y);
		return min;
	}
	public Point minYPointInRange(int p1, int p2)
	{
		double min=Double.MIN_VALUE;
		int index=-1;
		for(int i=p1;i<=p2;i++)
			if(i>=0&&i<data.size()) {
				index=i;
				min=Math.min(min,data.get(i).y);
			}
		return data.get(index);
	}
	public void scaleY(double s)
	{
		for(Point p : data)
			p.y*=s;
	}
	public void copyData(ArrayList<Point> pts)
	{
		data=new ArrayList<Point>();
		if(pts==null) {
			data=null;
			return;
		}
		for(Point p : pts)
			data.add(new Point(p.x,p.y));
	}
	public void copyData(ArrayList<Point> pts,int r1, int r2)
	{
		data=new ArrayList<Point>();
		if(r1>r2)
		{
			int temp=r1;
			r1=r2;
			r2=temp;
		}
		for(int i=r1;i<r2;i++)
			if(i>=0&&i<pts.size())
				data.add(new Point(pts.get(i).x,pts.get(i).y));
	}
	public void copyYData(ArrayList<Point> pts)
	{
		data=new ArrayList<Point>();
		int count=0;
		for(Point p : pts) {
			data.add(new Point(count,p.y));
			count++;
		}
	}

	public double rangeX()
	{
		return maxX()-minX();
	}

	public double rangeY()
	{
		return maxY()-minY();
	}

	public void add(Point a)
	{
		data.add(a);
	}
	public double integrate()
	{
		double out=0;
		for(int i=1;i<data.size();i++)
			out+=(data.get(i).x-data.get(i-1).x)*(data.get(i).y+data.get(i-1).y)/2;
		return out;
	}
	public double integrate(int xp)
	{
		double out=0;
		for(int i=1;i<xp;i++)
			out+=(data.get(i).x-data.get(i-1).x)*(data.get(i).y+data.get(i-1).y)/2;
		return out;
	}
	public double simpIntegrate()
	{
		double out=0;
		for(int i=0;i<data.size();i++)
		{
			double fx=data.get(i).y;
			if(i==0||i==data.size()-1)
				out+=fx;
			else if(i%2==0)
				out+=4*fx;
			else if(i%2==1)
				out+=2*fx;
		}
		out*=(data.get(1).x-data.get(0).x)/(3);
		return out;
	}
	public double simpIntegrate(int a, int b)
	{
		double out=0;
		int multiplier=1;
		if(a==b)
			return 0;
		if(a>b)
		{
			int c=b;
			b=a;
			a=c;
			multiplier=-1;
		}
		for(int i=a;i<=b;i++)
		{
			double fx=data.get(i).y;
			if(i==0||i==data.size()-1)
				out+=fx;
			else if(i%2==0)
				out+=4*fx;
			else if(i%2==1)
				out+=2*fx;
		}
		out*=(data.get(1).x-data.get(0).x)/(3);
		return out*multiplier;
	}
	public double simpIntegrate(double a, double b)
	{
		return simpIntegrate(getIndexAt(a),getIndexAt(b));
	}
	public DataSet getIntegral()
	{
		ArrayList<Point> out=new ArrayList<Point>();
		for(int i=1;i<data.size();i++)
			out.add(new Point(data.get(i).x,integrate(i)));
		return new DataSet(out);
	}
	public DataSet getDerivative()
	{
		ArrayList<Point> out=new ArrayList<Point>();
		for(int i=1;i<data.size();i++)
			out.add(new Point(data.get(i).x,(data.get(i).y-data.get(i-1).y)/(data.get(i).x-data.get(i-1).x)));
		return new DataSet(out);
	}
	public DataSet getSpectrum()
	{
		ArrayList<Point> points = data;
		int numHarmonics=data.size()/4;
		double period=rangeX();

		ArrayList<Point> out = new ArrayList<Point>();
		for(double i=1;i<numHarmonics;i+=1)
		{
			ArrayList<Point> a = new ArrayList<Point>();
			ArrayList<Point> b = new ArrayList<Point>();
			for(Point pt : points)
			{
				double w=Math.PI*2/period;
				a.add(new Point(pt.x,pt.y*Math.cos(i*w*pt.x)));
				b.add(new Point(pt.x,pt.y*Math.sin(i*w*pt.x)));
			}
			double an=(new DataSet(a)).simpIntegrate(),bn=(new DataSet(b)).simpIntegrate();
			out.add(new Point(out.size(),an));
			out.add(new Point(out.size(),bn));
		}
		return new DataSet(out);

	}
	public DataSet getSpectrum(int s, int e)
	{
		ArrayList<Point> points = data;
		int numHarmonics=e;
		double period=0;

		period=points.get(points.size()-1).x-points.get(0).x;

		ArrayList<Point> out = new ArrayList<Point>();
		for(double i=s;i<numHarmonics;i+=1)
		{
			ArrayList<Point> a = new ArrayList<Point>();
			ArrayList<Point> b = new ArrayList<Point>();
			for(Point pt : points)
			{
				double w=Math.PI*2/period;
				a.add(new Point(pt.x,pt.y*Math.cos(i*w*pt.x)));
				b.add(new Point(pt.x,pt.y*Math.sin(i*w*pt.x)));
			}
			double an=(new DataSet(a)).integrate(),bn=(new DataSet(b)).integrate();
			out.add(new Point(i,an+bn));
		}
		return new DataSet(out);

	}
	public int getIndexAt(double xPos)
	{
	  double min=Double.MAX_VALUE;
	  int ind=-1;
	  for(int i=0;i<data.size();i++)
	  {
	    double dist=Math.abs(data.get(i).x-xPos);
	    if(dist<min)
	    {
	      min=dist;
	      ind=i;
	    }
	  }
	  return ind;
	}
	public double interpolate(double xPoint)
	{
	  int closest1=-1,closest2=-1;
	  double min1=Double.MAX_VALUE,min2=Double.MAX_VALUE;
	  for(int i=0;i<data.size();i++)
	  {
	  	double dist=Math.abs(data.get(i).x-xPoint);
	  	if(min1>dist) {
	  		min2=min1;
	  		min1=dist;
	  		closest2=closest1;
	  		closest1=i;
	  	}
	  	else if(min2>dist) {
	  		min2=dist;
	  		closest2=i;
	  	}
	  }
	  return data.get(closest1).y+(data.get(closest2).y-data.get(closest1).y)/(data.get(closest2).x-data.get(closest1).x)*(xPoint-data.get(closest1).x);
	}

	public Point linearRegression()
	{
		double sumX=0,sumY=0,sumXY=0,sumXSqr=0;
		for(Point p : data)
		{
			sumX+=p.x;
			sumY+=p.y;
			sumXY+=p.x*p.y;
			sumXSqr+=p.x*p.x;
		}
		double n=data.size();
		double m=(n*sumXY-sumX*sumY)/(n*sumXSqr-sumX*sumX);
		double b=(sumY-m*sumX)/n;
		return new Point(m,b);
	}

	public Point3D quadraticRegression()
	{
		Point lR=getDerivative2().linearRegression();
		double a=lR.x/2,b=lR.y;
		double sum=0;
		for(Point p : data)
		{
			sum+=p.y-a*p.x*p.x-b*p.x;
		}
		sum/=data.size();
		return new Point3D(a,b,sum);
	}

	public DataSet getDerivative2()
	{
		ArrayList<Point> out = new ArrayList<Point>();
		for(int i=1;i<data.size()-1;i++)
		{
			out.add(new Point(data.get(i).x,(data.get(i+1).y-data.get(i-1).y)/(data.get(i+1).x-data.get(i-1).x)));
		}
		return new DataSet(out);
	}
	public DataSet convolve(DataSet d)
	{
		ArrayList<Point> out = new ArrayList<Point>();
		for(int i=0;i<data.size()+d.data.size()-1;i++)
		{
			double sum=0;
			for(int j=0;j<d.data.size();j++)
			{
				if(i-j>=0&&i-j<data.size())
					sum+=d.data.get(j).y*data.get(i-j).y;
			}
			out.add(new Point(i,sum));

		}
		return new DataSet(out);
	}
	public Matrix deConvolve(DataSet d)
	{
		Matrix out = d.getConvolutionMatrix1(data.size()+1-d.data.size()).inverse().multiply(getColMatrixY());
		return out;
	}
	public Matrix getConvolutionMatrix1(int len)
	{
		int size=data.size()+len-1;
		double [][] mat = new double[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<data.size();j++)
			{
				if(i-j>=0)
				{
					mat[i][i-j]=data.get(j).y;
				}
			}
		}
		return new Matrix(mat);
	}
	public Matrix getColMatrixY()
	{
		double [][] out = new double[data.size()][1];
		for(int i=0;i<data.size();i++)
			out[i][0]=data.get(i).y;
		return new Matrix(out);
	}
	public Polynomial fitPolynomial(int order)
	{
		double [][] x = new double[data.size()][order+1];
		double [][] y = new double[data.size()][1];
		for(int i=0;i<data.size();i++)
		{
			for(int j=0;j<=order;j++)
			{
				x[i][j]=Math.pow(data.get(i).x,j);
			}
			y[i][0]=data.get(i).y;
		}

		Matrix X = new Matrix(x),Y=new Matrix(y),XT=X.transpose(), beta=(XT.multiply(X)).inverse().multiply(XT).multiply(Y);
		double [] coeff= new double[order+1];
		for(int i=0;i<=order;i++)
			coeff[i]=beta.data[i][0];
		return new Polynomial(coeff);
	}
	public ArrayList<Double> fitGaussianSeries(ArrayList<Double> cent, ArrayList<Double> width)
	{
		double [][] x = new double[data.size()][cent.size()];
		double [][] y = new double[data.size()][1];
		for(int i=0;i<data.size();i++)
		{
			for(int j=0;j<cent.size();j++)
			{
				x[i][j]=Math.exp(-width.get(j)*Math.pow(data.get(i).x-cent.get(j),2));
			}
			y[i][0]=data.get(i).y;
		}

		Matrix X = new Matrix(x),Y=new Matrix(y),XT=X.transpose(), beta=(XT.multiply(X)).inverse().multiply(XT).multiply(Y);
		ArrayList<Double> out= new ArrayList<Double>();
		for(int i=0;i<cent.size();i++)
			out.add(beta.data[i][0]);
		return out;
	}
	public DataSet gaussianSmooth(int numGaussians)
	{
		double maxX=maxX(),minX=minX(),step=(maxX-minX)/numGaussians;
		ArrayList<Double> cents= new ArrayList<Double>(), widths=new ArrayList<Double>();
		for(double i=minX;i<=maxX+step/100;i+=step)
		{
			cents.add(i);
			widths.add(2.0/Math.sqrt(2*step));
		}
		ArrayList<Double> coeff = fitGaussianSeries(cents,widths);
		ArrayList<Point> outDat=new ArrayList<Point>();
		for(Point pt : data)
		{
			double sum=0;
			for(int i=0;i<coeff.size();i++)
			{
				sum+=coeff.get(i)*Math.exp(-widths.get(i)*Math.pow(pt.x-cents.get(i),2));
			}

			outDat.add(new Point(pt.x,sum));
		}
		return new DataSet(outDat);
	}
	public double getFitDerivative(double x, int numPoints, int order)
	{
		int index=getIndexAt(x);
		ArrayList<Point> sample=new ArrayList<Point>();
		for(int i=index-numPoints;i<=index+numPoints;i++)
		{
			if(i<0||i>=data.size())
				continue;
			sample.add(data.get(i));
		}
		return ((new DataSet(sample)).fitPolynomial(order)).differentiate().val(x);
	}
	public DataSet fitDerivative(int numPoints,int polyOrder)
	{
		ArrayList<Point> out= new ArrayList<Point>();
		for(Point pt: data)
			out.add(new Point(pt.x,getFitDerivative(pt.x,numPoints,polyOrder)));
		return new DataSet(out);
	}
	public ArrayList<Double> findZeros()
	{
		return findZeros(100);
	}
	public ArrayList<Double> findZeros(int numPossible)
	{
		int numContinuous=data.size()/numPossible;
		int contCount=0;
		double rangeY=rangeY();
		ArrayList<DataSet> samples = new ArrayList<DataSet>();
		ArrayList<Point> sample= new ArrayList<Point>();
		for(int i=0;i<data.size();i++)
		{
			if(Math.abs(data.get(i).y)<rangeY/50)
			{
				sample.add(data.get(i));
				contCount=0;
			}
			else if(contCount>numContinuous&&sample.size()>0) {
				contCount++;
					samples.add(new DataSet(sample));
				sample=new ArrayList<Point>();
			}
			else
				contCount++;
		}
		ArrayList<Double> out= new ArrayList<Double>();
		for(DataSet dat: samples)
		{
			out.add(dat.fitPolynomial(1).linearRoot());
		}
		return out;
	}
	public double findZeroNewton(double guess, int iterations)
	{
		double xOut=guess;
		for(int i=0;i<iterations;i++)
		{
			double m=getFitDerivative(xOut,data.size()/5,2);
			double yVal=interpolate(xOut);
			xOut=xOut-yVal/m;
		}
		return xOut;
	}
	public double findSinglePeak()
	{
		DataSet smooth=gaussianSmooth(15);
//   		ArrayList<Double> zeros=smooth.fitDerivative(data.size()/10,1).gaussianSmooth(15).findZeros(30);
//   		double max=Double.MIN_VALUE,xOut=data.get(0).x;
		return smooth.fitDerivative(data.size()/5,2).gaussianSmooth(10).findZeroNewton(data.get(maxYI()).x,20);
   		/*double max=Double.MIN_VALUE,xOut=data.get(0).x;
   		for(Double dbl : zeros)
   		{
   			double val=interpolate(dbl);
   			if(max<val) {
   				max=val;
   				xOut=dbl;
   			}
   		}
   		return xOut;*/
	}
	public double getScale(DataSet reference)
	{
		double [][] a= new double[data.size()][1], b= new double[data.size()][1];
		double sum1=0, sum2=0;
		for(int i=0;i<data.size();i++) {
			double refVal=	reference.interpolate(data.get(i).x);
			sum1+=refVal*data.get(i).y;
			sum2+=refVal*refVal;
		}
		return sum1/sum2;
	}

}