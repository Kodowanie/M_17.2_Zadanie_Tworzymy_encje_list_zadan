package hibernate.tasklist;

import hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {
	@Autowired
	private TaskListDao taskListDao;
	private static final String LASTNAME = "Smith";
	private static final String DESCRIPTION = "UK citizen";

	@Test
	void testFindByListName() {
		//given
		TaskList taskList = new TaskList(LASTNAME, DESCRIPTION);
		taskListDao.save(taskList);
		String lastName = taskList.getListName();
		//when
		List<TaskList> readTaskList = taskListDao.findByListName(lastName);
		//then
		assertEquals(1, readTaskList.size());
		//cleanUp
		taskListDao.deleteAll();
	}

}
