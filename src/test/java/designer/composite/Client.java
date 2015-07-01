package designer.composite;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		Branch ceo = initData();
		System.out.println(printInfo(ceo));
	}

	public static Branch initData() {
		Branch ceo = new Branch("w_b", "ceo", 20000);
		Branch devManager = new Branch("t_f", "dev_manage", 12000);
		Branch finalenceManager = new Branch("c_w", "finalence_manage", 1000);
		Leaf mishu = new Leaf("meime", "秘书", 3000);
		Leaf zhao = new Leaf("zhao_l", "开发", 8888);
		Leaf caiwu = new Leaf("cai_kk", "小财务", 999);
		ceo.addSubordinet(devManager);
		ceo.addSubordinet(finalenceManager);
		ceo.addSubordinet(mishu);
		devManager.addSubordinet(zhao);
		finalenceManager.addSubordinet(caiwu);
		return ceo;
	}

	public static String printInfo(Corp corp) {
		String info = "";
		if (corp instanceof Leaf) {
			info = info + corp.getInfo() + "\n";
		} else {
			info = info + corp.getInfo() + "\n";
			List<Corp> corpList = ((Branch) corp).getSubordinet();
			for (Corp temp : corpList) {
				info = info + printInfo(temp);
			}
		}
		return info;
	}

}
