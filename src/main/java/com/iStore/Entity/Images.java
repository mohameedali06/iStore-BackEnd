package com.iStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Images {

	@Id
	@GeneratedValue
	private int imgId;
	private String imgSrc1;
	private String imgSrc2;
	private String imgSrc3;
	private String imgSrc4;
	private String imgSrc5;

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getImgSrc1() {
		return imgSrc1;
	}

	public void setImgSrc1(String imgSrc1) {
		this.imgSrc1 = imgSrc1;
	}

	public String getImgSrc2() {
		return imgSrc2;
	}

	public void setImgSrc2(String imgSrc2) {
		this.imgSrc2 = imgSrc2;
	}

	public String getImgSrc3() {
		return imgSrc3;
	}

	public void setImgSrc3(String imgSrc3) {
		this.imgSrc3 = imgSrc3;
	}

	public String getImgSrc4() {
		return imgSrc4;
	}

	public void setImgSrc4(String imgSrc4) {
		this.imgSrc4 = imgSrc4;
	}

	public String getImgSrc5() {
		return imgSrc5;
	}

	public void setImgSrc5(String imgSrc5) {
		this.imgSrc5 = imgSrc5;
	}

	@Override
	public String toString() {
		return "Images [imgId=" + imgId + ", imgSrc1=" + imgSrc1 + ", imgSrc2=" + imgSrc2 + ", imgSrc3=" + imgSrc3
				+ ", imgSrc4=" + imgSrc4 + ", imgSrc5=" + imgSrc5 + "]";
	}
	
}
