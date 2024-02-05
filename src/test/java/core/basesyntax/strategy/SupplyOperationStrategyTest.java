package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.fruitstorge.FruitStorage;
import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.operations.Operation;
import org.junit.jupiter.api.Test;

class SupplyOperationStrategyTest {

    @Test
    void handle() {
        FruitStorage.fruitStorage.put("Apple", 10);

        // Create a FruitTransaction with a positive amount
        FruitTransaction validTransaction = new FruitTransaction(Operation.SUPPLY,"Apple", 5);

        // Call the handle method
        new SupplyOperationStrategy().handle(validTransaction);

        // Verify that the balance is updated correctly
        assertEquals(15, FruitStorage.fruitStorage.get("Apple"));
    }
}