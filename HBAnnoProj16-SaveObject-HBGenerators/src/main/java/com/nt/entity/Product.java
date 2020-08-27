//Entity class/ Domain class/model class/Persistent class/POJO class/HLO(hibernate language object) class
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
public class Product implements Serializable {
	 //bean properties
	
	/*@Id
		@GenericGenerator(name="gen1",strategy ="increment")
		@GeneratedValue(generator = "gen1")
	*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy ="identity")
	@GeneratedValue(generator = "gen1")*/
	
	
	/*@Id   --->create sequence with the name "gen1" starting with 1 , increment by 1
	@GenericGenerator(name="gen1",strategy ="sequence")
	@GeneratedValue(generator = "gen1")*/
	
	
	/*@Id
	@GenericGenerator(name="gen1",strategy ="sequence",
	                                           parameters =@Parameter(name="sequence_name",value="PID_SEQ") )
	@GeneratedValue(generator = "gen1")*/

	@Id
	@GenericGenerator(name="gen1",strategy ="seqhilo",
	                                           parameters = {@Parameter(name="sequence_name",value="PID_SEQ"),
	                                                                        @Parameter(name="max_lo", value="5")
	                                                                       }
	                                        )
	@GeneratedValue(generator = "gen1")
	private Integer pid;
	private String pname;
	private Float price;
	private Float qty;
	//setters and getters
	 //alt+shift+s ,r
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getQty() {
		return qty;
	}
	public void setQty(Float qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
