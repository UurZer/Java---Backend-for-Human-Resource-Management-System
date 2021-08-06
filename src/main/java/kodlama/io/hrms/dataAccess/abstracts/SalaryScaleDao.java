package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SalaryScale;

public interface SalaryScaleDao extends JpaRepository<SalaryScale, Integer>{
}
