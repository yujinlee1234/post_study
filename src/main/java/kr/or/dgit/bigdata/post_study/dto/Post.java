package kr.or.dgit.bigdata.post_study.dto;

public class Post {
	/* FIELDS */
	private String zipcode;
	private String sido;
	private String sigungu;
	private String doro;
	private int building1;
	private int building2;
	/* GETTER/SETTER */
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public int getBuilding1() {
		return building1;
	}

	public void setBuilding1(int building1) {
		this.building1 = building1;
	}
	수정수정수정수정수정수정
	public int getBuilding2() {
		return building2;
	}

	public void setBuilding2(int building2) {
		this.building2 = building2;
	}
	/* METHOD */
	@Override
	public String toString() {
		if(building2 != 0){
			return String.format("%s | %s %s %s %s-%s", zipcode,
				sido, sigungu, doro, building1, building2);
		}else{
			return String.format("%s | %s %s %s %s", zipcode,
					sido, sigungu, doro, building1);
		}
	}
	public String getAddress(){
		if(building2 != 0){
			return String.format("%s %s %s %s-%s", sido, sigungu, doro, building1, building2);
		}else{
			return String.format("%s %s %s %s", sido, sigungu, doro, building1);
		}
	}
	public String[] toArray(){
		return new String[]{zipcode, getAddress()};
	}
}
