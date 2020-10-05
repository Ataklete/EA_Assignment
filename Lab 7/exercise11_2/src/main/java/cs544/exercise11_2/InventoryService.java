package cs544.exercise11_2;

import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {
    @Override
    public int getNumberInStock(int productNumber) {
        return productNumber - 200;
    }
}
