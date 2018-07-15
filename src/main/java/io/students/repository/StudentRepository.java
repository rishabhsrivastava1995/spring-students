package io.students.repository;

import io.students.Student;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository <Student, Integer> {
	
	@Query(value = "SELECT * from student " +
			"WHERE admissionYear >= :admissionYearAfter "+
			"AND admissionYear <= :admissionYearBefore "+
			"AND active IN (:actives) "+
			"AND class IN (:classes)", nativeQuery = true)
	public Page<Student> findWithClasses(@Param("admissionYearAfter") Integer admissionYearAfter, 
			@Param("admissionYearBefore") Integer admissionYearBefore,
			@Param("actives") List<Boolean> actives, @Param("classes") List<Integer> classes , Pageable pageable);
	
	@Query(value = "SELECT * from student " +
			"WHERE admissionYear >= :admissionYearAfter "+
			"AND admissionYear <= :admissionYearBefore "+
			"AND active IN (:actives)",nativeQuery = true)
	public Page<Student> findWithoutClasses(@Param("admissionYearAfter") Integer admissionYearAfter, 
			@Param("admissionYearBefore") Integer admissionYearBefore,
			@Param("actives") List<Boolean> actives, Pageable pageable);
}
