package dmacc.beans;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Apr 19, 2023
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todo")
public class ToDoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String itemName;
	private String itemDetails;
	private int estimatedHours;
	private String createdDate;
	private String dueDate;
}
