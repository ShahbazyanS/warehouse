import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Material, Integer> materials;

    public Warehouse() {
        this.materials = new HashMap<>();
    }

    public void addMaterial(Material material, int quantity) {
        int currentQuantity = materials.getOrDefault(material, 0);
        int newQuantity = Math.min(currentQuantity + quantity, material.getMaxCapacity());
        materials.put(material, newQuantity);
    }

    public void removeMaterial(Material material, int quantity) {
        int currentQuantity = materials.getOrDefault(material, 0);
        int newQuantity = Math.max(currentQuantity - quantity, 0);
        if (newQuantity == 0) {
            materials.remove(material);
        } else {
            materials.put(material, newQuantity);
        }
    }

    public void moveMaterial(Material material, int quantity, Warehouse destination) {
        if (materials.containsKey(material)) {
            int currentQuantity = materials.get(material);
            int quantityToMove = Math.min(quantity, currentQuantity);
            removeMaterial(material, quantityToMove);
            destination.addMaterial(material, quantityToMove);
        }
    }

    public int getQuantity(Material material) {
        return materials.getOrDefault(material, 0);
    }

    public void printWarehouseData() {
        System.out.println("Warehouse Data:");
        for (Material material : materials.keySet()) {
            int quantity = materials.get(material);
            System.out.println(material.getName() + ": " + quantity);
        }
    }
}
