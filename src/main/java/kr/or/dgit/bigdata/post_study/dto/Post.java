package kr.or.dgit.bigdata.post_study.dto;

public class Post {
	/* FIELDS */
	private String zipcode;
	private String sido;
	private String sigungu;
	private String doro;
	private int building1;
	private int building2;
	/* CONSTRUCTOR */
	public Post() {}
	
	public Post(String sido) {
		super();
		this.sido = sido;
	}

	public Post(String zipcode, String sido, String sigungu, String doro, int building1, int building2) {
		super();
		this.zipcode = zipcode;
		this.sido = sido;
		this.sigungu = sigungu;
		this.doro = doro;
		this.building1 = building1;
		this.building2 = building2;
	}
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

	public int getBuilding2() {
		return building2;
	}

	public void setBuilding2(int building2) {
		this.building2 = building2;
	}
	/* METHOD */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + building1;
		result = prime * result + building2;
		result = prime * result + ((doro == null) ? 0 : doro.hashCode());
		result = prime * result + ((sido == null) ? 0 : sido.hashCode());
		result = prime * result + ((sigungu == null) ? 0 : sigungu.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (building1 != other.building1)
			return false;
		if (building2 != other.building2)
			return false;
		if (doro == null) {
			if (other.doro != null)
				return false;
		} else if (!doro.equals(other.doro))
			return false;
		if (sido == null) {
			if (other.sido != null)
				return false;
		} else if (!sido.equals(other.sido))
			return false;
		if (sigungu == null) {
			if (other.sigungu != null)
				return false;
		} else if (!sigungu.equals(other.sigungu))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

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
}
