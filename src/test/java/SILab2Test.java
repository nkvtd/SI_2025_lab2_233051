import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {
    @Test
    public void testEveryStatement() {
        RuntimeException ex;

        //1
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null,"1234567890123456");
        });
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //2
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(List.of(new Item(null, 1, 100, 0.0)),"1234567890123456");
        });
        assertTrue(ex.getMessage().contains("Invalid item!"));

        //3
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(List.of(new Item("Item1", 1, 100, 0.0)),"123");
        });
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        //4
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(List.of(new Item("Item1", 1, 100, 0.0)),"123456789012345a");
        });
        assertTrue(ex.getMessage().contains("Invalid character in card number!"));

        //5
        assertEquals(1570.0, SILab2.checkCart(List.of(new Item("Item1", 5, 400, 0.2)),"1234567890123456"));

        //6
        assertEquals(100.0,SILab2.checkCart(List.of(new Item("Item1", 1, 100, 0.0)),"1234567890123456"));
    }

    @Test
    public void testMultipleCondition() {
        //1
        assertEquals(320.0, SILab2.checkCart(List.of(new Item("Item1",1,350,0.0)),"1234567890123456"));

        //2
        assertEquals(112.5, SILab2.checkCart(List.of(new Item("Item1",2,75,0.05)),"1234567890123456"));

        //3
        assertEquals(210.0, SILab2.checkCart(List.of(new Item("Item1",12,20,0.0)),"1234567890123456"));

        //4
        assertEquals(15.0, SILab2.checkCart(List.of(new Item("Item1",3,5,0.0)),"1234567890123456"));
    }
}
