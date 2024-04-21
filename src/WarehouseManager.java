import java.util.HashMap;
import java.util.Map;

public class WarehouseManager {
    private Map<String, Warehouse> warehouses;

    public WarehouseManager() {
        this.warehouses = new HashMap<>();
    }

    public void createWarehouse(String name) {
        warehouses.put(name, new Warehouse());
    }

    public Warehouse getWarehouse(String name) {
        return warehouses.get(name);
    }

    public void addMaterialToWarehouse(String warehouseName, Material material, int quantity) {
        Warehouse warehouse = warehouses.get(warehouseName);
        if (warehouse != null) {
            warehouse.addMaterial(material, quantity);
        } else {
            System.out.println("Warehouse not found.");
        }
    }

    public void removeMaterialFromWarehouse(String warehouseName, Material material, int quantity) {
        Warehouse warehouse = warehouses.get(warehouseName);
        if (warehouse != null) {
            warehouse.removeMaterial(material, quantity);
        } else {
            System.out.println("Warehouse not found.");
        }
    }

    public void moveMaterialBetweenWarehouses(String sourceWarehouseName, String destinationWarehouseName, Material material, int quantity) {
        Warehouse sourceWarehouse = warehouses.get(sourceWarehouseName);
        Warehouse destinationWarehouse = warehouses.get(destinationWarehouseName);
        if (sourceWarehouse != null && destinationWarehouse != null) {
            sourceWarehouse.moveMaterial(material, quantity, destinationWarehouse);
        } else {
            System.out.println("Source or destination warehouse not found.");
        }
    }

    public void printWarehouseData(String warehouseName) {
        Warehouse warehouse = warehouses.get(warehouseName);
        if (warehouse != null) {
            warehouse.printWarehouseData();
        } else {
            System.out.println("Warehouse not found.");
        }
    }
}