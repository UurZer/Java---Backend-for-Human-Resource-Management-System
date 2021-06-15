package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="salary_scale")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class SalaryScale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="scale_id",unique = true)
	private int scaleId;
	
	@Column(name="max",unique = false)
	private String max;
	
	@Column(name="min",unique = false)
	private String min;

	
	@OneToMany(mappedBy = "salaryScale")
	private List<Advertisement> Advertisements;
	
	
	public List<Advertisement> getAdvertisements() {
		return Advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		Advertisements = advertisements;
	}

	public int getScaleId() {
		return scaleId;
	}

	public void setScaleId(int scaleId) {
		this.scaleId = scaleId;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}
}
