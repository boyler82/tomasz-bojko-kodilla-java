package com.kodilla.hiber.task.dao;

import com.kodilla.hiber.task.TaskFinancialDetails;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskFinancialDetailDaoTestSuite {

    @Autowired
    private TaskFinancialDetaliDao taskFinancialDetaliDao;

    @Test
    void testFindByPaid(){
//        given
        TaskFinancialDetails taskFinancialDetails =
        new TaskFinancialDetails(new BigDecimal(115), false);
//        when
        taskFinancialDetaliDao.save(taskFinancialDetails);
        List<TaskFinancialDetails> result = taskFinancialDetaliDao.findByPaid(false);
//        then
        assertEquals(1, result.size());
//        Clear
        int id = taskFinancialDetails.getId();
        taskFinancialDetaliDao.deleteById(id);



    }
}
