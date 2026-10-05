package entities;

import java.util.Date;

public class HouerContract {

		private Date date;
		private Double valuerPerHour;
		private Integer hours;
		
		public HouerContract() {
			
		}
		
		public HouerContract(Date date, Double valuerPerHour, Integer hours) {	
			this.date = date;
			this.valuerPerHour = valuerPerHour;
			this.hours = hours;
		}


		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Double getValuerPerHour() {
			return valuerPerHour;
		}

		public void setValuerPerHour(Double valuerPerHour) {
			this.valuerPerHour = valuerPerHour;
		}

		public Integer getHours() {
			return hours;
		}

		public void setHours(Integer hours) {
			this.hours = hours;
		}			
		
		public double totalValuer() {
			return valuerPerHour * hours;
		}
}




