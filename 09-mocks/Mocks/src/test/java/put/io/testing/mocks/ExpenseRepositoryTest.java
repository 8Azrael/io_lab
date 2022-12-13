package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void testLoadExpenses() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        //MyDatabase database = new MyDatabase();
        //ExpenseRepository repo = new ExpenseRepository(database);

        ExpenseRepository repo = new ExpenseRepository(mock);
        repo.loadExpenses();

        InOrder inOrder = inOrder(mock);
        inOrder.verify(mock).connect();
        inOrder.verify(mock).queryAll();
        inOrder.verify(mock).close();

        assertEquals(0, repo.getExpenses().size());
    }

    @Test
    void testSaveExpenses() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        //MyDatabase database = new MyDatabase();
        //ExpenseRepository repo = new ExpenseRepository(database);

        ExpenseRepository repo = new ExpenseRepository(mock);
        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        Expense expense3 = new Expense();
        Expense expense4 = new Expense();
        Expense expense5 = new Expense();

        repo.addExpense(expense1);
        repo.addExpense(expense2);
        repo.addExpense(expense3);
        repo.addExpense(expense4);
        repo.addExpense(expense5);

        repo.saveExpenses();

        InOrder inOrder = inOrder(mock);
        inOrder.verify(mock).connect();
        inOrder.verify(mock, times(5)).persist(any(Expense.class));
        inOrder.verify(mock).close();
    }
}
