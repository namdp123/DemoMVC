package view;

import java.util.Scanner;

import controller.EmployeeController;
import object.Employee;

public class EmployeeView {
	private Employee valueObject;
	 private EmployeeController controller;
	 Scanner s;

	 public EmployeeView() {
	   controller = new EmployeeController();
	   valueObject = new Employee();
	   s = new Scanner(System.in);
	 }

	 public void createEmployee() {
	   System.out.print("Nhap ma so nhan vien: ");
	   valueObject.setMaSo(s.nextLine());
	 
	   System.out.print("Nhap ho ten nhan vien: ");
	   valueObject.setHoTen(s.nextLine());

	   System.out.print("Nhap gioi tinh: ");
	   valueObject.setGioiTinh(s.nextLine());

	   System.out.print("Nhap ngay sinh: ");
	   valueObject.setNgaySinh(s.nextLine());

	   System.out.print("Nhap dia chi: ");
	   valueObject.setDiaChi(s.nextLine());
	   int cnt = controller.insertEmployee(valueObject);
	   if (cnt != 0) {
	     System.out.println("Them thanh cong!");
	   } else {
	     System.out.println("Khong the them!");
	   }
	 }

	 public void printEmployeeDetails() {
	   System.out.print("Nhap ma so tim kiem: ");
	   String ms = s.nextLine();
	   valueObject.setMaSo(ms);

	   Employee emp = controller.displayEmployee(valueObject);
	   if (emp != null) {
	     System.out.println(emp);
	   } else {
	   System.out.println("Khong tim thay!");
	  }
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		   int choice;
		   EmployeeView view = new EmployeeView();

		   do {
		     System.out.println(" 1. Tao nhan vien");
		     System.out.println(" 2. Show danh sach nhan vien");
		     System.out.println(" 3. Thoat");

		     System.out.print("Vui long nhap lua chon: ");
		     choice = s.nextInt();

		     //clear buffer
		     s.nextLine();

		     switch (choice) {
		       case 1:
		         view.createEmployee();
		         break;
		       case 2:
		         view.printEmployeeDetails();
		         break;
		     }
		   } while (choice != 3);


	}

}
