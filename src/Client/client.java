package Client;

import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import exampleApp.tp;
import exampleApp.tpHelper;

import java.io.IOException;
import java.util.Scanner;

public class client {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		log n = new log();
		System.out.print("Nhap so thu nhat, a = ");
        int a = client.scanner.nextInt();
        n.Logs("Nhap vao so thu nhat");
        System.out.print("Nhap so thu hai, b = ");
        int b = client.scanner.nextInt();
        n.Logs("Nhap vao so thu hai");
		try {
			ORB orb = ORB.init(args,null);
			org.omg.CORBA.Object object = orb.resolve_initial_references("NameService");
			NamingContext namingcontext=NamingContextHelper.narrow(object);
			NameComponent nameComp = new NameComponent("Hello","");
			NameComponent[] path = {nameComp};
			object = namingcontext.resolve(path);
			tp tpRef = tpHelper.narrow(object);	
			System.out.print("Ket qua phep tinh cong: ");
			System.out.println(tpRef.add(a, b));
			n.Logs("Ket qua cua phep tinh cong 2 so");
			System.out.print("Ket qua phep tinh tru: ");
			System.out.println(tpRef.sub(a, b));
			n.Logs("Ket qua cua phep tinh tru 2 so");
			System.out.print("Ket qua phep tinh nhan: ");
			System.out.println(tpRef.mul(a, b));
			n.Logs("Ket qua cua phep tinh nhan 2 so");
			System.out.print("Ket qua phep tinh chia: ");
			System.out.println(tpRef.div(a, b));
			n.Logs("Ket qua cua phep tinh chia 2 so");
		}catch(Exception e) {
			System.out.println("Client error ");
			e.printStackTrace();
		}
	}
}