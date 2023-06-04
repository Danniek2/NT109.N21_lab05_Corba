package Client;

import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import exampleApp.tp;
import exampleApp.tpHelper;


public class client {

	
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args,null);
			org.omg.CORBA.Object object = orb.resolve_initial_references("NameService");
			NamingContext namingcontext=NamingContextHelper.narrow(object);
			NameComponent nameComp = new NameComponent("Hello","");
			NameComponent[] path = {nameComp};
			object = namingcontext.resolve(path);
			tp tpRef = tpHelper.narrow(object);			
			System.out.print(tpRef.add(1, 2));
		}catch(Exception e) {
			System.out.println("Client error ");
			e.printStackTrace();
		}
	}
}