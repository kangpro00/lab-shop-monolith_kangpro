package labshopmonolith.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import labshopmonolith.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/inventories")
@Transactional
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @RequestMapping(
        value = "inventories/{id}/dcreasestock",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Inventory dcreaseStock(
        @PathVariable(value = "id") Long id,
        @RequestBody DcreaseStockCommand dcreaseStockCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /inventory/dcreaseStock  called #####");
        Optional<Inventory> optionalInventory = inventoryRepository.findById(
            id
        );

        optionalInventory.orElseThrow(() -> new Exception("No Entity Found"));
        Inventory inventory = optionalInventory.get();
        inventory.dcreaseStock(dcreaseStockCommand);

        inventoryRepository.save(inventory);
        return inventory;
    }
}
