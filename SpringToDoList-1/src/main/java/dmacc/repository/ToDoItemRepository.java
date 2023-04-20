package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.ToDoItem;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Apr 20, 2023
*/
@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
