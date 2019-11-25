package invertedindex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeMapTest {

    @Test
    void printIterative() {
        BinarySearchTreeMap bSTP = new BinarySearchTreeMap();

        bSTP.put("Jack", "0871231231");
        bSTP.put("Jill", "0877654321");
        bSTP.put("Bob", "0871234567");
        bSTP.put("Rob", "0851212121");
        
        ArrayList list = bSTP.printIterative();
        System.out.println(list.toString());
    }
}