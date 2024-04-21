public class Main {
    public static void main(String[] args) {

        WarehouseManager manager = new WarehouseManager();

        manager.createWarehouse("Warehouse1");
        manager.createWarehouse("Warehouse2");

        Material iron = new Material("Iron", "A metal material", "icon1", 1000);
        Material copper = new Material("Copper", "Another metal material", "icon2", 800);

        manager.addMaterialToWarehouse("Warehouse1", iron, 500);
        manager.addMaterialToWarehouse("Warehouse2", copper, 300);

        manager.moveMaterialBetweenWarehouses("Warehouse1", "Warehouse2", iron, 200);

        manager.printWarehouseData("Warehouse1");
        manager.printWarehouseData("Warehouse2");
    }
}
