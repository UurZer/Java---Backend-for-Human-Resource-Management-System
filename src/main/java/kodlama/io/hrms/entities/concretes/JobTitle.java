package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_titles")
@AllArgsConstructor
@NoArgsConstructor
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="title_id")
	private int title_id;

	@Column(name="title_name")
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}
}
