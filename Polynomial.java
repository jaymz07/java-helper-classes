import java.io.*;
import java.util.*;

public class Polynomial
{
	public double [] coeff;

	public Polynomial(double [] c)
	{
		coeff=c;
	}

	public double val(double x)
	{
		double out=0;
		for(int i=0;i<coeff.length;i++)
			out+=coeff[i]*Math.pow(x,i);
		return out;
	}

	public Polynomial differentiate()
	{
		if(coeff.length<=1)
			return null;
		double [] out = new double[coeff.length-1];
		for(int i=1;i<coeff.length;i++)
			out[i-1]=i*coeff[i];
		return new Polynomial(out);
	}
	public Polynomial integrate()
	{
		double [] out= new double[coeff.length+1];
		for(int i=0;i<coeff.length;i++)
			out[i+1]=coeff[i]/(i+1);
		return new Polynomial(out);
	}
	public double defIntegral(double a, double b)
	{
		Polynomial integral=integrate();
		return integral.val(b)-integral.val(a);
	}
	public Polynomial times(Polynomial p)
	{
		double [] out = new double[coeff.length+p.coeff.length-1];
		for(int i=0;i<coeff.length;i++)
			for(int j=0;j<p.coeff.length;j++)
				out[i+j]+=coeff[i]*p.coeff[j];
		return new Polynomial(out);
	}
	public double getRoot(double startX)
	{
		Polynomial deriv = differentiate();
		double x=startX;
		for(int i=0;i<100;i++)
		{
			double m=deriv.val(x);
			x=x-val(x)/m;
		}
		return x;
	}
	public double linearRoot()
	{
		return -coeff[0]/coeff[1];
	}
	public ArrayList<Double> roots()
	{
		double delta=0.01;

		ArrayList<Polynomial> derivs = new ArrayList<Polynomial>();
		derivs.add(differentiate());
		for(int i=1;i<coeff.length-2;i++)
			derivs.add(derivs.get(i-1).differentiate());
		ArrayList<Double> crits= new ArrayList<Double>(),allCrits=new ArrayList<Double>();
		crits.add(derivs.get(derivs.size()-1).linearRoot());
		for(int i=derivs.size()-1;i>=0;i--)
		{
			ArrayList<Double> newCrits = new ArrayList<Double>();
			for(Double crit: crits)
			{
				allCrits.add(crit);
				newCrits.add(derivs.get(i).getRoot(crit+delta));
				newCrits.add(derivs.get(i).getRoot(crit-delta));
			}
			crits=newCrits;
		}
		ArrayList<Double> roots = new ArrayList<Double>();
		for(Double crit: crits)
		{
			allCrits.add(crit);
			roots.add(getRoot(crit+delta));
			roots.add(getRoot(crit-delta));
		}
		for(double c : allCrits)
			if(Math.abs(val(c))<0.0000001)
				roots.add(c);
		//double [] out = new double[roots.size()];
		for(int i=0;i<roots.size();i++)
		{
			for(int j=0;j<i;j++)
				if(Math.abs(roots.get(i)-roots.get(j))<=.00000001)
				{
					roots.remove(i);
					i--;
					break;
				}
		}
		return roots;
		/*for(int i=0;i<roots.size();i++)
			out[i]=roots.get(i);
		return out;*/

	}
	public String toString()
	{
		String out="";
		for(int i=0;i<coeff.length;i++)
		{
			out=out+coeff[i];
			if(i>0)
				out=out+"X^"+i;
			if(i<coeff.length-1)
				out=out+" + ";
		}
		return out;
	}
}