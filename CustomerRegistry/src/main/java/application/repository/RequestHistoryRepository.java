package application.repository;

import application.domain.RequestHistory;
import org.springframework.data.repository.CrudRepository;


public interface RequestHistoryRepository extends CrudRepository<RequestHistory, Long> {



}
