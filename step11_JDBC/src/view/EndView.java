package view;

import java.util.ArrayList;

import model.domain.Emp01DTO;

public class EndView {

	public static void failMsg(String message) {
		System.out.println("발생된 이슈 : " + message);
	}

	public static void SuccessMsg(String message) {
		System.out.println(message);
	}

	public static void allEmpView(ArrayList<Emp01DTO> all) {
		System.out.println("사번" + "\t" + "이름" + "\t" + "월급" + "\t" + "연봉");
		for (Emp01DTO a : all) {
			System.out.println(a.getEmpno() + "\t" + a.getEname() + "\t" + a.getSal() + "\t" + a.getT_sal());
		}
	}

	public static void empView(Emp01DTO en) {
		System.out.println("사번" + "\t" + "이름" + "\t" + "월급" + "\t" + "연봉");
		System.out.println(en.getEmpno() + "\t" + en.getEname() + "\t" + en.getSal() + "\t" + en.getT_sal());
	}

}
