package Server;


import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import exampleApp._tpImplBase;

public class server {
	

	
	public static void main(String[] args) {
		
		try {
			
			ORB orb = ORB.init(args,null);
			ExampleServant servant = new ExampleServant();
			orb.connect((Object) servant);
			org.omg.CORBA.Object object = orb.resolve_initial_references("NameService");
			NamingContext namingContext=NamingContextHelper.narrow(object);
			NameComponent nameComp = new NameComponent("Hello","");
			NameComponent[] path = {nameComp};
			namingContext.rebind(path,servant);
			java.lang.Object syncObj = new java.lang.Object();
			synchronized(syncObj) {
				syncObj.wait();
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	
}

class ExampleServant extends _tpImplBase{

	
	public float add(float a, float b) {
		return a+b;
	}
	public float sub(float a, float b) {
		return a-b;
	}
	public float mul(float a, float b) {
		return a*b;
	}
	public float div(float a, float b) {
		return a/b;
	}
	
	
	
}
