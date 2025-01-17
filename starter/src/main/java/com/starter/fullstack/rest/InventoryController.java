package com.starter.fullstack.rest;

import com.starter.fullstack.api.Inventory;
import com.starter.fullstack.dao.InventoryDAO;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inventory Controller.
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
  private final InventoryDAO inventoryDAO;

  /**
   * Default Constructor.
   * @param inventoryDAO inventoryDAO.
   */
  public InventoryController(InventoryDAO inventoryDAO) {
    Assert.notNull(inventoryDAO, "Inventory DAO must not be null.");
    this.inventoryDAO = inventoryDAO;
  }

  /**
   * Save Inventory.
   * @param inventory Inventory to Save/Update.
   * @return Created/Updated Inventory.
   */
  @PostMapping
  public Inventory create(@Valid @RequestBody Inventory inventory) {
    return this.inventoryDAO.create(inventory);
  }

  /**
   * Delete Inventory By Id.
   *
   * @param ids ids.
   * @return Deleted inventory
   */
  @DeleteMapping
  public Optional<Inventory> deleteInventoryById(@RequestBody List<String> ids) {
    Assert.notNull(ids, "Inventory Id was not provided");
    return this.inventoryDAO.delete(ids);
  }

  /**
   * Find Inventorys.
   * @return List of Inventory.
   */
  @GetMapping
  public List<Inventory> findInventories() {
    return this.inventoryDAO.findAll();
  }
}

